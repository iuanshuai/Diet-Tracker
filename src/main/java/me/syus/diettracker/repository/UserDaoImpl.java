package me.syus.diettracker.repository;
import me.syus.diettracker.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl extends CRUDDaoImpl<User, Long> implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public User save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        String hql = "FROM User";
        Session s = sessionFactory.getCurrentSession();
        TypedQuery<User> query = s.createQuery(hql);
        return query.getResultList();
    }

    @Override
    public User findByIdEager(Long id) {
        return null;
    }

    @Override
    @Transactional
    public User findById(Long id) {
        String hql = "FROM User u where u.id = :userId";
        Session s = sessionFactory.getCurrentSession();
        TypedQuery<User> query = s.createQuery(hql);
        query.setParameter("userId", id);
        User user;
        try {
            user = query.getSingleResult();

        } catch (Exception e) {
            user = null;

        }
        return user;
    }

//    @Override
//    @Transactional
//    public User findByFirstName(String firstName) {
//        String hql = "FROM User u where lower(u.firstName) = lower(:firstName2)";
////        String hql = "FROM User u where u.firstName = :firstName2";
//        Session s = sessionFactory.getCurrentSession();
//        TypedQuery<User> query = s.createQuery(hql);
//        query.setParameter("firstName2", firstName);
//        User user;
//        try {
//            user = query.getSingleResult();
//
//        } catch (Exception e) {
//            user = null;
//
//        }
//        return user;
//    }


    @Override
    @Transactional
    public List<User> findByFirstName(String firstName) {
        String hql = "FROM User u where lower(u.firstName) = lower(:firstName2)";
//        String hql = "FROM User u where u.firstName = :firstName2";
        Session s = sessionFactory.getCurrentSession();
        TypedQuery<User> query = s.createQuery(hql);
        query.setParameter("firstName2", firstName);
        return getResultListFromHql(query);
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        String hql = "FROM User u where u.username = :username";
        Session s = sessionFactory.getCurrentSession();
        TypedQuery<User> query = s.createQuery(hql);
        query.setParameter("username", username);
        User user;
        try {
            user = query.getSingleResult();

        } catch (Exception e) {
            user = null;

        }
        return user;
    }

    @Override
    @Transactional
    public List<User> findByLastName(String lastName) {
        String hql = "FROM User u where lower(u.lastName) = lower(:lastName2)";
        Session s = sessionFactory.getCurrentSession();
        TypedQuery<User> query = s.createQuery(hql);
        query.setParameter("lastName2", lastName);
        return getResultListFromHql(query);
    }

    private List<User> getResultListFromHql(TypedQuery<User> query){
        List<User> users;
        try {
            users = query.getResultList();

        } catch (Exception e) {
            users = null;

        }
        return users;
    }
}
