package org.project.kiosk.user.application;

import org.project.kiosk.user.domain.Role;
import org.project.kiosk.user.domain.User;
import org.project.kiosk.user.error.*;
import org.project.kiosk.user.storage.UserStorage;

import static org.project.kiosk.util.Separator.BLANK;
import static org.project.kiosk.util.Separator.COMMA;

public class UserService {

    private final int UUID_INDEX = 0;
    private final int MONEY_INDEX = 1;

    private final UserStorage userStorage;

    public UserService(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public void save(String input, Role role) {
        String[] userInfo = input.split(COMMA.getSeparator() + BLANK.getSeparator());

        try{
            String uuid = userInfo[UUID_INDEX];
            int money = Integer.parseInt(userInfo[MONEY_INDEX]);

            validateUser(uuid, role);
            validateMoney(money);

            userStorage.save(User.createUser(uuid, money, role));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new WrongUserInputFormatException();
        }
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