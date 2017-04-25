<%@ page contentType="text/html;charset=utf-8" %>
<head>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/datemore.js"></script>
    <script src="js/layer/layer.js"></script>
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

<% if (session.getAttribute("user") == null && "${sessionScope.user.username}".equals("")){%>
<a href="register.htm">注册</a>
<a href="login.htm">登录</a>
<%} else {%>
<a href="javaScript:void(0)">${sessionScope.user.username}</a>
<a href="javaScript:void(0)" id="lagout">登出</a>
<%}%>
<a href="userslist.htm">用户列表</a>&nbsp<a href="addgoods.htm">录入</a>
<hr color="black"/>
<br/>
<%--物品陈列--%>
<div id="goodsList" style="float:left;width:70%;padding-left: 80px;">
    <div style="clear:both" id="last"></div>
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
    <div style="float:left;">总数量：<font id="totalRecord"></font></div>
    <div style="float:left;">
        &nbsp;&nbsp;&nbsp;&nbsp;
    </div>
    <div style="float:left;">总页数：<font id="totalPage"></font></div>
    <div style="float:left;">
        &nbsp;&nbsp;&nbsp;&nbsp;
    </div>
    <div style="float:left;"> 当前页：<font id="currentPage"></font></div>
    <div style="float:left;">
        &nbsp;&nbsp;&nbsp;&nbsp;
    </div>
    <div style="float:left;">
        每页数量：<input id="pageSize" size="1" type="number" min="1" max="48">
    </div>
    <div style="float:left;">
        &nbsp;&nbsp;&nbsp;&nbsp;
    </div>
    <div style="float:left;">
        跳转：<input id="jump" size="1" type="number" max="48" min="1">
        <button id="jumpBtn" style="background: gainsboro;border: none;" onclick="listdata()">确定</button>
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
        $('#pageDown').click(function (event) {
            event.preventDefault();
            var currentPage = $('#jump').val() == '' ? '1' : $('#jump').val();
            var next = parseInt(currentPage) + 1 > parseInt($('#totalPage').text()) ? parseInt($('#totalPage').text()) : parseInt(currentPage) + 1;
            $('#jump').val(next);
            listdata();
        });
        $('#pageUp').click(function (event) {
            event.preventDefault();
            var currentPage = $('#jump').val() == '' ? '1' : $('#jump').val();
            var pre = parseInt(currentPage) == 1 ? 1 : parseInt(currentPage) - 1;
            $('#jump').val(pre);
            listdata();
        });
        listdata();
        $('#lagout').off('click').on('click',function () {
            layer.open({
                content:'确定登出么？',
                yes:function (layero, index) {
                    $.post();
                    layer.close(layero);
                }
            })
        })
    });
    var flag = false;
    function listdata() {
        if (flag) {
            var totalRecord1 = parseInt($('#totalRecord').text());
            var pageSize1 = parseInt($('#pageSize').val() == '' ? '-1' : $('#pageSize').val());
            var currentPage1 = parseInt($('#jump').val() == '' ? '1' : $('#jump').val());
            if (pageSize1 * currentPage1 > totalRecord1) {
                return;
            }
        }
        flag = true;
        $('#goodsList').children().remove();
        var pageSize = $('#pageSize').val() == '' ? '-1' : $('#pageSize').val();
        var currentPage = $('#jump').val() == '' ? '1' : $('#jump').val();
        var url = 'getGoods.json';
        $.post(url, {'pageSize': pageSize, 'currentPage': currentPage}, function (data) {
            $('#currentPage').text(data.currentPage);
            $('#pageSize').val(data.pageSize);
            $('#totalPage').text(data.totalPage);
            $('#totalRecord').text(data.totalRecord);
            var dataList = data.dataList;
            for (var i = 0; i < dataList.length; i++) {
                var imgSrc = dataList[i]['picture'];
                var name = dataList[i]['name'];
                var ownername = dataList[i].ownername;
                var createtime = new Date(dataList[i].createtime).Format("yyyy-MM-dd");
                var domObj = '<div style="float:left;" class="good" >';
                domObj += '<div><img src="';
                domObj += imgSrc;
                domObj += '" width="250" height="250"><br/><a>物品名称：';
                domObj += name;
                domObj += '</a><br/><font>拥有者：</font><a>';
                domObj += ownername;
                domObj += '</a><br/><div>时间：';
                domObj += createtime;
                domObj += '</div> </div></div>';
                $('#goodsList').append(domObj);
            }
        })
    }
</script>
