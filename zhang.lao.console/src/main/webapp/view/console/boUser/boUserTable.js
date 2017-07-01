
layui.use(['layer','laydate'], function(){

});

var boUserConsoleGrid =new consoleGrid({table_id:"boUser"});
boUserConsoleGrid.init();
function boUserTableOperate(value){
return "<button type='button' class='btn btn-xs btn-default command-edit' onclick='consoleOpenWindow(\"boUser\",\"/console/bo_user/edit?id="+value+"\",\"编辑\")'><span class='glyphicon glyphicon-pencil'></span></button> ";
}
function boUserLoadParam(params){
params.query=boUserQueryString();
    params.reqtime=new Date().getDate();
return params;
}
function boUserQueryString() {
var objQuery = new Object();
    objQuery.nickName=$('#nickName').val()==''?null:$('#nickName').val(); 
     objQuery.phoneNumber=$('#phoneNumber').val()==''?null:$('#phoneNumber').val(); 
     objQuery.password=$('#password').val()==''?null:$('#password').val(); 
     objQuery.sex=$('#sex').val()==''?null:$('#sex').val(); 
     objQuery.age=$('#age').val()==''?null:$('#age').val(); 
     objQuery.state=$('#state').val()==''?null:$('#state').val(); 
 
var queryString = JSON.stringify(objQuery);
return queryString;
}

 function boUsersexFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '0': 
       showValue = '保密';
       break;
       case '1': 
       showValue = '男';
       break;
       case '2': 
       showValue = '女';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
 function boUserstateFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '0': 
       showValue = '不可用';
       break;
       case '1': 
       showValue = '可用';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
       function boUserhead_imageFormatter(value) 
       { 
         return '<a href="'+value+'" target="_blank" > <img style="height:50px;" src="'+value+'" alt="缩略图"> </a>';
       }
