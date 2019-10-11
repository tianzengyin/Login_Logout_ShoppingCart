<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/9
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
    <h1>商品列表</h1>
    <form action="<%=request.getContextPath()%>/shoppingCart?cmd=save" method="post">
        商品名称：<select name="name" >
                        <option>电脑</option>
                        <option>手机</option>
                        <option>IPAD</option>
                  </select> <br/>
        数量：<input type="number" name="num" /> <br/>
        <input type="submit" value="买买买"/>
    </form>
</body>
</html>
