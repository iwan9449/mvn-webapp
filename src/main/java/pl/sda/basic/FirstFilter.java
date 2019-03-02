package pl.sda.basic;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(filterName = "firstF", servletNames = {"first"})
public class FirstFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter writer = servletResponse.getWriter();
        writer.println("firstF: 1");

        String name = ((HttpServletRequest) servletRequest).getParameter("name");

        if (StringUtils.isNotEmpty(name)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            writer.println("Nie podales imienia!");
        }


        writer.println("firstF: 2");
    }
}
