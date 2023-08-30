package br.com.abrigo;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AbrigoParse {

    public AbrigoDTO entityToDTO(AbrigoEntity abrigoEntity){

        return new AbrigoDTO(abrigoEntity.getId(),
                abrigoEntity.getName(),
                abrigoEntity.getCity(),
                abrigoEntity.getPhone());
    }

    public AbrigoEntity dtoToEntity(AbrigoDTO abrigoDTO){
        return new AbrigoEntity(
                abrigoDTO.id(),
                abrigoDTO.name(),
                abrigoDTO.city(),
                abrigoDTO.phone()
        );
    }
}
