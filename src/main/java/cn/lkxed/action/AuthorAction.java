package cn.lkxed.action;

import cn.lkxed.service.AuthorService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.Parameter;
import cn.lkxed.po.Author;

import java.util.List;

public class AuthorAction extends ActionSupport {
    private List authors;
    private Author author;
    private AuthorService authorService;
    private int pageNum = 1;
    private int pageSize = 5;

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List getAuthors() {
        return authors;
    }

    public void setAuthors(List authors) {
        this.authors = authors;
    }

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String execute() {
        try {
            HttpParameters parameters = ActionContext.getContext().getParameters();
            if (parameters.size() == 0) { // 请求不带参数
                this.authors = authorService.findPage(1, 10);
            } else if (parameters.size() == 1) { // 请求带一个参数
                Parameter parameter = parameters.entrySet().iterator().next().getValue();
                if (parameter.getName().equalsIgnoreCase("name")) { // 根据名字查找
                    this.authors = authorService.findByName(parameter.getValue());
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

    public String jump() {
        try {
            HttpParameters parameters = ActionContext.getContext().getParameters();
                this.authors = authorService.findPage(1, 10);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String searchauthor(){
        List temp=authorService.findByName(author.getName());
        if(!temp.isEmpty())
        {
            author=(Author)temp.get(0);
        }
        return SUCCESS;
    }

    public String goToPage() {
        HttpParameters parameters = ActionContext.getContext().getParameters();
        if (parameters.isEmpty()) {
            this.pageNum = 1;
        } else if(parameters.get("pageNum") !=  null){
            this.pageNum = Integer.parseInt(parameters.get("pageNum").getValue());
        } else {
            return ERROR;
        }
        this.authors = authorService.findPage(pageNum, pageSize);
        return SUCCESS;
    }


}
