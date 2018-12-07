function MailMergeListCtrl($uibModal, $rootScope, $scope, $http, $location) {
	
	$scope.startrange=$rootScope.startDate;
	$scope.endRange=$rootScope.endDate;
	$scope.category=$rootScope.catName;
	
	$scope.cancel=function(){
		$scope.modalInstance.dismiss('cancel');
	}	
	$scope.MailGenClick=function(){
		//alert($scope.genNoticeBtnType);
		//renewals/generate1stnotices
		var api='';
		if($scope.genNoticeBtnType==1)
		api='api/facility/renewals/generate1stnotices?category='+$scope.category+"&startRange="+$scope.startrange+"&endRange="+$scope.endRange;
		else 
		api='api/facility/renewals/generate2ndnotices?category='+$scope.category+"&startRange="+$scope.startrange+"&endRange="+$scope.endRange+"&run1stdate="+$scope.run1stdate;
		
			
		$http.get(api)
		  	.then(function (response) {
		  		console.log(response.data);
		  		 var link = document.createElement('a');
                 link.href = response.data;//window.URL.createObjectURL(blob);
                 link.download = "renewal_output.pdf";
                 link.click();
		 },
		 function(response) {
 			$location.path('error');
 			console.log("Error While getting the data"); 
 		}
		  	);
	}
	$scope.checked=1;

	$scope.gridOptions = {
				
				enableColumnResize: true,
			    enableSorting: true,
			    enableFiltering: false,
			    
			    columnDefs: [
			    	
			    	{ name:  'dphCertno', displayName: 'License No', width: '10%'},
			    	//	cellTemplate: '<div class="ui-grid-cell-contents" ng-click="grid.appScope.showMe(row.entity.facId)">{{COL_FIELD CUSTOM_FILTERS}}</div>' },
			    	  { name:  'dexporiss',displayName: 'Issue Date', width: '10%' },
			    	  { name:  'corpName',displayName: 'Parent Corporation Name', width: '20%' },
				      { name:  'mailAdd1',displayName: 'Address Line1', width: '17%' },
				      { name:  'mailAdd2', displayName: 'Address Line2', width: '17%'},
				    	{ name:  'city', displayName: 'City', width: '10%'},
				    	{ name:  'mailstate', displayName: 'State', width: '5%'},
				    	{ name:  'mailZip', displayName: 'Zip', width: '5%'},
				    	{ name:  'country', displayName: 'Country', width: '10%'}
				    	
				  
				      
			    ],
			    onRegisterApi: function( gridApi ) {}
			    
		
			  };
	
	console.log("modalInstancemodalInstancemodalInstance");
	console.log($scope.modalInstance);
	
	var api='api/facility/renewals/daterange?category='+$scope.category+"&startRange="+$scope.startrange+"&endRange="+$scope.endRange;
	$http.get(api)
	  	.then(function (response) {
	  		console.log(response.data);
	  		  $scope.gridOptions.data = response.data;
	 },
	 function(response) {
			$location.path('error');
			console.log("Error While getting the data"); 
		}
	  	);

}
