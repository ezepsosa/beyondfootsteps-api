package com.beyondfootsteps.beyondfootsteps.exceptions;

public class InvalidCountryCodeException extends RuntimeException {

    public InvalidCountryCodeException() {
        super("Invalid country code.");
    }

}
