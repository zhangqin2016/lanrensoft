
layui.use(['layer','laydate'], function(){

});

var boProjectConsoleGrid =new consoleGrid({table_id:"boProject"});
boProjectConsoleGrid.init();
function boProjectTableOperate(value){
return "<button type='button' class='btn btn-xs btn-default command-edit' onclick='consoleOpenWindow(\"boProject\",\"/console/bo_project/edit?id="+value+"\",\"编辑\")'><span class='glyphicon glyphicon-pencil'></span></button> ";
}
function boProjectLoadParam(params){
params.query=boProjectQueryString();
return params;
}
function boProjectQueryString() {
var objQuery = new Object();
    objQuery.type=$('#type').val()==''?null:$('#type').val(); 
     objQuery.selfBuild=$('#selfBuild').val()==''?null:$('#selfBuild').val(); 
     objQuery.title=$('#title').val()==''?null:$('#title').val(); 
     objQuery.projectDevelopers=$('#projectDevelopers').val()==''?null:$('#projectDevelopers').val(); 
     objQuery.projectInto=$('#projectInto').val()==''?null:$('#projectInto').val(); 
     objQuery.projrctManager=$('#projrctManager').val()==''?null:$('#projrctManager').val(); 
     objQuery.projectEstate=$('#projectEstate').val()==''?null:$('#projectEstate').val(); 
     objQuery.province=$('#province').val()==''?null:$('#province').val(); 
     objQuery.city=$('#city').val()==''?null:$('#city').val(); 
     objQuery.country=$('#country').val()==''?null:$('#country').val(); 
     objQuery.address=$('#address').val()==''?null:$('#address').val(); 
     objQuery.decorationLeave=$('#decorationLeave').val()==''?null:$('#decorationLeave').val(); 
     objQuery.imageCover=$('#imageCover').val()==''?null:$('#imageCover').val(); 
     objQuery.state=$('#state').val()==''?null:$('#state').val(); 
     objQuery.sort=$('#sort').val()==''?null:$('#sort').val(); 
 
var queryString = JSON.stringify(objQuery);
return queryString;
}

 function boProjecttypeFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '1': 
       showValue = '产权';
       break;
       case '2': 
       showValue = '股权';
       break;
       case '3': 
       showValue = '租售';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
 function boProjectself_buildFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '1': 
       showValue = '是';
       break;
       case '2': 
       showValue = '否';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
 function boProjectstateFormatter(value) 
   { 
       var showValue=''; 
       switch(value+''){
       case '1': 
       showValue = '可用';
       break;
       case '0': 
       showValue = '不可用';
       break;
       }
    if(showValue.indexOf('不')!=-1||showValue.indexOf('否')!=-1||showValue.indexOf('禁')!=-1){    
       return '<span class="label label-warning">'+showValue+'</span>';
   }else{
       return '<span class="label label-info">'+showValue+'</span>';
   }
   }
