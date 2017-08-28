package com.tw.vapasi.registration;

public class ConferenceRegistrationTicket {
    String sessionName;
    String participantName;
    String participantEmailId;

    ConferenceRegistrationTicket(String sessionName, String participantName, String participantEmailId) {
        this.sessionName = sessionName;
        this.participantName = participantName;
        this.participantEmailId = participantEmailId;
    }

    public String getSessionName() {
        return sessionName;
    }
}
