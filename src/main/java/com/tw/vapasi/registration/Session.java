package com.tw.vapasi.registration;

public class Session {
    private String name;
    private int numberOfSeats;
    private Seat[] seats;

    Session(String name, Seat[] seats) {
        this.name = name;
        this.seats = seats;
        this.numberOfSeats = seats.length;
    }

    void addParticipant(Participant participant) {
        for (Seat seat : seats) {
            if ((seat.getParticipant() != null) && seat.getParticipant().getEmailId().equals(participant.getEmailId()))
                throw new ParticipantAlreadyRegisteredException("Participant already registered");
            seat.setParticipant(participant);
            break;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        for (Seat seat : seats)
            if (seat.isAvailable()) return true;
        return false;
    }
}
