package com.tw.vapasi.registration;

public class Session {
    private String name;
    private int numberOfSeats;
    private Seat[] seats;
    private boolean isAvailable;

    Session(String name, Seat[] seats) {
        this.name = name;
        this.seats = seats;
        this.numberOfSeats = seats.length;
    }

    boolean addParticipant(Participant participant) {
        for (Seat seat : seats) {
            if ((seat.getParticipant() != null) && seat.getParticipant().getName().equals(participant.getName()))
                throw new SeatsNotAvailableException("Participant already registered");
            if (seat.isAvailable()) {
                seat.setParticipant(participant);
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
