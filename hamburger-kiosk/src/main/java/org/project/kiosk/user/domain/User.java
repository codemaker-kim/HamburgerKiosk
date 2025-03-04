package org.project.kiosk.user.domain;

import org.project.kiosk.user.domain.dto.UserInfo;

public class User {
    private String uuid;
    private int money;
    private Role role;

    private User(){
    }

    public static User createUser(String uuid, int money, Role role) {
        User user = new User();
        user.uuid = uuid;
        user.money = money;
        user.role = role;

        return user;
    }

    public String getUuid() {
        return uuid;
    }

    public Role getRole() {
        return role;
    }
}
