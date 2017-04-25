<%--
  Created by IntelliJ IDEA.
  User: evenj
  Date: 2017/3/25
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>

<div style="position:absolute;margin-left: 530px; margin-top: 100px;">
    <form action="register.json">
        <span>用户名：</span>
        <input name="username" type="text" style="margin-left: 1px;"><br/>
        <span>密&nbsp;&nbsp;码：</span>
        <input name="passwords" type="password"><br/>
        <span>性&nbsp;&nbsp;别：</span>
        <select name="sex" style="width: 173px;">
            <option value="1">男</option>
            <option value="0">女</option>
        </select><br/>
        <span>电&nbsp;&nbsp;话：</span>
        <input name="tel" type="tel"><br/>
        <input value="提交" type="submit">
    </form>
</div>
</body>
</html>
