
layui.use(['layer','laydate'], function(){

});
$(function($) {
/*开启表单验证*/
$("#boUser_form").validation();
      $('input[auto_name="boUser_sex"]').each(function(){
       if('${boUser.sex!}'==this.value){ 
             $(this).attr('checked','checked');
            }
           });
       $('input[auto_name="boUser_state"]').each(function(){
       if('${boUser.state!}'==this.value){ 
             $(this).attr('checked','checked');
            }
           });
    consoleUploadAliImg('headImage','');
});
/*保存*/
function saveZqForm(){
if ($("#boUser_form").valid() == false) {
return false;
}
var formObject=new Object();
formObject.nickName=$('#nickName').val()==''?null:$('#nickName').val(); 
 formObject.phoneNumber=$('#phoneNumber').val()==''?null:$('#phoneNumber').val(); 
 formObject.password=$('#password').val()==''?null:$('#password').val(); 
 formObject.sex=($('input[name="sex"]:checked').val()==''?null:$('input[name="sex"]:checked').val()); 
 formObject.age=$('#age').val()==''?null:$('#age').val(); 
 formObject.state=($('input[name="state"]:checked').val()==''?null:$('input[name="state"]:checked').val()); 
 formObject.headImage=$('#headImage').val()==''?null:$('#headImage').val(); 
 formObject.id=$('#id').val()==''?null:$('#id').val(); 
 
var formObjectJson = JSON.stringify(formObject);
$.post("/console/bo_user/save",
{
formObjectJson :formObjectJson,
common_token :$("#common_token").val()
}, function(data) {
layer.alert(data.message, {skin: 'layui-layer-molv',closeBtn: 0 }, function(){
parent.$("#boUser").bootstrapTable("refresh");
parent.layer.closeAll();
});

});
}