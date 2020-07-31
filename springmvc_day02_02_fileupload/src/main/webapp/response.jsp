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
    <script src="js/jquery.min.js"/>
    <script>
        //页面加载,绑定单击事件
        $(function () {
            $("#btn").click(function () {
                // alert("hello btn");
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"tom","password":"123","age":30}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //data服务器端响应的数据
                        alert(data);
                        alert(data.password);
                        alert(data.username);
                    }
                });
            });
        });
    </script>
</head>
<body>
<a href="user/testString">testString</a>
<br>
<a href="user/testVoid">testVoid</a>
<br>
<a href="user/testForwardOrRedirect">testForwardOrRedirect</a>
<br>
<button id="btn">发送jsp请求</button>
</body>
</html>
