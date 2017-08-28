package com.tw.vapasi.registration;

public class Participant {
    private final String name;
    private final String emailId;

    Participant(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }
}
