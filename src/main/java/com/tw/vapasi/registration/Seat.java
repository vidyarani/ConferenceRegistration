package com.tw.vapasi.registration;

public class Seat {
    private Participant participant;
    private boolean isAvailable = true;

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
        isAvailable = false;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
