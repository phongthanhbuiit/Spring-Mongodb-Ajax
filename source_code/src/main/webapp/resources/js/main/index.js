// Call the dataTables jQuery plugin
$(document).ready(function () {
  

  viewChartCollumn();
  
  viewChartPie();
});

function viewChartCollumn() {
  var dataPoints = []
  var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	theme: "light2", // "light1", "light2", "dark1", "dark2"
	title:{
		text: "Hàng Tồn Kho"
	},
	axisY: {
		title: "Số Kg"
	},
	data: [{        
		type: "column",  
    dataPoints: dataPoints ,
	}]
  });
  
  	$.ajax({
		url: 'getAll',
		method: 'GET',
		success: function (data) {
      data.forEach(function(data){
  
        var label = data.product.name;  
        var count = data.count;
        count = Math.round(count*100)/100;
        dataPoints.push({y: count, label: label});
        chart.render();  
      });
      

		},
		dataType: "json",
		contentType: "application/json",

  });	
}

function viewChartPie() {
  var dataPointsPie = []
  var chartPie = new CanvasJS.Chart("chartContainerPie", {
	animationEnabled: true,
	theme: "light2", // "light1", "light2", "dark1", "dark2"
	title:{
		text: "Hàng Tồn Kho"
	},
	axisY: {
		title: "Số Kg"
	},
	data: [{        
		type: "pie",  
    dataPoints: dataPointsPie,
    startAngle: 240,
		yValueFormatString: "##0.00\"%\"",
		indexLabel: "{label} {y}",
	}]
  });
  
  	$.ajax({
		url: 'getAll',
		method: 'GET',
		success: function (data) {
      var sum = 0;
      data.forEach(function(data){
          sum = sum + data.count;
      });

      data.forEach(function(data){
        var label = data.product.name;  
        var count = data.count;
        count = Math.round(count*100)/100;
        count = count/sum*100;
        dataPointsPie.push({y: count, label: label});
        chartPie.render();  
      });
      

		},
		dataType: "json",
		contentType: "application/json",

  });	
}

