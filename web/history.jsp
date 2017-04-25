<%@ page import="tutorial.Global" %>
<%@ page import="tutorial.User" %>
<%@ page import="tutorial.question.QA" %>
<%@ page import="java.util.List" %>
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
    //    Global global = Global.getInstance();
//    String name = global.getUserName();
    User user = Global.getInstance().getUser();
    List<QA> qa = user.getQa();
    List<String> ans = user.getAns();

%>
<form action="menu.jsp" method="post">
    <input type="submit" class="menubutton" name="Home" value="Home"/>
</form>

<div class="container">
    <header>
        <h1 style="font-size:50px">Questions history</h1>
    </header>
   <ul id="questions" style="text-align: left;">

</ul>
    <table align="center">
        <%
            for (int i = 0; i < qa.size(); i++) {
        %>
        <tr>
            <td>
                Question: <%=qa.get(i).getQuestion()%>
                </br>
                Your answer:  <%=ans.get(i)%>
                </br>
            </td>
        </tr>
        <%
            }
        %>
    </table>
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

    var html="";for(var i=1;i<getCookie('questions').split('|').length;i++){ if(getCookie('questions').split('|')[i]!="") html=html+"<li>"+getCookie('questions').split('|')[i]+"</li>"; }
    document.getElementById('questions').innerHTML=html;
</script>
</body>
</html>
