
layui.use(['layer','laydate'], function(){

});

var boAppBannerConsoleGrid =new consoleGrid({table_id:"boAppBanner"});
boAppBannerConsoleGrid.init();
function boAppBannerTableOperate(value){
return "<button type='button' class='btn btn-xs btn-default command-edit' onclick='consoleOpenWindow(\"boAppBanner\",\"/console/bo_app_banner/edit?id="+value+"\",\"编辑\")'><span class='glyphicon glyphicon-pencil'></span></button> ";
}
function boAppBannerLoadParam(params){
params.query=boAppBannerQueryString();
return params;
}
function boAppBannerQueryString() {
var objQuery = new Object();
     objQuery.type=type;
     objQuery.sort=$('#sort').val()==''?null:$('#sort').val(); 
     objQuery.status=$('#status').val()==''?null:$('#status').val(); 
 
var queryString = JSON.stringify(objQuery);
return queryString;
}

       function boAppBannerbanner_imgFormatter(value) 
       { 
         return '<a href="'+value+'" target="_blank" > <img style="height:50px;" src="'+value+'" alt="缩略图"> </a>';
       }
 function boAppBannertarget_typeFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '1': 
       showValue = '页面';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
 function boAppBannerstatusFormatter(value)
   { 
       var showValue=''; 
       switch(value+''){
       case '0': 
       showValue = '禁用';
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
