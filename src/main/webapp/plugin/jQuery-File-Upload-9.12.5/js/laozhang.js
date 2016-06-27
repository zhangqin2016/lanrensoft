

  var consoleUpload=  function(id,ctx) {
      $('#'+id+'_file').attr("data-url","/file/upload_ali");
      $('#'+id+'_progress').hide();
        $('#'+id+'_file').fileupload({
            dataType: 'json',
            done: function (e, data) {
                // $.each(data.result, function (index, file) {
                var src = data.result.data;
                $('#'+id+'_progress').hide(1000);
                $("#"+id+"").val(src);
                $("#"+id+"_file_show").attr("src",src);

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