package com.solutis.votacao.domain.common.service;

import java.util.List;
import java.util.Optional;

public interface BaseService <T, ID>{

    <S extends T> S save(S entity);


    <S extends T> S update(S entity);

    List<T> findALL();

    List<T> findAll();

    Optional<T> findById(ID id);

    void delete(T entity);

    void deleteById(ID id);

    void beforeSave(T entity);

    void beforeUpdate(T entity);

}
