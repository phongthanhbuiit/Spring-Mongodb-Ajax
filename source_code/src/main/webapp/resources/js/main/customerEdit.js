$(document).ready(function () {
		var url = window.location.href;
		var id = url.substring(url.lastIndexOf('/') + 1);
		var customer = {};
		customer.id = id;
		findCustomer(id);
				//validaton input form
	window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
		var forms = document.getElementsByClassName('windsora-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      document.getElementById("editCustomer").addEventListener("click", function(event) {
				console.log("hello");
        if (form.checkValidity() === false) {
          event.preventDefault();
					event.stopPropagation();
        }
		form.classList.add('was-validated');
				if (form.checkValidity() === true) {

					updateCustomer(id);
        }
			}, false);
		});
});
});

//find customer
function findCustomer(id) {

		$.ajax({
        url: id + '/find',
		method: 'GET',
        success: function (data) {

			document.getElementById("name").value = data.name;
			document.getElementById("address").value = data.address;
			document.getElementById("phone").value = data.phone;
			document.getElementById("email").value = data.email;
			document.getElementById("moreinfo").value = data.moreinfo;

        },
        dataType: "json",
        contentType: "application/json",
	  })
	  
	  
}

//update customer
function updateCustomer(id) {
	
	var data = {}
	data["id"] = id;
	data["name"] = $("#name").val();
	data["address"] = $("#address").val();
	data["phone"] = $("#phone").val();
	data["email"] = $("#email").val();
	data["moreinfo"] = $("#moreinfo").val();
	data["date"] = getDay();
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

function getDay() {
	var today = new Date();
	return today;
}
