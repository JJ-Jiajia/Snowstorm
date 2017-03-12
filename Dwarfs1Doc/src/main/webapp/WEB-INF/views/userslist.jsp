<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <script src="js/jquery-3.1.1.min.js"></script>
</head>
<html style="background: black;color: greenyellow">
<head>
    <title>dwarfs</title>
</head>
<body>

<h1 class="Users">userlist:</h1><br>
<table border="0" id="datatable" >
    <tr> </tr>
</table>
</body>

</html>
<script>
    $(function () {
        var url = "getUsers";
        $.post(url, function (data) {
            var str = '';
            var flag=true;
            for (var i = 0; i < data.length; i++) {
                if(flag){
                    str+='<tr>';
                    for (key in data[i]) {
                        str+='<th>'+key+'</th>'
                    }
                    str+='</tr>';
                    flag=false;
                }
                str+='<tr>';
                for (key in data[i]) {
                    if('sex' == key){
                        str += '<td>'+(data[i][key]  == '1'?'male':'female' )+'</td>';
                    }else{
                        str += '<td>'+data[i][key]  +'</td>';
                    }
                }
                str+='</tr>';
            }
            $("#datatable").find("tr").after(str);
        })
    })
</script>