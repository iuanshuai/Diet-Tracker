package me.syus.diettracker.api;

import me.syus.diettracker.Service.ImageService;
import me.syus.diettracker.Service.StorageService;
import me.syus.diettracker.domain.Image;
import me.syus.diettracker.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@RequestMapping(value = {"/api/misc"})
@Controller
@ResponseBody
public class MiscController {

    @Autowired
    private StorageService storageService;
    @Autowired
    private ImageService imageService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    // @RequestBody
    // /api/misc/picture POST
    @RequestMapping(value = "/picture", method = RequestMethod.POST)
    public ResponseEntity<Image> uploadImage(@RequestParam("pic") MultipartFile file) {

        UUID uuid = UUID.randomUUID();
        File f = new File(System.getProperty("catalina.base") + uuid.toString());
        String fileName = "";
        Image image = null;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User username = (User) auth.getPrincipal();
        logger.debug("current user is: " + username);

//        Response response = new Response();

        try {
            file.transferTo(f);
            fileName = file.getOriginalFilename();
            int lastDot = fileName.lastIndexOf('.');
            // todo use apache commons-io
            fileName = fileName.substring(0, lastDot) + uuid.toString() + fileName.substring(lastDot);
            storageService.putObject(fileName, f);
            String imageRrl = storageService.getObjectUrl(fileName);
            image = imageService.saveImage("test", imageRrl, fileName);
            logger.info("check uploaded file name" + file.getOriginalFilename());
            logger.info("check uploaded new file name" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            // throw an http status code
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity(image, HttpStatus.OK);
    }


    // /api/misc/picture GET
    @RequestMapping(value = "/picture/{Id}", method = RequestMethod.GET)
    public String getUrlById(@PathVariable("Id") Long Id) {
        logger.debug("find image id: " + Id);
        return imageService.findUrlById(Id);
    }
}
