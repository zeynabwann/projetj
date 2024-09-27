package com.ism.repository.database;
import java.util.List;
import com.ism.repository.Repository;

public abstract class RepositoryBDImpl<T> implements Repository<T> {   
    @Override
    public List<T> selectAll() {
        return null;
    }

    

   
    
}
