package org.project.kiosk.io.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputProcessor {

    public static String getUserInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        return reader.readLine();
    }
}
