package pl.sda.basic;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(filterName = "secondF", servletNames = {"first"})
public class SecondFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter writer = servletResponse.getWriter();
        writer.println("secondF: 1");

        filterChain.doFilter(servletRequest, servletResponse);

        writer.println("secondF: 2");
    }
}
