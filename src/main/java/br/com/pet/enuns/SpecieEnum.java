package br.com.pet.enuns;

public enum SpecieEnum {
    DOG("Dog"),
    CAT("Cat");

    private final String specieValue;
    SpecieEnum(String specieValue) {
        this.specieValue = specieValue;
    }
}