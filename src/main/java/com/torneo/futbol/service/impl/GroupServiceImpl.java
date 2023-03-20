package com.torneo.futbol.service.impl;

import java.util.List;

import com.torneo.futbol.dao.GroupDao;
import com.torneo.futbol.model.Group;
import com.torneo.futbol.service.GroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public Group getById(Long id) {
        return groupDao.findById(id).orElse(null);
    }

    @Override
    public List<Group> getAll() {
        return groupDao.findAll();
    }

    @Override
    public Group create(Group group) {
        return groupDao.create(group);
    }

    @Override
    public Group update(Long id, Group group) {
        group.setId(id);
        return groupDao.create(group);
    }

    @Override
    public void deleteById(Long id) {
        groupDao.delete(id);
    }

    

}