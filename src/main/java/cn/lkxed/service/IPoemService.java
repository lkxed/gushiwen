package cn.lkxed.service;

import java.util.List;

public interface IPoemService {
    public List findAllPoems();
    public boolean isExisted(String name);
    public List findPage(int pageNum, int pageSize);
    public List findByTitle(String title);
}
