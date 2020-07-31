<%--
  Created by IntelliJ IDEA.
  User: xuqiangsheng
  Date: 2020/7/29
  Time: 8:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<meta charset="UTF-8">
<head>
    <title>Title</title>
</head>
<body>
<h3>传统文件上传</h3>
<br>
<form action="user/fileUpload1" method="post" enctype="multipart/form-data">
    <input type="file" name="upload"/>
    <br>
    <input type="submit" value="上传">
</form>
<br>
<h3>SpringMvc文件上传</h3>
<br>
<form action="user/fileUpload2" method="post" enctype="multipart/form-data">
    <input type="file" name="upload"/>
    <br>
    <input type="submit" value="上传">
</form>

<h3>跨服务器文件上传</h3>
<br>
<form action="user/fileUpload3" method="post" enctype="multipart/form-data">
    <input type="file" name="upload"/>
    <br>
    <input type="submit" value="上传">
</form>
</body>
</html>
