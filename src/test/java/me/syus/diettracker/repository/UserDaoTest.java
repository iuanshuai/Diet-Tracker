package me.syus.diettracker.repository;

import me.syus.diettracker.Service.UserService;
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

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@WebAppConfiguration

public class UserDaoTest {
    @Autowired
    private UserService userService;
    @Autowired
    private SessionFactory sessionFactory;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    @Transactional // after doing unit test, roll back
    public void findByIdTest() {
        User expectedResult = new User();
        expectedResult.setUsername("sanzhang002");
        expectedResult.setFirstName("san");
        expectedResult.setEmail("test@gmail.com");
        expectedResult.setLastName("Zhang");
        userService.save(expectedResult);
        logger.debug("the user id is: " + expectedResult.getId());
        User actualResult = userService.findById(expectedResult.getId());

        assertNotNull(actualResult);
        assertEquals(expectedResult, actualResult);

    }

    @Test
    @Transactional
    public void findByUsernameTest() {
        User expectResult = new User();
        expectResult.setUsername("testuser001");
        expectResult.setFirstName("Hung");
        expectResult.setLastName("John");
        expectResult.setPassword("aaa");
        expectResult.setEmail("test@icloud.com");
        userService.save(expectResult);
        User actualResult = userService.findByUsername(expectResult.getUsername());
        assertEquals(expectResult, actualResult);
    }

    @Test
    @Transactional // after doing unit test, roll back
    public void findByFirstNameTest() {

        User expectedResult = new User();
        expectedResult.setUsername("sanzhang001");
        expectedResult.setFirstName("san");
        expectedResult.setEmail("test@gmail.com");
        expectedResult.setPassword("aaa");
        expectedResult.setLastName("Zhang");
        userService.save(expectedResult);
//        sessionFactory.getCurrentSession().flush();
        logger.debug("the user first name is: " + expectedResult.getFirstName());

        User actualResult = userService.findByFirstName(expectedResult.getFirstName()).get(0);
        //assertNotNull(actualResult);
        assertEquals(expectedResult, actualResult);

    }

    @Test
    @Transactional
    public void findByLastNameTest() {
        User expectedResult = new User();
        expectedResult.setUsername("aaahhh001");
        expectedResult.setFirstName("hhh");
        expectedResult.setEmail("test@gmail.com");
        expectedResult.setLastName("aaa");
        expectedResult.setPassword("aaa");
        userService.save(expectedResult);
        logger.debug("the user last name is: " + expectedResult.getLastName());
        User actualResult = userService.findByLastName(expectedResult.getLastName()).get(0);
        assertEquals(expectedResult, actualResult);
    }



}
