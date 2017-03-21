import tutorial.Global;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;


@WebServlet("/login_servlet")
public class LoginServlet extends HttpServlet {
    private Global global = Global.getInstance();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password").trim();
        String name = request.getParameter("name").trim();
        System.out.println("password = " + password);
        System.out.println("name = " + name);

        if (password.isEmpty() || name.isEmpty()) {
            getServletContext().getRequestDispatcher("/index.jsp?empty=" + true).forward(request, response);
        } else {
            if (request.getParameter("register") != null) {
                System.out.println("register");
                boolean res = global.register(name, password);
                System.out.println("res = " + res);
                if (res) {
                    getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
                } else {
                    getServletContext().getRequestDispatcher("/index.jsp?register=" + res).forward(request, response);
                }
            } else {
                System.out.println("login");
                boolean res = global.login(name, password);
                System.out.println("res = " + res);
                if (res) {
                    HttpSession session=request.getSession();
                    session.setAttribute("username", name);
                    
                    getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
                } else {
                	//getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
                         
                	getServletContext().getRequestDispatcher("/index.jsp?login=" + res).forward(request, response);
                }
            }
        }
    }
}