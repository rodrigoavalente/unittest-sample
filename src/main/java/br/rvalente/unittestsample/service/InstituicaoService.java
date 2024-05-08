package br.rvalente.unittestsample.service;

import br.rvalente.unittestsample.dto.InstituicaoDTO;
import br.rvalente.unittestsample.repository.InstituicaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InstituicaoService {
    private final InstituicaoRepository repository;

    public InstituicaoDTO find(Integer id) throws Exception {
        InstituicaoDTO instituicao = repository.find(id);

        if (Objects.isNull(instituicao))
            throw new Exception("Instituição não encontrada");

        return instituicao;
    }
}
