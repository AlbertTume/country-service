package com.service.countryservice.application.dto;

public class ContinentDTO {

    private String code;
    private String name;

    public ContinentDTO() { }

    public ContinentDTO(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
