$(document).ready(function () {
		var url = window.location.href;
		var id = url.substring(url.lastIndexOf('/') + 1);
		var InputInfo = {};
		InputInfo.id = id;
		getAllProducts();
		getAllSupplivers();
		findInputInfo(id);

	//validaton input form
	window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
		var forms = document.getElementsByClassName('windsora-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      document.getElementById("editInputInfo").addEventListener("click", function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
					event.stopPropagation();
        }
		form.classList.add('was-validated');
				if (form.checkValidity() === true) {
					var number = $("#inputPrice").val();
					var number2 = $("#outputPrice").val();
					if (checkNumber(number) === true && checkNumber(number2) === true ) {
						var id = url.substring(url.lastIndexOf('/') + 1);
						var idProduct = $("#OptionSelectProduct").val();
						updateInputInfo(id, idProduct);
					}
					else {
						swal("Lỗi!", "Số tiền phải lớn hơn 0!","error");
					}
        }
			}, false);
		});
});
});

function findInputInfo(id) {

	$.ajax({
		url: id + '/find',
		method: 'GET',
		success: function (data) {
			
			var product = data.product;
			$('#OptionSelectProduct').val(product.id).change();
			var supplier = data.supplier;
			$('#OptionSelectSuppliver').val(supplier.id).change();
			document.getElementById("count").value = data.count;
			document.getElementById("qty").value = data.qty;
			document.getElementById("inputPrice").value = data.inputPrice;
			document.getElementById("outputPrice").value = data.outputPrice;
			sumPrice(data.inputPrice);
			sumOutPrice(data.outputPrice);
			income(data.inputPrice, data.outputPrice);

		},
		dataType: "json",
		contentType: "application/json",

	});	
}

	
//update InputInfo
function updateInputInfo(id, idProduct) {
	
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url:    'findProduct/' + idProduct,
		dataType: 'json',
		success: function (product) {
			
			var data = {}
			data["id"] = id;
			data["product"] = product;
			data["count"] = $("#count").val();
			data["qty"] = $("#qty").val();
			data["inputPrice"] = $("#inputPrice").val();
			data["outputPrice"] = $("#outputPrice").val();
			
			var idSupplier = $("#OptionSelectSuppliver").val();
			
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url:   'findSupplier/' + idSupplier,
				dataType: 'json',
				success: function (supplier) {
					
					data["supplier"] = supplier;
					data["date"] =  getDay();
					
					$.ajax({
						type: "PUT",
						contentType: "application/json",
						url: id + "/update",
						data: JSON.stringify(data),
						dataType: 'json',
						success: function () {
							
						swal("Chúc mừng!", "Bạn đã thêm thành công!", "success").then(() => {
							location.reload();
					});
						},
					});

				},
			});

		}
	});
}

function getAllSupplivers() {
	$.ajax({
		url: "getAllSuppliers",
		type: 'POST',
		contentType: "application/json",
		dataType: 'json',
		sort: true,
		success: function (data) {

			$.each(data, function (key, value) {
				$("#OptionSelectSuppliver").append('<option value=' + value.id + '>' + value.name + ' ('+ value.email +')'+'</option>');
			});
		}
	});
}

function getAllProducts() {
	$.ajax({
		url: "getAllProducts",
		type: 'POST',
		contentType: "application/json",
		dataType: 'json',
		sort: true,
		success: function (data) {

			$.each(data, function (key, value) {
				$("#OptionSelectProduct").append('<option value=' + value.id + '>' + value.name + ' ('+ value.measure.name+')'+'</option>');
			});
		}
	});
}

function checkNumber(number) {
	if (number <= 0) {
		return false;
	}
	return true;
}

function sumPrice(inputPrice) {
	var count = $("#count").val();
	if (count != 'null' && inputPrice != 'null') {
		var num = inputPrice*count;
		var currency = num.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
		 $("#suminput").val(currency);
	}
}

function sumOutPrice(newOutputPrice) {
	var count = $("#count").val();
	if (count != 'null' && newOutputPrice != 'null') {
		var num = newOutputPrice*count;
		var currency = num.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
		 $("#sumoutput").val(currency);
	}
	var inputPrice = $("#inputPrice").val();
	var outputPrice = $("#outputPrice").val();
	income(inputPrice, outputPrice);

}

function income(inputPrice, outputPrice) {
		var num = outputPrice - inputPrice;
		 $("#income").val(num);
		 num = num/inputPrice*100;
		 $("#sumincome").val(num.toFixed(2));
}

function getDay() {
	var today = new Date();
	return today;
}