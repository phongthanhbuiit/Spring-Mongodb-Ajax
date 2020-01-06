// Call the dataTables jQuery plugin
$(document).ready(function () {
  getAllProduct();
  var table = $('#cusTable').DataTable();
  $('#cusTable tbody ').on('click', "a.btn-delete", function () {
    swal({
      title: "Bạn chắc chứ?",
      text: "Sản phẩm này sẽ bị xoá vĩnh viễn nếu bạn chọn OK",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
      .then((willDelete) => {
      if (willDelete) {
      var data = table.row($(this).parents('tr')).data();
      var product = {};
      product.id = data.id;
      product.name = data.name;
      product.measure = data.measure;
 

      $.ajax({
        url: 'delete/' + product.id,
        method: 'DELETE',
        data: JSON.stringify(product),
        success: function () {
          swal("Chúc mừng!", "Bạn đã xoá thành công!", "success").then((value) => {
				location.reload();
			  });
        },
        dataType: "json",
        contentType: "application/json",
      })
        } else {
          swal("Sản phẩm không được xoá!");
        }
      });
  }) //end ajax delete product

    $('#cusTable tbody ').on('click', "a.btn-edit", function () {
      var data = table.row($(this).parents('tr')).data();
      var idProduct = data.id;
      var url = window.location.href;
      var urlHref = url + 'edit/' + idProduct;
            console.log("idProduct" + idProduct);
      console.log("url" + url);
      console.log("urlHref" + urlHref);
      window.location.href = urlHref;

    });
});

function getAllProduct() {
  $('#cusTable').DataTable({
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
      { "data": "measure.name" },
      {
        "data": null,
        "defaultContent": "<a class='btn btn-circle btn-delete'> <i class='fas fa-trash'></i></a> <a class='btn btn-warning btn-circle btn-edit'> <i class='fas fa-exclamation-triangle'></i></a> ",
        "targets": -1
      }
    ],
    fixedColumns: true,
  });
}


