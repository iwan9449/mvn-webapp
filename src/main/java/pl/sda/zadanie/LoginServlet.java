package pl.sda.zadanie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();

        if (session.getAttribute("user") == null) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");

            Optional<User> optUser = userRepository.getUserByLoginData(login, password);

            if (optUser.isPresent()) {
                session.setAttribute("user", optUser.get());
                writer.println("Zostałeś zalogowany jako " + optUser.get().getLogin());
            } else {
                writer.println("Niepoprawne dane logowania");
            }
        } else {
            writer.println("Jesteś zalogowany");
        }
    }
}
