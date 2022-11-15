package com.example.boardgamescontainer.entityModelFactories;

public interface EntityModelFactory<T, M> {

    T createEntityFromModel(M m);

    M createModelFromEntity(T t);

    M createModelFromEntityId(Long id);
}
