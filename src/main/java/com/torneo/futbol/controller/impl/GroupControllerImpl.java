
package com.torneo.futbol.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.torneo.futbol.controller.GroupController;
import com.torneo.futbol.model.Group;
import com.torneo.futbol.service.GroupService;

@RestController
public class GroupControllerImpl implements GroupController {

    @Autowired
    private GroupService groupService;

    @Override
    public ResponseEntity<Group> get(Long id) {
        Group group = groupService.getById(id);
        if (group == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(group, HttpStatus.OK);
        }
    }

    @Override
    public List<Group> getAll() {
        return groupService.getAll();
    }

    @Override
    public ResponseEntity<Group> save(Group group) {
        Group savedGroup = groupService.create(group);
        return new ResponseEntity<>(savedGroup,
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Group> update(Long id, Group group) {
        Group updatedGroup = groupService.update(id, group);
        if (updatedGroup == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updatedGroup, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        groupService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
