package me.syus.diettracker.repository;

import me.syus.diettracker.Service.UserService;
import me.syus.diettracker.config.AppConfig;
import me.syus.diettracker.domain.Authority;
import me.syus.diettracker.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@WebAppConfiguration
public class AuthorityDaoTest {

    @Autowired
    private AuthorityDao authorityDao;

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void findAuthoritiesByUserIdTest() {
        User u = new User();

        u.setUsername("zhangsan");
        u.setFirstName("Sanl");
        u.setLastName("HKdd");
        u.setEmail("zs@gmail.com");
        u.setPassword("akjdfd");
        userService.save(u);
        List<Authority> exceptedResult = new ArrayList<>();

        Authority a = new Authority();
        a.setAuthority("ROLE_REGISTERED_USER");
        a.setUser(u);
        authorityDao.save(a);
        exceptedResult.add(a);
        List<Authority> actualResult = authorityDao.findAuthoritiesByUserId(u.getId());

        assertEquals(exceptedResult, actualResult);


    }

}
