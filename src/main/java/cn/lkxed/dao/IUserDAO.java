package cn.lkxed.dao;

import cn.lkxed.po.User;

public interface IUserDAO {
    public User find(String name);
    public boolean saveOrUpdate(User user);
    public boolean delete(User user);
}
