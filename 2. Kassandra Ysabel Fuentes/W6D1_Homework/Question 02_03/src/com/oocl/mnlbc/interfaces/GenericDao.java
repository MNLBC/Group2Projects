package com.oocl.mnlbc.interfaces;
import java.util.List;
import java.util.Map;

public interface GenericDao<T> {
    
    long countAll(Map<String, Object> params);

    T create(T t);

    void delete(Object id);

    T find(Object id);

    T update(T t);   
}
