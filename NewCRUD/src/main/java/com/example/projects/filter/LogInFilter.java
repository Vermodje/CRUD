package com.example.projects.filter;

import com.example.projects.model.User;
import com.example.projects.service.UserService;
import com.example.projects.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(urlPatterns = {"/login"})
public class LogInFilter implements Filter {
    private UserService service = UserServiceImpl.getInstance();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    String login = request.getParameter("login");
    String password = request.getParameter("password");
    User user = service.getUserByLogin(login);
    HttpServletResponse resp = (HttpServletResponse) response;
    if(user != null && user.getPassword().equals(password)){
        request.setAttribute("users", service.getAllUsers());
        request.setAttribute("dao", service.getDAO());
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }
    else {
        resp.sendRedirect("/");
    }

    }

    @Override
    public void destroy() {

    }
}
