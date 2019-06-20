package me.syus.diettracker.Service;

import me.syus.diettracker.domain.User;
import me.syus.diettracker.repository.UserDao;
import me.syus.diettracker.repository.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public User save(User user){
        return userDao.save(user);
    }

    public User saveUser(User user){
        return userDao.save(user);
    }

    public List<User> findAll(){
        List<User> users = userDao.findAll();
        return users;
    }

    public User findById(Long id){
        User user = userDao.findById(id);
        return user;
    }

    public User findByUsername(String username){
        User user = userDao.findByUsername(username);
        return user;
    }

    public List<User> findByFirstName(String firstName){
        List<User> users = userDao.findByFirstName(firstName);
        return users;
    }

    public List<User> findByLastName(String lastName){
        List<User> users = userDao.findByLastName(lastName);
        return users;
    }


}
