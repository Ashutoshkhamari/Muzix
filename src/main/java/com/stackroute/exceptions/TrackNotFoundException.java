package com.stackroute.exceptions;

public class TrackNotFoundException extends Exception {
    private String message;

    public TrackNotFoundException() {
    }
    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public void setErrorMessage(String message) {
    }

    public void setRequestedURI(String requestURI)
    {

    }
}
