<%--
  Created by IntelliJ IDEA.
  User: xuqiangsheng
  Date: 2020/7/29
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试参数绑定</title>
</head>
<body>
<%--请求参数的绑定--%>
    <form action="param/saveAccount" method="post">
        姓名: <input type="text" name="username"/> <br/>
        密码: <input type="text" name="password"/> <br/>
        金额: <input type="text" name="money"/> <br/>
        用户名: <input type="text" name="user.uname"/> <br/>
        年龄: <input type="text" name="user.age"/> <br/>
        list集合<br/>
        用户名: <input type="text" name="userList[0].uname"/> <br/>
        年龄: <input type="text" name="userList[0].age"/> <br/>
        用户名: <input type="text" name="userList[1].uname"/> <br/>
        年龄: <input type="text" name="userList[1].age"/> <br/>
        用户名: <input type="text" name="userList[2].uname"/> <br/>
        年龄: <input type="text" name="userList[2].age"/> <br/>
        map集合<br/>
        用户名: <input type="text" name="userMap['one'].uname"/> <br/>
        年龄: <input type="text" name="userMap['one'].age"/> <br/>
        用户名: <input type="text" name="userMap['two'].uname"/> <br/>
        年龄: <input type="text" name="userMap['two'].age"/> <br/>
        用户名: <input type="text" name="userMap['three'].uname"/> <br/>
        年龄: <input type="text" name="userMap['three'].age"/> <br/>
        <input value="提交" type="submit"/>
    </form>
</a>
</body>
</html>
