package br.com.pet;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PetService {

    @Inject
    PetRepository repository;

    @Inject
    PetParse parse;


    public List<PetDTO> listAll() {

        List<PetDTO> petDTOS = new ArrayList<>();
        List<PetEntity> teste = this.repository.findAll().stream().toList();

        this.repository.findAll().stream().forEach(
                petEntity -> petDTOS.add(this.parse.entityToDto(petEntity))
        );

        return petDTOS;
    }
}
