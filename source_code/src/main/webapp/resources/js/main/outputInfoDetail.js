// Call the dataTables jQuery plugin
$(document).ready(function () {

  var url = window.location.href;
  var id = url.substring(url.lastIndexOf('/') + 1);
  
  getAllOutputInfo(id);
  findInputInfo(id);

});

function getAllOutputInfo(id) {
  $('#cusTable').DataTable({
    "processing": true,
    "serverSide": false,
    "autoWidth": true,
    "ajax": {
      "url":  id + '/findInput',
      "dataSrc": "",
      "contentType": "application/json",
      "type": "GET",
    },
    "columns": [
      { "data": null,
        "render": function(data) {
          var product = data['product'];
          var r = product.name + ' (' + product.measure.name + ')';
          return r;
        } },
      { "data": "count" },
      { "data": "qty"},
      { "data": "outputPrice"},
      { "data": null, 
        "render": function(data) {
          var x = data['count'];
          var y = data['outputPrice'];
          z = x*y;
          return z.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
        }}],
    fixedColumns: true,
  });
}

function findInputInfo(id) {

	$.ajax({
		url: id + '/find',
		method: 'GET',
		success: function (data) {

			var customer = data['customer'];
			document.getElementById("customer").value = customer.name +  ' - ' + customer.phone + ' - ' + customer.email;
      var date = data['date'];
      date = moment(date).format('DD/MM/YYYY');
      document.getElementById("date").value = date;
      var listInput = data['input'];
      var sum = 0;
      listInput.forEach(function(item){
          sum = sum + item.count*item.outputPrice;
      });
      sum = sum.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});

      document.getElementById("sumMomey").value = sum;
		},
		dataType: "json",
		contentType: "application/json",

	});	
}

