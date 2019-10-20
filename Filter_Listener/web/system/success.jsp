<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/8
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

欢迎:${sessionScope.USERNAME_IN_SESSION} 登录
<a href="<%=request.getContextPath()%>/LogoutServlet">注销</a>
<hr/>
<h1>主界面</h1><br>
<a href="<%=request.getContextPath()%>/system/f1.jsp">功能一</a>
<a href="<%=request.getContextPath()%>/system/f2.jsp">功能二</a>
<a href="<%=request.getContextPath()%>/system/f3.jsp">功能三</a>

</body>
</html>
