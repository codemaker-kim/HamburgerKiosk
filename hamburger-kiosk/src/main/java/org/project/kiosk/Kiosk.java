package org.project.kiosk;

import org.project.kiosk.io.input.ConsoleInputProcessor;
import org.project.kiosk.io.output.ConsoleOutputPrinter;
import org.project.kiosk.order.application.OrderService;
import org.project.kiosk.order.storage.OrderStorage;
import org.project.kiosk.user.application.UserService;
import org.project.kiosk.user.domain.User;
import org.project.kiosk.user.storage.UserStorage;

import java.io.IOException;

import static org.project.kiosk.util.Choice.*;

public class Kiosk {

    private User accessor;
    private User Manager;

    private final ConsoleOutputPrinter outputPrinter = new ConsoleOutputPrinter();
    private final UserService userService = new UserService(new UserStorage());
    private final OrderService orderService = new OrderService(new OrderStorage());

    public void run() throws IOException {
        String userInput;
        while (true) {
            userInput = ConsoleInputProcessor.getUserInput();

            switch (userInput) {

            }
        }
    }

    private void joinManager() throws IOException {
        String input = ConsoleInputProcessor.getUserInput();

        input.split("");
    }

}
