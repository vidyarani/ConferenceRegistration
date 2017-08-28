package com.tw.vapasi.registration;

public class Session {
    private String name;
    private Seat[] seats;

    Session(String name, Seat[] seats) {
        this.name = name;
        this.seats = seats;
    }

    void addParticipant(Participant participant) {
        for (Seat seat : seats) {

            if (seat.getParticipant() == null) {
                seat.setParticipant(participant);
                break;
            } else if ((seat.getParticipant() != null) && seat.getParticipant().equals(participant))
                throw new ParticipantAlreadyRegisteredException("Participant already registered");
        }
    }

    public String getName() {
        return name;
    }

    public boolean canAccommodate() {
        for (Seat seat : seats)
            if (seat.getParticipant() == null) {
                return true;
            }
        return false;
    }
}
