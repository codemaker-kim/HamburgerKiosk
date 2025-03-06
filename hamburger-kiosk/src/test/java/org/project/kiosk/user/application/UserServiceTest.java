package org.project.kiosk.user.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.project.kiosk.user.error.AlreadyExistUserException;
import org.project.kiosk.user.error.NegativeMoneyException;
import org.project.kiosk.user.error.UserNotFoundException;
import org.project.kiosk.user.error.WrongIdFormatException;
import org.project.kiosk.user.storage.UserStorage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
        String input = "관리자1, 20000";
        userService.save(input, ROLE_MANAGER);

        //when & then
        assertThatThrownBy(() -> userService.save("관리자1, 10000", ROLE_MANAGER))
                .isInstanceOf(AlreadyExistUserException.class);
    }

    @Test
    @DisplayName("돈이 음수라면 예외를 발생시킨다.")
    void userServiceTest2() {
        //given
        String input = "관리자1, -20000";

        //when & then
        assertThatThrownBy(() -> userService.save(input, ROLE_MANAGER))
                .isInstanceOf(NegativeMoneyException.class);
    }

    @Test
    @DisplayName("사용자가 회원일 때, 고유 id가 숫자가 아니라면 예외를 발생시킨다.")
    void userServiceTest3() {
        //given
        String input = "회원1, 10000";

        //when & then
        assertThatThrownBy(() -> userService.save(input, ROLE_MEMBER))
                .isInstanceOf(WrongIdFormatException.class);
    }

    @Test
    @DisplayName("사용자가 관리자일 때, 고유 id가 문자가 포함되어있지 않으면 예외를 발생시킨다.")
    void userServiceTest4() {
        //given
        String input = "7777, 10000";

        //when & then
        assertThatThrownBy(() -> userService.save(input, ROLE_MANAGER))
                .isInstanceOf(WrongIdFormatException.class);
    }

    @Test
    @DisplayName("존재하지 않는 사용자로 로그인하면, 예외를 발생시킨다.")
    void userServiceTest5() {
        //given
        String uuid = "관리자1";

        //when & then
        assertThatThrownBy(() -> userService.login(uuid))
                .isInstanceOf(UserNotFoundException.class);
    }
}