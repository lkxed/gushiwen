package cn.lkxed.dao;

import cn.lkxed.po.Author;

import java.util.List;

public interface IAuthorDAO {
    public List findAll();
    public List findPage(int pageNum, int pageSize);
    public List findByExample(Author example);
}
