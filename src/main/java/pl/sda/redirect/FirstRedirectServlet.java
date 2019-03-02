package pl.sda.redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstRedirectServlet", urlPatterns = "/redirect")
public class FirstRedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        writer.println("Servlet 1: before redirect");

        //resp.sendRedirect("/redirect-target");
//        req.getRequestDispatcher("/redirect-target").forward(req, resp);
        req.getRequestDispatcher("/redirect-target").include(req, resp);

        writer.println("Servlet 1: after redirect");

    }
}
