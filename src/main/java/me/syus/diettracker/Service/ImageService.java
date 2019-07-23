package me.syus.diettracker.Service;

import me.syus.diettracker.domain.Image;
import me.syus.diettracker.repository.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImageService {

    @Autowired
    private ImageDao imageDao;

    public Image saveImage(String title, String url, String s3key) {
        Image image = new Image();
        image.setTitle(title);
        image.setUrl(url);
        image.setS3key(s3key);
        return imageDao.save(image);
    }
}
