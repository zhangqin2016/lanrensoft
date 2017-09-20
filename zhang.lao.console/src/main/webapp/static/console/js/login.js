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

function initMap() {
    var myChart = echarts.init(document.getElementById('map'));
   var option = {
        backgroundColor: '#000',
        globe: {
            baseTexture: "/static/image/data-1491837049070-rJZtl7Y6x.jpg",
            heightTexture: "/static/image/data-1491837049070-rJZtl7Y6x.jpg",
            displacementScale: 0.04,
            shading: 'realistic',
            environment: '/static/image/data-1491837999815-H1_44Qtal.jpg',
            realisticMaterial: {
                roughness: 0.9
            },
            postEffect: {
                enable: true
            },
            light: {
                main: {
                    intensity: 5,
                    shadow: true
                }
            }
        }
    };
    myChart.setOption(option);
}
$(function () {
    initMap();
});
