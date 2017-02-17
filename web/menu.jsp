<%@ page import="tutorial.Global" %>
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
    Global global = Global.getInstance();
    String name = global.getUserName();
%>
Hello, <%=name%>
<form action="index.jsp" method="post">
    <input type="submit" name="Logout" value="Logout"/>
</form>
<form action="history.jsp" method="post">
    <input type="submit" name="History" value="History"/>
</form>

<div class="container">
    <header>
        <h1 style="font-size:50px">Codingfolio</h1>
    </header>
    <table align="center">
        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/menu_servlet" method="post">
                	<h4>Enter Topics
                    <input type="text" size="40" name="tags" placeholder="Topics:for, if, array, while, string, math">
                    <input type="submit" name="question" value="Enter"/></h4>
                </form>
                	<h4 style="text-align:center"> You can put more than one topic</h4>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
