package pl.sda.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "second", urlPatterns = "/second",
        initParams = {
            @WebInitParam(name = "key", value = "val"),
            @WebInitParam(name = "number", value = "10")
        }, loadOnStartup = 1)
public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String key = getInitParameter("key");
        String number = getInitParameter("number");


        PrintWriter writer = resp.getWriter();
        writer.println("Second Servlet");
        writer.println(key + " " + number);
    }
}
