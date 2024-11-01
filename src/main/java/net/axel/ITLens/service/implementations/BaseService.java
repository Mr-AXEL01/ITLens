package net.axel.ITLens.service.implementations;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.axel.ITLens.service.interfaces.IBaseService;
import net.axel.ITLens.util.mapper.BaseMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Transactional
@RequiredArgsConstructor
public abstract class BaseService<E, D, R, K> implements IBaseService<E, D, R, K> {

    protected final JpaRepository<E, K> repository;
    protected final BaseMapper<E, R, D> mapper;

    @Override
    public List<R> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @Override
    public R getById(K id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        return repository.findById(id)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
    }

    @Override
    public R create(D dto) {
        E entity = mapper.toEntity(dto);
        E savedEntity = repository.save(entity);
        return mapper.toResponseDto(savedEntity);
    }

    @Override
    public R update(K id, D dto) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        E entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
        updateEntity(entity, dto);
        E updatedEntity = repository.save(entity);
        return mapper.toResponseDto(updatedEntity);
    }

    @Override
    public void delete(K id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (!repository.existsById(id)) {
            throw new RuntimeException("Entity not found with id: " + id);
        }

        repository.deleteById(id);
    }

    protected abstract void updateEntity(E entity, D dto);
}
