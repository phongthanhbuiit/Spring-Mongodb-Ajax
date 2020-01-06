$(document).ready(function() {

		//validaton input form
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
		var forms = document.getElementsByClassName('windsora-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      document.getElementById("addNewSupplier").addEventListener("click", function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
					event.stopPropagation();
        }
		form.classList.add('was-validated');
				if (form.checkValidity() === true) {

					addSupplier();
        }
			}, false);
		});
});
function addSupplier() {
	
	var data = {}
	data["name"] = $("#name").val();
	data["address"] = $("#address").val();
	data["phone"] = $("#phone").val();
	data["email"] = $("#email").val();
	data["moreinfo"] = $("#moreinfo").val();
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
}

function getDay() {
	var today = new Date();
	return today;
}
