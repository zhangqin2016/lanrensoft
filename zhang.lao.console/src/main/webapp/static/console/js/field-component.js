/**
 * @张钦 2016-08-07 22:59:59
 * @param option
 * option参数有：
 * selectId:下拉框id
 * ctxPath:系统上下文路径，项目如果部署在跟路径可以不传
 * tableName:要查询的数据库表名
 * showValueField:要查询的数据库字段名(作为下拉框的显示值)
 * valueField:要查询的数据库字段名(作为下拉框的真实值)
 * where: 查询条件列如:where state = 1
 * @param callback  回调函数
 */
var componentSelectInit=function(option,callback) {
    var ctx="";
    var where="";
    if(option.ctxPath){
        ctx= option.ctxPath;
    }
    if(option.where){
        where= option.where;
    }
    $.getJSON(ctx+"/console/select/json",
        {
            valueField: option.valueField,
            table: option.tableName,
            showValueField: option.showValueField,
            where:where
        },
        function (data) {
            if (data.code == 1) {
                $("#" + option.selectId).empty();
                $("#" + option.selectId).append("<option value=''>请选择...</option>");
                $(data.data).each(function (i, o) {
                    $("#" + option.selectId).append("<option value='" + o.v + "'>" + o.s + "</option>");
                });
                try{
                    callback();
                }catch (e){}

            } else {
                alert(data.message);
            }

        });
}

/**
 *  <div class="checkbox" id="orderSellChannelId">
 <script type="text/javascript">
 $(function($){
                                            componentCheckedInit(
                                                {
                                                    ctxPath:'${ctxPath}',
                                                    tableName:"bo_dictionary",
                                                    showValueField:"name",
                                                    valueField:"value",
                                                    where:" where code ='order_sales_channel ' ",
                                                    renderId:"orderSellChannelId",
                                                    renderName:"orderSellChannel"
                                                }
                                                ,function(){
                                                });
                                        });
 </script>
 </div>
 * @param option
 * @param callback
 */
var componentCheckedInit=function(option,callback) {
    var ctx="";
    var where="";
    if(option.ctxPath){
        ctx= option.ctxPath;
    }
    if(option.where){
        where= option.where;
    }
    $.getJSON(ctx+"/console/select/json",
        {
            valueField: option.valueField,
            table: option.tableName,
            showValueField: option.showValueField,
            where:where
        },
        function (data) {
            if (data.http_status == 1) {
                var html ="";

                $(data.data).each(function (i, o) {
                    html+=' <label> <input type="checkbox" name="'+option.renderName+'" value="'+ o.v+'"> '+ o.s+'</label>';
                });
                $("#"+option.renderId).html(html);
                try{
                    callback();
                }catch (e){}

            } else {
                alert(data.message);
            }

        });
}

$("select").each(function () {
    $(this).css("width","160px");
    //$(this).parent().css("height","34px");

    $(this).select2({
        placeholder: '选择'
        ,width :'resolve'
        ,height:"resolve"
    });
    $(this).select2();
})
