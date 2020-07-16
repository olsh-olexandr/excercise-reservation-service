package com.grapeup.exercise.controller;

import com.grapeup.exercise.service.SimpleRestService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudRestController<D, S extends SimpleRestService<D>> {
    @Autowired
    @Getter
    private S service;

    @GetMapping
    public List<? extends D> getAll(){
        return service.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<D> getById(@PathVariable long id) {
        Optional<D> item = service.getById(id);
        return item.map(d -> ResponseEntity.ok().body(d)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<D> removeById(@PathVariable long id) {
        service.removeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody D dto) {
        long newId = service.create(dto);
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequestUri().build(String.valueOf(newId)))
                .build();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody D dto, @PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().body("Invalid id");
        }
        service.update(dto, id);
        return ResponseEntity.ok(dto);
    }
}