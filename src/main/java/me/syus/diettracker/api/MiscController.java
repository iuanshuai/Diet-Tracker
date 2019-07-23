package me.syus.diettracker.api;

import me.syus.diettracker.Service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;


@RequestMapping(value = {"/api/misc"})
@Controller
@ResponseBody
public class MiscController {

    @Autowired
    private StorageService storageService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

//    @RequestBody
    @RequestMapping(value = "/picture", method = RequestMethod.POST)
    public void uploadImage(@RequestParam("pic") MultipartFile file) {
        File f = new File("/Users/shuaiyuan/Desktop/aa.md");
        try {
            file.transferTo(f);
            storageService.putObject(file.getOriginalFilename(), f);
            logger.info("check uploaded file name" + file.getOriginalFilename());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
