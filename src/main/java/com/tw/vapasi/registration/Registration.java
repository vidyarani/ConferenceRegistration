package com.tw.vapasi.registration;

public class Registration {
    private Session[] sessions;

    public Registration(Session[] sessions) {
        this.sessions = sessions;
    }

    public ConferenceRegistrationTicket register(Participant participant) throws SeatsNotAvailableException {
        for (Session session : sessions) {
            if (session.addParticipant(participant)) {
                ConferenceRegistrationTicket ticket = generateTicket(participant, session);
                return ticket;
            }
        }
        throw new SeatsNotAvailableException("Seats Not Available");
    }

    private ConferenceRegistrationTicket generateTicket(Participant participant, Session session) {
        ConferenceRegistrationTicket ticket = new ConferenceRegistrationTicket();
        ticket.setSessionName(session.getName());
        ticket.setParticipantName(participant.getName());
        return ticket;
    }
}