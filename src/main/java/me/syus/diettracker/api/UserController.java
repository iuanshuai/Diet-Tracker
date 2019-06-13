package me.syus.diettracker.api;


import me.syus.diettracker.domain.User;
import me.syus.diettracker.repository.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping(value = {"/api/users", "/api/user"}) // all the requests from "/api/users & user" will be listened
@Controller
@ResponseBody // return a data format
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public List getUserList() {
        logger.debug("list users");
        return userDao.findAll();
    }

    // /api/users/5  /object/object_id
    @RequestMapping(value="/{Id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("Id") Long Id) {
        logger.debug("find users id: " + Id);
        return userDao.findById(Id);
    }
}
