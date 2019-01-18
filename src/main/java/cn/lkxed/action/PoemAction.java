package cn.lkxed.action;

import cn.lkxed.service.PoemService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.Parameter;

import java.util.List;

public class PoemAction extends ActionSupport {
    private List poems;

    private PoemService poemService;

    public List getPoems() {
        return poems;
    }

    public void setPoems(List poems) {
        this.poems = poems;
    }

    public void setPoemService(PoemService poemService) {
        this.poemService = poemService;
    }

    public String execute() {
        try {
            HttpParameters parameters = ActionContext.getContext().getParameters();
            if (parameters.size() == 0) { // 请求不带参数
                this.poems = poemService.findPage(1, 10);
            } else if (parameters.size() == 1) { // 请求带一个参数
                Parameter parameter = parameters.entrySet().iterator().next().getValue();
                if (parameter.getName().equalsIgnoreCase("title")) { // 根据标题查找
                    this.poems = poemService.findByTitle(parameter.getValue());
                } else { // 参数无效
                    return ERROR;
                }
            } else { // 参数过多
                return ERROR;
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
}
