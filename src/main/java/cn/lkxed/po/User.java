package cn.lkxed.po;

public class User {
    private String username;
    private String password;

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    private String like;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {}
}
