package com.tw.vapasi.registration;

public class SeminarRegistrationTicket {
    String sessionName;
    String participantName;
    String participantEmailId;

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public void setParticipantEmailId(String participantEmailId) {
        this.participantEmailId = participantEmailId;
    }
}
