package com.oocl.mnlbc.interfaces;
import java.util.Map;

/**
*
* @author Danna Soquiat
* @since 2016-07-18
*
*
*/

public interface GenericDao<T> {
    
    long countAll(Map<String, Object> params);

    T create(T t);

    void delete(Object id);

    T find(Object id);

    T update(T t);   
}
