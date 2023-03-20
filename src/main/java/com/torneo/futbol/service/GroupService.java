package com.torneo.futbol.service;

import java.util.List;

import com.torneo.futbol.model.Group;

public interface GroupService {

    Group getById(Long id);

    List<Group> getAll();

    Group create(Group group);

    Group update(Long id, Group group);

    void deleteById(Long id);
}