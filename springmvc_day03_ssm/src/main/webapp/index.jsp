<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/31
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="account/findAll">测试查询所有</a>
<h3>测试保存</h3>
<form action="account/saveAccount" method="post">
    姓名:<input type="text" name="name">
    uid:<input type="text" name="uid">
    金额:<input type="text" name="money">
    <input type="submit" value="提交">
</form>
</body>
</html>
