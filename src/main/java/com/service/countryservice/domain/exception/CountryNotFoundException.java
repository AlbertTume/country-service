package com.service.countryservice.domain.exception;

public class CountryNotFoundException extends RuntimeException {

    private final String isoCode2;

    public CountryNotFoundException(String isoCode2) {
        super(String.format("Country with ISO code %s not found", isoCode2));
        this.isoCode2 = isoCode2;
    }

    public String getIsoCode2() {
        return isoCode2;
    }

}
