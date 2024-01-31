package servlet;

import model.User;
import org.hibernate.Session;
import service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AuthServlet", value = "/auth")
public class AuthServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("auth.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message;
        String name = req.getParameter("name");
        if (userService.containsName(name)) {
            message = "пользователь с таким именем уже существует";
            req.setAttribute("message", message);
            req.getRequestDispatcher("auth.jsp").forward(req, resp);
        } else {
            User user = new User();
            user.setName(name);
            user.setPassword(req.getParameter("password"));
            userService.save(user);
            message = "поздравляем, вы зарегистрировались";
            req.setAttribute("message", message);
            HttpSession session = req.getSession();
            session.setAttribute("User", user);
            req.getRequestDispatcher("index.jsp").forward(req, resp);

        }
    }
}
