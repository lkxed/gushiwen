package cn.lkxed.service;

import java.util.List;

public interface IAuthorService {
    public List findAll();
    public boolean isExisted(String name);
    public List findPage(int pageNum, int pageSize);
    public List findByName(String name);
}
