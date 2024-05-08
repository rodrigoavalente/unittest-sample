package br.rvalente.unittestsample.repository;

import br.rvalente.unittestsample.dto.InstituicaoDTO;
import org.springframework.stereotype.Component;

@Component
public class InstituicaoRepository extends SampleRepository<InstituicaoDTO> {
    InstituicaoRepository() {
        super();
    }
}
