package org.project.kiosk.io.output;

public enum RootMessage {
    EXIT("0. 종료"),
    JOIN_MANAGER("1. 관리자 생성"),
    ACCESS_MANAGER("2. 관리자 접속"),
    JOIN_MEMBER("3. 회원 생성"),
    ACCESS_MEMBER("4. 회원 접속");

    private final String message;

    RootMessage(String message) {
        this.message = message;
    }

    public void printMessage(){
        System.out.println(message);
    }
}
