package com.tw.vapasi.registration;

import java.util.ArrayList;

public class Conference {
    private Session[] sessions;
    private final String SEATS_NOT_AVAILABLE = "Seats Not Available";

    public Conference(Session[] sessions) {
        this.sessions = sessions;
    }

    public ArrayList<Session> getAvailableSessions() throws SeatsNotAvailableException {
        ArrayList<Session> availableSessions = new ArrayList<Session>();
        for (Session session : sessions)
            if (session.canAccommodate())
                availableSessions.add(session);
        if (availableSessions.size() == 0)
            throw new SeatsNotAvailableException(SEATS_NOT_AVAILABLE);
        return availableSessions;
    }

    public ConferenceRegistrationTicket register(Participant participant, Session selectedSession) throws SeatsNotAvailableException {
        ConferenceRegistrationTicket ticket;
        if (selectedSession.canAccommodate()) {
            selectedSession.addParticipant(participant);
            ticket = generateTicket(participant, selectedSession);
        } else throw new SeatsNotAvailableException(SEATS_NOT_AVAILABLE);
        return ticket;
    }

    private ConferenceRegistrationTicket generateTicket(Participant participant, Session session) {
        return new ConferenceRegistrationTicket(session.getName(), participant.getName(), participant.getEmailId());
    }
}