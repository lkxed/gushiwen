package cn.lkxed.dao;

import java.util.List;

public interface ITagDAO {
    public List findAll();
    public List findPage(int pageNum, int pageSize);
}
