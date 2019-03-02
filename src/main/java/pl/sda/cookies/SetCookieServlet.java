package pl.sda.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebServlet(name = "setCookie", urlPatterns = "/set-cookie")
public class SetCookieServlet extends HttpServlet {

    private static final String COOKIE_NAME = "access";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            Optional<Cookie> testCookie = Arrays.stream(cookies)
                    .filter(cookie -> COOKIE_NAME.equals(cookie.getName())).findFirst();

            if (!testCookie.isPresent()) {
                Cookie cookie = new Cookie(COOKIE_NAME, "true");
                cookie.setMaxAge(60);
                resp.addCookie(cookie);
            } else {
                resp.getWriter()
                        .println("Ciastko o nazwie 'test' ma wartość: '" + testCookie.get().getValue() + "'");
            }
        }
    }
}
