package br.com.tutor;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.WebApplicationException;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TutorService {

    @Inject
    TutorRepository tutorRepository;

    @Inject
    TutorParse tutorParse;

    public List<TutorDTO> findAllTutors() {

        List<TutorDTO> tutorDTOS = new ArrayList<>();

        this.tutorRepository.findAll().stream().forEach(item -> tutorDTOS.add(tutorParse.entityToDTO(item)));

        return tutorDTOS;
    }

    public void createNewTutor(TutorDTO tutorDTO) throws WebApplicationException {

        if (tutorDTO.id() != null) {
            throw new BadRequestException("Dont send ID in post");
        }

        tutorRepository.persist(tutorParse.dtoToEntity(tutorDTO));
    }


    public void updateTutor(Long id, TutorDTO tutorDTO) {
        TutorEntity tutorEntity = tutorRepository.findById(id);

        tutorEntity.setCity(tutorDTO.city());
        tutorEntity.setName(tutorDTO.name());
        tutorEntity.setAbout(tutorDTO.about());
        tutorEntity.setEmail(tutorDTO.email());
        tutorEntity.setPassword(tutorDTO.password());
        tutorEntity.setCelPhone(tutorDTO.cellPhone());

        tutorRepository.persist(tutorEntity);
    }

    public void updateTutor(Long id, String field, String newData) {
        Log.info("Aqui!");
    }

    public void deleteTutor(Long id) {
        tutorRepository.deleteById(id);
    }

    public TutorDTO searchTutorById(Long id) throws Exception {

        TutorDTO tutorDTO;

        tutorDTO = tutorParse.entityToDTO(tutorRepository.findById(id));

        if (tutorDTO == null) {
            throw new Exception("Tutor not found");
        }

        return tutorDTO;
    }

}
