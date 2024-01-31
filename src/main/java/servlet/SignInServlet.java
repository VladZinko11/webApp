package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignInServlet", value = "/signIn")
public class SignInServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("signIn.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String message;
        if (!userService.containsName(name)) {
            message = "Пользователь с таким именем не найден";
            req.setAttribute("message", message);
            req.getRequestDispatcher("signIn.jsp").forward(req, resp);
        } else {
            User user = userService.findByName(name);
            if (user.getPassword().equals(password)) {
                message = "Вы вошли";
                req.getSession().setAttribute("User", user);
                req.setAttribute("message", message);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
            else {
                message = "Неверный пароль";
                req.setAttribute("message", message);
                req.getRequestDispatcher("signIn.jsp").forward(req, resp);
            }

        }

    }
}
