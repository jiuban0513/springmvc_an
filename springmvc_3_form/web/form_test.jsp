<%--
  Created by IntelliJ IDEA.
  User: AEB
  Date: 2019/5/20
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>SpringMVC表单传参</title>
</head>
<body>

<form action="/param" role="form" method="post">
    用户名：<input type="text" name="username"><br/>
    密码：<input type="text" name="password"><br/>
    <input type="submit" value="提 交">
</form>

</body>
</html>
