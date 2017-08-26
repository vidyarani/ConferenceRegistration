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
        participant = new Participant("Rex","rex@gmail.com" );
        sessions = new Session[2];
        registration = new Registration(sessions);
    }

    private Session[] createSessions(Seat[] seats) {
        for (int i = 0; i < 2; i++) {
            Session session = new Session(seats);
            sessions[i] = session;
        }

        return sessions;
    }

    @Test()
    public void returnsMessageIfSeatsNotAvailable() {
        Seat[] seats = new Seat[2];

        for (int i = 0; i < seats.length; i++) {
            Seat seat = new Seat();
            seat.setAvailable(false);
            seats[i] = seat;
        }
        createSessions(seats);
        try {
            ConferenceRegistrationTicket ticket = registration.register(participant);
        }catch (SeatsNotAvailableException exception){
            Assert.assertEquals("Seats Not Available", exception.getMessage());
        }
    }
}
