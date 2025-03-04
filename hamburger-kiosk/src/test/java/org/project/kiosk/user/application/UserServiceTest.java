package org.project.kiosk.user.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.project.kiosk.user.domain.Role;
import org.project.kiosk.user.domain.User;
import org.project.kiosk.user.error.AlreadyExistUserException;
import org.project.kiosk.user.error.NegativeMoneyException;
import org.project.kiosk.user.error.WrongIdFormatException;
import org.project.kiosk.user.storage.UserStorage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.project.kiosk.user.domain.Role.ROLE_MANAGER;
import static org.project.kiosk.user.domain.Role.ROLE_MEMBER;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(new UserStorage());
    }

    @Test
    @DisplayName("중복되는 사용자가 존재하면 예외를 발생시킨다.")
    void userServiceTest1() {
        //given
        String uuid = "관리자1";
        int money = 20000;
        userService.save(uuid, money, ROLE_MANAGER);

        //when & then
        assertThatThrownBy(() -> userService.save("관리자1", 10000, ROLE_MANAGER))
                .isInstanceOf(AlreadyExistUserException.class);
    }

    @Test
    @DisplayName("돈이 음수라면 예외를 발생시킨다.")
    void userServiceTest2() {
        //given
        String uuid = "관리자1";
        int money = -20000;

        //when & then
        assertThatThrownBy(() -> userService.save(uuid, money, ROLE_MANAGER))
                .isInstanceOf(NegativeMoneyException.class);
    }

    @Test
    @DisplayName("사용자가 회원일 때, 고유 id가 숫자가 아니라면 예외를 발생시킨다.")
    void userServiceTest3() {
        //given
        String uuid = "회원1";
        int money = 10000;

        //when & then
        assertThatThrownBy(() -> userService.save(uuid, money, ROLE_MEMBER))
                .isInstanceOf(WrongIdFormatException.class);
    }

    @Test
    @DisplayName("사용자가 관리자일 때, 고유 id가 문자가 포함되어있지 않으면 예외를 발생시킨다.")
    void userServiceTest4() {
        //given
        String uuid = "7777";
        int money = 10000;

        //when & then
        assertThatThrownBy(() -> userService.save(uuid, money, ROLE_MANAGER))
                .isInstanceOf(WrongIdFormatException.class);
    }
}