/**
 * 
 */
  $(document).ready(function() {  
            var chart = {
               type: 'bar'
            };
            var title = {
               text: 'Genre Monkly Pickup Statistic'   
            };
            var subtitle = null;
            var xAxis = {
               categories: ['Week 1', 'Week 2', 'Week 3', 'Week 4'],
               title: {
                  text: null
               }
            };
            var yAxis = {
               min: 0,
               title: {
                  text: 'PickUp',
                  align: 'high'
               },
               labels: {
                  overflow: 'justify'
               }
            };
            var tooltip = {
               valueSuffix: ' time'
            };
            var plotOptions = {
               bar: {
                  dataLabels: {
                     enabled: true
                  }
               },
               series: {
                  stacking: 'normal'
               }
            };
            var legend = {
               layout: 'vertical',
               align: 'right',
               verticalAlign: 'top',
               x: -40,
               y: 100,
               floating: true,
               borderWidth: 1,
               
               backgroundColor: (
                  (Highcharts.theme && Highcharts.theme.legendBackgroundColor)
                  || '#FFFFFF'),
               shadow: true
            };
            var credits = {
               enabled: false
            };
            var series = [
               {
                  name: 'Comics',
                  data: [280,200,300,400]
               }, 
               {
                  name: 'Novel',
                  data: [270, 100, 250, 350]
               }, 
               {
                  name: 'Science',
                  data: [230, 100, 200, 300]      
               },
               {
                   name: 'Romantic',
                   data: [240, 250, 300, 410]      
                },
               {
                   name: 'Others',
                   data: [210, 140, 200, 350]      
                }
            ];
      
            var json = {};   
            json.chart = chart; 
            json.title = title;   
            json.subtitle = subtitle; 
            json.tooltip = tooltip;
            json.xAxis = xAxis;
            json.yAxis = yAxis;  
            json.series = series;
            json.plotOptions = plotOptions;
            json.legend = legend;
            json.credits = credits;
            $('#genre-chart').highcharts(json);
         });
