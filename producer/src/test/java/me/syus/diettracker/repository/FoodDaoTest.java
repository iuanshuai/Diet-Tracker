package me.syus.diettracker.repository;

import me.syus.diettracker.config.AppConfig;
import me.syus.diettracker.domain.Food;
import me.syus.diettracker.domain.Image;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@WebAppConfiguration
public class FoodDaoTest {
    @Autowired
    private FoodDao foodDao;

    @Autowired
    private ImageDao imageDao;

    @Test
    @Transactional
    public void findByIdTest() {
        Food expectedResult = new Food();
        expectedResult.setFoodName("Chicken Teriyaki");
        expectedResult.setFoodType("rice");
        expectedResult.setFoodCalorie(340);
        foodDao.save(expectedResult);
        Food actualResult = foodDao.findById(expectedResult.getId());
        assertNotNull(actualResult);
        assertEquals(expectedResult, actualResult);
    }




}
