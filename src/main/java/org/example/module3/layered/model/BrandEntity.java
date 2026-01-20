package org.example.module3.layered.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Setter
@Getter
public class BrandEntity {
    private Integer id;
    private String name;
    private String country;
    private Integer foundedYear;

    public BrandEntity(Integer id, String name, String country, Integer foundedYear) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.foundedYear = foundedYear;
    }

    public BrandEntity(String name, String country, Integer foundedYear) {
        this.name = name;
        this.country = country;
        this.foundedYear = foundedYear;
    }





}
