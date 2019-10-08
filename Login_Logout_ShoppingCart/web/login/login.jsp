<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/7
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>登录界面</h1>
    <form action="<%=request.getContextPath()%>/login" method="post">
        用户名：<input type="text" name="username"/><br>
        密码：<input type="password" name="password"/><span>${errorMsg}</span>
        <input type="submit" value="登录">
    </form>
</body>
</html>
