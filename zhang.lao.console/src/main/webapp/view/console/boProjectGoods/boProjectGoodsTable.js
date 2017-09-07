
layui.use(['layer','laydate'], function(){

});

var boProjectGoodsConsoleGrid =new consoleGrid({table_id:"boProjectGoods"});
boProjectGoodsConsoleGrid.init();
function boProjectGoodsTableOperate(value){
return "<button type='button' class='btn btn-xs btn-default command-edit' onclick='consoleOpenWindow(\"boProjectGoods\",\"/console/bo_project_goods/edit?id="+value+"\",\"编辑\")'><span class='glyphicon glyphicon-pencil'></span></button> ";
}
function boProjectGoodsLoadParam(params){
params.query=boProjectGoodsQueryString();
return params;
}
function boProjectGoodsQueryString() {
var objQuery = new Object();
    objQuery.title=$('#title').val()==''?null:$('#title').val(); 
     objQuery.buildArea=$('#buildArea').val()==''?null:$('#buildArea').val(); 
     objQuery.equityPrice=$('#equityPrice').val()==''?null:$('#equityPrice').val(); 
     objQuery.adminPrice=$('#adminPrice').val()==''?null:$('#adminPrice').val(); 
     objQuery.detail=$('#detail').val()==''?null:$('#detail').val(); 
     objQuery.imageCover=$('#imageCover').val()==''?null:$('#imageCover').val(); 
     objQuery.tag=$('#tag').val()==''?null:$('#tag').val(); 
 
var queryString = JSON.stringify(objQuery);
return queryString;
}

