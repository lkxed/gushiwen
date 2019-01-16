package cn.lkxed.dao;

import java.util.List;

public interface IPoemDAO {
    public List findAll();
    public List findPage(int pageNum, int pageSize);
    public List findByTitle(String title);
}
