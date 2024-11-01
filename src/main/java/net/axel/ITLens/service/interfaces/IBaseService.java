package net.axel.ITLens.service.interfaces;

import java.util.List;

public interface IBaseService<E, D, R, K> {
    List<R> getAll();

    R getById(K id);

    R create(D dto);

    R update(K id, D dto);

    void delete(K id);
}
