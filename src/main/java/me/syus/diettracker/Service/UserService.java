package me.syus.diettracker.Service;

import javassist.NotFoundException;
import me.syus.diettracker.domain.User;
import me.syus.diettracker.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public User save(User user) {
        return userDao.save(user);
    }

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public List<User> findAll() {
        List<User> users = userDao.findAll();
        return users;
    }

    public User findById(Long id) {
        User user = userDao.findById(id);
        return user;
    }

    public User findByUsername(String username) {
        User user = userDao.findByUsernameIgnoreCase(username);
        return user;
    }

    public List<User> findByFirstName(String firstName) {
        List<User> users = userDao.findByFirstName(firstName);
        return users;
    }

    public List<User> findByLastName(String lastName) {
        List<User> users = userDao.findByLastName(lastName);
        return users;
    }


    public User findByEmailOrUsername(String keyword) throws NullPointerException{
        if (keyword == null || "".equals(keyword.trim())) {
            throw new NullPointerException("Search keyword is null");
        }
        User user = userDao.findByEmailIgnoreCase(keyword);
        if (user == null) {
            user = userDao.findByUsernameIgnoreCase(keyword);
        }
//        if (user == null) {
//            throw new NotFoundException();
//        }
        return user;

    }

}
