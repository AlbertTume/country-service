package com.service.countryservice.application.dto;

public class CountryDTO {

    private String isoCode2;
    private String name;
    private String continentCode;
    private String continentName;

    public CountryDTO() { }

    public CountryDTO(String isoCode2, String name, String continentCode, String continentName) {
        this.isoCode2 = isoCode2;
        this.name = name;
        this.continentCode = continentCode;
        this.continentName = continentName;
    }

    public String getIsoCode2() {
        return isoCode2;
    }

    public void setIsoCode2(String isoCode2) {
        this.isoCode2 = isoCode2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

}
