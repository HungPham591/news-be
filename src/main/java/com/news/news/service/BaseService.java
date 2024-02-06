package com.news.news.service;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public abstract class BaseService<T, ID> {
    protected JpaRepository<T, ID> repository;



    @Transactional(readOnly = true)
    public List<T> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Transactional
    public T save(T entity) {
        return repository.save(entity);
    }

    @Transactional
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    public <S, R> R mapObject(S source, Function<S, R> mapper) {
        return mapper.apply(source);
    }

    public <S, R> List<R> mapObjects(List<S> sources, Function<S, R> mapper) {
        return sources.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}
