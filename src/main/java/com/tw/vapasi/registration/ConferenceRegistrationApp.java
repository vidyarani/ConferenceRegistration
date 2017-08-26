package com.tw.vapasi.registration;

public class ConferenceRegistrationApp {
    public static void main(String[] args) {
        Session[] sessions = new Session[2];
        Registration registration = new Registration(sessions);
        Participant participant = new Participant("Vidya", "Vidya@email.com");
        ConferenceRegistrationTicket ticket = registration.register(participant);
        if(ticket!=null)
            System.out.println("Succesfully Registered to " + ticket.getSessionName());
    }
}
