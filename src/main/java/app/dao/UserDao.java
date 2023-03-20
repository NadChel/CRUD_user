package app.dao;

import app.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    User getUserById(long id);

    void deleteUserById(long id);
}
