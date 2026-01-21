package com.service.countryservice.application.dto;

public class CountryValidationDTO {

    private String isoCode2;
    private boolean exists;

    public CountryValidationDTO() { }

    public CountryValidationDTO(String isoCode2, boolean exists) {
        this.isoCode2 = isoCode2;
        this.exists = exists;
    }

    public String getIsoCode2() {
        return isoCode2;
    }

    public void setIsoCode2(String isoCode2) {
        this.isoCode2 = isoCode2;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }
}
