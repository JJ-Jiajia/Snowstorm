<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="checklogin" method="post">
   用户名： <input name="username" type="text"><br/>
    输密码： <input name="password" type="password"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
