package com.example.projects.filter;

import com.example.projects.model.User;
import com.example.projects.service.UserService;
import com.example.projects.service.UserServiceImpl;

import javax.jws.soap.SOAPBinding;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(urlPatterns = {"/login/admin", "/login/user"})
public class TestFilter implements Filter {
    private UserService service = UserServiceImpl.getInstance();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        String role = (String) session.getAttribute("role");
        if(role.equals("user")){
            //req.getRequestDispatcher("/user.jsp").forward(req, resp);
            resp.sendRedirect("/user.jsp");
        }
        if(role.equals("admin")){
            req.setAttribute("users", service.getAllUsers());
            req.getRequestDispatcher("/admin.jsp").forward(req, resp);
        }

    }

    @Override
    public void destroy() {

    }
}
