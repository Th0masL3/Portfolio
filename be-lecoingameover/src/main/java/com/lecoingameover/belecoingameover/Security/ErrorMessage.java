package com.lecoingameover.belecoingameover.Security;

public record ErrorMessage(String message) {

    public static ErrorMessage from(final String message) {
        return new ErrorMessage(message);
    }
}