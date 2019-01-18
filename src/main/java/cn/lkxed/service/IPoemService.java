package cn.lkxed.service;

import java.util.List;

public interface IPoemService {
    public List findAll();
    public boolean isExisted(String title);
    public List findPage(int pageNum, int pageSize);
    public List findByTitle(String title);
}
