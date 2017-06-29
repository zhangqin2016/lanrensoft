/**
 * Created by zhangqin on 2017/5/25.
 */
//注意：导航 依赖 element 模块，否则无法进行功能性操作
$(function($){
    $("a[name='first_nav']").click(function(){
        layui.data("nav", {key:"first_nav",value:$(this).attr("id")});
    });
    $("a[name='second_nav']").click(function(){
        var li = $(this).parent();
        $(li).attr("class","active");
        layui.data("nav", {key:"second_nav",value:$(this).attr("id")});
    });
    $("a[name='three_nav']").click(function(){
        layui.data("nav", {key:"three_nav",value:$(this).attr("id")});
    });
    var nav = layui.data('nav');
    var first_nav = nav.first_nav;
    var second_nav = nav.second_nav;
    var three_nav = nav.three_nav;
    if(first_nav!=undefined){
        var li = $("#"+first_nav).parent();
        $(li).attr("class","active");
    }
    if(second_nav!=undefined){
        var li = $("#"+second_nav).parent();
        $(li).attr("class","active");
    }
    if(three_nav!=undefined){
        var li = $("#"+three_nav).parent();
        $(li).attr("class","active");
    }



});