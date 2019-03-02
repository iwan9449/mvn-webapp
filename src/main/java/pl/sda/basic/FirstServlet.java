package pl.sda.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        if (name == null) {
            name = getInitParameter("name");
        }

        String test = getInitParameter("test");
        int count = Integer.parseInt(test);

        PrintWriter writer = resp.getWriter();
        for (int i = 0; i < count; i++) {
            writer.println("Witaj " + name);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("POST");
    }
}
