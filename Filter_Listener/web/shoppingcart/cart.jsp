<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/10
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的购物车</title>
</head>
<body>
<h1>我的购物车</h1>
   <table cellspacing="0" cellpadding="0" border="1" width="80%">
       <tr>
           <td>名称</td>
           <td>价格</td>
           <td>数量</td>
           <td>操作</td>
       </tr>
           <c:forEach items="${sessionScope.SHOPPINGCART_IN_SESSION.items}" var="item">
               <tr>
                   <td>${item.name}</td>
                   <td>${item.price}</td>
                   <td>${item.num}</td>
                   <td><a href="<%=request.getContextPath()%>/shoppingCart?cmd=delete&id=${item.id}">删除</a></td>
               </tr>
           </c:forEach>
       <c:if test="${empty sessionScope.SHOPPINGCART_IN_SESSION.items}">
           <tr>
               <td colspan="4">购物车空空如也，赶快去购物吧！！！</td>
           </tr>
       </c:if>
       <c:if test="${!empty sessionScope.SHOPPINGCART_IN_SESSION.items}">
           <tr>
               <td colspan="4" style="text-align: right;" >总价为：${sessionScope.SHOPPINGCART_IN_SESSION.totalPrice}</td>
           </tr>
       </c:if>

   </table>
<a href="<%=request.getContextPath()%>/shoppingcart/shopping.jsp">继续购物</a>
</body>
</html>
