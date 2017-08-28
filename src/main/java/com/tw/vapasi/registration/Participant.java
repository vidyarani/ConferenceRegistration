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

    @Override
    public boolean equals(Object object) {
        Participant participant = (Participant) object;
        return (this.name.equals(participant.getName()) && this.emailId.equals(participant.getEmailId()));
    }
}
