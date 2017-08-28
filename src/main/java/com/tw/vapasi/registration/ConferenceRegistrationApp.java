package com.tw.vapasi.registration;

import java.util.ArrayList;

public class ConferenceRegistrationApp {

    public static void main(String[] args) {
        Session[] sessions = createSessions();
        Conference conference = new Conference(sessions);
        Participant rex = new Participant("Rex", "rex@gmail.com");
        ArrayList<Session> availableSessions = conference.getAvailableSessions();
        
        if (availableSessions.size() != 0) {
            ConferenceRegistrationTicket ticket = conference.register(rex, availableSessions.get(0));
            System.out.println("Succesfully Registered to " + ticket.getSessionName());
        }
    }

    private static Session[] createSessions() {
        Session[] sessions = new Session[2];
        for (int i = 0; i < sessions.length; i++) {
            sessions[i] = new Session("Session" + (i + 1), new Seat[]{new Seat(), new Seat()});
        }
        return sessions;
    }
}
