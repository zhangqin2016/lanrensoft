
layui.use(['layer','laydate'], function(){

});

var boCmsNewsConsoleGrid =new consoleGrid({table_id:"boCmsNews"});
boCmsNewsConsoleGrid.init();
function boCmsNewsTableOperate(value){
return "<button type='button' class='btn btn-xs btn-default command-edit' onclick='consoleOpenWindow(\"boCmsNews\",\"/console/bo_cms_news/edit?id="+value+"\",\"编辑\")'><span class='glyphicon glyphicon-pencil'></span></button> ";
}
function boCmsNewsLoadParam(params){
params.query=boCmsNewsQueryString();
return params;
}
function boCmsNewsQueryString() {
var objQuery = new Object();
    objQuery.publish=$('#publish').val()==''?null:$('#publish').val(); 
     objQuery.author=$('#author').val()==''?null:$('#author').val(); 
     objQuery.source=$('#source').val()==''?null:$('#source').val(); 
     objQuery.content=$('#content').val()==''?null:$('#content').val(); 
     objQuery.title=$('#title').val()==''?null:$('#title').val(); 
     objQuery.newsType=$('#newsType').val()==''?null:$('#newsType').val(); 
     objQuery.intro=$('#intro').val()==''?null:$('#intro').val(); 
     objQuery.tag=$('#tag').val()==''?null:$('#tag').val(); 
 
var queryString = JSON.stringify(objQuery);
return queryString;
}

 function boCmsNewspublishFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '0': 
       showValue = '未发布';
       break;
       case '1': 
       showValue = '已发布';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
       function boCmsNewscoverFormatter(value) 
       { 
         return '<a href="'+value+'" target="_blank" > <img style="height:50px;" src="'+value+'" alt="缩略图"> </a>';
       }
 function boCmsNewsnews_typeFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '1': 
       showValue = '1';
       break;
       case '2': 
       showValue = '2';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
