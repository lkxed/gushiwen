package cn.lkxed.action;

import cn.lkxed.po.User;
import cn.lkxed.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.HttpParameters;

public class UserAction extends ActionSupport {
    private String message;

    private User user;

    private UserService userService;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String execute() {
        return SUCCESS;
    }

    public String login() {
        HttpParameters parameters = ActionContext.getContext().getParameters();
        String username = parameters.get("loginUsername").getValue();
        String password = parameters.get("loginPassword").getValue();
        if (userService.login(new User(username, password))) {
            return SUCCESS;
        }
        return ERROR;
    }

    public String register() {
        HttpParameters parameters = ActionContext.getContext().getParameters();
        String username = parameters.get("username").getValue();
        String password = parameters.get("password").getValue();
        String repeat = parameters.get("repeat").getValue();
        System.out.println(username);
        if (userService.register(username, password, repeat)) {
            this.message = "success";
            return SUCCESS;
        }
        this.message = "error";
        return ERROR;
    }
}
