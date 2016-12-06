/**
 * Created by tech6 on 2016/7/28.
 */

/**
 *
 * @param id
 * @param url
 * @param title
 * @param height
 * @param width
 */
var consoleOpenWindow = function(id,url,title,height,width) {
    art.dialog({
        id: "id-dialog-"+id,
        title: title,
        padding: 0,
        fixed: true,
        content: '<iframe height="'+(height*0.8)+'px" width="'+(width*0.8)+'px" frameborder=0 src="'+url+'";></iframe>'
    });
}

/**
 *
 * @param id
 * @param url
 * @param title
 */
var consoleOpenWindow = function(id,url,title) {
    var height=$(window).height();
    var width=$(window).width();
    art.dialog({
        id: "id-dialog-"+id,
        title: title,
        padding: 0,
        fixed: true,
        content: '<iframe height="'+(height*0.8)+'px" width="'+(width*0.8)+'px" frameborder=0 src="'+url+'";></iframe>'
    });
}

var consoleGrid=function(options){
    var obj = options ||{};
    this.table_id=obj.table_id;
    var self=this;
    this.delete=function(id,url){
        var ids=[];
        $($("#"+self.table_id+"").bootstrapTable('getSelections')).each(function(i,o){
            ids.push( eval("o."+id+""));
        });
        if(ids.length==0){
            $.alert({
                title: '提示!',
                confirmButton:'确定',
                autoClose: 'confirm|1000',
                content: '请选择要删除的数据'
            });
        }else{
            $.confirm({
                keyboardEnabled: true,
                content: '是否删除？',
                title:"提示",
                animation:"scalex",
                confirmButton:"是",
                autoClose: 'cancel|5000',
                cancelButton:"否",
                confirm: function(){
                    $.post(url,{ids:ids.join(",")},function(data){
                        $.alert({
                            title: '提示!',
                            confirmButton:'确定',
                            autoClose: 'confirm|3000',
                            content: data.message
                        });
                        $("#"+self.table_id+"").bootstrapTable("refresh");
                    });
                }
            });
        }
    },this.enterToQuery= function(event){
            var e = event || window.event || arguments.callee.caller.arguments[0];
            if (e.keyCode == 13) {
                $('#'+self.table_id+'QuerySearch').click();
            }
    },
    this.init = function(){
        $('#'+self.table_id+'Reset').click(function() {
            $('#'+self.table_id+'_form').find('input,select').val('');
        });
        /**
         * 给搜索按钮绑定事件
         */
        $('#'+self.table_id+'QuerySearch').click(function() {
            $("#"+self.table_id+"").bootstrapTable("refresh");
        });
    }
};