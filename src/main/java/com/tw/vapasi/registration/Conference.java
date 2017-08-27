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
            if (session.isAvailabile()) {
                availableSessions.add(session);
                return availableSessions;
            }
        throw new SeatsNotAvailableException("Seats Not Available");
    }

    public SeminarRegistrationTicket register(Participant participant, Session selectedSession) throws SeatsNotAvailableException {
        SeminarRegistrationTicket ticket;
        selectedSession.addParticipant(participant);
        ticket = generateTicket(participant, selectedSession);
        return ticket;
    }

    private SeminarRegistrationTicket generateTicket(Participant participant, Session session) {
        SeminarRegistrationTicket ticket = new SeminarRegistrationTicket();
        ticket.setSessionName(session.getName());
        ticket.setParticipantName(participant.getName());
        ticket.setParticipantEmailId(participant.getEmailId());
        return ticket;
    }
}