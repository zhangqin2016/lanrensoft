
var uploader = uploadJSSDK;
  var upImage=  function(url,id) {
      $('#'+id+'_file').attr("data-url",url);
      $('#'+id+'_progress').hide();
      $('#'+id+'_file').fileupload({
          dataType: 'json',
          chunkSize:1000 * 1024 * 1024,
          maxFileSize: 2000 * 1024 * 1024,
          autoUpload: false,
          add: function (e, data) {
              browserMD5File( data.files[0], function (err, md5) {
                  $.post("/console/file/exist/" + md5, function (oo) {
                      if (oo.code === 1) {
                          var obj = oo.data;
                          $("#" + id + "").val(obj.fileUrl);
                          $("#" + id + "_file_show").attr("src", obj.fileUrl);
                          $("#" + id + "_file_show").attr("href", obj.fileUrl);
                      } else {
                          data.submit();
                      }
                  })
              })
          },
          done: function (e, data) {
              // $.each(data.result, function (index, file) {
              if(data.result.code==1){
                  var obj = data.result.data;
                  $('#'+id+'_progress').hide(1000);
                  $("#"+id+"").val(obj.fileUrl);
                  $("#"+id+"_file_show").attr("src",obj.fileUrl);
                  $("#"+id+"_file_show").attr("href",obj.fileUrl);
                  //  });
              }else{
                  layer.msg(data.result.message);
              }
          },
          dropZone: $('#dropzone')
      }).on('fileuploadprogressall', function (e, data) {
          $('#'+id+'_progress').show();
          var progress = parseInt(data.loaded / data.total * 100, 10);
          $('#'+id+'_progress .progress-bar').css(
              'width',
              progress + '%'
          );
      });
  }
  var upFile=  function(url,id) {
      $('#'+id+'_file').attr("data-url",url);
      $('#'+id+'_progress').hide();
      $('#'+id+'_file').fileupload({
          dataType: 'json',
          maxFileSize: 1000 * 1024 * 1024,
          add: function (e, data) {
              browserMD5File( data.files[0], function (err, md5) {
                  $.post("/console/file/exist/" + md5, function (oo) {
                      if (oo.code === 1) {
                          var obj = oo.data;
                          $("#"+id+"").val(obj.fileUrl);
                          $("#"+id+"_file_show").text(obj.fileUrl);
                          $("#"+id+"_file_show").attr("href",obj.fileUrl);
                      } else {
                          data.submit();
                      }
                  })
              })
          },
          done: function (e, data) {
              // $.each(data.result, function (index, file) {
              if(data.result.code==1){
                  var obj = data.result.data;
                  $('#'+id+'_progress').hide(1000);
                  $("#"+id+"").val(obj.fileUrl);
                  $("#"+id+"_file_show").text(obj.fileUrl);
                  $("#"+id+"_file_show").attr("href",obj.fileUrl);
                  //  });
              }else{
                  layer.msg(data.result.message);
              }
          },
          dropZone: $('#dropzone')
      }).on('fileuploadprogressall', function (e, data) {
          $('#'+id+'_progress').show();
          var progress = parseInt(data.loaded / data.total * 100, 10);
          $('#'+id+'_progress .progress-bar').css(
              'width',
              progress + '%'
          );
      });
  }

  var consoleUploadImg=  function(id,ctx) {
        upImage(ctx+"/file/upload",id)
  }
  var consoleUploadFile=  function(id,ctx) {
      upFile(ctx+"/file/upload",id)
  }
var consoleUploadAliImg=  function(id,ctx) {
    $('#'+id+'_progress').hide();
    $("#"+id+"_file").change(function (event) {
        var e = event;
        var files = e.target.files;

        $.post("/console/file/ali/token",function (data) {
            $('#' + id + '_progress').show();
            var token = data.data.token;
            uploader({
                file: files[0],   //文件，必填,html5 file类型，不需要读数据流，
                name: new Date().getTime() + ".jpg", //文件名称，选填，默认为文件名称
                token: token,  //token，必填
                dir: '/image/console/',  //目录，选填，默认根目录''
                retries: 2,  //重试次数，选填，默认0不重试
                maxSize: 0,  //上传大小限制，选填，默认0没有限制
                callback: function (percent, result) {
                    if(percent==-1){
                        layer.alert(result);
                    }else{
                        $('#' + id + '_progress .progress-bar').css(
                            'width',
                            percent + '%'
                        );
                        if(percent==100){
                            $('#' + id + '_progress').hide(1000);
                            $("#" + id + "").val(result['url']);
                            $("#" + id + "_file_show").attr("src", result['url']);
                            $("#" + id + "_file_show").attr("href", result['url']);
                        }
                    }
                    //percent（上传百分比）：-1失败；0-100上传的百分比；100即完成上传
                    //result(服务端返回的responseText，json格式)
                }

            });
        });
    })

}
var consoleUploadAliFile=  function(id,ctx) {
    $('#'+id+'_progress').hide();
    $("#"+id+"_file").change(function (event) {
        var e = event;
        var files = e.target.files;

        $.post("/console/file/ali/token",function (data) {
            $('#' + id + '_progress').show();
            var token = data.data.token;
            uploader({
                file: files[0],   //文件，必填,html5 file类型，不需要读数据流，
                name: new Date().getTime() + files[0].name, //文件名称，选填，默认为文件名称
                token: token,  //token，必填
                dir: '/file/console/',  //目录，选填，默认根目录''
                retries: 2,  //重试次数，选填，默认0不重试
                maxSize: 0,  //上传大小限制，选填，默认0没有限制
                callback: function (percent, result) {
                    if(percent==-1){
                        layer.alert(result);
                    }else{
                        $('#' + id + '_progress .progress-bar').css(
                            'width',
                            percent + '%'
                        );
                        if(percent==100){
                            $('#' + id + '_progress').hide(1000);
                            $("#" + id + "").val(result['url']);
                            $("#" + id + "_file_show").text( result['url']);
                        }
                    }
                    //percent（上传百分比）：-1失败；0-100上传的百分比；100即完成上传
                    //result(服务端返回的responseText，json格式)
                }

            });
        });
    })

}
  var consoleUploadImgBack=  function(id,ctx) {
      var url = ctx+"/file/background/set";

      $('#'+id+'_file').attr("data-url",url);
      $('#'+id+'_progress').hide();
      $('#'+id+'_file').fileupload({
          dataType: 'json',
          maxFileSize: 1000 * 1024 * 1024,
          autoUpload: false,
          add: function (e, data) {
                          data.submit();
          },
          done: function (e, data) {
              // $.each(data.result, function (index, file) {
              if(data.result.code==1){
                  var obj = data.result.data;
                  $('#'+id+'_progress').hide(1000);
                  $("#"+id+"").val(obj.fileUrl);
                  $("#"+id+"_file_show").attr("src",obj.fileUrl+"?"+new Date().getTime());
                  $("#"+id+"_file_show").attr("href",obj.fileUrl+"?"+new Date().getTime());
                  //  });
              }else{
                  layer.msg(data.result.message);
              }
          },
          dropZone: $('#dropzone')
      }).on('fileuploadprogressall', function (e, data) {
          $('#'+id+'_progress').show();
          var progress = parseInt(data.loaded / data.total * 100, 10);
          $('#'+id+'_progress .progress-bar').css(
              'width',
              progress + '%'
          );
      });
  }
  function calculate(file,callBack){
      browserMD5File(file, function (err, md5) {
          callBack(md5);
      });
  }
