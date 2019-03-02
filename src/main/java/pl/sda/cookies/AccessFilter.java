package pl.sda.cookies;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebFilter(filterName = "accessFilter", servletNames = "giveMeData")
public class AccessFilter implements Filter {

    private static final String COOKIE_NAME = "access";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();

        if (cookies != null) {
            Optional<Cookie> optCookie = Arrays.stream(cookies).filter(cookie -> COOKIE_NAME.equals(cookie.getName())).findFirst();

            if (optCookie.isPresent()) {
                String access = optCookie.get().getValue();
                Boolean hasAccess = Boolean.valueOf(access);
                if (hasAccess) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } else {
                servletResponse.getWriter().println("Nie masz uprawnień!");
            }
        }

    }
}
