<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/26
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品编辑界面</title>
</head>
<body>

    <form action="<%=request.getContextPath()%>/product?cmd=save" method="post">
        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td>商品名</td>
                <td><input type="text" name="productName" required value="${product.productName}"></td>
            </tr>
            <tr>
                <td>分类ID</td>
                <td>
                    <input type="number" name="dir" value="${product.dirId}">
                </td>
            </tr>
            <tr>
                <td>零售价</td>
                <td><input type="number" name="salePrice" required min="0" value="${product.salePrice}"></td>
            </tr>
            <tr>
                <td>供应商</td>
                <td><input type="text" name="supplier" required value="${product.supplier}"></td>
            </tr>
            <tr>
                <td>品牌</td>
                <td><input type="text" name="brand" required value="${product.brand}"></td>
            </tr>
            <tr>
                <td>折扣</td>
                <td><input type="text" name="cutoff" required value="${product.cutoff}"></td>
            </tr>
            <tr>
                <td>成本价</td>
                <td><input type="number" name="costPrice" required value="${product.costPrice}"></td>
            </tr>
            <tr><td colspan="2"><input type="submit" value="提交"></td></tr>
        </table>
    </form>
</body>
</html>
