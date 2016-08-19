

  var consoleUploadImg=  function(id,ctx) {
      $('#'+id+'_file').attr("data-url",ctx+"/file/upload");
      $('#'+id+'_progress').hide();
        $('#'+id+'_file').fileupload({
            dataType: 'json',
            done: function (e, data) {
                // $.each(data.result, function (index, file) {
                var obj = data.result.data;
                $('#'+id+'_progress').hide(1000);
                $("#"+id+"").val(obj.url);
                $("#"+id+"_file_show").attr("src",obj.url);

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
              var obj = data.result.data;
              $('#'+id+'_progress').hide(1000);
              $("#"+id+"").val(obj.url);
              $("#"+id+"_file_show").text(obj.url);

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