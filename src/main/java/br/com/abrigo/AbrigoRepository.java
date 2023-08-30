package br.com.abrigo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AbrigoRepository implements PanacheRepository<AbrigoEntity> {
}
