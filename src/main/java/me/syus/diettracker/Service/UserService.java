package me.syus.diettracker.Service;

import me.syus.diettracker.domain.User;
import me.syus.diettracker.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    public List<User> getBestValue() {
        List<User> users = userDao.findAll();
        return users;
    }

}
