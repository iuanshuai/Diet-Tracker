package me.syus.diettracker.repository;

import me.syus.diettracker.Service.UserService;
import me.syus.diettracker.config.AppConfig;
import me.syus.diettracker.domain.User;
import me.syus.diettracker.extend.security.UserDetailsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertEquals;

@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@WebAppConfiguration


public class LoginTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    @Transactional
    public void loginTest() {

        User expectedResult = new User();
        expectedResult.setUsername("sanzhangd002");
        expectedResult.setFirstName("san");
        expectedResult.setEmail("test@gmail.com");
        expectedResult.setLastName("Zhang");
        expectedResult.setPassword("abc123");
        userService.save(expectedResult);

        UserDetails actualResult = userDetailsServiceImpl.loadUserByUsername(expectedResult.getUsername());
        UserDetails actualResult2 = userDetailsServiceImpl.loadUserByUsername(expectedResult.getEmail());

        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult, actualResult2);

    }

}
