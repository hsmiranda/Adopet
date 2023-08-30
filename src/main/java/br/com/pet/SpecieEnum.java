package br.com.pet;

import lombok.ToString;

@ToString
public enum SpecieEnum {
    DOG("Dog"),
    CAT("Cat");

    private final String specieValue;

    SpecieEnum(String specieValue) {
        this.specieValue = specieValue;
    }

}