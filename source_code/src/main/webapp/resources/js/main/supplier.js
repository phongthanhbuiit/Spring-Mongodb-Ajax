// Call the dataTables jQuery plugin
$(document).ready(function () {
  getAllSupplier();
  var table = $('#supTable').DataTable();
  $('#supTable tbody ').on('click', "a.btn-delete", function () {
    swal({
      title: "Bạn chắc chứ?",
      text: "Khách hàng này sẽ bị xoá vĩnh viễn nếu bạn chọn OK",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
      .then((willDelete) => {
      if (willDelete) {
      var data = table.row($(this).parents('tr')).data();
      var supplier = {};
      supplier.id = data.id;
      supplier.name = data.name;
      supplier.address = data.address;
      supplier.phone = data.phone;
      supplier.email = data.email;
      supplier.moreinfo = data.moreinfo;
      supplier.date = data.date;

      $.ajax({
        url: 'delete/' + supplier.id,
        method: 'DELETE',
        data: JSON.stringify(supplier),
        success: function () {
          swal("Chúc mừng!", "Bạn đã xoá thành công!", "success").then((value) => {
				location.reload();
			  });
        },
        dataType: "json",
        contentType: "application/json",
      })
        } else {
          swal("Nhà cung cấp không được xoá!");
        }
      });
  }) //end ajax delete supplier

    $('#supTable tbody ').on('click', "a.btn-edit", function () {
      var data = table.row($(this).parents('tr')).data();
      var idSupplier = data.id;
      var url = window.location.href;
      var urlHref = url + 'edit/' + idSupplier;
            console.log("idSupplier" + idSupplier);
      console.log("url" + url);
      console.log("urlHref" + urlHref);
      window.location.href = urlHref;

    });
});

function getAllSupplier() {
  $('#supTable').DataTable({
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
      { "data": "address" },
      { "data": "phone" },
      { "data": "email" },
      { "data": "moreinfo" },
      { "data": "date" },
      {
        "data": null,
        "defaultContent": "<a class='btn btn-circle btn-delete'> <i class='fas fa-trash'></i></a> <a class='btn btn-warning btn-circle btn-edit'> <i class='fas fa-exclamation-triangle'></i></a> ",
        "targets": -1
      }
    ],
    columnDefs: [
      { "width": "100px", targets: 7 },
      {targets:6, render:function(data){
      return moment(data).format('DD/MM/YYYY');
    }}
    ],
    fixedColumns: true,
  });
}


