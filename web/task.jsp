<%@page import="javax.swing.JOptionPane"%>
<%@ page import="tutorial.Global,java.util.*" %>
<%@ page import="tutorial.question.QA" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta HTTP-EQUIV=Expires CONTENT="0">   
<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">  
    <title>Java</title>
</head>
<style>
    div.container {
        width: 100%;
        clear: left;
        text-align: center;
    }

    header, footer {
        padding: 1em;
        color: white;
    }

    body {
        background: #76b852; /* fallback for old browsers */
        background: -webkit-linear-gradient(right, #76b852, #8DC26F);
        background: -moz-linear-gradient(right, #76b852, #8DC26F);
        background: -o-linear-gradient(right, #76b852, #8DC26F);
        background: linear-gradient(to left, #76b852, #8DC26F);
        font-family: "Roboto", sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }
</style>

<body>
<%
String answer = "";
    List<QA> lq=null;
    Global global = Global.getInstance();
    String question = request.getAttribute("question") != null ? (String) request.getAttribute("question") : null;
    String ans = request.getAttribute("ans") != null ? (String) request.getAttribute("ans") : null;
    String ansCode = request.getAttribute("ans_code") != null ? (String) request.getAttribute("ans_code") : null;
    String tags = request.getAttribute("tags") != null ? (String) request.getAttribute("tags") : null;
    if (question == null) {
    	System.out.println("Task.jsp: Calling getQAfortags");
        lq  = global.getQAForTags(tags);
        int size = 0;
        String temp = "";
        List<String> tempans = new ArrayList<String>();
        for(QA q : lq)
        {
        	size++;
        	int random = (int)(Math.random()*100);
        	
        	System.out.println("Random is "+ random);
    		
    		if(temp.equals(""))
        	{
        		temp=q.getQuestion();
        		if(random%2==0)
        		{
        		temp = temp.replace("20", ""+random);
        		temp = temp.replace("21", ""+(random+1));
        		tempans.add(q.getAnswer().replace("20",""+random).replace("21",""+(random+1)));
        		}
        		else
        		{
            		temp = temp.replace("21", ""+random);
            		temp = temp.replace("20", ""+(random+1));
            		
        		tempans.add(q.getAnswer().replace("21",""+random).replace("20",""+(random+1)));
        		}   
        	} 		
        	else
        	{
        		String quest = q.getQuestion().replace("Write a code to ", "");
        		if(random%2==0)
        		{
        		quest = quest.replace("20", ""+random);
        		quest = quest.replace("21", ""+(random+1));
        		tempans.add(q.getAnswer().replace("20",""+random).replace("21",""+(random+1)));
        		
        		}
        		else
        		{
            		quest = quest.replace("21", ""+random);
            		quest = quest.replace("20", ""+random+1);
            		tempans.add(q.getAnswer().replace("21",""+random).replace("20",""+(random+1)));
            			}
        		temp=temp + " and " +quest;
        	 		
        		
        		
        }
        }
        if(size>1)
        {
        	temp = temp.replace("?", "");
        	temp = temp.replace(".", "");
        }
        System.out.println(temp+" and ans "+tempans);
        QA qa    = (QA)lq.get(0);       
        question = temp;
        //boolean syntax = false;
        ans = qa.getAnswer();
        ansCode = qa.getCode();
        for(int i = 0;i<tempans.size();i++)
        {
        	if(i==0)
        		ans =tempans.get(i);
        	else
        	{
        		ans = ans.replace("...",tempans.get(i));
        		
        	}
        }
        ans = ans.replace("{", "{"+System.getProperty("line.separator"));
        ans = ans.replace("}", System.getProperty("line.separator")+"}");
        }

    question = question.replace("\"", "'");
    ansCode = ans;
    answer = ans.replace("...", "");
    
    String isTrue=(String)request.getParameter("isTrue")!= null ? (String) request.getAttribute("isTrue") : null;
    if(isTrue==null)
    	{isTrue = "null";}
    String code = request.getAttribute("code") != null ? (String) request.getAttribute("code") : null;
    if (code == null) {
        code = "\npublic class MainClass {\n" +
                "    public static void main(String arf[]) {\n" +
                		"\n\t//Type code here "+
                "    }\n" +
                "}";
    }
    else
    	code=code.trim();
  
%>
<form action="menu.jsp" method="post">
    <input type="submit" name="Home" value="Home"/>
</form>
<div class="container">

    <header>
        <h1>Task</h1>
    </header>
    <% /* for(Object ob2:lq) {
    	QA qa = (QA)ob2;
    	 out.println(qa.getQuestion()+"<br/>");
    	
         }*/
    out.println(question);
    	System.out.println();
       	%> 
   
    <br>


    <textarea name="code" rows="20" cols="100" form="usrform">
    <%=code%>
    </textarea>
    <footer>
        <form action="${pageContext.request.contextPath}/TaskServlet" method="post" id="usrform">
            <input type="submit" name="Check" value="Check"/>
            <input type="hidden" name="ans" value="<%=ans%>">
            <input type="hidden" name="question" value="<%=question%>">
            <input type="hidden" name="ans_code" value="<%=ansCode%>">
            <input type="hidden" name="tags" value="<%=tags%>"> 
            <input type = "hidden" name ="isTrue" value = "not">
        </form>

        <form action="${pageContext.request.contextPath}/menu_servlet" method="post" id="usrform">
            <input type="submit" name="New question" value="New question"/>
            <input type="hidden" name="tags" value="<%=tags%>">
        </form>

        <% 
        //JOptionPane.showMessageDialog(null,isTrue);
            if (isTrue.equalsIgnoreCase("true")) {
        %>
        <h2>You are right!</h2>
        <h2>Try another question</h2>
        <% } else if(isTrue.equalsIgnoreCase("false")){%>
         <h2>You are wrong =( Try again )</h2>
        <%
                }
          %>
        <details>
            <summary>Show code for answer</summary>
            <pre align="left"><%=ansCode.replace("'", "\"")%></pre>
        </details>
    </footer>
</div>
</body>
</html>
