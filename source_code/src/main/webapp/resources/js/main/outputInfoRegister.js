$(document).ready(function() {
	getAllCustomers();
	var indexArr = [];
	indexArr = getNewInputOther(0); 

	// validaton input form
    // Fetch all the forms we want to apply custom Bootstrap validation styles
	// to
	var forms = document.getElementsByClassName('windsora-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      document.getElementById('addNewOutputInfo').addEventListener('click', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
		form.classList.add('was-validated');
				if (form.checkValidity() === true) {
					var productList = [];
					for (index in indexArr) {
						productList = addInput(productList, index);
					}
					data = {}
					data['input'] = productList;
					var idCustomer = $("#OptionSelectCustomer").val();
					addOutputInfo(idCustomer, data);	
				}
				
			}, false);
		});
});

function addInput(arrInput, index) {
	var productIndex = "#OptionSelectProduct" + index + " :selected";
	var idProduct = $(productIndex).val();
	
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url:  idProduct + '/findProduct',
		dataType: 'json',
		success: function (product) {
			var temp = {}
			temp['product'] = product;
			var qtyIndex = "#qty" + index;
			var qty = $(qtyIndex).val();
			var countIndex = "#count" + index;
			var count = $(countIndex).val();
			var outputPriceIndex = "#outputPrice"+index; 
			var outputPrice = $(outputPriceIndex).val();

			temp['qty'] = qty;
			temp['count'] = count;
			temp['outputPrice'] = outputPrice;
			arrInput.push(temp);
		}});

	return arrInput;
}

function addOutputInfo(id, data) {

			$.ajax({
				type: 'POST',
				contentType: 'application/json',
				url:  id + '/findCustomer',
				dataType: 'json',
				success: function (customer) {
				
					data['customer'] = customer;
					data['date'] = getDay();
					
					$.ajax({
						type: 'POST',
						contentType: 'application/json',
						url: 'create',
						data: JSON.stringify(data),
						dataType: 'json',
						success: function () {
							
						swal('Chúc mừng!', 'Bạn đã thêm thành công!', 'success').then(() => {
							location.reload();
					});
						},
					});

				},
			});

		
	
}

function getAllProducts(index) {
	$.ajax({
		url: 'getAllProducts',
		type: 'POST',
		contentType: 'application/json',
		dataType: 'json',
		sort: true,
		success: function (data) {

			$.each(data, function (key, value) {
				$('#OptionSelectProduct'+index).append('<option value=' + value.id + '>' + value.name + ' ('+ value.measure.name+')'+'</option>');
			});
		}
	});
}

function getAllCustomers() {
	$.ajax({
		url: 'getAllCustomers',
		type: 'POST',
		contentType: 'application/json',
		dataType: 'json',
		sort: true,
		success: function (data) {

			$.each(data, function (key, value) {
				$("#OptionSelectCustomer").append('<option value=' + value.id + '>' + value.name + ' ('+ value.email +')'+'</option>');
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

function sumPrice(inputPrice, index) {
	var count = $('#count' + index).val();
	if (count != 'null' && inputPrice != 'null') {
		var num = inputPrice*count;
		var currency = num.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
		 $('#sumoutput' + index).val(currency);
	}
}



function getDay() {
	var today = new Date();
	return today;
}

function getNewInputOther(index) {
	var arr = new Array();
	getAllProducts(index);
	arr.push(index);
	$('.btn-addmore').click(function(event){
			event.preventDefault();
			index = index + 1;
			var formInput = '.formInput';
			var input = '<div id = "input'+ index + '">';
			var labelProduct = '<div class="form-group row">';
			labelProduct += '<label class="label"> Hàng Đã Nhập: </label>';
			var selectProduct = '<div class="col-sm-12 mb-3 mb-sm-0">';
			selectProduct += '<select class="form-control form-control-lg OptionSelectProduct" id="OptionSelectProduct'+ index + '"> </select> </div> </div>';
			var count = '<div class="form-group row">';
			count+= '<div class="col-sm-6 mb-3 mb-sm-0">';
			count+='<label class=label> Số Kí: </label> <input type="number"';
			count+='step=0.1 class="form-control form-control-outputInfo"';
			count+='id="count'+index+'" placeholder="Số Kí (kilogram)" required>';
			count+='<div class="invalid-feedback">Vui lòng nhập số lượng (Số Kí)</div></div>';
			
			var qty = '<div class="col-sm-6 mb-3 mb-sm-0">';
			qty+= '<label class=label> Số Lượng: </label> <input type="number"';
			qty+= 'class="form-control form-control-outputInfo" id="qty'+index;
			qty+= '" placeholder="Số lượng" required>';
			qty+= '<div class="invalid-feedback">Vui lòng nhập số Lượng</div></div></div>';
			var outmoney = '<div class="form-group row">';
			outmoney+= '<div class="col-sm-6 mb-3 mb-sm-0">';
			outmoney+= '<label class=label> Số tiền bán (1KG): </label> <input type="number" step=any class="form-control form-control-outputInfo"';
			outmoney+= 'id="outputPrice'+index+'" placeholder=" Số tiền bán"';
			outmoney+= 'oninput="sumPrice(this.value,'+ index+')"';
			outmoney+= 'onchange="sumPrice(this.value, '+index+')" required>';
			outmoney+= '<div class="invalid-feedback">Vui lòng nhập Số tiền bán</div> </div>';
			var summoney = '<div class="col-sm-6 mb-3 mb-sm-0">';
			summoney+= '<label class=label> Tổng số tiền: </label> <input type="text"';
			summoney+= 'class="form-control form-control-outputInfo" id="sumoutput'+ index;
			summoney+= '" placeholder="Thành tiền" readonly> </div> </div>';
			var btnRemove = '<a id="btnRemove'+index+ '" class="btn btn-outputInfo btn-block btn-remove">';
			btnRemove+= 'Xoá Hàng Hoá Này </a> <br> <br> <hr> </div>';
									

			$(formInput).append(input+labelProduct+selectProduct+count+qty+outmoney+ summoney + btnRemove+'</div> </div>');
			
			getAllProducts(index);
			arr.push(index);
			$('.btn-remove').click(function(e){
				 e.preventDefault(); 
         var formNum = this.id.charAt(this.id.length-1);
				 var inputElement = '#input'+ formNum;
				 $(this).remove();
				 $(inputElement).remove();
				 arr.splice(formNum, 1);
			});
		});
		
		return arr;
}
