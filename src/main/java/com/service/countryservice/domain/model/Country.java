package com.service.countryservice.domain.model;

import java.util.Objects;

public class Country {

    private String isoCode2;
    private String name;
    private Continent continent;

    public Country() {}

    public Country(String isoCode2, String name, Continent continent) {
        this.isoCode2 = isoCode2;
        this.name = name;
        this.continent = continent;
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

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(isoCode2, country.isoCode2);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isoCode2);
    }

    @Override
    public String toString() {
        return "Country{" +
                "isoCode2='" + isoCode2 + '\'' +
                ", name='" + name + '\'' +
                ", continent=" + continent.getName() +
                '}';
    }
}
