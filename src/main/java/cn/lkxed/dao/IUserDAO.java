package cn.lkxed.dao;

import cn.lkxed.po.User;

import java.util.List;

public interface IUserDAO {
    public List find(User user);
    public void save(User user);
    public void update(User user);
    public void delete(User user);
}
