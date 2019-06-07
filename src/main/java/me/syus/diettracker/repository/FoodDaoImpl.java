package me.syus.diettracker.repository;

import me.syus.diettracker.domain.Food;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class FoodDaoImpl implements FoodDao {

    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public Food save(Food food) {
        Session session = sessionFactory.getCurrentSession();
        session.save(food);
        return food;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Food> findAll() {
        String hql = "FROM Food";
        Session s = sessionFactory.getCurrentSession();
        TypedQuery<Food> query = s.createQuery(hql);
        return query.getResultList();
    }

    @Override
    public Food findByIdEager(Long id) {
        return null;
    }

    @Override
    public Food findById(Long id) {
        String hql = "FROM Food f where f.id = :foodId";
        Session s = sessionFactory.getCurrentSession();
        TypedQuery<Food> query = s.createQuery(hql);
        query.setParameter("foodId", id);
        return query.getSingleResult();
    }
}
