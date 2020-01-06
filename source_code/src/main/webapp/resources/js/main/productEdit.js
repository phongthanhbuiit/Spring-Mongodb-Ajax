$(document).ready(function () {
	var url = window.location.href;
	var id = url.substring(url.lastIndexOf('/') + 1);
	var product = {};
	product.id = id;
	getAllMeaures();

	findProduct(id);
	//validaton input form
	// Fetch all the forms we want to apply custom Bootstrap validation styles to
	var forms = document.getElementsByClassName('windsora-validation');
	// Loop over them and prevent submission
	Array.prototype.filter.call(forms, function (form) {
		document.getElementById("editProduct").addEventListener("click", function (event) {
			if (form.checkValidity() === false) {
				event.preventDefault();
				event.stopPropagation();
			}
			form.classList.add('was-validated');
			if (form.checkValidity() === true) {

				updateProduct(id);
			}
		}, false);
	});
});

//find product
function findProduct(id) {

	$.ajax({
		url: id + '/find',
		method: 'GET',
		success: function (data) {

			document.getElementById("name").value = data.name;
			var measure = data.measure;
			$('#OptionSelect').val(measure.id).change();

		},
		dataType: "json",
		contentType: "application/json",

	});	
}

//update product

function updateProduct(id) {

	var data = {}
	data["id"] = id;
	data["name"] = $("#name").val();
	var idMeausre = $("#OptionSelect").val();
	var name = $('#OptionSelect :selected').text();
	var measure = {}
	measure["id"] = idMeausre;
	measure["name"] = name;
	data["measure"] = measure;
	$.ajax({
		type: "PUT",
		contentType: "application/json",
		url: id + '/update',
		data: JSON.stringify(data),
		dataType: 'json',
		success: function () {
			swal("Chúc mừng!", "Bạn đã cập nhật thành công!", "success").then(() => {
				location.reload();
			});
		},
	});
}

function getAllMeaures() {
	$.ajax({
		url: "getAllMeasures",
		type: 'POST',
		contentType: "application/json",
		dataType: 'json',

		success: function (data) {
			
			$.each(data, function (key, value) {
				$("#OptionSelect").append('<option value=' + value.id + '>' + value.name + '</option>');
			});
		},
	});
}

