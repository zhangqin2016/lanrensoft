
layui.use(['layer','laydate'], function(){

});

var boTestConsoleGrid =new consoleGrid({table_id:"boTest"});
boTestConsoleGrid.init();
function boTestTableOperate(value){
return "<button type='button' class='btn btn-xs btn-default command-edit' onclick='consoleOpenWindow(\"boTest\",\"/console/bo_test/edit?id="+value+"\",\"编辑\")'><span class='glyphicon glyphicon-pencil'></span></button> ";
}
function boTestLoadParam(params){
params.query=boTestQueryString();
return params;
}
function boTestQueryString() {
var objQuery = new Object();
    objQuery.name=$('#name').val()==''?null:$('#name').val(); 
     objQuery.birthday=$('#birthday').val()==''?null:$('#birthday').val(); 
     objQuery.age=$('#age').val()==''?null:$('#age').val(); 
     objQuery.sex=$('#sex').val()==''?null:$('#sex').val(); 
 
var queryString = JSON.stringify(objQuery);
return queryString;
}

       function boTestimg_urlFormatter(value) 
       { 
         return '<a href="'+value+'" target="_blank" > <img style="height:50px;" src="'+value+'" alt="缩略图"> </a>';
       }
 function boTestsexFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '男': 
       showValue = '男';
       break;
       case '女': 
       showValue = '女';
       break;
       case '保密': 
       showValue = '保密';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
