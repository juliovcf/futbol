package com.torneo.futbol.dao;

import java.util.List;
import java.util.Optional;

import com.torneo.futbol.model.Group;

public interface GroupDao {
    
    Group create(Group group);

    List<Group> findAll();

    Optional<Group> findById(Long id);

    Group update(Long id, Group group);

    void delete(Long id);
    
}