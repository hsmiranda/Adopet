package br.com.tutor;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TutorParse {

    public TutorDTO entityToDTO(TutorEntity tutorEntity) {

        return new TutorDTO(
                tutorEntity.getId(),
                tutorEntity.getName(),
                tutorEntity.getEmail(),
                tutorEntity.getPassword(),
                tutorEntity.getCelPhone(),
                tutorEntity.getCity(),
                tutorEntity.getAbout()
        );
    }

    public TutorEntity dtoToEntity(TutorDTO tutorDTO) {

        return new TutorEntity(
                tutorDTO.id(),
                tutorDTO.name(),
                tutorDTO.email(),
                tutorDTO.password(),
                tutorDTO.cellPhone(),
                tutorDTO.city(),
                tutorDTO.about()
        );
    }
}
