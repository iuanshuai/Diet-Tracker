package me.syus.diettracker.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import java.util.List;

public class CRUDDaoImpl<T, ID> implements CRUDDao<T, ID> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public T save(T t) {
        Session session = sessionFactory.getCurrentSession();
        session.save(t);
        return t;
    }

    @Override
    public List<T> findAll() {
        String hql = "FROM T";
        Session s = sessionFactory.getCurrentSession();
        TypedQuery<T> query = s.createQuery(hql);
        return query.getResultList();
    }

    @Override
    public T findById(ID id) {
        String hql = "FROM T t where t.id = :id2";
        TypedQuery<T> query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("id2", id);
        return query.getSingleResult();
    }
}
