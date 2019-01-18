package cn.lkxed.service;

import cn.lkxed.dao.UserDAO;
import cn.lkxed.po.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class UserService {
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean login(User user) {
        List userList = userDAO.find(user);
        if (userList.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean register(String username, String password, String repeat) {
        if (username.length() >= 5 && username.length() <= 12 && password.length() >=8 && password.length() <= 20 && repeat.equals(password)) {
            userDAO.save(new User(username, password));
            System.out.println("register");
            return true;
        }
        System.out.println("register-error");
        return false;
    }

    public User find(User user) {
        List userList = userDAO.find(user);
        if (userList.isEmpty()) {
            return null;
        } else {
            return (User)userList.get(0);
        }
    }

    public User findByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        List userList = userDAO.find(user);
        if (userList.isEmpty()) {
            return null;
        } else {
            return (User)userList.get(0);
        }
    }

    public void delete(User user) {
        userDAO.delete(user);
    }

    public void save(User user) {
        userDAO.save(user);
    }

    public void update(User user) {
        userDAO.update(user);
    }
}
