package br.com.adocao.Impl;

import br.com.adocao.*;
import br.com.tutor.TutorDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class AdocaoService implements IAdocaoService {

    @Inject
    IAdocaoBO bo;

    @Inject
    IAdocaoParse parse;

    @Inject
    AdocaoRepository repository;

    @Override
    public List<AdocaoDTO> findAll() {
        List<AdocaoDTO> adocaoDTOS = new ArrayList<>();

        this.repository.findAll().stream().forEach(
                item -> adocaoDTOS.add(
                        this.parse.entityToDto(item)
                )
        );

        return adocaoDTOS;
    }

    @Override
    public AdocaoDTO create(AdocaoDTO adocaoDTO) {
        return null;
    }

    @Override
    public AdocaoDTO update(AdocaoDTO adocaoDTO, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
