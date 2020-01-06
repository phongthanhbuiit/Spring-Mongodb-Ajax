$(document).ready(function () {
	getAllMeaures();
	//validaton input form
	// Fetch all the forms we want to apply custom Bootstrap validation styles to
	var forms = document.getElementsByClassName('windsora-validation');
	// Loop over them and prevent submission
	Array.prototype.filter.call(forms, function (form) {
		document.getElementById("addNewProduct").addEventListener("click", function (event) {
			if (form.checkValidity() === false) {
				event.preventDefault();
				event.stopPropagation();
			}
			form.classList.add('was-validated');
			if (form.checkValidity() === true) {

				addProduct();
			}
		}, false);
	});
});

function addProduct() {


	var id = $("#OptionSelect").val();
	var name = $('#OptionSelect :selected').text();
	var measure = {}
	measure["id"] = id;
	measure["name"] = name;
	var data = {}
	data["name"] = $("#name").val();
	data["measure"] = measure;

	add(data);

}
function add(data) {
		$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "create",
		data: JSON.stringify(data),
		dataType: 'json',
		success: function () {
			console.log(data);
			swal("Chúc mừng!", "Bạn đã thêm thành công!", "success").then(() => {
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
		}
	});
}
