package com.torneo.futbol.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.torneo.futbol.model.Group;

public interface GroupController {

    @GetMapping("/{id}")
    public ResponseEntity<Group> get(@PathVariable(required = true) Long id);

    @GetMapping
    public ResponseEntity<List<Group>> get(@RequestParam(required = false) Collection<Long> ids);

    @PostMapping
    public ResponseEntity<Group> save(@RequestBody Group group);

    @PutMapping
    public ResponseEntity<Group> update(@RequestBody Group group);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(required = true) Long id);

}
