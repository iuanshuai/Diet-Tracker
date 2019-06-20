package me.syus.diettracker.api;


import me.syus.diettracker.Service.UserService;
import me.syus.diettracker.domain.User;
import me.syus.diettracker.repository.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = {"/api/users", "/api/user"}) // all the requests from "/api/users & user" will be listened
@Controller
@ResponseBody // return a data format
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserDao userDao;
    @Autowired
    //TODO replace userDao operation
    private UserService userService;

    // /api/users GET
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List getUserList() {
        logger.debug("list users");
        return userDao.findAll();
    }

    // /api/users POST
    @RequestMapping(value = "", method = RequestMethod.POST)
    public User addUser(@RequestBody User u) {
        return userDao.save(u);
    }


    // /api/users/5  /object/object_id
    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("Id") Long Id) {
        logger.debug("find users id: " + Id);
        return userDao.findById(Id);
    }

    // /api/users?username=seany
    @RequestMapping(value = "", method = RequestMethod.GET, params = "id")
    public User getUserByUsername(@RequestParam("id") Long id) {
        logger.debug("find users by id: " + id);
        return userDao.findById(id);
    }

    // /api/users?firstname=seany
    @RequestMapping(value = "", method = RequestMethod.GET, params = "first_name")
    public List<User> getUserByFirstName(@RequestParam("first_name") String firstName) {
        logger.debug("find users by firstname: " + firstName);
        return userDao.findByFirstName(firstName);

    }

    // /api/users?lastname=seany
    @RequestMapping(value = "", method = RequestMethod.GET, params = "last_name")
    public List<User> getUserByLastName(@RequestParam("last_name") String lastName) {
        logger.debug("find users by lastname: " + lastName);
        return userDao.findByLastName(lastName);

    }

}
