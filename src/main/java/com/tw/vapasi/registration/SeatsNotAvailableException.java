package com.tw.vapasi.registration;

public class SeatsNotAvailableException extends RuntimeException {

    public SeatsNotAvailableException(String message) {
        super(message);
    }
}
