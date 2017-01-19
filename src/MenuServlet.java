

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tutorial.Global;

import java.io.IOException;


@WebServlet("/menu_servlet")
public class MenuServlet extends HttpServlet {
    private Global global = Global.getInstance();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/menu.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tags = request.getParameter("tags");

        System.out.println("User type tags : " + tags);
        request.setAttribute("tags", tags.trim());

        getServletContext().getRequestDispatcher("/task.jsp").forward(request, response);

    }
}