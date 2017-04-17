<%@ page import="tutorial.Global" %>
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
        <h1>Java tutorial</h1>
    </header>
    <table align="center">
        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/menu_servlet" method="post">
                    <input type="text" size="40" name="tags" placeholder="Write tags separated by spaces">
                    <input type="submit" name="question" value="Generate question for tags"/>
                </form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
