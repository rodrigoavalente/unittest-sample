package br.rvalente.unittestsample.service;

import br.rvalente.unittestsample.dto.PessoaDTO;
import br.rvalente.unittestsample.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    private final InstituicaoService instituicaoService;

    private Integer currentId = 0;

    public boolean save(Integer key, PessoaDTO value) throws Exception {
        currentId++;

        value.setId(currentId);

        if (Objects.isNull(value.getNome()))
            throw new Exception("Nome não pode ser nulo.");

        if (Objects.isNull(value.getIdade()))
            throw new Exception("Idade não pode ser nula.");

        if (Objects.isNull(value.getInstituicaoId()))
            throw new Exception("Instituição não pode ser nula.");
        else {
            value.setInstituicaoDTO(instituicaoService.find(value.getId()));
        }

        return pessoaRepository.save(key, value);
    }

    public PessoaDTO find(Integer key) {
        return pessoaRepository.find(key);
    }

    public boolean delete(Integer key) {
        return pessoaRepository.delete(key);
    }
}
