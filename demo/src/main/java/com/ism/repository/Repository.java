package com.ism.repository;
import java.util.List;

public interface Repository<T> {
    void insert(T data);
    int insert(String sql);

    List<T> selectAll();
    
}
