package com.tw.vapasi.registration;

import java.util.ArrayList;

public class ConferenceRegistrationApp {
    public static void main(String[] args) {
        Conference conference = new Conference(createSessions());
        ArrayList<Session> availableSessions = conference.getAvailableSessions();
        Participant participant = new Participant("Vidya", "Vidya@email.com");
        if (availableSessions.size() != 0) {
            ConferenceRegistrationTicket ticket = conference.register(participant, availableSessions.get(0));
            System.out.println("Succesfully Registered to " + ticket.getSessionName());
        }
    }

    private static Session[] createSessions() {
        Session[] sessions = new Session[2];
        sessions[0] = new Session("Session1", new Seat[]{createSeat(true), createSeat(false)});
        sessions[1] = new Session("Session1", new Seat[]{createSeat(true), createSeat(false)});
        return sessions;
    }

    private static Seat createSeat(boolean isAvailable) {
        Seat seat = new Seat();
        return seat;
    }
}
