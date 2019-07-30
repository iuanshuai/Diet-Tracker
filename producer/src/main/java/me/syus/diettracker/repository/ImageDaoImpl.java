package me.syus.diettracker.repository;

import me.syus.diettracker.domain.Image;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ImageDaoImpl implements CRUDDao<Image, Long>, ImageDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public Image save(Image image) {
        Session session = sessionFactory.getCurrentSession();
        session.save(image);
        return image;
    }

    @Override
    public List<Image> findAll() {
        return null;
    }

    @Override
    public Image findByIdEager(Long id) {
        return null;
    }

    @Override
    public Image findById(Long id) {

        String hql = "FROM Image image where image.id = :imageId";
        Session s = sessionFactory.getCurrentSession();
        TypedQuery<Image> query = s.createQuery(hql);
        query.setParameter("imageId", id);
        Image image;
        try {
            image = query.getSingleResult();

        } catch (Exception e) {
            image = null;

        }
        return image;
    }


}
