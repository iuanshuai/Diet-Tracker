package me.syus.diettracker.repository;


import me.syus.diettracker.Service.UserService;
import me.syus.diettracker.config.AppConfig;
import me.syus.diettracker.domain.User;
import me.syus.diettracker.extend.security.JwtTokenUtil;
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

@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@WebAppConfiguration
public class JwtTokenUtilTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Test
    @Transactional
    public void generateTokenTest() {

        User user = new User();
        user.setUsername("unituser");
        user.setFirstName("san");
        user.setEmail("test@gmail.com");
        user.setLastName("Zhang");
        user.setPassword("abc123");
        userService.save(user);
        String token = jwtTokenUtil.generateToken(userService.findByEmailOrUsername("unituser"));
        logger.debug("token="+token);
        String[] actualResult = token.split("\\.");
        assertEquals(actualResult.length, 3);
    }

    @Test
    @Transactional
    public void getUsernameFromTokenTest() {
        User user = new User();
        user.setUsername("unituser");
        user.setFirstName("san");
        user.setEmail("test@gmail.com");
        user.setLastName("Zhang");
        user.setPassword("abc123");
        userService.save(user);
        String token = jwtTokenUtil.generateToken(userService.findByEmailOrUsername("unituser"));
        String expectedResult = user.getUsername();
        String actualResult = jwtTokenUtil.getUsernameFromToken(token);
        assertEquals(expectedResult, actualResult);

    }

}
