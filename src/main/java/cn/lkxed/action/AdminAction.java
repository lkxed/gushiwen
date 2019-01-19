package cn.lkxed.action;

import cn.lkxed.po.Admin;
import cn.lkxed.service.AdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.HttpParameters;

public class AdminAction extends ActionSupport {
    private Admin admin;
    private AdminService adminService;
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public String adminlogin(){
        System.out.println(admin.getPassword());
        System.out.println(admin.getUsername());
        if (adminService.login(admin)) {
            return SUCCESS;
        }
        return ERROR;
    }

}
