package cn.lkxed.filter;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class JspFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        if(request.getRequestURI().indexOf(".jsp")>0){
            String uri = request.getRequestURI();
            String actionName = request.getRequestURI().substring(uri.lastIndexOf('/')+1, uri.indexOf(".jsp"));
            response.sendRedirect(actionName);
            return ;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
