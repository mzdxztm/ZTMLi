package com.mzdxztm.ztm.library.data.db;

import java.util.List;

public interface ITable<T> {

    boolean createTable(String tableName);

    boolean deleteTable();

    boolean tableUpdate();

    boolean addCanNullCulum(String type, String culumName);

    boolean addNotNullCulum(String type, String culumName);

    boolean inseart(T entity);

    boolean delete(T entity);

    boolean delete(long id);

    boolean update(T entity);

    List<T> qurery(String sql, String[] selectionArgs);

}
