package by.it_academy.jd2.HomeWork.messenger.controllers.web.filters;

import by.it_academy.jd2.HomeWork.messenger.core.dto.RoleType;
import by.it_academy.jd2.HomeWork.messenger.core.dto.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if ((session != null) && session.getAttribute("user") != null) {
            if(req.getSession().getAttribute("user").equals("admin")) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            resp.sendRedirect(contextPath + "/ui/SignIn");
        }
    }

    @Override
    public void destroy() {

    }
}
