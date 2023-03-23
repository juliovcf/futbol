
package com.torneo.futbol.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.torneo.futbol.model.Group;

import io.swagger.annotations.ApiParam;

@RequestMapping("/groups")
public interface GroupController {

    @GetMapping("/{id}")
    public ResponseEntity<Group> get(@PathVariable(required = true) Long id);

    @GetMapping
    public List<Group> getAll();

    @PostMapping
    public ResponseEntity<Group> save(@ApiParam(required = true) @RequestBody Group group);

    @PutMapping("/{id}")
    public ResponseEntity<Group> update(@PathVariable(required = true) Long id, @RequestBody Group group);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(required = true) Long id);

}