package com.service.countryservice.domain.exception;

public class ContinentNotFoundException extends RuntimeException {

    private final String code;

    public ContinentNotFoundException(String code) {
        super(String.format("Continent with code %s not found", code));
        this.code = code;
    }

    public ContinentNotFoundException(Integer id) {
        super(String.format("Continent with id %d not found", id));
        this.code = null;
    }

    public String getCode() {
        return code;
    }
}
