<%--
  Created by IntelliJ IDEA.
  User: yangself
  Date: 2019/10/21
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户登陆</title>
  </head>
  <body>
  <%
    String msg = "";
    String username = "";
    String message = (String)request.getAttribute("msg");
    if (message != null){
      msg = message ;
    }
    Cookie[] userCookies = request.getCookies();
    if (userCookies!=null) {
      for (Cookie userCookie : userCookies
      ) {
        if (userCookie.getName().equals("username")) {
          username = userCookie.getValue();
        }
      }
    }
  %>
  <div style="color: red"><%=msg%></div>
    <form action="/Login/LoginPass" method="post">
      用户名：<input type="text" name="username" value="<%=username%>"/><br/>
      密  码：<input type="password" name="password"><br/>
      请输入验证码：<input type="text" name="verityCode"><img src="/Login/VerifyCodeServlet" alt="verifyCode">
      <br/>
      <input type="submit" value="提交">
    </form>
  </body>
</html>
