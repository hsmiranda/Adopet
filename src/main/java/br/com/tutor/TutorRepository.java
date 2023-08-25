package br.com.tutor;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TutorRepository implements PanacheRepository<TutorEntity> {


}
