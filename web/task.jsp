<%@ page import="tutorial.Global,java.util.*" %>
<%@ page import="tutorial.question.QA" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Codingfolio</title>
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
        background-color: #55b561;
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
     .button {
    background-color: #4c9656;
    border: none;
    color: white;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 20px;
    cursor: pointer;
}
.menubutton {
    background-color: white; /* Green */
    border: none;
    color: #4CAF50;
    padding: 10px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 12px;
    cursor: pointer;
}
</style>

<body>
<%  boolean isTrue=false;
    List<QA> lq=null;
    Global global = Global.getInstance();
    String question = request.getAttribute("question") != null ? (String) request.getAttribute("question") : null;
    String ans = request.getAttribute("ans") != null ? (String) request.getAttribute("ans") : null;
    String ansCode = request.getAttribute("ans_code") != null ? (String) request.getAttribute("ans_code") : null;
    String tags = request.getAttribute("tags") != null ? (String) request.getAttribute("tags") : null;
    if (question == null) {
    	System.out.println("Task.jsp: Calling getQAfortags");
        lq  = global.getQAForTags(tags);
        QA qa    = (QA)lq.get(0);       
        question = qa.getQuestion();
        ans = qa.getAnswer();
        ansCode = qa.getCode();
    }

    question = question.replace("\"", "'");
    ansCode = ansCode.replace("\"", "'");

    String code = request.getAttribute("code") != null ? (String) request.getAttribute("code") : null;
    if (code == null) {
        code = "\npublic class MainClass {\n" +
                "    public static void main() {\n" +
                "    }\n" +
                "}";
    }
    Object ob1 = request.getAttribute("isTrue");
    if(ob1 != null){
    	 isTrue = (Boolean)request.getAttribute("isTrue");
    }
    	 
    String score = request.getParameter("score");
%>
<form action="menu.jsp" method="post">
    <input type="submit" class="menubutton" name="Home" value="Home"/>
</form>
<div class="container">

    <header>
        <h1 style="font-size:50px">Question</h1>
    </header>
    <h3>
    <% if(lq!=null)  for(Object ob2:lq) {
    	QA qa = (QA)ob2;
    	 out.println(qa.getQuestion()+"<br/>");
    	
         }
    else out.println(question+"<br/>");
    	
       	%> 
   </h3>
    </br>


    
    <footer>
        <form action="${pageContext.request.contextPath}/task_servlet" method="post" id="usrform">
        <textarea name="code" rows="20" cols="100" form="usrform">
    <%=code%>
    </textarea>
    		<br/>
            <input type="submit" class="button" name="Check" value="Check"/>
            <input type="hidden" name="ans" value="<%=ans%>">
            <input type="hidden" name="question" value="<%=question%>">
            <input type="hidden" name="ans_code" value="<%=ansCode%>">
            <input type="hidden" name="tags" value="<%=tags%>">
        </form>

        <form action="${pageContext.request.contextPath}/menu_servlet" method="post" id="usrform">
            <input type="submit" class="button" name="New question" value="New question"/>
            <input type="hidden" name="tags" value="<%=tags%>">
        </form>

        <% 
        if(request.getAttribute("code") != null)
            if (isTrue) {
        %>
        <h2>Correct!</h2>
        <h2>Try another question</h2>
        <% } else {%>
        <h2>Wrong</h2>
        <h2>Try again</h2>
        <%
                }
                    %>
        <details>
            <summary>Show code for answer</summary>
            <pre align="left"><%=ansCode.replace("'", "\"")%></pre>
        </details>
    </footer>
</div>
<script type="text/javascript">
function setCookie(c_name,value){
    var exdays=1000;
    var exdate=new Date();
    exdate.setDate(exdate.getDate() + 1000);
    var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
    document.cookie=c_name + "=" + c_value;
  }
function getCookie(c_name)
    {
    var c_value = document.cookie;
    var c_start = c_value.indexOf(" " + c_name + "=");
    if (c_start == -1)
      {
      c_start = c_value.indexOf(c_name + "=");
      }
    if (c_start == -1)
      {
      c_value = null;
      }
    else
      {
      c_start = c_value.indexOf("=", c_start) + 1;
      var c_end = c_value.indexOf(";", c_start);
      if (c_end == -1)
      {
    c_end = c_value.length;
    }
    c_value = unescape(c_value.substring(c_start,c_end));
    }
    return c_value;
    }
    function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }
setCookie('questions',getCookie('questions').replace(/|$/, '')+'|<% if(lq!=null) for(Object ob2:lq) {
    	QA qa = (QA)ob2;
    	 out.print(qa.getQuestion());
    	
         } %>');

</script>
</body>
</html>
