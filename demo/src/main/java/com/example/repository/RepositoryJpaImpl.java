package com.example.repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ism.repository.Repository;


public class RepositoryJpaImpl<T> implements Repository<T> {
    private EntityManagerFactory emf;
    protected EntityManager em;
    EntityManagerFactory emf = Persistence.createEntityFactory();

    @Override
    public void insert(T data){
        try {
            em.getTransaction().begin();
            em.persist(data);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            // TODO: handle exception
        }
    }

    @Override
    public List<T> selectAll() {
        return this.em.CreateQuery("SELECT u FROM Client u", type).getResultList();
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectAll'");
    }

    @Override
    public int insert(String sql) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

}
