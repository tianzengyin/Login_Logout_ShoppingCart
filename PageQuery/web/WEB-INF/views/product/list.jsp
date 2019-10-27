<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/24
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>商品列表</h1>
<table cellspacing="0" cellpadding="0" border="1" width="80%">
    <tr style="background-color: gold">
        <td>ID</td>
        <td>商品名</td>
        <td>分类ID</td>
        <td>零售价</td>
        <td>供应商</td>
        <td>品牌</td>
        <td>折扣</td>
        <td>成本价</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${requestScope.PRODUCTS}" var="item" varStatus="vs">
        <tr style="background-color: ${vs.count % 2 == 0 ? 'blueviolet':''}">
            <td>${item.id}</td>
            <td>${item.productName}</td>
            <td>${item.dirId}</td>
            <td>${item.salePrice}</td>
            <td>${item.supplier}</td>
            <td>${item.brand}</td>
            <td>${item.cutoff}</td>
            <td>${item.costPrice}</td>
            <td><a href="<%=request.getContextPath()%>/product?cmd=edit&id=${item.id}">编辑</a>
                <a href="<%=request.getContextPath()%>/product?cmd=delete&id=${item.id}">删除</a>
            </td>

        </tr>
    </c:forEach>
    <tr>
        <td><a href="<%=request.getContextPath()%>/product?cmd=add">添加商品</a></td>
    </tr>
</table>
</body>
</html>
