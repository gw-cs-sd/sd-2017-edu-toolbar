<%@ page import="turorial.Global" %>
<%@ page import="turorial.question.QA" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
        background-color: #00897B;
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
    Global global = Global.getInstance();
    String question = request.getAttribute("question") != null ? (String) request.getAttribute("question") : null;
    String ans = request.getAttribute("ans") != null ? (String) request.getAttribute("ans") : null;
    String ansCode = request.getAttribute("ans_code") != null ? (String) request.getAttribute("ans_code") : null;
    String tags = request.getAttribute("tags") != null ? (String) request.getAttribute("tags") : null;
    if (question == null) {
        QA qa = global.getQAForTags(tags);
        question = qa.getQuestion();
        ans = qa.getAnswer();
        ansCode = qa.getCode();
    }

    question = question.replace("\"", "'");
    ansCode = ansCode.replace("\"", "'");

    String code = request.getAttribute("code") != null ? (String) request.getAttribute("code") : null;
    if (code == null) {
        code = "\npublic class MainClass {\n" +
                "    public static String main() {\n" +
                "        //Type code here\n" +
                "    }\n" +
                "}";
    }

    Boolean isTrue = request.getAttribute("isTrue") != null ? (boolean) request.getAttribute("isTrue") : null;
    String score = request.getParameter("score");
%>
<form action="menu.jsp" method="post">
    <input type="submit" name="Home" value="Home"/>
</form>
<div class="container">

    <header>
        <h1>Task</h1>
    </header>

    <%=question%>
    </br>


    <textarea name="code" rows="20" cols="100" form="usrform">
    <%=code%>
    </textarea>
    <footer>
        <form action="${pageContext.request.contextPath}/task_servlet" method="post" id="usrform">
            <input type="submit" name="Check" value="Check"/>
            <input type="hidden" name="ans" value="<%=ans%>">
            <input type="hidden" name="question" value="<%=question%>">
            <input type="hidden" name="ans_code" value="<%=ansCode%>">
            <input type="hidden" name="tags" value="<%=tags%>">
        </form>

        <form action="${pageContext.request.contextPath}/menu_servlet" method="post" id="usrform">
            <input type="submit" name="New question" value="New question"/>
            <input type="hidden" name="tags" value="<%=tags%>">
        </form>

        <% if (isTrue != null) {
            if (isTrue) {
        %>
        <h2>You are right!</h2>
        <h2>Try another question</h2>
        <% } else {%>
        <h2>You are wrong =( Try again</h2>
        <%
                }
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
