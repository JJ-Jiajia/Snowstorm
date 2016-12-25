<%--
  Created by IntelliJ classEA.
  User: jiajia19889
  Date: 2016/12/23
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script>
        $(function () {
            setInterval("changeFontColor()",250);
        })
        function changeFontColor() {
            var Dwarfs=["Doc","Bashful","Sleepy","Sneezy","Happy","Dopey","Grumpy"];
            for(var d in Dwarfs){
                $("."+Dwarfs[d]).css("color",getRandomColor());
            }

        }
        function getRandomColor() {
            var color='#';
            for(var i=0;i<=5;i++){
                color+=(Math.floor(Math.random()*16)).toString(16);
            }
            return color;
        }
    </script>
</head>
<html>
<head>
    <title>dwarfs</title>
</head>
<body >
<h1 style="font-family: 'Microsoft YaHei Mono';" class="Dwarfs">Seven Dwarfs</h1>
<h2 style="font-family: 'Microsoft YaHei Mono';" class="Doc">Doc</h2>
<h2 style="font-family: 'Microsoft YaHei Mono';" class="Bashful">Bashful</h2>
<h2 style="font-family: 'Microsoft YaHei Mono';" class="Sleepy">Sleepy</h2>
<h2 style="font-family: 'Microsoft YaHei Mono';" class="Sneezy">Sneezy</h2>
<h2 style="font-family: 'Microsoft YaHei Mono';" class="Happy">Happy</h2>
<h2 style="font-family: 'Microsoft YaHei Mono';" class="Dopey">Dopey</h2>
<h2 style="font-family: 'Microsoft YaHei Mono';" class="Grumpy">Grumpy</h2>
</body>
</html>
