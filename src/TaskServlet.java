import tutorial.Global;
import tutorial.Regex;
import tutorial.question.QA;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.io.IOException;
import tutorial.code.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


@WebServlet("/task_servlet")
public class TaskServlet extends HttpServlet {
    private Global global = Global.getInstance();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/task.jsp").forward(req, resp);
    }

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("check post called");
    	if (request.getParameter("Check") != null) {
            System.out.println("On check");
            //String isTrue = request.getParameter("isTrue");
            String isTrue = "false";
            String code = request.getParameter("code");
            String ans = request.getParameter("ans");
            String question = request.getParameter("question");
            String ansCode = request.getParameter("ans_code");
            String tags = request.getParameter("tags");
            
             
           
            RuntimeCompiler r = new RuntimeCompiler();
            r.addClass("MainClass", code);
           // String checkcode = "false";
            boolean is  = r.compile();
            System.out.println("is = "+is);
            if(is)
            {
            	String answe = ans.replace("...", "").replace("}", "").replace("{", "").replace("\n", "").replace("\r", "").replace("\t", "").replace("\\s+","").replace("'", "\"").toLowerCase().replaceAll("\\s+", "");
            	String userans = code.replace("...", "").replace("}", "").replace("{", "").replace("\n", "").replace("\r", "").replace("\t", "").replace("\\s+","").toLowerCase().replaceAll("\\s+", "");
            	ArrayList<String> integers = Regex.regex("int", userans);
            	ArrayList<String> Strings = Regex.regex("String", userans);
            	ArrayList<String> array = Regex.regex("array", userans);
            for(String s :integers)
            {
            	userans = userans.replace("i", s);
            	answe = answe.replace("i", s);
            }
            
            for(String s :Strings)
            {
            	userans = userans.replace("str", s);
            	answe = answe.replace("str", s);
            }
            
            for(String s :array)
            {
            	userans = userans.replace("array", s);
            	answe = answe.replace("array", s);
            }
            
            
            	if(!userans.contains(answe))
					{
					is = false;	
					isTrue = "false";
					//JOptionPane.showMessageDialog(null, "Container = "+userans+"Iscontained"+answe);
					}
            	else
            		{isTrue = "true";
            	//JOptionPane.showMessageDialog(null, "Container = "+userans+"Iscontained"+answe);
            		}
            		}
            System.out.println("code syntax is "+ isTrue);
 
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
            System.out.println(tags);
            //String contextPath = request.getContextPath();
            
        	//response.sendRedirect(response.encodeRedirectURL(contextPath +"/task.jsp"));
            getServletContext().getRequestDispatcher("/task.jsp").forward(request, response);
        }
        else
        {
        	System.out.println("check button null");
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