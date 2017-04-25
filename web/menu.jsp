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
        background-color: #55b561;
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
    .button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 10px;
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
<%
    Global global = Global.getInstance();
    String name = global.getUserName();
%>
<h2>Hello, <%=name%></h2>
<form action="index.jsp" method="post">
    <input type="submit" class="menubutton" name="Logout" value="Logout"/>
</form>
<form action="history.jsp" method="post">
    <input type="submit" class="menubutton" name="History" value="History"/>
</form>

<div class="container">
    <header>
        <h1 style="font-size:50px">Codingfolio</h1>
    </header>
    <table align="center">
        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/menu_servlet" method="post">
                    <input type="text"  size="40"  name="tags" placeholder="Write tags separated by spaces">
                    
                    <input type="submit" class="button" name="question" value="Enter"/>
                </form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
