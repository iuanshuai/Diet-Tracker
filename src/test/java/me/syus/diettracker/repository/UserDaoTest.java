package me.syus.diettracker.repository;

import me.syus.diettracker.config.AppConfig;
import me.syus.diettracker.domain.User;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.*;


@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@WebAppConfiguration

public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private SessionFactory sessionFactory;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    @Transactional // after doing unit test, roll back
    public void findByIdTest() {
        User expectedResult = new User();
        expectedResult.setFirstName("san");
        expectedResult.setEmail("test@gmail.com");
        expectedResult.setLastName("Zhang");
        userDao.save(expectedResult);
        logger.debug("the user id is: " + expectedResult.getId());
        User actualResult = userDao.findById(expectedResult.getId());

        assertNotNull(actualResult);
        assertEquals(expectedResult, actualResult);

    }


    @Test
    @Transactional // after doing unit test, roll back
    public void findByFirstNameTest() {
        User expectedResult = new User();
        expectedResult.setFirstName("san");
        expectedResult.setEmail("test@gmail.com");
        expectedResult.setLastName("Zhang");
        userDao.save(expectedResult);
//        sessionFactory.getCurrentSession().flush();
        logger.debug("the user first name is: " + expectedResult.getFirstName());

        User actualResult = userDao.findByFirstName(expectedResult.getFirstName());
        System.out.println(actualResult.getFirstName());

        //assertNotNull(actualResult);
        assertEquals(expectedResult, actualResult);

    }
}
