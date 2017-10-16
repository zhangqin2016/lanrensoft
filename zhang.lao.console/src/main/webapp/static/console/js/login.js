$(function ($) {
    $("#loginId").click(function () {
        $("#loginForm").submit();
    });
});

function loginEnterToQuery(e){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if (e.keyCode == 13) {
        $("#loginForm").submit();
    }
}
function changePatchca(){
    $("#patchca_img").attr('src','/common/captcha/get/loginCaptcha?'+ Date.parse(new Date())+Math.floor(Math.random()*999999));
}

