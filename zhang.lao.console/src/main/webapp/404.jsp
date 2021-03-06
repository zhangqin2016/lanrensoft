<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>404</title>
    <style>
        body{
            font-family:"Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
        }
        .error_four{
            width: 80%;
            height: 80%;
            position: absolute;
            top: 0;left: 0;right: 0;bottom: 0;
            margin: auto;
            /*border: 1px solid red;*/
        }
        .four_p{
            text-align: center;
            padding-bottom: 50px;
        }
        .four_back{
            padding: 10px;
            text-align: center;
            background: #11c691;
            color: #f5f5f5;
            border-radius: 5px;
            /*margin:auto;*/
            font-size: 16px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="error_four container">
        <div class="row">
           <div class="col-xs-12 four_p">
               <img src="<%=request.getContextPath()%>/portal_2/images/404p.png" alt=""/>
           </div>
            <div class="col-xs-12 four_p">
                <img src="<%=request.getContextPath()%>/portal_2/images/404t.png" alt=""/>
            </div>
            <div class="col-xs-2 four_back" onclick="javascript:history.back(-1);">
                返回上一页
            </div>
        </div>
    </div>
    <script src="<%=request.getContextPath()%>/plugin/jquery/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script>

        var fourleft=($(window).width()*0.8-$(".four_back").width())/2;
        $(".four_back").css({
            marginLeft:fourleft
        })
        $(window).resize(function(){
            var fourleft=($(window).width()*0.8-$(".four_back").width())/2;
            $(".four_back").css({
                marginLeft:fourleft
            })
        })
    </script>
</body>
</html>