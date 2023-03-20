package com.torneo.futbol.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.torneo.futbol.dao.GroupDao;
import com.torneo.futbol.model.Group;
import com.torneo.futbol.repository.GroupRepository;

@Repository
public class GroupDaoImpl implements GroupDao {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group create(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Optional<Group> findById(Long id) {
        return findById(id);
    }

    @Override
    public Group update(Long id, Group group) {
        group.setId(id);
        return groupRepository.save(group);
    }

    @Override
    public void delete(Long id) {
        groupRepository.deleteById(id);
    }

}
