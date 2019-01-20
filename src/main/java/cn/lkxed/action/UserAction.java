package cn.lkxed.action;

import cn.lkxed.po.User;
import cn.lkxed.po.Poem;
import cn.lkxed.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.json.annotations.JSON;

import java.util.List;
import java.util.Map;

public class UserAction extends ActionSupport {
    @JSON
    public String getMessage() {
        return message;
    }

    private String message;

    @JSON(serialize = false)
    public Poem getPoem() {
        return poem;
    }

    public void setPoem(Poem poem) {
        this.poem = poem;
    }


    private List users;

    @JSON(serialize = false)
    public List getUsers() {
        return users;
    }

    public void setUsers(List users) {
        this.users = users;
    }

    private User user;
    private Poem poem;

    private UserService userService;

    @JSON(serialize = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String execute() {
        return SUCCESS;
    }

    public String login() {
        if (userService.login(user)) {
            return SUCCESS;
        }
        Map<String, Object> request = (Map)ActionContext.getContext().get("request");
        request.put("loginerror", "用户名或密码错误");
        return ERROR;
    }

    public String register() {
        HttpParameters parameters = ActionContext.getContext().getParameters();
        String username = parameters.get("username").getValue();
        String password = parameters.get("password").getValue();
        String repeat = parameters.get("repeat").getValue();
        System.out.println(username);
        int result = userService.register(username, password, repeat);
        if (result == 0) {
            this.message = "success";
        } else if (result == 1) {
            this.message = "existed";
        } else {
            this.message = "error";
        }
        return SUCCESS;
    }


    public String adminuser()
    {
        try {
            HttpParameters parameters = ActionContext.getContext().getParameters();
            this.users= userService.findAll();
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String deleteuser()
    {
        userService.delete(user);
        this.users= userService.findAll();
        return SUCCESS;
    }

    public String admin()
    {
        return SUCCESS;
    }

    public String mark() {
        this.user = (User)ActionContext.getContext().getSession().get("nowuser");
        String bookMark = user.getBookmark() == null ? "": user.getBookmark();
        if (!bookMark.contains(poem.getId())) {
            user.setBookmark(bookMark+poem.getId()+',');
            userService.update(user);
        } else {
            Map<String, Object> request = (Map)ActionContext.getContext().get("request");
            request.put("markwarning", "已收藏，请勿重复收藏！");
        }
        return SUCCESS;
    }
    public String unmark() {
        this.user = (User)ActionContext.getContext().getSession().get("nowuser");
        String bookMark = user.getBookmark() == null ? "": user.getBookmark();
        if (bookMark.contains(poem.getId())) {
            bookMark = bookMark.replace(poem.getId()+",","");
            user.setBookmark(bookMark);
            userService.update(user);
            ActionContext.getContext().getSession().put("nowuser", user);
        }
        return SUCCESS;
    }

    public String logout() {
        ActionContext.getContext().getSession().remove("nowuser");
        ActionContext.getContext().getSession().remove("tip");
        return SUCCESS;
    }
}
