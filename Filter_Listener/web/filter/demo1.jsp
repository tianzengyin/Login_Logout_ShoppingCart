<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/13
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/hello" method="post">
    <input type="text" name="username">
    <input type="submit" value="提交">
</form>

</body>
</html>
