package com.example.projects.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        boolean a = session != null && session.getAttribute("user") != null;
        boolean b = req.getRequestURI().equalsIgnoreCase(req.getContextPath() + "/login");
       if(a || b){
           chain.doFilter(request, response);

       }
       else {
           resp.sendRedirect("/login");

       }
    }
}
