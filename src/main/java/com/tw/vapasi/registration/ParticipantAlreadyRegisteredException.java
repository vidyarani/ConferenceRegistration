package com.tw.vapasi.registration;

public class ParticipantAlreadyRegisteredException extends RuntimeException {

    public ParticipantAlreadyRegisteredException(String message) {
        super(message);
    }
}
