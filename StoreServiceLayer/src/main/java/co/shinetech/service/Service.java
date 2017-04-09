/*
* Service.java
 */
package co.shinetech.service;

import co.shinetech.model.Domain;

/**
 * Service Interface to expose abstract useful basic operation methods (CRUD operations).
 * Created by rodrigo on 3/24/2017.
 */
public interface Service<T extends Domain> {
    void create(T o);
    T findById(String id);
    Iterable<T> findAll();
    void update(T o);
    void delete(T o);
}