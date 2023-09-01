package br.com.pet;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PetParse {

    public PetDTO entityToDto(PetEntity petEntity){
        return new PetDTO(
                petEntity.getId(),
                petEntity.getName(),
                petEntity.getSize(),
                petEntity.getAge(),
                petEntity.getDescription(),
                petEntity.getSpecie(),
                petEntity.getAbrigo(),
                petEntity.getAdotado()

        );
    }

    public PetEntity dtoToEntity(PetDTO petDTO){
        return new PetEntity(petDTO.id(),
                petDTO.name(),
                petDTO.size(),
                petDTO.age(),
                petDTO.description(),
                petDTO.specie(),
                petDTO.abrigo(),
                petDTO.adotado());
    }
}
