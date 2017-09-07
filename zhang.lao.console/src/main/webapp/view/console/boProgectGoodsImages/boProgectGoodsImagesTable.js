
layui.use(['layer','laydate'], function(){

});

var boProgectGoodsImagesConsoleGrid =new consoleGrid({table_id:"boProgectGoodsImages"});
boProgectGoodsImagesConsoleGrid.init();
function boProgectGoodsImagesTableOperate(value){
return "<button type='button' class='btn btn-xs btn-default command-edit' onclick='consoleOpenWindow(\"boProgectGoodsImages\",\"/console/bo_progect_goods_images/edit?id="+value+"\",\"编辑\")'><span class='glyphicon glyphicon-pencil'></span></button> ";
}
function boProgectGoodsImagesLoadParam(params){
params.query=boProgectGoodsImagesQueryString();
return params;
}
function boProgectGoodsImagesQueryString() {
var objQuery = new Object();
    objQuery.goodsId=$('#goodsId').val()==''?null:$('#goodsId').val(); 
     objQuery.imageName=$('#imageName').val()==''?null:$('#imageName').val(); 
     objQuery.sort=$('#sort').val()==''?null:$('#sort').val(); 
 
var queryString = JSON.stringify(objQuery);
return queryString;
}

       function boProgectGoodsImagesimage_urlFormatter(value) 
       { 
         return '<a href="'+value+'" target="_blank" > <img style="height:50px;" src="'+value+'" alt="缩略图"> </a>';
       }
       function boProgectGoodsImagesimage_typeFormatter(value) 
       { 
         return '<a href="'+value+'" target="_blank" > <img style="height:50px;" src="'+value+'" alt="缩略图"> </a>';
       }
