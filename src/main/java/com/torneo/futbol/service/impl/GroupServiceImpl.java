package com.torneo.futbol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torneo.futbol.model.Group;
import com.torneo.futbol.repository.GroupRepository;
import com.torneo.futbol.service.GroupService;

@Service
public class GroupServiceImpl  implements GroupService{

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public List<Group> getAllgroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group addGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group updateGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public void deleteGroupById(Long id) {
        groupRepository.deleteById(id);
        
    }
    
}