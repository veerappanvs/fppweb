function FiscalReportCtrl($uibModal, $rootScope, $scope, $http, $location) {
	 
	$scope.isSuccess=false;
	$scope.isCheckRegister=false;
	$scope.isAdmin=$rootScope.isAdmin;
	var date = new Date();
	$scope.fiscalreportdate = date.getFullYear() + '-' + ('0' + (date.getMonth() + 1)).slice(-2) + '-' + ('0' + date.getDate()).slice(-2);
	
	$scope.master = {};
	console.log(' FiscalReportCtrl- $scope.isAdmin = '+$scope.isAdmin);
	 
	//$scope.acctnameList1 = ['Bedding-Toys Sterilization','Food Processors','Frozen Desserts','IMS Rating','Non-alcoholic (in-of-state)','Non-alcoholic (out-of-state)','Out of State Bakeries','Vending Machines','Water Vending','Stuffed Toy','Single Service Rating','Residential Kitchen','Methyl Wood','Health Certificate']
	
	/*$scope.acctnameList1 =['Bottled Water and Carbonated Non-Alcoholic Beverages (In-State)','Methyl Alcohol','Processor, Baked Goods','Processor, Food','Processor, Frozen Desserts','Processor, Residential Kitchen','Processor, Seafood','Distributor, Food','Warehouse',
		'Cold Storage Warehouse','Out-of-State Bakeries','Vending Machines, Food and Beverages','Vending Machines, Water Only','Bedding','Upholstered Furniture','Stuffed Toys', 'Sterilization',
		'Out-of-State Frozen Desserts', 'Processor, Milk(IMS Rating)','Processor, Milk(Single Service Manufacturer Rating)','Research Animals(cats and dogs)',
		'Export Statements','Health Certificate','Bottled Water and Carbonated Non-Alcoholic Beverages (Out-of-State)','Processor, Meat & Poultry(>$10 million annual sales)','Processor, Meat & Poultry(all other M&P processors)','Milk Laboratory State Certification',
		'Milk Laboratory Inspection per Procedural Specialty','Milk Laboratory Interstate Licenses','Mics.Revenue']
		*/
	//console.log('global_LicenseType.shift()'+global_LicenseType.shift());
	//var tempArray = global_LicenseType;
	//tempArray.shift();
	$scope.acctnameList1 = global_LicenseType_shifted;
	$scope.acctnameList2 = global_LicenseType_shifted;
	$scope.acctnameList3 = global_LicenseType_shifted;
	$scope.acctnameList4 = global_LicenseType_shifted;
		
	function getDateMonthYear(datetoFormat) {
		var d = new Date(datetoFormat);
		console.log("getDateinText : "+datetoFormat);
	    var month = new Array();
	    month[0] = "January";
	    month[1] = "February";
	    month[2] = "March";
	    month[3] = "April";
	    month[4] = "May";
	    month[5] = "June";
	    month[6] = "July";
	    month[7] = "August";
	    month[8] = "September";
	    month[9] = "October";
	    month[10] = "November";
	    month[11] = "December";

	    var monthPart = month[d.getMonth()];
	    var yearPart = d.getFullYear();
	    var formattedDate = monthPart+' '+yearPart;
	    console.log("getDateinText formatted : "+formattedDate);
	    return formattedDate;
	}
	
	
	
	 $scope.markReadonlyDetail = function(toggle){
		  $scope.isReadonly=toggle;
	 }
	 $scope.activefacilities=function(activefacilitiesmodel){
		 $http.get('api/facility/reports/activefaclist?acctname='+activefacilitiesmodel)
		  	.then(function (response) {
		  		 console.log("Downloading Fiscal report ");
            var link = document.createElement('a');
            link.href = response.data;//window.URL.createObjectURL(blob);
            link.download = "ActiveFacilitiesReport.xlsx";
            link.click();
            
		  	 },/*function(error){
			    	console.log("errror occured");
			  }*/
		  	function(response) {
	    			$location.path('error');
	    			console.log("Error While getting the data"); 
	    		}
		  	 
		  	);
	 }
	  $scope.fiscalReport = function(acctname, startDate, endDate ){
		  var str = $scope.batchNumber;
		  
		  console.log("before acctName"+acctname+"startDate "+startDate+"endDate "+endDate);
		  if(acctname != null && startDate != null && endDate != null){
			  console.log("before acctName"+acctname+"startDate "+startDate+"endDate "+endDate);
			  var sd = new Date(startDate);
			  var ed = new Date(endDate);	
			  
			  var sdtext = getDateMonthYear(startDate);
			  var edtext = getDateMonthYear(endDate);
			  
			  console.log("sdtext "+sdtext);
			  console.log("edtext "+edtext);
			  var formSD = sd.getFullYear()+'-'+(sd.getMonth()+1)+'-'+sd.getDate();
			  var ed = new Date(endDate);	
			  var formED = ed.getFullYear()+'-'+(ed.getMonth()+1)+'-'+ed.getDate();
			  
			  console.log("formSD "+formSD);
			  console.log("formED "+formED);
				 // $http.post('api/gl/receiptoffees/fiscalreport?acctname='+$scope.acctname+'&startDate='+sdtext+'&endDate='+edtext)
			  //$http.post('api/gl/receiptoffees/fiscalreport?acctname='+acctname+'&startDate='+formSD+'&endDate='+formED)
			  $http.post('api/gl/receiptoffees/fiscalreport?acctname='+acctname+'&startDate='+startDate+'&endDate='+endDate)
				  	.then(function (response) {
				  		 console.log("Downloading Fiscal report ");
	                   var link = document.createElement('a');
	                   link.href = response.data;//window.URL.createObjectURL(blob);
	                   link.download = "FiscalReport.xlsx";
	                   link.click();
	                   
				  	 },/*function(error){
					    	console.log("errror occured");
					  }*/
				  	function(response) {
			    			$location.path('error');
			    			console.log("Error While getting the data"); 
			    		}
				  	 
				  	);
			  
			  }else 
		  	  $scope.checked=false;
	  };
	  
	  
	  

	  $scope.expiredFacilites=function(dateIssue,dateExpire,catName){	
			
			 $http.post('api/facility/reports/expirefaclist?startDate='+dateIssue+'&endRange='+dateExpire+'&catName='+catName)
					  	.then(function (response) {
		  		 console.log("Downloading Fiscal report ");
	        var link = document.createElement('a');
	        link.href = response.data;//window.URL.createObjectURL(blob);
	        link.download = "ExpiredFacilitiesReport.xlsx";
	        link.click();
	        
		  	 },/*function(error){
			    	console.log("errror occured");
			  }*/
		  	function(response) {
	    			$location.path('error');
	    			console.log("Error While getting the data"); 
	    		}
		  	 
					  	);
		}

	  $scope.expiredRegisterationFacilites=function(startDate,acctName){		
			
			 $http.post('api/facility/reports/expiredregistration?startDate='+startDate+'&acctName='+acctName)
					  	.then(function (response) {
		  		 console.log("Downloading Fiscal report ");
	        var link = document.createElement('a');
	        link.href = response.data;//window.URL.createObjectURL(blob);
	        link.download = "Expired registration with Active FacilitiesReport.xlsx";
	        link.click();
	        
		  	 },/*function(error){
			    	console.log("errror occured");
			  }*/
		  	function(response) {
	    			$location.path('error');
	    			console.log("Error While getting the data"); 
	    		}
		  	 
					  	);
		}
	  
	  


		 
	}
