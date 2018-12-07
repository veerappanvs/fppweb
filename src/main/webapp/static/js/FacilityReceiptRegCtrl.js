function FacilityReceiptRegCtrl($uibModal,$rootScope, $scope, $http, $routeParams, $route, $location, $window) {
	
	$scope.info=[];
	$scope.info.title='Add New Transaction';
	$scope.isAdmin=$rootScope.isAdmin;
	$scope.isEditEnabled=false;
	$scope.addreceipt=true;
	$scope.checkregistry=false;
	$scope.printCheck=false;
	var date = new Date();
/*	$scope.receiptFeeDate = date.getFullYear() + '-' + ('0' + (date.getMonth() + 1)).slice(-2) + '-' + ('0' + date.getDate()).slice(-2);
*/
	$scope.data={};
	$scope.data.amount=300;
	 var editTransactionDetail = $rootScope.transactionEditDetails;
	console.log('Facility Reciept view trl  ---passingValues'+  JSON.stringify( editTransactionDetail));
	$scope.certaction = ['RENEWAL','FEE CHARGED','SCHEDULE UPDATE','PENDING','ACTIVE WAS PENDING','REFUND']
	$scope.size=10;
	
	$scope.isReadonly=false;
	 $scope.markReadonly = function(toggle){
		  $scope.isReadonly=toggle;
	 }
	 
	 $scope.editAppFn = function(toggle){
		 $scope.markReadonly(false);
		 $scope.isEditEnabled=true;
		// $scope.addPerson();
	 }
	 
	 
	 if(editTransactionDetail){
			$scope.isEditEnabled=true;
			$scope.data={};
			$scope.data = editTransactionDetail;
			$scope.data.checkno=($scope.data.checkno).trim();
			console.log('Assigning the edit details'+ JSON.stringify( $scope.data));
			console.log('Assigning the edit details'+ $scope.data.batchNo);
	 }


	 
	 $scope.addPerson = function(){
		  	console.log('$scope.data.printed --'+$scope.data.printed);
		  	console.log('$scope.printSelected --'+$scope.printSelected);
		 	$scope.master = {};
		 	$scope.data.printed=($scope.printSelected?1:0);
		  	console.log('$scope.data.printed --'+$scope.data.printed);

		 	var inventory =  $scope.data;
		 	

	  		console.log('transactoin data '+JSON.stringify(inventory));
	        $http.post('api/trans/new/'+$rootScope.tmp_facId, inventory)
	        .then(
	        		function(response) {
	        			$scope.data = response.data;
	        			$scope.markReadonly(true);
	        			$scope.isEditEnabled=true;
	        			console.log('Added Reciept : '+response.location);
	        			$scope.data.hasInserted=true;
	        			var message = "<h3>Transcation created Successfully.</h3>";
	        		     var modalHtml = '<div class="modal-body">' + message + '</div>';
	        		     modalHtml += '<div class="modal-footer" style="text-align:center;border-top:;"><button class="btn btn" ng-click="ok()">OK</button></div>';
	        		    
	        		     if(response.status==200){
			        		     var modalInstance = $uibModal.open({
			        		       template: modalHtml,
			        		       controller: ModalInstanceCtrl4
			        		     });	
	        				}
	        			
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
	 
	 $scope.editPerson = function(){
		  	
		 	$scope.master = {};
		 	//$scope.data.printed=$scope.data.printed==0?1:0;
		  	console.log('$scope.data.printSelected before--'+$scope.data.printSelected);
		 	$scope.data.printed=($scope.printSelected?1:0);
		  	console.log('$scope.data.printed --'+$scope.data.printed);
		  	
		 	var inventory =  $scope.data;
		 	console.log('$scope.data.printed '+$scope.data.printed);
	  		console.log('transactoin modify data '+JSON.stringify(inventory));
	  	//	$scope.data.facreg.facilities.facType=(facinfo.facilities.checkno.trim()) 
	        //$http.post('api/trans/new/'+$rootScope.tmp_facId, inventory)
	  		$http.post('api/trans/modify/', inventory)
	        .then(
	        		function(response) {
	        			$scope.data = response.data;
	        			$scope.markReadonly(true);
	        			$scope.isEditEnabled=true;
	        			console.log('Added Reciept : '+response.data);
	        			$scope.data.hasInserted=true;
	        			var message = "<h3>Transcation Deatils Updated Successfully.</h3>";
	        		     var modalHtml = '<div class="modal-body">' + message + '</div>';
	        		     modalHtml += '<div class="modal-footer" style="text-align:center;border-top:;"><button class="btn btn" ng-click="ok()">OK</button></div>';
	        		     var modalInstance = $uibModal.open({
	        		       template: modalHtml,
	        		       controller: ModalInstanceCtrl4
	        		     });	
	        			
	        		}, 
/*	        		function(response) {
	        			console.log("Error While posting the data ---> "+response.status );
	        			if(response.status==409){
     					$scope.data.isDuplicateApp=true;
     				}
	        			$location.path('error');
	        		}
*/	
	        		function(response) {
		    			$location.path('error');
		    			console.log("Error While getting the data"); 
		    		}
	        );  
	
	 }
	 
	 var ModalInstanceCtrl4 = function($scope, $uibModalInstance) {
		  
		   $scope.ok=function(){
			   $uibModalInstance.dismiss('cancel');
			   $rootScope.refresh=true;
				$location.url('/FCsearch');
			}
		  };
	  var ModalInstanceCtrl2 = function($scope, $uibModalInstance) {
		   $scope.cancel = function() {
		     $uibModalInstance.dismiss('cancel');
		   };
		   $scope.back=function(){
			   $uibModalInstance.dismiss('cancel');
				$location.url('/search1');
			}
		  };
	 
	

 var ModalInstanceCtrl = function($scope, $uibModalInstance) {
	   $scope.ok = function() {
	     $uibModalInstance.close();
	   };
	   $scope.cancel = function() {
	     $uibModalInstance.dismiss('cancel');
	   };
	  };
	 
	  $scope.addTransaction = function(){
	 var message = "<h3><b>Print Confirmation <b></h3><div>By Clicking Ok your details will be saved and You can Add New Transaction</div>";
	     var modalHtml = '<div class="modal-body">' + message + '</div>';
	     modalHtml += '<div class="modal-footer" style="text-align:center;border-top:;"><button class="btn btn" ng-click="ok()">Ok</button><button class="btn btn" style="margin-left: 12%" ng-click="cancel()">Cancel</button></div>';
	     var modalInstance = $uibModal.open({
	       template: modalHtml,
	       controller: ModalInstanceCtrl
	     });
	     modalInstance.result.then(function() {
	     	
	    	 $scope.info.title='Add New Transaction';
			 	$scope.master = {};

		  		var inventory = $scope.data;
		  		console.log('Inventory Data '+$scope.data); 
		  		
		        $http.post('api/gl/receiptoffees/create', inventory)
		        .then(
		        		function(response) {
		        			//$scope.data = response.data;
		        			//$scope.markReadonly(true);
		        			$scope.data.routinCode='';
		        			$scope.data.accountName='';
		        			$scope.data.checkNumber='';
		        			$scope.data.amount=300;
		        			$scope.data.appfacyname='';
		        			$scope.data.scanPrintKey='';
		        			$scope.data.appfacid='';
		        			$scope.data.payer='';
		        			$scope.data.status='';
		        			$scope.data.commentOntheFacility='';
		        			$scope.data.certification='';
		        			$scope.data.checkboxStatus=false;
		        			
		        			console.log('test');
		        			console.log(response.data);
		        			console.log('Added Reciept : '+response.location);
		        			//$scope.data.hasInserted=true;
		        			
		        		} 	        		
		        ); 
 },
 function(response) {
		$location.path('error');
		console.log("Error While getting the data"); 
	}
	     
	     ); 

	  }   
	
	 
	 $scope.reset = function(){
		 $scope.data = angular.copy($scope.master);
	 }
	
		


}