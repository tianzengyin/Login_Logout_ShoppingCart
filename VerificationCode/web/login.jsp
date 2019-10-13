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
    <script type="text/javascript">
        function change() {
            document.getElementById("randomCode").src = "<%=request.getContextPath()%>/randomCode?" + new Date().getTime();
        }
    </script>
</head>
<body>
    <h1>登录界面</h1>
    <form action="<%=request.getContextPath()%>/login" method="post">
        用户名：<input type="text" name="username"/><br>
        密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"/><span>${errorMsg}</span><br/>

        验证码：<input type="text" name="checkCode" maxlength="5" style="width: 100px">
        <img src="<%=request.getContextPath()%>/randomCode" alt="验证码" title="看不清？点击切换" onclick="change()" id="randomCode"><br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
