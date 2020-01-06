// Call the dataTables jQuery plugin
$(document).ready(function () {
  getAllInputInfo();
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
      var inputInfo = {};
      inputInfo.id = data.id;
      inputInfo.product = data.product;
      inputInfo.count = data.count;
      inputInfo.qty = data.qty;
      inputInfo.inputPrice = data.inputPrice;
      inputInfo.outputPrice = data.outputPrice;
      inputInfo.supplier = data.supplier;
      inputInfo.date = data.date;

      $.ajax({
        url: 'delete/' + inputInfo.id,
        method: 'DELETE',
        data: JSON.stringify(inputInfo),
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
  }) //end ajax delete inputInfo

    $('#cusTable tbody ').on('click', "a.btn-edit", function () {
      var data = table.row($(this).parents('tr')).data();
      var idInputInfo = data.id;
      var url = window.location.href;
      var urlHref = url + 'edit/' + idInputInfo;
            console.log("idInputInfo" + idInputInfo);
      console.log("url" + url);
      console.log("urlHref" + urlHref);
      window.location.href = urlHref;

    });
});

function getAllInputInfo() {
  $('#cusTable').DataTable({
    "processing": true,
    "serverSide": false,
    "order": [[0, "desc"]],
    "autoWidth": true,
    "ajax": {
      "url": "getAll",
      "dataSrc": "",
      "contentType": "application/json",
      "type": "GET",
    },
    "columns": [
      { "data": "id" },
      { "data": "product.name" },
      { "data": "count" },
      { "data": null,
    	    "render": function(data,type,row) {
    	    return (data.qty + ' (' +data.product.measure.name + ')')
    	    		}  
    	      },
      { "data": "inputPrice" },
      { "data": null,
    	  "render": function(data,type,row) { 
    		  var num = data["count"] * data["inputPrice"];
    		  var currency = num.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
    		  return currency;
    		  }  
      },
      { "data": "outputPrice" },
      { "data": null,
    	  "render": function(data,type,row) { 
    		  var num = data["count"] * data["outputPrice"];
    		  var currency = num.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
    		  return currency;
    		  }  
      },
      { "data": "supplier.name" },
      { "data": "date" },
      {
        "data": null,
        "defaultContent": "<a class='btn btn-circle btn-delete'> <i class='fas fa-trash'></i></a> <a class='btn btn-warning btn-circle btn-edit'> <i class='fas fa-exclamation-triangle'></i></a> ",
        "targets": -1
      }
    ],
    columnDefs: [
        {
        targets:9, render:function(data){
        return moment(data).format('DD/MM/YYYY');
      }}
      ],
    fixedColumns: true,
  });
}


