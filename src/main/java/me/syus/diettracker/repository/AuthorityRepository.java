package me.syus.diettracker.repository;

import me.syus.diettracker.domain.Authority;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class AuthorityRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    public Authority save(Authority a) {
        Session session = sessionFactory.getCurrentSession();
        session.save(a);
        return a;
    }

    @Transactional
    public List<Authority> findAuthoritiesByUserId(Long userId) {
        String hql = "FROM Authority a where a.user.id = :userid ";
        Session s = sessionFactory.getCurrentSession();
        TypedQuery<Authority> query = s.createQuery(hql);
        query.setParameter("userid", userId);
        List<Authority> a;
        try {
            a = query.getResultList();
        } catch (Exception e) {
            a = null;
        }
        return a;
    }
}
