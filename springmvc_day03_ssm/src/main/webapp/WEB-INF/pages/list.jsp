<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/31
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>查询所有账户</h3>
<c:forEach items="${list}" var="account">
    姓名:${account.money}
    <br>
    id:${account.id}
    <br>

</c:forEach>
</body>
</html>
