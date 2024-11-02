package net.axel.ITLens.mapper;

public interface BaseMapper<E, R, D> {
    E toEntity(D dto);

    R toResponseDto(E entity);

    E toEntityFromResponseDto(R responseDto);
}
