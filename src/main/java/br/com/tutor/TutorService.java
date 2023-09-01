package br.com.tutor;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.WebApplicationException;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TutorService {

    @Inject
    TutorRepository repository;

    @Inject
    TutorParse parse;

    public List<TutorDTO> findAllTutors() {

        List<TutorDTO> tutorDTOS = new ArrayList<>();

        this.repository.findAll().stream().forEach(item -> tutorDTOS.add(parse.entityToDTO(item)));

        return tutorDTOS;
    }

    public void createNewTutor(TutorDTO tutorDTO) throws WebApplicationException {

        if (tutorDTO.id() != null) {
            throw new BadRequestException("Dont send ID in post");
        }

        repository.persist(parse.dtoToEntity(tutorDTO));
    }


    public void updateTutor(Long id, TutorDTO tutorDTO) {
        TutorEntity tutorEntity = repository.findById(id);

        tutorEntity.setCity(tutorDTO.city());
        tutorEntity.setName(tutorDTO.name());
        tutorEntity.setAbout(tutorDTO.about());
        tutorEntity.setEmail(tutorDTO.email());
        tutorEntity.setPassword(tutorDTO.password());
        tutorEntity.setCelPhone(tutorDTO.cellPhone());

        repository.persist(tutorEntity);
    }

    public void deleteTutor(Long id) {
        repository.deleteById(id);
    }

    public TutorDTO searchTutorById(Long id) throws Exception {

        TutorDTO tutorDTO = parse.entityToDTO(repository.findById(id));

        if (tutorDTO == null) {
            throw new Exception("Tutor not found");
        }

        return tutorDTO;
    }

}
