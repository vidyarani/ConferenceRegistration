package com.tw.vapasi.registration;

public class SessionUtilites {
    static Session[] createSessions() {
        Session[] sessions = new Session[2];
        for (int index = 0; index < sessions.length; index++) {
            sessions[index] = new Session("Session" + (index + 1), new Seat[]{new Seat(), new Seat()});
        }
        return sessions;
    }
}