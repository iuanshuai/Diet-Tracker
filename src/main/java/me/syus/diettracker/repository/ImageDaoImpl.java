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
public class ImageDaoImpl implements ImageDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
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
        return null;
    }
}
