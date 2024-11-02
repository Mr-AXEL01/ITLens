package net.axel.ITLens.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.axel.ITLens.service.interfaces.IBaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseController<E, D, R, K> {

    protected final IBaseService<E, D, R, K> baseService;

    @GetMapping
    public ResponseEntity<List<R>> getAll() {
        List<R> entities = baseService.getAll();
        return ResponseEntity.ok(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<R> getById(@PathVariable("id") K id) {
        R entity = baseService.getById(id);
        return ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<R> create(@RequestBody @Valid D dto) {
        R createdEntity = baseService.create(dto);
        return new ResponseEntity<>(createdEntity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<R> update(@PathVariable("id") @Valid K id, @RequestBody D dto) {
        R updatedEntity = baseService.update(id, dto);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") K id) {
        baseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
