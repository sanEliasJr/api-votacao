package com.solutis.votacao.domain.common.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class BaseServiceImpl <T, ID> implements BaseService<T,ID>{

    public abstract <R extends JpaRepository<T, ID>> R getRepository();


    @Override
    public <S extends T>  S save (S entity){
        beforeSave(entity);
        return getRepository().save(entity);
    }


    @Override
    public <S extends T> S update(S entity){
        beforeUpdate(entity);
        return getRepository().save(entity);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public Optional<T> findById(ID id){
        return getRepository().findById(id);
    }

    @Override
    public void delete (T entity){
        getRepository().delete(entity);
    }

    @Override
    public void deleteById(ID id){
        getRepository().deleteById(id);
    }
}
