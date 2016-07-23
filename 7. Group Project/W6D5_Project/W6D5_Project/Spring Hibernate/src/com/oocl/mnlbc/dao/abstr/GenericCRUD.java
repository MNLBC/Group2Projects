package com.oocl.mnlbc.dao.abstr;

public interface GenericCRUD<T> {
    public int add(T t);
    public int update(T t);
    public int remove(long id);
    

}
