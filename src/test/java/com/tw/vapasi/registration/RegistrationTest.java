package com.tw.vapasi.registration;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class RegistrationTest {
    Participant participant;
    Session[] sessions;
    Registration registration;

    @Before
    public void setUp() {
        participant = new Participant("Rex", "rex@gmail.com");
        sessions = new Session[2];
        registration = new Registration(sessions);
    }

    private Session[] createSessions(Session[] sessions) {
        for (int i = 0; i < sessions.length; i++)
            this.sessions[i] = sessions[i];
        return sessions;
    }

    private Seat createSeat(boolean isAvailable) {
        Seat seat = new Seat();
        seat.setAvailable(isAvailable);
        return seat;
    }

    @Test()
    public void returnsMessageIfSeatsNotAvailable() {
        Session session1 = new Session("Session1", new Seat[]{createSeat(false), createSeat(false)});
        Session session2 = new Session("Session2", new Seat[]{createSeat(false), createSeat(false)});
        createSessions(new Session[]{session1, session2});
        try {
            registration.register(participant);
        } catch (SeatsNotAvailableException exception) {
            Assert.assertEquals("Seats Not Available", exception.getMessage());
        }
    }

    @Test()
    public void returnSessionNameIfSeatsAvailableForRegistratoin() {
        Session session1 = new Session("Session1", new Seat[]{createSeat(true), createSeat(false)});
        Session session2 = new Session("Session2", new Seat[]{createSeat(false), createSeat(false)});
        createSessions(new Session[]{session1, session2});
        ConferenceRegistrationTicket ticket = registration.register(participant);
        Assert.assertEquals("Session1", ticket.getSessionName());
    }

    @Test()
    public void returnsSecondSessionNameIFFirstSessionIsNotAvailable() {
        Session session1 = new Session("Session1", new Seat[]{createSeat(false), createSeat(false)});
        Session session2 = new Session("Session2", new Seat[]{createSeat(true), createSeat(false)});
        createSessions(new Session[]{session1, session2});
        ConferenceRegistrationTicket ticket = registration.register(participant);
        Assert.assertEquals("Session2", ticket.getSessionName());
    }

    @Test()
    public void returnsErrorMessageIfPartcipantRegistersForMultipleSessions() {
        Session session1 = new Session("Session1", new Seat[]{createSeat(false), createSeat(false)});
        Session session2 = new Session("Session2", new Seat[]{createSeat(true), createSeat(false)});
        createSessions(new Session[]{session1, session2});
        try {
            registration.register(participant);
            Participant participantWithSameDetails = new Participant("Rex", "rex@gmail.com");
            registration.register(participantWithSameDetails);
        } catch (SeatsNotAvailableException exception) {
            Assert.assertEquals("Participant already registered", exception.getMessage());
        }
    }

    @Test()
    public void allowNewPartcipantToRegisterForSameSessionIfAvailable() {
        Session session1 = new Session("Session1", new Seat[]{createSeat(true), createSeat(true)});
        Session session2 = new Session("Session2", new Seat[]{createSeat(true), createSeat(false)});
        createSessions(new Session[]{session1, session2});
        registration.register(participant);
        Participant newParticipant = new Participant("Alex", "alex@gmail.com");
        ConferenceRegistrationTicket newTicket = registration.register(newParticipant);
        Assert.assertEquals("Session1", newTicket.getSessionName());
    }
}
