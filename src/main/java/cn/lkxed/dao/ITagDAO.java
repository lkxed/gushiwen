package cn.lkxed.dao;

import java.util.List;

public interface ITagDAO {
    public List findByHql(String hql);
}