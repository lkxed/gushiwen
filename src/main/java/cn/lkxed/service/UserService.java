package cn.lkxed.service;

import cn.lkxed.dao.UserDAO;
import cn.lkxed.po.User;
import org.springframework.transaction.annotation.Transactional;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;
import java.util.Map;

@Transactional
public class UserService {
    private UserDAO userDAO;
    private Map<String, Object> request, session;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean login(User user) {
        ActionContext ctx = ActionContext.getContext();
        session = (Map) ctx.getSession();
        request = (Map) ctx.get("request");
        List userList = userDAO.check(user);
        if (userList.isEmpty()) {
            return false;
        } else {
            session.put("nowuser",(User)userList.get(0));
            session.put("tip",user.getUsername());
            return true;
        }
    }

    public int register(String username, String password, String repeat) {
        if (username.length() >= 5 && username.length() <= 12 && password.length() >=8 && password.length() <= 20 && repeat.equals(password)) {
            User user = new User();
            user.setUsername(username);
            if (this.find(user) == null) {
                user.setPassword(password);
                userDAO.save(user);
            }
            else {
                System.out.println("用户"+username+"已存在");
                return 1;
            }
            System.out.println("注册成功");
            return 0;
        }
        System.out.println("注册失败");
        return 2;
    }

    public User find(User user) {
        List userList = userDAO.find(user);
        System.out.println("size"+userList.size());
        if (userList.isEmpty() || userList == null) {
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
    public List findAll() {
        return userDAO.findAll();
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
