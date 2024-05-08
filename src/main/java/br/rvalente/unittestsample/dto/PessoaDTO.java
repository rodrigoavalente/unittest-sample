package br.rvalente.unittestsample.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class PessoaDTO {

    private Integer id;

    private String nome;

    private Integer idade;

    private Integer instituicaoId;

    private InstituicaoDTO instituicaoDTO;
}
