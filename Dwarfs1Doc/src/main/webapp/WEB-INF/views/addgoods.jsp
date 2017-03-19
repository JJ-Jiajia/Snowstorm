<%--
  Created by IntelliJ IDEA.
  User: jim
  Date: 17-3-17
  Time: 下午11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加物品</title>
</head>
<body>
<form action="addgoods.json" enctype="multipart/form-data" method="post">
    物品名称：<input name="name"><br/>
    物品图片：<input type="file" name="picture"><br/>
    物品描述：<input name="memo"><br/>
    <input type="submit"value="确定">
</form>
</body>
</html>
