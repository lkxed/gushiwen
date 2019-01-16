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

    public PoemService getPoemService() {
        return poemService;
    }

    public void setPoemService(PoemService poemService) {
        this.poemService = poemService;
    }

    public String execute() {
        HttpParameters parameters = ActionContext.getContext().getParameters();
        if (!parameters.isEmpty()) {
            Parameter parameter = parameters.entrySet().iterator().next().getValue();
            switch (parameter.getName()) {
                case "title":
                    this.poems = poemService.findByTitle(parameter.getValue());
                    break;
                default:
                    this.poems = poemService.findPage(1, 10);
                    break;
            }
            return SUCCESS;
        }
        return ERROR;
    }
}
