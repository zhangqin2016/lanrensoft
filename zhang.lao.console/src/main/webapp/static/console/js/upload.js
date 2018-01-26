

  var upImage=  function(url,id) {
      $('#'+id+'_file').attr("data-url",url);
      $('#'+id+'_progress').hide();
      $('#'+id+'_file').fileupload({
          dataType: 'json',
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
      upImage(ctx+"/file/upload/ali",id)
  }
  var consoleUploadAliFile=  function(id,ctx) {
      upFile(ctx+"/file/upload/ali",id)
  }

  function calculate(file,callBack){
      browserMD5File(file, function (err, md5) {
          callBack(md5);
      });
  }