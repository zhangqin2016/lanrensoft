
layui.use(['layer','laydate'], function(){

});
$(function($) {
/*开启表单验证*/
$("#boProgectGoodsImages_form").validation();
 consoleUploadImg('imageUrl',''); consoleUploadImg('imageType','');
});
/*保存*/
function saveZqForm(){
if ($("#boProgectGoodsImages_form").valid() == false) {
return false;
}
var formObject=new Object();
formObject.goodsId=$('#goodsId').val()==''?null:$('#goodsId').val(); 
 formObject.imageUrl=$('#imageUrl').val()==''?null:$('#imageUrl').val(); 
 formObject.imageName=$('#imageName').val()==''?null:$('#imageName').val(); 
 formObject.imageType=$('#imageType').val()==''?null:$('#imageType').val(); 
 formObject.sort=$('#sort').val()==''?null:$('#sort').val(); 
 formObject.id=$('#id').val()==''?null:$('#id').val(); 
 
var formObjectJson = JSON.stringify(formObject);
$.post("/console/bo_progect_goods_images/save",
{
formObjectJson :formObjectJson,
common_token :$("#common_token").val()
}, function(data) {
layer.alert(data.message, {skin: 'layui-layer-molv',closeBtn: 0 }, function(){
parent.$("#boProgectGoodsImages").bootstrapTable("refresh");
parent.layer.closeAll();
});

});
}