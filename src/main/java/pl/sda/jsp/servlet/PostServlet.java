package pl.sda.jsp.servlet;


import pl.sda.jsp.model.PostModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "postServlet", urlPatterns = "/post")
public class PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PostModel post = new PostModel("Tytuł posta", "Jakaś dowolna treść", "Jan Kowalski", LocalDateTime.now());

        req.setAttribute("post", post);
        req.getRequestDispatcher("/post.jsp").forward(req, resp);

    }
}
