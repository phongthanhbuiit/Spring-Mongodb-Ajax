$(document).ready(function () {
		var url = window.location.href;
		var id = url.substring(url.lastIndexOf('/') + 1);
		var measure = {};
		measure.id = id;
		findMeasure(id);
				//validaton input form
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
		var forms = document.getElementsByClassName('windsora-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      document.getElementById("editMeasure").addEventListener("click", function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
					event.stopPropagation();
        }
		form.classList.add('was-validated');
				if (form.checkValidity() === true) {

					updateMeasure(id);
        }
			}, false);
		});
});

//find measure
function findMeasure(id) {

		$.ajax({
        url: id + '/find',
		method: 'GET',
        success: function (data) {

			document.getElementById("name").value = data.name;

        },
        dataType: "json",
        contentType: "application/json",
	  })
	  
	  
}

//update measure
function updateMeasure(id) {
	
	var data = {}
	data["id"] = id;
	data["name"] = $("#name").val();
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

