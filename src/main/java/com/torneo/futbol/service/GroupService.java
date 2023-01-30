package com.torneo.futbol.service;

import java.util.List;

import com.torneo.futbol.model.Group;

public interface GroupService {

    Group getGroupById(Long id);

    List<Group> getAllgroups();

    Group addGroup(Group group);

    Group updateGroup(Group group);

    void deleteGroupById(Long id);
}