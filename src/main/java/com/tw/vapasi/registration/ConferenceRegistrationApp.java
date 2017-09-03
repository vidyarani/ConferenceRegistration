package com.tw.vapasi.registration;

import java.util.ArrayList;

public class ConferenceRegistrationApp {

    public static void main(String[] args) {
        Session[] sessions = SessionUtilites.createSessions();
        Conference conference = new Conference(sessions);
        Participant rex = new Participant("Rex", "rex@gmail.com");
        ArrayList<Session> availableSessions = conference.getAvailableSessions();
        ConferenceRegistrationTicket ticket = conference.register(rex, availableSessions.get((int) (Math.random()*availableSessions.size())));
        System.out.println("Successfully Registered to " + ticket.getSessionName());
    }
}