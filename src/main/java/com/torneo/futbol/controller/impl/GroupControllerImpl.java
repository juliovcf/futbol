package com.torneo.futbol.controller.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneo.futbol.controller.GroupController;
import com.torneo.futbol.model.Group;
import com.torneo.futbol.service.GroupService;

@RestController
@RequestMapping("/api/groups")
public class GroupControllerImpl implements GroupController {

    @Autowired
    private GroupService groupService;

    @Override
    public ResponseEntity<Group> get(Long id) {
        Group group = groupService.getGroupById(id);
        if (group == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(group, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<Group>> get(Collection<Long> ids) {
        return null;
    }

    @Override
    public ResponseEntity<Group> save(Group group) {
        Group savedGroup = groupService.addGroup(group);
        return new ResponseEntity<>(savedGroup, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Group> update(Group group) {
        Group updatedGroup = groupService.updateGroup(group);
        if (updatedGroup == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updatedGroup, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        groupService.deleteGroupById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}    
