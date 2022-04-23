package by.it_academy.jd2.ClassWork.person.controllers.web.filters;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(urlPatterns = {"/person"})
public class SecurityFilter implements Filter {

    private boolean active = false;

    @Override
    public void init(FilterConfig config) throws ServletException {
        String act = config.getInitParameter("active");
        if (act != null) {
            active = (act.toUpperCase().equals("TRUE"));
    }
}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        if (active) {
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
