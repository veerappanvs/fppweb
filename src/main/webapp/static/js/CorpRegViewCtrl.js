function CorpRegViewCtrl($uibModal, $rootScope, $scope, $http,$routeParams, $window, $location) {

	$scope.countries=glob_countries;
	$scope.place_holder=[];
	$scope.place_holder.corp_name='Corporation Name';
	$scope.place_holder.corp_address1='Line 1';
	$scope.place_holder.corp_address2='Line 2';
	$scope.place_holder.corp_address_city='City';
	$scope.place_holder.corp_address_state='State';
	$scope.place_holder.corp_address_zip='Zip';
	$scope.place_holder.corp_address_country='Country Name / Code';
	$scope.place_holder.corp_lname='Last Name';
	$scope.place_holder.corp_fname='First Name';
	$scope.place_holder.corp_mname='Middle Name';
	$scope.place_holder.corp_suffix='Suffix';
	$scope.place_holder.corp_title='Title';
	$scope.place_holder.corp_phone='Phone';
	$scope.place_holder.corp_phone_ext='Phone ext';
	$scope.place_holder.corp_email='Email Address';
	$scope.place_holder.corp_prt_cmts='Parent Corporation Comments';
	$scope.isReadonly=true;
	$scope.data={};
	$scope.paramCorpId=$rootScope.corpId;
	$scope.reportcorpEnable=false;
	console.log("$scope.paramCorpId::"+$scope.paramCorpId);
	if($rootScope.modelEnabled){
			$scope.data={};
			var value=$rootScope.corpId;
			$rootScope.corpId=0;
			$http.get('api/corp/id/'+value)
		  	.then(function (response) {
		  		$scope.data.corpName=response.data.corpName;
				$scope.data.cMailadd1=response.data.cMailadd1;
				$scope.data.cMailadd2=response.data.cMailadd2;
				$scope.data.cMailcity=response.data.cMailcity;
				$scope.data.cMailstate=response.data.cMailstate;
				$scope.data.cMailzip=response.data.cMailzip;
				$scope.data.corpCountry=response.data.corpCountry;
				$scope.data.cLast=response.data.cLast;
				$scope.data.cFirst=response.data.cFirst;
				$scope.data.cMiddle=response.data.cMiddle;
				$scope.data.cSuffix=response.data.cSuffix;
				$scope.data.cTitle=response.data.cTitle;
				$scope.data.corpPhone=response.data.corpPhone;
				$scope.data.corpPhoneExt=response.data.corpPhoneExt;
				$scope.data.corpEmail=response.data.corpEmail;
				$scope.data.cComments=response.data.cComments;
				$scope.data.id=response.data.id;
		  		console.log(response.data);
		  	},
		  	function(response) {
    			$location.path('error');
    			console.log("Error While getting the data"); 
    		}
		  	
		  	);
			$scope.modelEnabled=true;
			$rootScope.modelEnabled=0;
	
	}
	$scope.Editable=function(){
		$scope.isReadonly=false;
	}
	
	

	$scope.save = function(){
	  	
	 	$scope.master = {};
	 	
	 	$scope.validation=[];
		 var valid=1;
			/*  if(!$scope.data.corpPhone || $scope.data.corpPhone=='undefined'){
				 $scope.validation.corpPhone=1;
				 valid=0;
			  } 
			  if(!$scope.data.corpPhoneExt || $scope.data.corpPhoneExt=='undefined'){
					 $scope.validation.corpPhoneExt=1;
					 valid=0;
				  } 
				  if(!$scope.data.cMailzip || $scope.data.cMailzip=='undefined'){
						 $scope.validation.cMailzip=1;
						 valid=0;
					  }
				if(!$scope.data.cMailstate || $scope.data.cMailstate=='undefined'){
							 $scope.validation.cMailstate=1;
							 valid=0;
						  } */
			  if(valid!=1){
				  $scope.validation.status=1;
				  return 0;
			  }
	  	
	 	
  		var inventory = $scope.data;
  		console.log('Inventory Data ');
  		console.log(inventory);
        $http.post('api/corp/create', inventory)
        .then(
        		function(response) {
        			$scope.data = response.data;
        		       	console.log('Added Reciept : '+response.location);
        		       	$scope.hasInserted=true;
        		       	var message = '<div class="text-center"  ><h3><b>Corporation Details Updated Successfully</b></h3></div>';
						var modalHtml = '<div class="modal-body">' + message + '</div>';
						modalHtml += '<div class="modal-footer" style="text-align:center;border-top:;"><button class="btn btn" ng-click="OK()">Ok</button>';
						var modalInstance = $uibModal.open({
							template : modalHtml,
							controller : ModalInstanceCtrl1
						});

        			
        		}, 
        	/*	function(response) {
        			console.log("Error While posting the data ---> "+response.status );
        			if(response.status==409){
    					$scope.data.isDuplicateApp=true;
    				}
        			$location.path('detail');
        		}*/
        		
        		function(response) {
	    			$location.path('error');
	    			console.log("Error While getting the data"); 
	    		}
        );  

 }
	
	var ModalInstanceCtrl1 = function($scope, $uibModalInstance) {
		$scope.OK = function() {
			//$route.reload();
			//alert("pani chesthundhi");
			/*$uibModalInstance.dismiss('cancel');
			$uibModalInstance.close();
			$scope.modalInstance.close();*/
			$window.location.reload();
		};
		
	};
	
	 $scope.ok = function () {
         $uibModalInstance.close();
       };
     
       $scope.cancel = function () {
         $uibModalInstance.dismiss('cancel');
       };




   function licenseSearch(){
		console.log("licenseSearch "+$scope.paramCorpId)
		//console.log("corp search api"+api)
		$http.get('api/fac/searchbycorpid/'+$scope.paramCorpId)
	  	.then(function (response) {
	  		console.log(response.data);
	  		$scope.gridOptions.data = response.data;
	  	},
	  	
	  	function(response) {
			$location.path('error');
			console.log("Error While getting the data"); 
		}
	  	);
		$scope.reportcorpEnable=true;
	}
	
/*	$scope.gridOptions = {
		enableColumnResize: true,
	    enableSorting: true,
	    enableFiltering: false,
	    showTreeExpandNoChildren: true,
		enableColumnResize: true
	};
	
	

	$scope.gridOptions.columnDefs = [
		{ name:  'licenseType', displayName: 'license type', width: '15%',},
		{ name:  'license',displayName: 'license no', width: '12%' },
    	{ name:  'facilityName',displayName: 'Facility Name', width: '18%' },
      	{ name:  'facilityAdd1',displayName: 'Address Line 1', width: '19%' },
      	{ name:  'facAdd2',displayName: 'Address Line 2', width: '18%'},
      	{ name:  'facState',displayName: 'State', width: '10%' },
      	{ name:  'facZip',displayName: 'Zip', width: '8%' }
      	//{ name:  'delete',cellTemplate: '<div><button class="btn btn-default" ng-click="grid.appScope.deleteFacility(row.entity.facId)"><i class="glyphicon glyphicon-trash"></i></button></div>'}
	];
	*/
	var $ctrl = this;
	var modalScope = $scope.$new();
	
	 $scope.showMe = function(value){
		 $rootScope.facModelEnabled=1;
		 $rootScope.facId=value;
		  
		 /*var modalInstance = $uibModal.open({
		      templateUrl: 'FacilityRegView.html'
		 });*/
		 
		 
		  var modalInstance = $uibModal.open({
		      templateUrl: 'FacilityRegView.html',
		      scope: modalScope
		 });
		  modalScope.modalInstance = modalInstance;
			//$scope.modalInstance.dismiss('cancel');
			  

		 
      };
      
      $scope.cancel=function(){
  		$scope.modalInstance.dismiss('cancel');
  	}	
      
   $scope.gridOptions = {
			
			enableColumnResize: true,
		    enableSorting: true,
		    enableFiltering: false,
		    showTreeExpandNoChildren: true,
		    columnDefs: [
		    	
		    	{ name:  'facilityName',displayName: 'Facility Name', width: '20%',cellTemplate: '<a class="ui-grid-cell-contents mouse_cursor" ng-click="grid.appScope.showMe(row.entity.facId)">{{COL_FIELD CUSTOM_FILTERS}}</a>'  },
		    	{ name:  'LicenseType', displayName: 'license type', width: '15%'},
		    	  { name:  'license',displayName: 'license no', width: '10%' },
		    	  
			      { name:  'facilityAdd1',displayName: 'Address Line 1', width: '30%' },
			      { name:  'facAdd2',displayName: 'Address Line 2', width: '20%'},
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
		    		  			childData.cMailadd1=facl[i].facilityAddress1;
		    		  			childData.cMailadd2=facl[i].facilityAddress2;
		    		  			childData.cMailstate=facl[i].facilityState;
		    		  			childData.cMailzip=facl[i].facilityZip;
		   		  		    }
		    		  		$scope.gridOptionsCorp.data.splice(index,0,childData);
		    		  		row.entity.nodesLoaded=1;
		    		  	});
		        	}
		        	$scope.nodeLoaded = 1;
		        });
		      }
		    
	
		  };

	
	

	licenseSearch();
	
	$scope.deleteFacility = function(value){
		  
		var message = "<h3><b>Confirmation <b></h3><div>Do you want to delete transcation?</div>";
 		var modalHtml = '<div class="modal-body">' + message + '</div>';
 		modalHtml += '<div class="modal-footer" style="text-align:center;border-top:;"><button class="btn btn" ng-click="ok()">Yes</button><button class="btn btn" style="margin-left: 12%" ng-click="cancel()">No</button></div>';
 		var modalInstance = $uibModal.open({
 			template : modalHtml,
 			controller : ModalInstanceCtrl
 		});
 		modalInstance.result.then(function() {
 			//$rootScope.tmp_facId=$scope.tmp_facId;
 			// $rootScope.fdata.id=passingValues.id;
 			$http.get('api/corp/delete/'+value).then(
 					function(response) {
	        			//$scope.facilityRegistrations.splice(recId,1);
 						licenseSearch();
 					},
 					/*function(response) {
 						licenseSearch();
 						console.log("Error While posting the data ---> "+ response.status);
 						if (response.status == 409) {
 							$scope.data.isDuplicateApp = true;
 						}
 					}
*/
 					function(response) {
		    			$location.path('error');
		    			console.log("Error While getting the data"); 
		    		}
 			);

 		});
		 
     };
     var ModalInstanceCtrl = function($scope, $uibModalInstance) {
  		$scope.ok = function() {
  			$uibModalInstance.close();
  		};
  		$scope.cancel = function() {
  			$uibModalInstance.dismiss('cancel');
  		};
  	};


}