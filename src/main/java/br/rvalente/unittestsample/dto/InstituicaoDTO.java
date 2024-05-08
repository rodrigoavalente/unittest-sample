package br.rvalente.unittestsample.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InstituicaoDTO {
    private Integer id;

    private String nome;
}
