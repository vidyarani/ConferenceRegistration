package com.tw.vapasi.registration;

import java.util.ArrayList;

public class Conference {
    private Session[] sessions;

    public Conference(Session[] sessions) {
        this.sessions = sessions;
    }

    public ArrayList<Session> getAvailableSessions() throws SeatsNotAvailableException {
        ArrayList<Session> availableSessions = new ArrayList<Session>();
        for (Session session : sessions)
            if (session.isAvailable())
                availableSessions.add(session);
        if (availableSessions.size() == 0)
            throw new SeatsNotAvailableException("Seats Not Available");
        return availableSessions;
    }

    public ConferenceRegistrationTicket register(Participant participant, Session selectedSession) throws SeatsNotAvailableException {
        ConferenceRegistrationTicket ticket;
        if (selectedSession.isAvailable()) {
            selectedSession.addParticipant(participant);
            ticket = generateTicket(participant, selectedSession);
        } else throw new SeatsNotAvailableException("Seats Not Available");
        return ticket;
    }

    private ConferenceRegistrationTicket generateTicket(Participant participant, Session session) {
        return new ConferenceRegistrationTicket(session.getName(), participant.getName(), participant.getEmailId());
    }
}