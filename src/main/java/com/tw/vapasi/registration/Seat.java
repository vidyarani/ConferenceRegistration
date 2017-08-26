package com.tw.vapasi.registration;

public class Seat {
    private Participant participant;
    private boolean isAvailable;

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
