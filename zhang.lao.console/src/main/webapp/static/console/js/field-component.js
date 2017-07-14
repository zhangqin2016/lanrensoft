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