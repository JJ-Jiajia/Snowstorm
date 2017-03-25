<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>物品详情</title>
    <style>
        img {
            object-fit: cover;
        }

        .good {
            padding-left: 8px;
        }
    </style>
</head>
<body>
物品名称：${goodsInfo.name}<br>
物品分类：${goodsInfo.goodClass}<br>
拥有者：${goodsInfo.ownername}<br>

物品描述：${goodsInfo.memo}<br>
<%--图片详情陈列--%>
<div id="goodsList" style="float:left;width:70%;padding-left: 80px;">
    <c:forEach items="${pictures}" var="GoodPicture">
        <div style="float:left;" class="good">
            <img src="${GoodPicture.picturePath}" width="250" height="250">
        </div>
    </c:forEach>
    <div style="clear:both" id="last"></div>
</div>

</body>
</html>
