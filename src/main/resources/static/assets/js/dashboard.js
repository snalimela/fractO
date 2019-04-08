(function(){
	$('.modal-backdrop').remove();
	var chartOptions;
	var data = {
			  labels: ['Bananas', 'Apples', 'Grapes'],
			  series: [20, 15, 40]
			};

			var options = {
			  labelInterpolationFnc: function(value) {
			    return value[0]
			  }
			};

			var responsiveOptions = [
			  ['screen and (min-width: 640px)', {
			    chartPadding: 30,
			    labelOffset: 100,
			    labelDirection: 'explode',
			    labelInterpolationFnc: function(value) {
			      return value;
			    }
			  }],
			  ['screen and (min-width: 1024px)', {
			    labelOffset: 80,
			    chartPadding: 20
			  }]
			];
	//var chart =  new Chartist.Pie('#ownersChart', data, options, responsiveOptions);
	
	var dashboard = {
		
		initDocumentationCharts: function() {
        if ($('#dailySalesChart').length != 0 && $('#websiteViewsChart').length != 0) {
        
        dataDailySalesChart = {
          labels: ['M', 'T', 'W', 'T', 'F', 'S', 'S'],
          series: [
            [12, 17, 7, 17, 23, 18, 38]
          ]
        };
  
        optionsDailySalesChart = {
          lineSmooth: Chartist.Interpolation.cardinal({
            tension: 0
          }),
          low: 0,
          high: 50, // creative tim: we recommend you to set the high sa the biggest value + something for a better look
          chartPadding: {
            top: 0,
            right: 0,
            bottom: 0,
            left: 0
          },
        }
  
        var dailySalesChart = new Chartist.Line('#dailySalesChart', dataDailySalesChart, optionsDailySalesChart);
  
        var animationHeaderChart = new Chartist.Line('#websiteViewsChart', dataDailySalesChart, optionsDailySalesChart);
      }
    },
		initDashboardPageCharts: function() {

			if ($('#dailySalesChart').length != 0 || $('#completedTasksChart').length != 0 || $('#websiteViewsChart').length != 0) {
				dataDailySalesChart = {
					labels: ['M', 'T', 'W', 'T', 'F', 'S', 'S'],
					series: [
						[12, 17, 7, 17, 23, 18, 38]
					]
				};

				optionsDailySalesChart = {
					lineSmooth: Chartist.Interpolation.cardinal({
						tension: 0
					}),
					low: 0,
					high: 50,
					chartPadding: {
						top: 0,
						right: 0,
						bottom: 0,
						left: 0
					},
				}

				var dailySalesChart = new Chartist.Line('#dailySalesChart', dataDailySalesChart, optionsDailySalesChart);

				md.startAnimationForLineChart(dailySalesChart);

				dataCompletedTasksChart = {
					labels: ['12p', '3p', '6p', '9p', '12p', '3a', '6a', '9a'],
					series: [
						[230, 750, 450, 300, 280, 240, 200, 190]
					]
				};

				optionsCompletedTasksChart = {
					lineSmooth: Chartist.Interpolation.cardinal({
						tension: 0
					}),
					low: 0,
					high: 1000,chartPadding: {
						top: 0,
						right: 0,
						bottom: 0,
						left: 0
					}
				}

				var completedTasksChart = new Chartist.Line('#completedTasksChart', dataCompletedTasksChart, optionsCompletedTasksChart);

				md.startAnimationForLineChart(completedTasksChart);

				var dataWebsiteViewsChart = {
					labels: ['J', 'F', 'M', 'A', 'M', 'J', 'J', 'A', 'S', 'O', 'N', 'D'],
					series: [
						[542, 443, 320, 780, 553, 453, 326, 434, 568, 610, 756, 895]

					]
				};
				var optionsWebsiteViewsChart = {
					axisX: {
						showGrid: false
					},
					low: 0,
					high: 1000,
					chartPadding: {
						top: 0,
						right: 5,
						bottom: 0,
						left: 0
					}
				};
				var responsiveOptions = [
					['screen and (max-width: 640px)', {
						seriesBarDistance: 5,
						axisX: {
							labelInterpolationFnc: function(value) {
								return value[0];
							}
						}
					}]
				];
				var websiteViewsChart = Chartist.Bar('#websiteViewsChart', dataWebsiteViewsChart, optionsWebsiteViewsChart, responsiveOptions);
				md.startAnimationForBarChart(websiteViewsChart);
			}
		},
		
		initPropertiesList: function() {
			var config = {
					info: false,
					pagingType: "simple_numbers",
					searching: false,
					bLengthChange: false,
					language: {
						paginate: {
							previous: 'Previous',
							next: 'Next'
						}
					},
					columns: [

						{ 
							title: "Property",
							render: function(d,r,c) {
								console.log(d,r,c)
								return '<a href="#" class="property-name" data-pid="'+ c[4] +'">'+ d +'</a>'
							}
						},
						{ title: "City" },
						{ title: "State" },
						{ title: "Area(Sq.Ft.)" },
						{ title: "PropertyId" , visible: false},
					]
				};
			xhr(function(r){
				$('#capital-amount').text('$'+r.originalCapital);
				$('#increased-amount').text('$'+r.increasedCapital);
				$('#growth').text(' '+r.growth+'%');
				$('#lastMonthIncome').text(r.lastMonthIncome);
				$('#lastMonthVariance').text(' '+r.lastMonthVariance+'%');
				$('#totalArea').text(r.totalArea);
				r = r.properties;
				config.data = r.map(function(p){
					return [
					        p.propertyName, p.city, p.state, p.areaSqft, p.propertyId
					        ]
				});
				$('#property-list').DataTable(config);
				
			}, '/v2/owner/1', 'GET', true);
			
			
		}
	};
	
	$(document).on('click', '.property-name', function(e){
		e.preventDefault();
		var id = $(this).data('pid');
		xhr(function(r){
			$('#property-name-pop').text(r.property.PropertyName);
			$('#property-des-pop').text(r.property.Description);
			$('#avilable-pop').text(' '+r.property.Area);
			$('#price-pop').text('$'+r.property.Price);
			var dp = r.property.owners.map(function(o){
				return {
				        	y: parseInt(o.percentage),
				        	name: o.firstName + ' ' +o.lastName
				        };
				        
			});
			console.log(dp);
			var options = {
					exportEnabled: true,
					animationEnabled: true,
					title:{
						text: "Owners Share"
					},
					legend:{
						horizontalAlign: "right",
						verticalAlign: "center"
					},
					data: [{
						type: "pie",
						showInLegend: true,
						toolTipContent: "<b>{name}</b>",
						indexLabel: "{name}",
						legendText: "{name} (#percent%)",
						indexLabelPlacement: "inside",
						dataPoints: dp
					}]
				};
				$("#chartContainer").CanvasJSChart(options);
		$('#propertyModal').modal();
		},'/v2/property/'+id, 'GET', true )
		
	});

	
		
	dashboard.initPropertiesList();
	dashboard.initDashboardPageCharts();
})()