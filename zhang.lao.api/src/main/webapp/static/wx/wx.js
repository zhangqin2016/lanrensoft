/*
 * 注意：
 * 1. 所有的JS接口只能在公众号绑定的域名下调用，公众号开发者需要先登录微信公众平台进入“公众号设置”的“功能设置”里填写“JS接口安全域名”。
 * 2. 如果发现在 Android 不能分享自定义内容，请到官网下载最新的包覆盖安装，Android 自定义分享接口需升级至 6.0.2.58 版本及以上。
 * 3. 完整 JS-SDK 文档地址：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html
 *
 * 如有问题请通过以下渠道反馈：
 * 邮箱地址：weixin-open@qq.com
 * 邮件主题：【微信JS-SDK反馈】具体问题
 * 邮件内容说明：用简明的语言描述问题所在，并交代清楚遇到该问题的场景，可附上截屏图片，微信团队会尽快处理你的反馈。
 */
var isInitWx= false;
function initWxJspai(event){
    if(isInitWx){
        event();
    }else{
        $.get("/wx/jsapi/get",{url:window.location.href},function (data) {
            var d = data.body;
            wx.config({
                debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                appId: d.appId, // 必填，公众号的唯一标识
                timestamp: d.timestamp, // 必填，生成签名的时间戳
                nonceStr: d.nonceStr, // 必填，生成签名的随机串
                signature: d.signature,// 必填，签名
                jsApiList: [
                    'checkJsApi',
                    'scanQRCode'
                ]
            });
            isInitWx=true;
            event();
        });
    }

}

$(function () {
    $("#scan").click(function () {
        initWxJspai(function () {
            WxScanQRCode(function (res) {
                $("#result").html(res.resultStr);
            })
        });
    })
});

wx.error(function (res) {
alert("该浏览器不支持微信api");
});
try{

    function WxScanQRCode(fun){
        wx.scanQRCode({
            needResult: 1,
            desc: 'scanQRCode desc',
            success: function (res) {
                fun(res);
            }
        });

    }; }catch (e){}