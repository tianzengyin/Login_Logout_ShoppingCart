<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/8
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>注册页面</title>
</head>
<body>
<br><br><br>
<h3 align = "center">注册页面</h3>
<hr>
<form align = "center" action= "<%=request.getContextPath()%>/registerServlet" method="post">
    <table align = "center" border="0">
        <tr><td>用户名</td><td><input type="text" name="userName" ></td></tr>
        <tr><td>密码</td><td><input type="password" name="userPwd" ></td></tr>
        <tr><td>确认密码</td><td><input type="password" name="userRePwd" ></td></tr>
        <tr><td align = "center" colspan="2"><input type="submit" value = "注册" style="color:blue" ></td></tr>
    </table>

</form>
</body>
</html>
