package app.service;

import app.dao.UserDao;
import app.models.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
//@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Model setShowUsersModel(Model model) {
        return model.addAttribute("userList", userDao.getAllUsers());
    }

    @Override
    public Model setAddUserModel(Model model) {
        return model.addAttribute("user", new User());
    }

    @Override
//    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public Model setUpdateUserModel(Model model, long id) {
        return model.addAttribute("user", userDao.getUserById(id));
    }

    @Override
//    @Transactional
    public void deleteUserById(long id) {
        userDao.deleteUserById(id);
    }
}
