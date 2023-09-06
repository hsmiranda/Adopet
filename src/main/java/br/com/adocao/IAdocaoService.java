package br.com.adocao;

import java.util.List;

public interface IAdocaoService {

    public List<AdocaoDTO> findAll();

    public AdocaoDTO create(AdocaoDTO adocaoDTO);

    public AdocaoDTO update(AdocaoDTO adocaoDTO, Long id);

    public void delete(Long id);

}
