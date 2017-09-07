
layui.use(['layer','laydate'], function(){

});

var boProgectAroundConsoleGrid =new consoleGrid({table_id:"boProgectAround"});
boProgectAroundConsoleGrid.init();
function boProgectAroundTableOperate(value){
return "<button type='button' class='btn btn-xs btn-default command-edit' onclick='consoleOpenWindow(\"boProgectAround\",\"/console/bo_progect_around/edit?id="+value+"\",\"编辑\")'><span class='glyphicon glyphicon-pencil'></span></button> ";
}
function boProgectAroundLoadParam(params){
params.query=boProgectAroundQueryString();
return params;
}
function boProgectAroundQueryString() {
var objQuery = new Object();
    objQuery.projectId=$('#projectId').val()==''?null:$('#projectId').val(); 
 
var queryString = JSON.stringify(objQuery);
return queryString;
}

       function boProgectAroundnameFormatter(value) 
       { 
         return '<a href="'+value+'" target="_blank" > <img style="height:50px;" src="'+value+'" alt="缩略图"> </a>';
       }
       function boProgectAroundinfo_imageFormatter(value) 
       { 
         return '<a href="'+value+'" target="_blank" > <img style="height:50px;" src="'+value+'" alt="缩略图"> </a>';
       }
