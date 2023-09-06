package br.com.adocao;

public interface IAdocaoParse {

    public AdocaoDTO entityToDto(AdocaoEntity entidade);
    public AdocaoEntity dtoToEntity(AdocaoDTO adocaoDTO);
}
