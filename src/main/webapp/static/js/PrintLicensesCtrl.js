function PrintLicensesCtrl($uibModal, $rootScope, $scope, $http,$routeParams, $window, $location) {
	

	$scope.checked=false;
	
	//$scope.acctnameDropDown = ['','Bedding-Toys Sterilization','Food Processors','Frozen Desserts','IMS Rating','Non-alcoholic (in-of-state)','Non-alcoholic (out-of-state)','Out of State Bakeries','Vending Machines','Water Vending','Stuffed Toy','Single Service Rating','Residential Kitchen','Methyl Wood','Health Certificate']
	$scope.acctnameDropDown =global_LicenseType;
	/*$scope.accountName = ['','Bottled Water and Carbonated Non-Alcoholic Beverages (In-State)','Methyl Alcohol','Processor, Baked Goods','Processor, Food','Processor, Frozen Desserts','Processor, Residential Kitchen','Processor, Seafood','Distributor, Food','Warehouse',
		'Cold Storage Warehouse','Out-of-State Bakeries','Vending Machines, Food and Beverages','Vending Machines, Water Only','Bedding','Upholstered Furniture','Stuffed Toys', 'Sterilization',
		'Out-of-State Frozen Desserts', 'Processor, Milk(IMS Rating)','Processor, Milk(Single Service Manufacturer Rating)','Research Animals(cats and dogs)',
		'Export Statements','Health Certificate','Bottled Water and Carbonated Non-Alcoholic Beverages (Out-of-State)','Processor, Meat & Poultry(>$10 million annual sales)','Processor, Meat & Poultry(all other M&P processors)','Milk Laboratory State Certification',
		'Milk Laboratory Inspection per Procedural Specialty','Milk Laboratory Interstate Licenses','Mics.Revenue'];
*/
	$scope.Orderbylist = ['','Completion Time','Alphabetically'];
	$scope.Showtable=function (){
		$scope.checked=true;
	}
$scope.gridOptions = {
			
			enableColumnResize: true,
		    enableSorting: true,
		    enableFiltering: false,
		    
		    columnDefs: [
		    	
		    	{ name:  'Total No 1st', displayName: 'Total No 1st', width: '15%'},
		    	//	cellTemplate: '<div class="ui-grid-cell-contents" ng-click="grid.appScope.showMe(row.entity.facId)">{{COL_FIELD CUSTOM_FILTERS}}</div>' },
		    	  { name:  'Total No. 2nd',displayName: 'Total No. 2nd', width: '10%' },
		    	  { name:  'Who Sent 1st',displayName: 'Who Sent 1st', width: '20%' },
			      { name:  'Who Sent 2nd',displayName: 'Who Sent 2nd', width: '30%' }
			      
		    ],
		    onRegisterApi: function( gridApi ) {}
		    
	
		  };

	$scope.printLicense = function(acctname, orderby){
		
		 console.log("before acctName"+acctname+"orderby "+orderby);
		  if(acctname != null && orderby != null ){
			  var date = new Date(); 
			  var currentTimeinmiSecs = date.getTime();
			  var filenameprefix  =currentTimeinmiSecs+'_';
			  
			//  $http.get('api/facility/print/license?acctname='+catalina.out+'&orderby='+orderby)
			  $http.get('api/facility/print/licenses?acctname='+acctname+'&orderBy='+orderby+'&filenameprefix='+filenameprefix)
				  	.then(function (response) {
				  		 console.log("Downloading Expired Registration report ");
	                   var link = document.createElement('a');
	                  
	                   link.href = response.data;//window.URL.createObjectURL(blob);
	                   link.download = filenameprefix+"permit_output.pdf";
	                 //  link.download = "permit_output.pdf";
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
		
	}

	
}
