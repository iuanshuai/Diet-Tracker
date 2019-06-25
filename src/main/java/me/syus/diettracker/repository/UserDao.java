package me.syus.diettracker.repository;
import me.syus.diettracker.domain.User;
import java.util.List;

public interface UserDao {
    User save(User user);

    List<User> findAll();

    User findByIdEager(Long id);

    User findById(Long id);

    User findByUsernameIgnoreCase(String username);

    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    User findByEmailIgnoreCase(String email);


}
