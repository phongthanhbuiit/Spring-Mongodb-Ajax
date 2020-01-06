$(document).ready(function() {

		//validaton input form
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
		var forms = document.getElementsByClassName('windsora-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      document.getElementById("addNewMeasure").addEventListener("click", function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
					event.stopPropagation();
        }
		form.classList.add('was-validated');
				if (form.checkValidity() === true) {

					addMeasure();
        }
			}, false);
		});
});
function addMeasure() {
	
	var data = {}
	data["name"] = $("#name").val();
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

