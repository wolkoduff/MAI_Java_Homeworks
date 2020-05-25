package ru.mai.sample.Function;

public interface Functions<T> {
    Iterable<T> findAll();
    void save(T entries);
    T findByIdNumber(int id);
    void delete(T entries);
}
