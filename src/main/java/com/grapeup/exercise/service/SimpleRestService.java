package com.grapeup.exercise.service;

import java.util.List;
import java.util.Optional;

public interface SimpleRestService<T> {
    List<? extends T> getAll();

    void removeById(long id);

    void update(T item, long id);

    long create(T item);

    Optional<T> getById(long id);
}