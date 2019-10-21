<%--
  Created by IntelliJ IDEA.
  User: yangself
  Date: 2019/10/21
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功登陆</title>
</head>
<body>
<%
    String user = "";
    String LoginUser = (String)request.getSession().getAttribute("LoginUser");
    if (LoginUser != null){
        user = LoginUser ;
    }else{
        request.setAttribute("msg","对不起，你还没有登陆！");
        request.getRequestDispatcher("/index.jsp").forward(request,response);
        return;
    }

%>
<h1>欢迎登陆！<%=user%></h1>
</body>
</html>
