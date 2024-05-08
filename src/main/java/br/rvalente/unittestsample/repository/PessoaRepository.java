package br.rvalente.unittestsample.repository;

import br.rvalente.unittestsample.dto.PessoaDTO;

import java.util.HashMap;
import java.util.Map;

public class PessoaRepository {

    private final Map<Integer, PessoaDTO> table;

    PessoaRepository() {
        table = new HashMap<>();
    }

    public boolean save(Integer key, PessoaDTO value) {
        table.put(key, value);
        return true;
    }

    public PessoaDTO find(Integer key) {
        return table.get(key);
    }

    public boolean delete(Integer key) {
        table.remove(key);
        return true;
    }

}
