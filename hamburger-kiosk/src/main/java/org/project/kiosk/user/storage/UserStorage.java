package org.project.kiosk.user.storage;

import org.project.kiosk.user.domain.Role;
import org.project.kiosk.user.domain.User;
import org.project.kiosk.user.domain.dto.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private final List<User> userList;

    public UserStorage() {
        userList = new ArrayList<>();
    }

    public void save(User user) {
        userList.add(user);
    }

    public boolean isExist(String uuid, Role role) {
        for(User user : userList) {
            if(user.getUuid().equals(uuid) && user.getRole().equals(role))
                return true;
        }
        return false;
    }
}
