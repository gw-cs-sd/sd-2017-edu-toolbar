<%@ page import="tutorial.Global" %>
<%@ page import="tutorial.User" %>
<%@ page import="tutorial.question.QA" %>
<%@ page import="java.util.List" %>
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

    td {
        padding-top: .5em;
        padding-bottom: .5em;
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
    //    Global global = Global.getInstance();
//    String name = global.getUserName();
    User user = Global.getInstance().getUser();
    List<QA> qa = user.getQa();
    List<String> ans = user.getAns();

%>
<form action="menu.jsp" method="post">
    <input type="submit" name="Home" value="Home"/>
</form>

<div class="container">
    <header>
        <h1>Questions history</h1>
    </header>
    <table align="center">
        <%
            for (int i = 0; i < qa.size(); i++) {
        %>
        <tr>
            <td>
                Question: <%=qa.get(i).getQuestion()%>
                <br>
                Your answer:  <%=ans.get(i)%>
                <br>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
