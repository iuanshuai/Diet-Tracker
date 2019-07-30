package me.syus.diettracker.repository;
import me.syus.diettracker.Service.ImageService;
import me.syus.diettracker.config.AppConfig;
import me.syus.diettracker.domain.Image;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class ImageServiceTest {
    @Autowired
    private ImageService imageService;



    @Test
    @Transactional
    public void findByIdTest() {
        Image exceptedResult = new Image();
        exceptedResult.setTitle("test title");
        exceptedResult.setUrl("http://test.com");
        exceptedResult.setS3key("tests3key");
        imageService.save(exceptedResult);
        Image actualResult = imageService.findById(exceptedResult.getId());
        assertEquals(exceptedResult, actualResult);
    }

    @Test
    @Transactional
    public void findUrlByIdTest() {
        Image image = new Image();
        image.setTitle("test title");
        image.setUrl("http://test.com");
        image.setS3key("tests3key");
        imageService.save(image);
        String url = imageService.findUrlById(image.getId());
        assertEquals(url, "http://test.com");
    }


}
