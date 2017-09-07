
layui.use(['layer','laydate'], function(){

});
$(function($) {
/*开启表单验证*/
$("#boProgectAround_form").validation();
 consoleUploadImg('name',''); consoleUploadImg('infoImage','');
});
/*保存*/
function saveZqForm(){
if ($("#boProgectAround_form").valid() == false) {
return false;
}
var formObject=new Object();
formObject.projectId=$('#projectId').val()==''?null:$('#projectId').val(); 
 formObject.name=$('#name').val()==''?null:$('#name').val(); 
 formObject.infoImage=$('#infoImage').val()==''?null:$('#infoImage').val(); 
 formObject.id=$('#id').val()==''?null:$('#id').val(); 
 
var formObjectJson = JSON.stringify(formObject);
$.post("/console/bo_progect_around/save",
{
formObjectJson :formObjectJson,
common_token :$("#common_token").val()
}, function(data) {
layer.alert(data.message, {skin: 'layui-layer-molv',closeBtn: 0 }, function(){
parent.$("#boProgectAround").bootstrapTable("refresh");
parent.layer.closeAll();
});

});
}