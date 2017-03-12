<%@ page contentType="text/html;charset=utf-8" %>
<head>
    <script src="js/jquery-3.1.1.min.js"></script>
    <title>旧物置换</title>
    <style>
        img {
            object-fit: cover;
        }

        .good {
            padding-left: 8px;
        }
    </style>
</head>
<html>
<body>
<center><h2>闺蜜旧物置换平台</h2></center>
<hr color="black"/>
<br/>
<%--物品陈列--%>
<div id="goodsList" style="float:left;width:70%;padding-left: 80px;">
    <div style="float:left; " class="good" >
        <div><img src="imgs/DSC_9612.jpg" width="250" height="250"><br/><a>物品名称：你家男朋友</a><br/><font>拥有者：</font><a>飞飞</a><br/>
            <div>时间：2017.2.7</div>
        </div>
    </div>

    <div style="clear:both" ></div>
</div>
<br/>
<%--分隔换行--%>
<div style="float: right;width: 100%;"></div>
<br/>
<%--分页工具栏--%>
<div id="tabBar" style="float:left;">
    <div style="float:left;">
        <a href="" id="pageUp"><span><<</span>上一页</a>
    </div>
    <div style="float:left;">
        &nbsp;&nbsp;&nbsp;&nbsp;
    </div>
    <div style="float:left;"> 当前页：<font id="currentPage">1</font></div>
    <div style="float:left;">
        &nbsp;&nbsp;&nbsp;&nbsp;
    </div>
    <div style="float:left;">
        每页数量：<input id="pageSize" size="1" >
    </div>
    <div style="float:left;">
        &nbsp;&nbsp;&nbsp;&nbsp;
    </div>
    <div style="float:left;">总页数：<font id="totalPage">1</font></div>
    <div style="float:left;">
        &nbsp;&nbsp;&nbsp;&nbsp;
    </div>
    <div style="float:left;">
        <button id="jumpBtn" style="background: white;border: none;">跳转</button>
        <input id="jump" size="1">
    </div>
    <div style="float:left;">
        &nbsp;&nbsp;&nbsp;&nbsp;
    </div>
    <div style="float:left;">
        <a href="" id="pageDown">下一页<span>>></span></a>
    </div>
</div>

<div style="float: left;width: 100%;height: 100px;"></div>
</body>
</html>
<script>
    $(function () {
        listdata();
    });
    function listdata() {
        var pageSize=$('#pageSize').val() == ''?'48':$('#pageSize').val();
        var jump=$('#jump').val() == ''?'1':$('#pageSize').val();
        var url='getGoods';
        $.post(url,{'pageSize':pageSize,'jump':jump},function (data) {

        })

    }
</script>
