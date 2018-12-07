function CorpRegistrationCtrl($uibModal, $rootScope, $scope, $http,$routeParams, $window, $location) {
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
	
	
//	/**/
	$scope.data={};
	$scope.data.corpCountry='33';
	$scope.corp=[];
	
	if($rootScope.modelEnabled){
			$scope.corp.corp_name=$rootScope.corpdata.corpName;
			$scope.corp.corp_address1=$rootScope.corpdata.cMailadd1;
			$scope.corp.corp_address2=$rootScope.corpdata.cMailadd2;
			$scope.corp.corp_address_city=$rootScope.corpdata.cMailcity;
			$scope.corp.corp_address_state=$rootScope.corpdata.cMailstate;
			$scope.corp.corp_address_zip=$rootScope.corpdata.cMailzip;
			$scope.data.corpCountry=$rootScope.corpdata.corpCountry;
			$scope.corp.corp_lname=$rootScope.corpdata.cLast;
			$scope.corp.corp_fname=$rootScope.corpdata.cFirst;
			$scope.corp.corp_mname=$rootScope.corpdata.cMiddle;
			$scope.corp.corp_suffix=$rootScope.corpdata.cSuffix;
			$scope.corp.corp_title=$rootScope.corpdata.cTitle;
			$scope.corp.corp_phone=$rootScope.corpdata.corpPhone;
			$scope.corp.corp_phone_ext=$rootScope.corpdata.corpPhoneExt;
			$scope.corp.corp_email=$rootScope.corpdata.corpEmail;
			$scope.corp.corp_prt_cmts=$rootScope.corpdata.cComments;
		}

	/*$scope.saveReg=function(){
		alert("test111");
	 	$scope.master = {};

  		var inventory = $scope.data;
  		console.log('Inventory Data '+$scope.data);
  		console.log('inventory.facilityName '+inventory.appfacyname); 
        $http.post('api/gl/receiptoffees/create', inventory)
        .then(
        		function(response) {
        			$scope.data = response.data;
        			$scope.markReadonly(true);
        			console.log('Added Reciept : '+response.location);
        			$scope.data.hasInserted=true;
        			
        		}, 
        		function(response) {
        			console.log("Error While posting the data ---> "+response.status );
        			if(response.status==409){
    					$scope.data.isDuplicateApp=true;
    				}
        			$location.path('detail');
        		}
        		
        );
	}
	
*/	
	$scope.saveReg = function(){
		
		$scope.validation=[];
		 var valid=1;
			/*  if(!$scope.data.corpPhone || $scope.data.corpPhone=='undefined'){
				 $scope.validation.corpPhone=1;
				 valid=0;
			  } 
			  if(!$scope.data.corpPhoneExt || $scope.data.corpPhoneExt=='undefined'){
					 $scope.validation.corpPhoneExt=1;
					 valid=0;
				  } */
				  /*if(!$scope.data.cMailzip || $scope.data.cMailzip=='undefined'){
						 $scope.validation.cMailzip=1;
						 valid=0;
					  }
				if(!$scope.data.cMailstate || $scope.data.cMailstate=='undefined'){
							 $scope.validation.cMailstate=1;
							 valid=0;
						  }*/
			  if(valid!=1){
				  $scope.validation.status=1;
				  return 0;
			  }
	  	
	 	$scope.master = {};

  		var inventory = $scope.data;
  		console.log('Inventory Data '+JSON.stringify($scope.data));
        $http.post('api/corp/create', inventory)
        .then(
        		function(response) {
        			$scope.data = response.data;
        		       	console.log('Added Reciept : '+response.location);
        		       	$scope.hasInserted=true;
        		       	$scope.isReadonly=true;
        		       	$scope.buttonValue=!$scope.buttonValue;
        		       	$scope.buttonValue1=!$scope.buttonValue1;
        		       	
        		       	var message =  '<div class="text-center"  ><h3><b>Corporation created Successfully</b></h3></div>';
						var modalHtml = '<div class="modal-body">' + message + '</div>';
						modalHtml += '<div class="modal-footer" style="text-align:center;border-top:;"><button class="btn btn" ng-click="ok()">Ok</button>';
						var modalInstance = $uibModal.open({
							template : modalHtml,
							controller : ModalInstanceCtrl1
						});
        			
        		}, 
        		/*function(response) {
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
		$scope.ok = function() {
			$uibModalInstance.close();
			//$scope.modalInstance.close();
			$location.url('/DbContent');
		};
		
	};



}
