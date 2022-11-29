package com.mypack.mypack.dao;

import com.sun.tools.javac.util.List;

import java.util.Map;

public interface dao<T> {
    public T get(Class<T> tClass,Integer id);
    public boolean save(T object);
    public boolean update(T object);
    public boolean deleteId(Class<T> tClass, int id);

    public List<T> getAll(Class<T> tClass);

}
