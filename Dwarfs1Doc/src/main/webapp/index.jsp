<head>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script>
        $(function () {
            setInterval("changeFontColor()",500);
        })
        function changeFontColor() {
            var color='#';
            for(var i=0;i<=5;i++){
                color+=(Math.floor(Math.random()*16)).toString(16);
            }
            $("#dwarfs").css("color",color);
        }
    </script>
</head>
<html>
<body>
<h2>Hello World!</h2>
<a href="dwarfs" style="font-family: Consolas;font-size: 20px;" id="dwarfs" >Let's see seven Dwarfs!</a>
</body>
</html>
