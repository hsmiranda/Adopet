package br.com.pet.enuns;

import lombok.ToString;

public enum SpecieEnum {
    DOG("Dog"),
    CAT("Cat");

    private final String specieValue;
    SpecieEnum(String specieValue) {
        this.specieValue = specieValue;
    }
}