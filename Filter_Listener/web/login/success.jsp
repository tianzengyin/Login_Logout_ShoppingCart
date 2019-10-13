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

<%
    //登录校验
    Object obj = request.getSession().getAttribute("USER_IN_SESSION");
        if(obj ==null ){
           // response.sendRedirect("/login/login.jsp");
            request.getRequestDispatcher("/login/login.jsp").forward(request,response);
        }

%>
欢迎:${sessionScope.USER_IN_SESSION.getUsername()} 登录
<a href="<%=request.getContextPath()%>/LogoutServlet">注销</a>
<hr/>
</body>
</html>
