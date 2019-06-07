package me.syus.diettracker.repository;
import me.syus.diettracker.config.AppConfig;
import me.syus.diettracker.domain.Food;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.*;


@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")


public class FoodDaoTest {
    @Autowired
    private FoodDao foodDao;

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

    }
}
