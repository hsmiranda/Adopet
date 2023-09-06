package br.com.adocao.Impl;

import br.com.adocao.AdocaoDTO;
import br.com.adocao.IAdocaoBO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AdocaoBO implements IAdocaoBO {
    @Override
    public AdocaoDTO setAdotado() {
        return null;
    }

    @Override
    public Boolean isAdotado() {
        return null;
    }
}
