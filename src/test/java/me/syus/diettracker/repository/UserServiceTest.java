package me.syus.diettracker.repository;

import me.syus.diettracker.Service.UserService;
import me.syus.diettracker.config.AppConfig;
import me.syus.diettracker.domain.User;
import me.syus.diettracker.extend.exp.NotFoundException;
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

public class UserServiceTest {
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
        expectedResult.setPassword("abc123");
        userService.save(expectedResult);
        logger.debug("the user id is: " + expectedResult.getId());
        User actualResult = userService.findById(expectedResult.getId());

        assertNotNull(actualResult);
        assertEquals(expectedResult, actualResult);

    }


    @Test
    @Transactional
    public void findByEmailOrUsernameTest() throws NotFoundException {
        User exceptedResult = new User();
        exceptedResult.setUsername("zhangsan");
        exceptedResult.setFirstName("Sanl");
        exceptedResult.setLastName("HKdd");
        exceptedResult.setEmail("zs@gmail.com");
        exceptedResult.setPassword("akjdfd");
        userService.save(exceptedResult);
        User actualResult = userService.findByEmailOrUsername(exceptedResult.getEmail());
        assertEquals(exceptedResult, actualResult);

        User actualResult2 = userService.findByEmailOrUsername(exceptedResult.getUsername());
        assertEquals(exceptedResult, actualResult2);
    }


//    @Test
//    @Transactional
//    public void createUserTest() {
//        User exceptedResult = new User();
//        exceptedResult.setUsername("zhangsan");
//        exceptedResult.setFirstName("Sanl");
//        exceptedResult.setLastName("HKdd");
//        exceptedResult.setEmail("zs@gmail.com");
//        exceptedResult.setPassword("akjdfd");
//        userService.createUser(exceptedResult);
//        User actualResult = userService.findByEmailOrUsername(exceptedResult.getEmail());
//        assertFalse(exceptedResult.getPassword() == actualResult.getPassword());
//    }

}
