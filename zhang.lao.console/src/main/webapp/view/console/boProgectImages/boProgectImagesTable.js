
layui.use(['layer','laydate'], function(){

});

var boProgectImagesConsoleGrid =new consoleGrid({table_id:"boProgectImages"});
boProgectImagesConsoleGrid.init();
function boProgectImagesTableOperate(value){
return "<button type='button' class='btn btn-xs btn-default command-edit' onclick='consoleOpenWindow(\"boProgectImages\",\"/console/bo_progect_images/edit?id="+value+"\",\"编辑\")'><span class='glyphicon glyphicon-pencil'></span></button> ";
}
function boProgectImagesLoadParam(params){
params.query=boProgectImagesQueryString();
return params;
}
function boProgectImagesQueryString() {
var objQuery = new Object();
    objQuery.projectId=$('#projectId').val()==''?null:$('#projectId').val(); 
     objQuery.imageName=$('#imageName').val()==''?null:$('#imageName').val(); 
     objQuery.sort=$('#sort').val()==''?null:$('#sort').val(); 
 
var queryString = JSON.stringify(objQuery);
return queryString;
}

       function boProgectImagesimage_urlFormatter(value) 
       { 
         return '<a href="'+value+'" target="_blank" > <img style="height:50px;" src="'+value+'" alt="缩略图"> </a>';
       }
       function boProgectImagesimage_typeFormatter(value) 
       { 
         return '<a href="'+value+'" target="_blank" > <img style="height:50px;" src="'+value+'" alt="缩略图"> </a>';
       }
