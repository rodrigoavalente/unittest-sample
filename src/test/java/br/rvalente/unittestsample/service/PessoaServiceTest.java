package br.rvalente.unittestsample.service;


import br.rvalente.unittestsample.dto.InstituicaoDTO;
import br.rvalente.unittestsample.dto.PessoaDTO;
import br.rvalente.unittestsample.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PessoaServiceTest {
    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private InstituicaoService instituicaoService;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    public void testSave() throws Exception {
        Integer key = 1;
        PessoaDTO pessoaDTO = PessoaDTO.builder().nome("João").idade(30).instituicaoId(1).build();

        when(instituicaoService.find(1)).thenReturn(InstituicaoDTO.builder().build());

        when(pessoaRepository.save(anyInt(), any(PessoaDTO.class))).thenReturn(true);

        boolean result = pessoaService.save(key, pessoaDTO);

        assertFalse(result);
        assertNotNull(pessoaDTO.getId());
    }

    @Test
    public void testSaveWithNullName() {
        Integer key = 1;
        PessoaDTO pessoaDTO = PessoaDTO.builder().idade(30).instituicaoId(1).build();

        Exception exception = assertThrows(Exception.class, () -> pessoaService.save(key, pessoaDTO));

        assertEquals(exception.getMessage(), "Nome não pode ser nulo.");
    }

    @Test
    public void testSaveWithNullIdade() {
        Integer key = 1;
        PessoaDTO pessoaDTO = PessoaDTO.builder().idade(null).nome("Nome").instituicaoId(1).build();

        Exception exception = assertThrows(Exception.class, () -> pessoaService.save(key, pessoaDTO));

        assertEquals(exception.getMessage(), "Idade não pode ser nula.");
    }

    @Test
    public void testSaveWithNullInstituicao() {
        Integer key = 1;
        PessoaDTO pessoaDTO = PessoaDTO.builder().idade(30).nome("Nome").instituicaoId(null).build();

        Exception exception = assertThrows(Exception.class, () -> pessoaService.save(key, pessoaDTO));

        assertEquals(exception.getMessage(), "Instituição não pode ser nula.");
    }

    @Test
    public void testSaveWithNonExistingInstituicao() throws Exception {
        Integer key = 1;
        PessoaDTO pessoaDTO = PessoaDTO.builder().idade(30).nome("Nome").instituicaoId(2).build();

        when(instituicaoService.find(anyInt())).thenThrow(new Exception("Instituição não pode ser nula."));

        when(pessoaRepository.save(anyInt(), any(PessoaDTO.class))).thenReturn(true);

        Exception exception = assertThrows(Exception.class, () -> pessoaService.save(key, pessoaDTO));

        assertEquals(exception.getMessage(), "Instituição não pode ser nula.");
    }
}
