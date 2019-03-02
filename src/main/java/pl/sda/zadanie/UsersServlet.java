package pl.sda.zadanie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "users", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserRepository userRepository = new UserRepository();
        List<User> users = userRepository.getUsers();

        PrintWriter writer = resp.getWriter();

        for (User user : users) {
            writer.println("Login: " + user.getLogin());
            writer.println("Password: " + user.getPassword());
            writer.println("Role: " + user.getRole());
            writer.println();
        }
    }
}
