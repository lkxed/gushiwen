package cn.lkxed.service;

import cn.lkxed.po.Admin;
import com.opensymphony.xwork2.ActionContext;
import cn.lkxed.dao.AdminDAO;
import java.util.List;
import java.util.Map;

public class AdminService {
    private AdminDAO adminDAO;
    public AdminDAO getAdminDAO() {
        return adminDAO;
    }
    public void setAdminDAO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }
    public boolean login(Admin admin) {

        List userList = adminDAO.find(admin);
        if (userList.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
