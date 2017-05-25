/**
 * Created by zhangqin on 2017/5/25.
 */
$(function () {
    $(".layui-nav-item").click(function () {
        window.localStorage.navShowId=$(this).attr("id");
        $(".layui-nav-item").attr("class","layui-nav-item");
        $(this).attr("class","layui-nav-item layui-nav-itemed");
    })
    $("#"+ window.localStorage.navShowId).attr("class","layui-nav-item layui-nav-itemed");

    $("dd").click(function () {
        window.localStorage.navThreeShowId=$(this).attr("id");
        $(".dd").attr("class","");
        $(this).attr("class","layui-this");
    })
    $("#"+ window.localStorage.navThreeShowId).attr("class","layui-this");

})

$(function($){
    $("a[name='second_nav']").click(function(){
        $.cookie('second_three_nav_cookie', null,{ path: '/' });
        $.cookie('second_nav_cookie', $(this).attr("id"),{ path: '/' });
    });
    $("a[name='second_three_nav']").click(function(){
        $.cookie('second_three_nav_cookie', $(this).attr("id"),{ path: '/' });
        $.cookie('second_nav_cookie', null,{ path: '/' });
    });
    $("a[name='three_nav']").click(function(){
        $.cookie('three_nav_cookie', $(this).attr("id"),{ path: '/' });
    });
    var second_three_nav_cookie = $.cookie('second_three_nav_cookie');
    var second_nav_cookie = $.cookie('second_nav_cookie');
    var three_nav_cookie = $.cookie('three_nav_cookie');
    if(second_three_nav_cookie!=undefined&&second_three_nav_cookie!=null&&second_three_nav_cookie!='null'){
        var li = $("#"+second_three_nav_cookie).parent();
        $(li).attr("class","layui-this");
    }else{
        if(second_nav_cookie!=undefined&&second_nav_cookie!=null&&second_nav_cookie!='null'){
            var li = $("#"+second_nav_cookie).parent();
            $(li).attr("class","layui-nav-item layui-nav-itemed");
        }
    }



});