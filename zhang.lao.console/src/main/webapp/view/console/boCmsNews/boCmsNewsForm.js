
layui.use(['layer','laydate'], function(){

});
$(function($) {
/*开启表单验证*/
$("#boCmsNews_form").validation();
      $('input[auto_name="boCmsNews_publish"]').each(function(){
       if('${boCmsNews.publish!}'==this.value){ 
             $(this).attr('checked','checked');
            }
           });
 	$("#newsType").val("${boCmsNews.newsType!}");
 	if('${boCmsNews.newsType!}'==''){
 	    $("#newsType").val('1');
 	}
  consoleUploadImg('cover','${ctxPath}');
});
/*保存*/
function saveZqForm(){
if ($("#boCmsNews_form").valid() == false) {
return false;
}
var formObject=new Object();
formObject.publish=($('input[name="publish"]:checked').val()==''?null:$('input[name="publish"]:checked').val()); 
 formObject.author=$('#author').val()==''?null:$('#author').val(); 
 formObject.source=$('#source').val()==''?null:$('#source').val(); 
 formObject.content=$('#content').val()==''?null:$('#content').val(); 
 formObject.cover=$('#cover').val()==''?null:$('#cover').val(); 
 formObject.title=$('#title').val()==''?null:$('#title').val(); 
 formObject.newsType=$('#newsType').val()==''?null:$('#newsType').val(); 
 formObject.intro=$('#intro').val()==''?null:$('#intro').val(); 
 formObject.tag=$('#tag').val()==''?null:$('#tag').val(); 
 formObject.id=$('#id').val()==''?null:$('#id').val(); 
 
var formObjectJson = JSON.stringify(formObject);
$.post("${ctxPath}/console/bo_cms_news/save",
{
formObjectJson :formObjectJson,
common_token :$("#common_token").val()
}, function(data) {
layer.alert(data.message, {skin: 'layui-layer-molv',closeBtn: 0 }, function(){
parent.$("#boCmsNews").bootstrapTable("refresh");
parent.layer.closeAll();
});

});
}