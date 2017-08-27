package com.tw.vapasi.registration;

import java.util.ArrayList;

public class ConferenceRegistrationApp {
    public static void main(String[] args) {
        Session[] sessions = new Session[2];
        Conference conference = new Conference(sessions);
        ArrayList<Session> availableSessions = conference.getAvailableSessions();
        Participant participant = new Participant("Vidya", "Vidya@email.com");
        if (availableSessions.size() != 0) {
            SeminarRegistrationTicket ticket = conference.register(participant, availableSessions.get(0));
            if (ticket != null)
                System.out.println("Succesfully Registered to " + ticket.getSessionName());
        }
    }
}
