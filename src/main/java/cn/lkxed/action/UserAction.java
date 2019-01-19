package cn.lkxed.action;

import cn.lkxed.po.User;
import cn.lkxed.po.Poem;
import cn.lkxed.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.HttpParameters;
import java.util.List;
public class UserAction extends ActionSupport {
    private String message;

    public Poem getPoem() {
        return poem;
    }

    public void setPoem(Poem poem) {
        this.poem = poem;
    }

    private List users;

    public List getUsers() {
        return users;
    }

    public void setUsers(List users) {
        this.users = users;
    }

    private User user;
    private Poem poem;

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
        if (userService.login(user)) {
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

    public String inlike(){
        System.out.println("sadwqawdeqdsfc");
        if(user.getLike()==null)
            user.setLike(poem.getId()+',');
        else
            user.setLike(user.getLike()+poem.getId()+',');
        userService.update(user);
        return SUCCESS;
    }

    public String admin()
    {
        return SUCCESS;
    }


}
