<%--
  Created by IntelliJ IDEA.
  User: AEB
  Date: 2019/5/21
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>测试文件上传</title>
</head>
<body>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="picture">
        <input type="submit" value="上 传">
    </form>
</body>
</html>
