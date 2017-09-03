package com.tw.vapasi.registration;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class ConferenceRegistrationTest {
    Participant rex, alex, bob, john;

    @Before
    public void setUp() {
        rex = new Participant("Rex", "rex@gmail.com");
        alex = new Participant("Alex", "alex@gmail.com");
        bob = new Participant("Bob", "bob@gmail.com");
        john = new Participant("John", "john@gmail.com");
    }

    private Session[] createSessions() {
        Session[] sessions = new Session[2];
        for (int index = 0; index < sessions.length; index++) {
            sessions[index] = new Session("Session" + (index + 1), new Seat[]{new Seat(), new Seat()});
        }
        return sessions;
    }

    @Test()
    public void returnsTrueIfSessionsAreAvailable() {
        Conference conference = new Conference(createSessions());
        try {
            ArrayList<Session> availableSessions = conference.getAvailableSessions();
            Assert.assertEquals(2, availableSessions.size());
        } catch (SeatsNotAvailableException exception) {
        }
    }

    @Test()
    public void returnsMessageIfSessionsNotAvailable() {
        Session[] sessions = createSessions();
        Conference conference = new Conference(sessions);
        try {
            conference.register(rex, sessions[0]);
            conference.register(alex, sessions[0]);
            conference.register(bob, sessions[1]);
            conference.register(john, sessions[1]);
            ArrayList<Session> avlbsessions = conference.getAvailableSessions();
        } catch (SeatsNotAvailableException exception) {
            Assert.assertEquals("Seats Not Available", exception.getMessage());
        }
    }

    @Test()
    public void returnsErrorMessageIfRegisteredToUnavailableSession() {
        Session[] sessions = createSessions();
        Conference conference = new Conference(sessions);
        try {
            conference.register(rex, sessions[0]);
            conference.register(alex, sessions[0]);
            conference.register(bob, sessions[0]);
        } catch (SeatsNotAvailableException exception) {
            Assert.assertEquals("Seats Not Available", exception.getMessage());
        }
    }

    @Test()
    public void returnSessionNameIfAfterSuccessfulRegistratoin() {
        Session[] sessions = createSessions();
        Conference conference = new Conference(sessions);

        ConferenceRegistrationTicket ticket = conference.register(rex, sessions[0]);
        Assert.assertEquals("Session1", ticket.getSessionName());
    }

    @Test()
    public void returnsErrorMessageIfPartcipantRegistersForMultipleSessions() {
        Session[] sessions = createSessions();
        Conference conference = new Conference(sessions);
        try {
            conference.register(rex, sessions[0]);
            conference.register(rex, sessions[0]);
        } catch (ParticipantAlreadyRegisteredException exception) {
            Assert.assertEquals("Participant already registered", exception.getMessage());
        }
    }

    @Test()
    public void allowNewPartcipantToRegisterForSameSessionIfAvailable() {
        Session[] sessions = createSessions();
        Conference conference = new Conference(sessions);
        conference.register(rex, sessions[0]);
        ConferenceRegistrationTicket newTicket = conference.register(alex, sessions[0]);
        Assert.assertEquals("Session1", newTicket.getSessionName());
    }
}
