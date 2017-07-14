

  var consoleUploadImg=  function(id,ctx) {
      $('#'+id+'_file').attr("data-url",ctx+"/file/upload");
      $('#'+id+'_progress').hide();
        $('#'+id+'_file').fileupload({
            dataType: 'json',
            done: function (e, data) {
                if(data.result.code==1){
                    var obj = data.result.data;
                    $('#'+id+'_progress').hide(1000);
                    $("#"+id+"").val(obj.url);
                    $("#"+id+"_file_show").attr("src",obj.url);
                }else{
                    layer.msg(data.result.message);
                }
                // $.each(data.result, function (index, file) {


                //  });
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
  var consoleUploadFile=  function(id,ctx) {
      $('#'+id+'_file').attr("data-url",ctx+"/file/upload");
      $('#'+id+'_progress').hide();
      $('#'+id+'_file').fileupload({
          dataType: 'json',
          done: function (e, data) {
              // $.each(data.result, function (index, file) {
              if(data.result.code==1){
                  var obj = data.result.data;
                  $('#'+id+'_progress').hide(1000);
                  $("#"+id+"").val(obj.url);
                  $("#"+id+"_file_show").text(obj.url);
              }else{
                  layer.msg(data.result.message);
              }


              //  });
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
  var consoleUploadAliImg=  function(id,ctx) {
      $('#'+id+'_file').attr("data-url",ctx+"/file/upload/ali");
      $('#'+id+'_progress').hide();
      $('#'+id+'_file').fileupload({
          dataType: 'json',
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
  var consoleUploadAliFile=  function(id,ctx) {
      $('#'+id+'_file').attr("data-url",ctx+"/file/upload/ali");
      $('#'+id+'_progress').hide();
      $('#'+id+'_file').fileupload({
          dataType: 'json',
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