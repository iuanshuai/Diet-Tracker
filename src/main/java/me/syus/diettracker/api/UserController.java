package me.syus.diettracker.api;


import me.syus.diettracker.repository.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping(value = {"/api/users", "/api/user"}) // all the requests from "/api/users & user" will be listened
@Controller
@ResponseBody // return a data format
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public List getUserList() {
        logger.debug("list users");
        return userDao.findAll();
    }

}
