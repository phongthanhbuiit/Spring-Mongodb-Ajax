// Call the dataTables jQuery plugin
$(document).ready(function () {
  getAllOutputInfo();
  var table = $('#cusTable').DataTable();
  $('#cusTable tbody ').on('click', "a.btn-delete", function () {
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
      var outputInfo = {};
      outputInfo.id = data.id;

      $.ajax({
        url: 'delete/' + outputInfo.id,
        method: 'DELETE',
        data: JSON.stringify(outputInfo),
        success: function () {
          swal("Chúc mừng!", "Bạn đã xoá thành công!", "success").then((value) => {
				location.reload();
			  });
        },
        dataType: "json",
        contentType: "application/json",
      })
        } else {
          swal("Khánh hàng không được xoá!");
        }
      });
  }) //end ajax delete outputInfo

    $('#cusTable tbody ').on('click', "a.btn-detail", function () {
      var data = table.row($(this).parents('tr')).data();
      var idOutputInfo = data.id;
      var url = window.location.href;
      var urlHref = url + 'detail/' + idOutputInfo;
      console.log("idOutputInfo" + idOutputInfo);
      console.log("url" + url);
      console.log("urlHref" + urlHref);
      window.location.href = urlHref;

    });
});

function getAllOutputInfo() {
  $('#cusTable').DataTable({
    "processing": true,
    "serverSide": false,
    "autoWidth": true,
    "order": [[0, "desc"]],
    "ajax": {
      "url": "getAll",
      "dataSrc": "",
      "contentType": "application/json",
      "type": "GET",
    },
    "columns": [
      { "data": "id" },
      { "data": "customer.name" },
      { "data": null,
      "render": function(data, type, row) {
          var listInput = data['input'];
          var sum = 0;
          listInput.forEach(function(item){
              sum = sum + item.count;
          });
          return sum;
        }},
       { "data": null,
      "render": function(data, type, row) {
          var listInput = data['input'];
          var sum = 0;
          listInput.forEach(function(item){
              sum = sum + item.count*item.outputPrice;
          });
          return sum.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
        }},
      { "data": "date" },
      {
        "data": "id",
      },
      {
        "data": null,
        "defaultContent": "<a class='btn btn-circle btn-delete'> <i class='fas fa-trash'></i></a> <a class='btn btn-circle btn-detail'> <i class='fa fa-info-circle'></i></a> ",
        "targets": -1
      }
    ],
    columnDefs: [
        {
          targets:4, render:function(data)
          {
            return moment(data).format('DD/MM/YYYY');
          }
        },
        {
          targets: 5, render: function(data) {
            var url = window.location.href + "/qrcode/" + data;
            return '<img src = "'  + url + '" />';
          }
        }
      ],
    fixedColumns: true,
  });
}


