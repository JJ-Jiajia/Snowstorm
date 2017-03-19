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
<a href="login">登录</a> <a href="userslist">test</a><a href="addgoods">录入</a>
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
        跳转：<input id="jump" size="1"  type="number" max="48" min="1">
        <button id="jumpBtn" style="background: gainsboro;border: none;" onclick="listdata()" >确定</button>
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
    // 对Date的扩展，将 Date 转化为指定格式的String
    // 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
    // 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
    // 例子：
    // (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
    // (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
    $(function () {
        $('#pageDown').click(function (event) {
            event.preventDefault();
            var currentPage = $('#jump').val() == '' ? '1' : $('#jump').val();
            var next=parseInt(currentPage)+1>parseInt($('#totalPage').text())?parseInt($('#totalPage').text()):parseInt(currentPage)+1;
            $('#jump').val(next);
            listdata();
        });
        $('#pageUp').click(function (event) {
            event.preventDefault();
            var currentPage = $('#jump').val() == '' ? '1' : $('#jump').val();
            var pre=parseInt(currentPage) ==1 ?1:parseInt(currentPage)-1;
            $('#jump').val(pre);
            listdata();
        });
        listdata();
    });
    var flag=false;
    function listdata() {
        if(flag){
            var totalRecord1=parseInt($('#totalRecord').text());
            var pageSize1 = parseInt($('#pageSize').val() == '' ? '-1' : $('#pageSize').val());
            var currentPage1 = parseInt($('#jump').val() == '' ? '1' : $('#jump').val());
            if(pageSize1*currentPage1>totalRecord1){
                return;
            }
        }
        flag=true;
        $('#goodsList').children().remove();
        var pageSize = $('#pageSize').val() == '' ? '-1' : $('#pageSize').val();
        var currentPage = $('#jump').val() == '' ? '1' : $('#jump').val();
        var url = 'getGoods';
        $.post(url, {'pageSize': pageSize, 'currentPage': currentPage}, function (data) {
            $('#currentPage').text(data.currentPage);
            $('#pageSize').val(data.pageSize);
            $('#totalPage').text(data.totalPage);
            $('#totalRecord').text(data.totalRecord);
            var dataList = data.dataList;
            for(var i=0;i<dataList.length;i++){
                var imgSrc = dataList[i]['picture'];
                var name = dataList[i]['name'];
                var ownername =dataList[i].ownername;
                var createtime =new Date(dataList[i].createtime).Format("yyyy-MM-dd");
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
                $('#goodsList').append(domObj);}
        })

    }
</script>
