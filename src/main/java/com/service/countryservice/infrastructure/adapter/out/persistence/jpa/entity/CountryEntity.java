package com.service.countryservice.infrastructure.adapter.out.persistence.jpa.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "countries")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "iso_code_2", nullable = false, length = 2)
    private String isoCode2;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "continent_id")
    private ContinentEntity continent;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public  CountryEntity() {}

    public CountryEntity(Integer id, String isoCode2, String name, ContinentEntity continent, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.isoCode2 = isoCode2;
        this.name = name;
        this.continent = continent;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public ContinentEntity getContinent() {
        return continent;
    }

    public void setContinent(ContinentEntity continent) {
        this.continent = continent;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CountryEntity that = (CountryEntity) o;
        return Objects.equals(isoCode2, that.isoCode2);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isoCode2);
    }

    @Override
    public String toString() {
        return "CountryEntity{" +
                "continent=" + continent.getName() +
                ", name='" + name + '\'' +
                ", isoCode2='" + isoCode2 + '\'' +
                ", id=" + id +
                '}';
    }
}
