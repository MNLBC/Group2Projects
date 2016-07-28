package com.oocl.mnlbc.dao.abstr;

public interface GenericCRUD<T> {
    public boolean add(T t);
    public boolean update(T t);
    public boolean remove(long id);
    

}
