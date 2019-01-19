package cn.lkxed.dao;

import cn.lkxed.po.User;
import cn.lkxed.po.Admin;

import java.util.List;

public interface IAdminDAO {
    public List find(Admin admin);
}
