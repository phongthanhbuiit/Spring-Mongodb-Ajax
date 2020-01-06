$(document).ready(function() {
	getAllProducts();
	 getAllSupplivers();
	// validaton input form
    // Fetch all the forms we want to apply custom Bootstrap validation styles
	// to
	var forms = document.getElementsByClassName('windsora-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      document.getElementById("addNewInputInfo").addEventListener("click", function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
		form.classList.add('was-validated');
				if (form.checkValidity() === true) {
					var number = $("#inputPrice").val();
					var number2 = $("#outputPrice").val();
					if (checkNumber(number) === true && checkNumber(number2) === true ) {
						var id =  $("#OptionSelectProduct").val();
						addInputInfo(id);
					}
					else {
						swal("Lỗi!", "Số tiền phải lớn hơn 0!","error");
					}
					
        }
			}, false);
		});
});
function addInputInfo(id) {

	$.ajax({
		type: "POST",
		contentType: "application/json",
		url:  id + '/findProduct',
		dataType: 'json',
		success: function (product) {
			
			var data = {}
			data["product"] = product;
			data["count"] = $("#count").val();
			data["qty"] = $("#qty").val();
			data["inputPrice"] = $("#inputPrice").val();
			data["outputPrice"] = $("#outputPrice").val();
			
			var idSupplier = $("#OptionSelectSuppliver").val();
			
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url:  idSupplier + '/findSupplier',
				dataType: 'json',
				success: function (supplier) {
					
					data["supplier"] = supplier;
					data["date"] = getDay();
					
					$.ajax({
						type: "POST",
						contentType: "application/json",
						url: "create",
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

function getDay() {
	var today = new Date();
	return today;
}