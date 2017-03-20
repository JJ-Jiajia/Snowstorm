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
<form action="savegoods.json" enctype="multipart/form-data" method="post">
    物品名称：<input name="name"><br/>
    物品分类：<input name="class"><br/>
    封面图片：<input type="file" name="picture"><br/>
    详细图片：<input type="file" name="picture">
    <button id="add" type="button">添加</button>
    <br/>
    物品描述：<textarea name="memo"></textarea><br/>
    <input type="submit" value="确定">
</form>
</body>
</html>
<script src="js/jquery-3.1.1.min.js"></script>
<script>
    $(function () {
        $("#add").click(function () {
            $("#add").before('<br/><input type="file" name="picture">');
        });
    });
</script>