package com.example.projects.filter;

import com.example.projects.model.User;
import com.example.projects.service.UserService;
import com.example.projects.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/login")
public class UserFilter implements Filter {
    private UserService service = UserServiceImpl.getInstance();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        String login = (String) session.getAttribute("login");
        String userrole = (String) session.getAttribute("role");
        if (login == null) {
            String userLogin = req.getParameter("login");
            String userPassword = req.getParameter("password");
            User user = service.getUserByLogin(userLogin);
            if (user != null && user.getPassword().equals(userPassword)) {
                session.setAttribute("login", userLogin);
                session.setAttribute("user", user);
                String role = user.getRole();
                session.setAttribute("role", role);
                System.out.println("Attr was added");
                if (role.equals("user")) {
                    resp.sendRedirect("/login/user");
                } else {
                    resp.sendRedirect("/login/admin");
                }

            } else {
                resp.sendRedirect("/home");
                System.out.println("No Authofication");
            }


        } else if (userrole.equals("user")) {
            resp.sendRedirect("/login/user");
        } else if (userrole.equals("admin")) {
            resp.sendRedirect("/login/admin");
        }


    }


    @Override
    public void destroy() {

    }
}
