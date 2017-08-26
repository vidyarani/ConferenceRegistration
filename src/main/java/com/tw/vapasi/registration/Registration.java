package com.tw.vapasi.registration;

public class Registration {
    private Session[] sessions;

    public Registration(Session[] sessions) {
        this.sessions = sessions;
    }

    public ConferenceRegistrationTicket register(Participant participant) throws SeatsNotAvailableException {
        for (Session session : sessions)
            if (session.addParticipant(participant))
                generateTicket(participant, session);
        throw new SeatsNotAvailableException("Seats Not Available");
    }

    private void generateTicket(Participant participant, Session session) {
        ConferenceRegistrationTicket ticket = new ConferenceRegistrationTicket();
        ticket.setSessionName(session.getName());
        ticket.setParticipantName(participant.getName());
    }
}