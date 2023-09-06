package br.com.adocao.Impl;

import br.com.adocao.AdocaoEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AdocaoRepository implements PanacheRepository<AdocaoEntity> {
}
