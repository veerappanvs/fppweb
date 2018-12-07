'use strict';
function FacilityCorpSearchCtrl($uibModal, $rootScope, $scope, $http,$routeParams, $window, $location,$log) {


	$scope.place_holder={
			'license_type':'license type',
			'license_no':'license no',
			'name':'name',
			'address':'address',
	};
	
	$scope.tableHeader={
			'license_type':'license type',
			'license_no':'license no',
			'name':'name',
			'address':'address',
	};
	if($rootScope.refresh==true){
		$rootScope.transactionEditDetails=0;
		/*$location.reload();*/
	}
	$scope.reportEnable=0;
	$scope.reportfacEnable=0;
	$scope.reportcorpEnable=0;
	
	//$scope.license_type = ['','Bedding-Toys Sterilization','Food Processors','Frozen Desserts','IMS Rating','Non-alcoholic (in-of-state)','Non-alcoholic (out-of-state)','Out of State Bakeries','Vending Machines','Water Vending','Stuffed Toy','Single Service Rating','Residential Kitchen','Methyl Wood','Health Certificate'];
	$scope.license_type = global_LicenseType;
	//$scope.license_type = glob_LicenseType;
	/*$scope.license_type = ['','Bottled Water and Carbonated Non-Alcoholic Beverages (In-State)','Methyl Alcohol','Processor, Baked Goods','Processor, Food','Processor, Frozen Desserts','Processor, Residential Kitchen','Processor, Seafood','Distributor, Food','Warehouse',
	              		'Cold Storage Warehouse','Out-of-State Bakeries','Vending Machines, Food and Beverages','Vending Machines, Water Only','Bedding','Upholstered Furniture','Stuffed Toys', 'Sterilization',
	              		'Out-of-State Frozen Desserts', 'Processor, Milk(IMS Rating)','Processor, Milk(Single Service Manufacturer Rating)','Research Animals(cats and dogs)',
	              		'Export Statements','Health Certificate','Bottled Water and Carbonated Non-Alcoholic Beverages (Out-of-State)','Processor, Meat & Poultry(>$10 million annual sales)','Processor, Meat & Poultry(all other M&P processors)','Milk Laboratory State Certification',
	              		'Milk Laboratory Inspection per Procedural Specialty','Milk Laboratory Interstate Licenses','Mics.Revenue']*/		
	
	
	
	
	
	$scope.doSearch=function(){
		console.log($scope.search.facility);
		if(!$scope.search.facility)
			facSearch();
		else 
			corpSearch();
		$scope.reportEnable=1;
	}
	
	function facSearch(){
		/*var api="api/facview/all?";
		if($scope.search.license_no){
			api=api+'license='+$scope.search.license_no+'&'
		}
		if($scope.search.license_type){
			api=api+'licenseType='+$scope.search.license_type+'&'
		}
		if($scope.search.name){
			api=api+'facilityName='+$scope.search.name+'&'
		}
		if($scope.search.address){
			api=api+'facilityAdd1='+$scope.search.address+'&'
		}*/
		
var api="api/facview/all?";
		
		if(!$scope.search.license_no){
			$scope.search.license_no=''
		}
		if(!$scope.search.license_type){
			$scope.search.license_type='';
		}
		if(!$scope.search.name){
			$scope.search.name='';
		}
		if(!$scope.search.address){
			$scope.search.address='';
		}
		api=api+'facilityName='+$scope.search.name+'&facilityAdd1='+$scope.search.address+'&license='+$scope.search.license_no+'&licenseType='+$scope.search.license_type+'&corpName=&facilityCity=&facZip=';
		
		
		$http.get(api)
		  	.then(function (response) {
		  		var data=response.data;
		  		for ( var i = 0; i < data.length; i++ ){
		  		 /* { name:  'cLast', displayName: 'license type', width: '20%' },
			      { name:  'cFirst',displayName: 'license no', width: '20%' },
			      { name:  'corpName',displayName: 'name', width: '30%' },
			      { name:  'corpAdd1',displayName: 'address', width: '30%'}*/

		  			
		  			data[i].corpName=data[i].facilityName;
		  			data[i].corpAdd1=data[i].facilityAdd1;
		  			data[i].corpAdd2=data[i].facAdd2;
		  			data[i].corpState=data[i].facState;
		  			data[i].corpZip=data[i].facZip;
		  		}
		  		$scope.reportfacEnable=1;
		  		$scope.reportcorpEnable=0;
		  		  $scope.gridOptionsCorp.data = data;
		 },
		 function(response) {
 			$location.path('error');
 			console.log("Error While getting the data"); 
 		}
		  	);
	}
	function corpSearch(){
		console.log("corp search")
		var api="api/corp/all?";
		if(!$scope.search.name){
			$scope.search.name='';				
		}
		if(!$scope.search.address){
			$scope.search.address='';
				}
		api=api+'corpName='+$scope.search.name+'&corpAdd1='+$scope.search.address+'&corpAdd2=&corpCity=&corpState=&corpZip=';
		
		//console.log("corp search api"+api)
		
		$http.get(api)
		  	.then(function (response) {
		  		console.log(response.data);
		  		var data=response.data;
		  		/*
		  		for ( var i = 0; i < data.length; i++ ){
		  		     data[i].$$treeLevel =0;
		  		     data[i].baseLevel =i;
		  		     data[i].nodesLoaded =0;
		  		   }*/
		  		  $scope.gridOptions.data = data;
			  		$scope.reportfacEnable=0;
			  		$scope.reportcorpEnable=1;
		 },
		 function(response) {
 			$location.path('error');
 			console.log("Error While getting the data"); 
 		}
		  	
		  	);
	}
	$scope.corpDetail=function(name){
		alert(name);
	}
	$scope.gridOptions = {
			expandableRowTemplate: '<div ui-grid="row.entity.subGridOptions" ui-grid-edit style="height:100px;"></div>',
			expandableRowHeight: 100,
			enableColumnResize: true,
			 expandableRowScope: {
			      clickMeSub: function(){alert('hi');}
			    },	
			onRegisterApi: function (gridApi) {
					gridApi.expandable.on.rowExpandedStateChanged($scope, function (row) {
							if (row.isExpanded) {
									row.entity.subGridOptions = {
											columnDefs: [
												{ name:  'facilityName',displayName: 'Facility Name', width: '20%' },
												 { name:  'licenseType', displayName: 'license type', width: '15%',},
												 { name:  'license',displayName: 'license no', width: '10%' },
											      
											      { name:  'facilityAdd1',displayName: 'Address Line 1', width: '27%' },
											      { name:  'facAdd2',displayName: 'Address Line 2', width: '18%'},
											      { name:  'facCity',displayName: 'City', width: '18%'},
											      { name:  'facState',displayName: 'State', width: '5%' },
											      { name:  'facZip',displayName: 'Zip', width: '5%' }
									],
									enableColumnResize: true,
									};
									
									console.log(row);
									
									//$http.get('api/fac/corpid/'+row.entity.id)
									$http.get('api/fac/searchbycorpid/'+row.entity.id)
					    		  	.then(function (response) {
					    		  		
					    		  		for(var k=0;k<response.data.length;k++){
					    		  			response.data[k].licenseType2='<a onclick="showme(k)">'+response.data[k].licenseType+'</a>'
							        	}
					    		  		
					    		  		row.entity.subGridOptions.data = response.data;
					    		  		console.log(response.data);
					    		  	},
					    		  	
					    		  	function(response) {
						    			$location.path('error');
						    			console.log("Error While getting the data"); 
						    		}
					    		  	);
									
									/*$http.get('https://cdn.rawgit.com/angular-ui/ui-grid.info/gh-pages/data/100.json')
											.then(function(response) {
													row.entity.subGridOptions.data = response.data;
											});*/
							}
					});
			}
	};
	
	

	$scope.gridOptions.columnDefs = [
		 { name:  'corpName',displayName: 'Corporation Name', width: '30%',
				cellTemplate: '<a class="ui-grid-cell-contents mouse_cursor" ng-click="grid.appScope.corpDetails(row.entity.id)">{{COL_FIELD CUSTOM_FILTERS}}</a>' },
		  { name:  'cMailadd1',displayName: 'Address Line1', width: '30%'},
	      { name:  'cMailadd2',displayName: 'Address Line2', width: '20%'},
	      { name:  'cMailcity',displayName: 'City', width: '10%'},
	      { name:  'cMailstate',displayName: 'State', width: '10%'},
	      { name:  'cMailzip',displayName: 'Zip', width: '10%'}
	]
	enableColumnResize: true,
	
	$scope.corpDetails=function(value){
		  
		$rootScope.modelEnabled=true;
	     $rootScope.corpId=value;
	   /*  var modalInstance = $uibModal.open({
	       templateUrl:'CorpRegView.html',
	       controller:  function ($scope, $uibModalInstance) {
	           $scope.ok = function () {
	               $uibModalInstance.close();
	             };
	           
	             $scope.cancel = function () {
	               $uibModalInstance.dismiss('cancel');
	             };
	           }
	     });*/
	     
	     var modalInstance = $uibModal.open({
		      templateUrl: 'CorpRegView.html',
		      scope: modalScope
		 });
		  modalScope.modalInstance = modalInstance;
		  
	     
	}
	var $ctrl = this;
	var modalScope = $scope.$new();
	
	 $scope.showMe = function(value){
		 $rootScope.facModelEnabled=1;
		 $rootScope.facId=value;
		  
		 /*var modalInstance = $uibModal.open({
		      templateUrl: 'FacilityRegView.html'
		 });*/
			  
		  var modalInstance1 = $uibModal.open({
		      templateUrl: 'FacilityRegView.html',
		      scope: modalScope
		 });
		  modalScope.modalInstance = modalInstance1;
		  

		 
      };
      
      $scope.corpFacDetails = function(value){

         // alert("test");
    	  /*
 		 $rootScope.facModelEnabled=1;
 		 $rootScope.facId=value;
 		  var modalInstance = $uibModal.open({
 		      templateUrl: 'FacilityRegView.html'
 		 });
 		  */
 		 
       };


	
	
	$scope.gridOptionsCorp = {
			
			enableColumnResize: true,
		    enableSorting: true,
		    enableFiltering: false,
		    showTreeExpandNoChildren: true,
		    columnDefs: [
		    	{ name:  'facilityName',displayName: 'Facility Name', width: '20%', cellTemplate: '<a class="ui-grid-cell-contents mouse_cursor" ng-click="grid.appScope.showMe(row.entity.facId)">{{COL_FIELD CUSTOM_FILTERS}} </a>' },
		    	{ name:  'licenseType', displayName: 'license type', width: '15%' },
		    	  { name:  'license',displayName: 'license no', width: '10%'},
			   	  
			      { name:  'facilityAdd1',displayName: 'Address Line 1', width: '20%' },
			      { name:  'facAdd2',displayName: 'Address Line 2', width: '15%'},
			      { name:  'facilityCity',displayName: 'City', width: '10%' },
			      { name:  'facState',displayName: 'State', width: '5%' },
			      { name:  'facZip',displayName: 'Zip', width: '5%' }
		    ],
		    onRegisterApi: function( gridApi ) {
		        $scope.gridApi = gridApi;
		        $scope.gridApi.treeBase.on.rowExpanded($scope, function(row) {
		        	var index=0;
		        	console.log($scope.gridOptionsCorp.data.length);
		        	for(var k=0;k<$scope.gridOptionsCorp.data.length;k++){
		        		if($scope.gridOptionsCorp.data[k].$$hashKey==row.entity.$$hashKey){
		        			index=(k+1);
		        			break;
		        		}
		        	}
		        	if(row.entity.nodesLoaded==0){
		        		$http.get('api/fac/corpid/'+row.entity.id)
		    		  	.then(function (response) {
		    		  		var facl=response.data;
		    		  		var childData={};
		    		  		for ( var i = 0; i < facl.length; i++ ){		    		  			
		    		  			
		    		  			childData.corpName=facl[i].facilityName;
		    		  			childData.corpAdd1=facl[i].facilityAddress1;
		    		  			childData.corpAdd2=facl[i].facilityAddress2;
		    		  			childData.corpState=facl[i].facilityState;
		    		  			childData.corpZip=facl[i].facilityZip;
		   		  		    }
		    		  		$scope.gridOptionsCorp.data.splice(index,0,childData);
		    		  		row.entity.nodesLoaded=1;
		    		  	},
		    		  	function(response) {
			    			$location.path('error');
			    			console.log("Error While getting the data"); 
			    		}
		    		  	
		    		  	);
		        	}
		        	$scope.nodeLoaded = 1;
		        });
		      }
		    
	
		  };
	
}
