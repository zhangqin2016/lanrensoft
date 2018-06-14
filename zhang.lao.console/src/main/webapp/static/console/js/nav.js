/**
 * Created by zhangqin on 2017/5/25.
 */
//注意：导航 依赖 element 模块，否则无法进行功能性操作
var s ="glyphicon glyphicon-chevron-down zq-left";
var h ="glyphicon glyphicon-chevron-right zq-left";
$(function($){
    $.post("/console/first/nav",function (data) {
        $("#firstNav").html(data.data);

        $("a[name='first_nav']").click(function(){
            if($(this).parent().attr("class")!="active") {
                layui.data("nav", {key: "first_nav", value: $(this).attr("id")});
                initNavClass();
            }
        });

    });
    var nav = layui.data('nav');
    var first_nav = nav.first_nav;
    if(first_nav){
        first_nav= first_nav.replace("first_","");
    }else{
        first_nav = 0000;
    }
    $.post("/console/second/nav?nav_id="+first_nav,function (data2) {
        $("#secondNav").html(data2.data);
        $("a[name='second_nav']").click(function(){

            layui.data("nav", {key: "three_nav", remove: true});
            layui.data("nav", {key: "second_nav", value: $(this).attr("id")});
            initNavClass();
            var three= $(this).parent().find("span[name='showThreeNav']").eq(0);
            var dl = $(three).parent().parent().find("dl");
            if(  $(three).attr("class")==s){
                dl.hide();
                $(three).attr("class",h);
            }else{
                dl.show();
                $(three).attr("class",s);
            }

        });
        $("a[name='three_nav']").click(function(){
            layui.data("nav", {key: "three_nav", value: $(this).attr("id")});
            initNavClass();
        });


        initNavClass();
        if(data2.data.length==0){
            $(".zq-left-nav").hide();
            $(".zq-main-body").css("margin-left",0);
        }else{
            $(".zq-left-nav").show();
            $(".zq-main-body").css("margin-left",212);
        }
    });
});
function initNavClass() {
    var nav = layui.data('nav');
    var first_nav = nav.first_nav;
    var second_nav = nav.second_nav;
    var three_nav = nav.three_nav;
    if(first_nav!=undefined){
        var li = $("#"+first_nav).parents("li");
        $(li).attr("class","active");
    }
    if(second_nav!=undefined){
        var li = $("#"+second_nav).parents("li");
        $(li).attr("class","active");
    }
    if(three_nav!=undefined){
        var sli = $("#"+three_nav).parents("li");
        var dd = $("#"+three_nav).parents("dd");
        $(sli).attr("class","active");
        $(dd).attr("class","active");
        $("#"+three_nav).parents("dl").show();
        $(sli).find("span[name='showThreeNav']").attr("class",s);
    }
}