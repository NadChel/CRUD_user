package app.service;

import app.models.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

public interface UserService {
    Model setShowUsersModel(Model model);

    Model setAddUserModel(Model model);

    void addUser(User user);

    Model setUpdateUserModel(Model mode, long id);

    @Transactional
    void deleteUserById(long id);
}
