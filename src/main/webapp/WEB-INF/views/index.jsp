<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    FractO Dashboard
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <link href="/resources/assets/css/material-dashboard.css?v=2.1.1" rel="stylesheet" />
  <link href="/resources/assets/css/app.css" rel="stylesheet" />
</head>

<body>
  <div id="main-wrapper" class="wrapper ">
  </div>
  <script src="/resources/assets/js/jquery.min.js"></script>
  <script src="/resources/assets/js/popper.min.js"></script>
  <script src="/resources/assets/js/bootstrap-material-design.min.js"></script>
  <script src="/resources/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <script src="/resources/assets/js/plugins/moment.min.js"></script>
  <script src="/resources/assets/js/plugins/sweetalert2.js"></script>
  <script src="/resources/assets/js/plugins/jquery.validate.min.js"></script>
  <script src="/resources/assets/js/plugins/jquery.bootstrap-wizard.js"></script>
  <script src="/resources/assets/js/plugins/bootstrap-selectpicker.js"></script>
  <script src="/resources/assets/js/plugins/bootstrap-datetimepicker.min.js"></script>
  <script src="/resources/assets/js/plugins/jquery.dataTables.min.js"></script>
  <script src="/resources/assets/js/plugins/bootstrap-tagsinput.js"></script>
  <script src="/resources/assets/js/plugins/jasny-bootstrap.min.js"></script>
  <script src="/resources/assets/js/plugins/fullcalendar.min.js"></script>
  <script src="/resources/assets/js/plugins/jquery-jvectormap.js"></script>
  <script src="/resources/assets/js/plugins/nouislider.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
  <script src="/resources/assets/js/plugins/arrive.min.js"></script>
  <script src="/resources/assets/js/plugins/chartist.min.js"></script>
  <script src="/resources/assets/js/plugins/bootstrap-notify.js"></script>
  <script src="/resources/assets/js/material-dashboard.js?v=2.1.1"></script>
  <script src="/resources/assets/js/app.js"></script>
  <script src="https://canvasjs.com/assets/script/jquery.canvasjs.min.js"></script>
  <script>
    $(document).ready(function() {
        var $wrapper = $('#main-wrapper');
        
        window.addEventListener('hashchange', function (e) {
          e.preventDefault();
          var url = '/resources/assets/templates/' + location.hash.replace('#','') + '.html';
          loadTemplate(url, function(r){
        	  $wrapper.html(r);
          })
        });
        
        var loadTemplate = function (url, c) {
        	xhr(c, url, 'GET');
  		}
        
        // XMLHttpRequest

        var xhr = function () {
          var count = 0;

          var responseHandler = function (data, c) {
            count -= 1;
            if (count === 0) {
            }
            c(data);
          };

          var startSpinner = function () {
            count += 1;
          }

          var stopSpinner = function () {
          }

          return function (callback, url, method, apiMethod, data) {
            if (data && typeof data === 'object') {
              data = JSON.stringify(data);
            }

            startSpinner();
            $.ajax({
              method: method,
              url: url,
              data: data,
              contentType: apiMethod ? 'application/json' : '',
            }).done(function (response) {
                responseHandler(response, callback);
              });
          };

        }();
        
        window.xhr = xhr;
        
        var hash = location.hash || '#login';
        hash = hash.replace('#', '');
       	loadTemplate('/resources/assets/templates/'+ hash +'.html', function(r){
         	  $wrapper.html(r);
           })
        

	});
  </script>
</body>

</html>
