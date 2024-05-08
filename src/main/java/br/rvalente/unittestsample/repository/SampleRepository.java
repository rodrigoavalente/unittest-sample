package br.rvalente.unittestsample.repository;

import java.util.HashMap;
import java.util.Map;

public class SampleRepository<T> {
    private final Map<Integer, T> table;

    SampleRepository() {
         table = new HashMap<>();
    }

    public boolean save(Integer key, T value) {
        table.put(key, value);
        return true;
    }

    public T find(Integer key) {
        return table.get(key);
    }

    public boolean delete(Integer key) {
        table.remove(key);
        return true;
    }
}
