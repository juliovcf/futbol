package com.torneo.futbol.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.torneo.futbol.dao.IMatchEventDao;
import com.torneo.futbol.model.MatchEvent;
import com.torneo.futbol.repository.MatchEventRepository;

public class MatchEventDao implements IMatchEventDao{

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllInBatch(Iterable<MatchEvent> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<MatchEvent> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MatchEvent> findAll(Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends MatchEvent> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends MatchEvent> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MatchEvent> findAllById(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public MatchEvent getById(Long id) {
        return null;
    }

    @Override
    public MatchEvent getOne(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MatchEvent getReferenceById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends MatchEvent> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends MatchEvent> List<S> saveAllAndFlush(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends MatchEvent> S saveAndFlush(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<MatchEvent> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(MatchEvent entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll(Iterable<? extends MatchEvent> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public MatchEvent findById(Long id) {
        
        return MatchEventRepository.findById(id);
    }

    @Override
    public <S extends MatchEvent> S save(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends MatchEvent> long count(Example<S> example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <S extends MatchEvent> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <S extends MatchEvent> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends MatchEvent, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends MatchEvent> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public Collection<MatchEvent> getByMatchID(Collection<Long> id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<MatchEvent> get(Collection<Long> id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
