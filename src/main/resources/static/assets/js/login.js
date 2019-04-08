(function(){
	String.prototype.supplant = function (o) {
    return this.replace(
      /{([^{}]*)}/g,
      function (a, b) {
        var r = o[b];
        return typeof r === 'string' || typeof r === 'number' ? r : (r ? a : '');
      }
    );
  };
	var $login = $('.login-form');
	var $pdp = $('.pdp').html();
	var $container = $('.container-fostrap .card-container');
	$login.submit(function(e){
		e.preventDefault();
		var _data = {};
		var d = $(this).serializeArray();
		for (var i = 0, len = d.length; i < len; i++) {
          var f = d[i];
          if (f.value) {
            _data[f.name] = f.value;
          }
        }
		if(_data.username === 'admin') {
			location.hash = '#admin';
			return;
		}
		location.hash = '#dashboard';
	});	

	var data = [
	    		{
	    			available:'1500',
	    			property: 'Arbor Glen Apartments',
	    			desc:	'Beautiful home in great nieghborhood',		 
	    			price: '3000',
	    			img: '/resources/assets/images/img1.jpg',
	    		},{
	    			available:'2500',
	    			property: 'The Heights of Collingswood',
	    			desc:	'Nice 3 Bed 2 Bath Home!!!!!!!!!',		 
	    			price: '3400',
	    			img: '/resources/assets/images/img2.jpg',
	    		},{
	    			available:'1500',
	    			property: 'TABULA RASA',
	    			desc:	'Beautiful Home,Large rooms',		 
	    			price: '2000',
	    			img: '/resources/assets/images/img3.jpg',
	    		},{
	    			available:'1800',
	    			property: 'Bella Terra At City Center',
	    			desc:	'Beautiful Newly Constructed 4 Bedroom Home!',		 
	    			price: '4200',
	    			img: '/resources/assets/images/img4.jpg',
	    		},{
	    			available:'500',
	    			property: 'Grand Adams- dupe',
	    			desc:	'Well-Maintained Two-Story 4-Bedroom Home..',		 
	    			price: '7000',
	    			img: '/resources/assets/images/img5.jpg',
	    		},{
	    			available:'550',
	    			property: 'Parkway Lofts',
	    			desc:	'Upgraded Corner Unit Condo at Pacific Pines',		 
	    			price: '6000',
	    			img: '/resources/assets/images/img6.jpg',
	    		},{
	    			available:'750',
	    			property: 'Amber Chase',
	    			desc:	'Extraordinary listing with pool in plano',		 
	    			price: '3800',
	    			img: '/resources/assets/images/img7.jpg',
	    		},{
	    			available:'1200',
	    			property: 'Creekside Village Apartment Homes',
	    			desc:	'His/Her Closets in Master Bedroom',		 
	    			price: '3400',
	    			img: '/resources/assets/images/img8.jpg',
	    		}
	    	]
	
		for (var i=0;i<data.length;i++){
    		$container.append($pdp.supplant(data[i]));
    	}
	
	    	

	
})();