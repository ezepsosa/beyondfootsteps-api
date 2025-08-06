package com.beyondfootsteps.beyondfootsteps.exceptions;

public class InvalidCountryCodeException extends RuntimeException {
    public InvalidCountryCodeException() {
        super("Invalid country code.");
    }

    public InvalidCountryCodeException(String message) {
        super(message);
    }

    public InvalidCountryCodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
