package org.project.kiosk.user.application;

import org.project.kiosk.user.domain.Role;
import org.project.kiosk.user.domain.User;
import org.project.kiosk.user.error.AlreadyExistUserException;
import org.project.kiosk.user.error.NegativeMoneyException;
import org.project.kiosk.user.error.UserNotFoundException;
import org.project.kiosk.user.error.WrongIdFormatException;
import org.project.kiosk.user.storage.UserStorage;

public class UserService {
    private final UserStorage userStorage;

    public UserService(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public void save(String uuid, int money, Role role) {
        validateUser(uuid, role);
        validateMoney(money);

        userStorage.save(User.createUser(uuid, money, role));
    }

    public User login(String uuid) {
        return userStorage.findByUuid(uuid)
                .orElseThrow(UserNotFoundException::new);
    }

    private void validateUser(String uuid, Role role) {
        validateUUID(uuid, role);

        if(userStorage.isExist(uuid, role))
            throw new AlreadyExistUserException();
    }

    private void validateMoney(int money) {
        if(money < 0)
            throw new NegativeMoneyException();
    }

    private void validateUUID(String uuid, Role role) {
        if(role==Role.ROLE_MEMBER && !uuid.chars().allMatch(Character::isDigit))
            throw new WrongIdFormatException();
        else if(role==Role.ROLE_MANAGER && uuid.chars().allMatch(Character::isDigit))
            throw new WrongIdFormatException();
    }
}