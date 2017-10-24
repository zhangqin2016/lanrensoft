$(function ($) {
    $(".zq-loginbtn").click(function () {
        $("#password").val(SparkMD5.hash($("#password").val()));
        $("#loginForm").submit();
    });
});

function loginEnterToQuery(e){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if (e.keyCode == 13) {
        $("#password").val(SparkMD5.hash($("#password").val()));
        $("#loginForm").submit();
    }
}
function changePatchca(){
    $("#patchca_img").attr('src','/common/captcha/get/loginCaptcha?'+ Date.parse(new Date())+Math.floor(Math.random()*999999));
}

