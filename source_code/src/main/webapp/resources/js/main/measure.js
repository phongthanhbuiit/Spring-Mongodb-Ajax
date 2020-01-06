// Call the dataTables jQuery plugin
$(document).ready(function () {
  getAllMeasure();
  var table = $('#idTable').DataTable();
  $('#idTable tbody ').on('click', "a.btn-delete", function () {
    swal({
      title: "Bạn chắc chứ?",
      text: "Đo lường này sẽ bị xoá vĩnh viễn nếu bạn chọn OK",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
      .then((willDelete) => {
      if (willDelete) {
      var data = table.row($(this).parents('tr')).data();
      var measure = {};
      measure.id = data.id;
      measure.name = data.name;

      $.ajax({
        url: 'delete/' + measure.id,
        method: 'DELETE',
        data: JSON.stringify(measure),
        success: function () {
          swal("Chúc mừng!", "Bạn đã xoá thành công!", "success").then((value) => {
				location.reload();
			  });
        },
        dataType: "json",
        contentType: "application/json",
      })
        } else {
          swal("Đo lường không được xoá!");
        }
      });
  }) //end ajax delete measure

    $('#idTable tbody ').on('click', "a.btn-edit", function () {
      var data = table.row($(this).parents('tr')).data();
      var idMeasure = data.id;
      var url = window.location.href;
      var urlHref = url + 'edit/' + idMeasure;
            console.log("idMeasure" + idMeasure);
      console.log("url" + url);
      console.log("urlHref" + urlHref);
      window.location.href = urlHref;

    });
});

function getAllMeasure() {
  $('#idTable').DataTable({
    "processing": true,
    "serverSide": false,
    "order": [[0, "desc"]],
    "autoWidth": true,
    "ajax": {
      "url": "getAll",
      "dataSrc": "",
      "contentType": "application/json",
      "type": "get",
    },
    "columns": [
      { "data": "id" },
      { "data": "name" },
      {
        "data": null,
        "defaultContent": "<a class='btn btn-circle btn-delete'> <i class='fas fa-trash'></i></a> <a class='btn btn-warning btn-circle btn-edit'> <i class='fas fa-exclamation-triangle'></i></a> ",
        "targets": -1
      }
    ],

    fixedColumns: true,
  });
}


