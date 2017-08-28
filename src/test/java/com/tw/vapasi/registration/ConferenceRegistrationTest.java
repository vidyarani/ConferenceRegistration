package com.tw.vapasi.registration;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class ConferenceRegistrationTest {
    Participant participant;
    Session[] sessions;
    Conference conference;

    @Before
    public void setUp() {
        participant = new Participant("Rex", "rex@gmail.com");
        sessions = new Session[2];
        conference = new Conference(sessions);
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
    public void returnsTrueIfSessionIsAvailable() {
        Session session1 = new Session("Session1", new Seat[]{createSeat(true), createSeat(false)});
        Session session2 = new Session("Session2", new Seat[]{createSeat(false), createSeat(false)});
        createSessions(new Session[]{session1, session2});
        try {
            ArrayList<Session> availableSessions = conference.getAvailableSessions();
            Assert.assertEquals(1, availableSessions.size());
        } catch (SeatsNotAvailableException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test()
    public void returnsMessageIfSessionsNotAvailable() {
        Session session1 = new Session("Session1", new Seat[]{createSeat(false), createSeat(false)});
        Session session2 = new Session("Session2", new Seat[]{createSeat(false), createSeat(false)});
        createSessions(new Session[]{session1, session2});
        try {
            conference.getAvailableSessions();
        } catch (SeatsNotAvailableException exception) {
            Assert.assertEquals("Seats Not Available", exception.getMessage());
        }
    }

    @Test()
    public void returnsErrorMessageIfRegisteredToUnavailableSession() {
        Session session = new Session("Session1", new Seat[]{createSeat(false), createSeat(false)});
        try {
            conference.register(participant, session);
        } catch (SeatsNotAvailableException exception) {
            Assert.assertEquals("Seats Not Available", exception.getMessage());
        }

    }

    @Test()
    public void returnSessionNameIfSeatsAvailableForRegistratoin() {
        Session session = new Session("Session1", new Seat[]{createSeat(true), createSeat(false)});
        ConferenceRegistrationTicket ticket = conference.register(participant, session);
        Assert.assertEquals("Session1", ticket.getSessionName());
    }

    @Test()
    public void returnsErrorMessageIfPartcipantRegistersForMultipleSessions() {
        Session session1 = new Session("Session1", new Seat[]{createSeat(false), createSeat(true)});
        Session session2 = new Session("Session2", new Seat[]{createSeat(true), createSeat(false)});
        try {
            conference.register(participant, session1);
            conference.register(participant, session2);
        } catch (ParticipantAlreadyRegisteredException exception) {
            Assert.assertEquals("Participant already registered", exception.getMessage());
        }
    }

    @Test()
    public void allowNewPartcipantToRegisterForSameSessionIfAvailable() {
        Session session = new Session("Session1", new Seat[]{createSeat(true), createSeat(true)});
        conference.register(participant, session);
        Participant newParticipant = new Participant("Alex", "alex@gmail.com");
        ConferenceRegistrationTicket newTicket = conference.register(newParticipant, session);
        Assert.assertEquals("Session1", newTicket.getSessionName());
    }
}
