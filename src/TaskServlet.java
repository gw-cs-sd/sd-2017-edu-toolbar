import tutorial.Global;
import tutorial.question.QA;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/task_servlet")
public class TaskServlet extends HttpServlet {
    private Global global = Global.getInstance();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/task.jsp").forward(req, resp);
    }

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("Check") != null) {
            System.out.println("On check");
            String code = request.getParameter("code");
            String ans = request.getParameter("ans");
            String question = request.getParameter("question");
            String ansCode = request.getParameter("ans_code");
            String tags = request.getParameter("tags");

            boolean isTrue = global.runCode(code, new QA(question, ans, ansCode));

            System.out.println("Code = " + code);
            System.out.println("Ans = " + ans);
            System.out.println("AnsCode = " + ansCode);
            System.out.println("isTrue = " + isTrue);
            System.out.println("tags = " + tags);

            request.setAttribute("code", code);
            request.setAttribute("ans", ans);
            request.setAttribute("isTrue", isTrue);
            request.setAttribute("question", question);
            request.setAttribute("ans_code", ansCode);
            request.setAttribute("tags", tags);

            getServletContext().getRequestDispatcher("/task.jsp").forward(request, response);
        }
//        else if (request.getParameter("Next") != null) {
//            System.out.println("On next");
//            int textQuestion = num + 1;
//            getServletContext().getRequestDispatcher("/task.jsp?theme" + theme + "&num=" + textQuestion + "&score=" + score).forward(request, response);
//        } else if (request.getParameter("Home") != null) {
//            System.out.println("On Home");
//            getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
//        }
    }
}