function AddRecieptCtrl($uibModal,$rootScope, $scope, $http, $routeParams, $route, $location, $window,$filter) {
	
	$scope.info=[];
	$scope.info.title='Add New Receipt';
	$scope.isAdmin=$rootScope.isAdmin;
	$scope.isEditEnabled=false;
	$scope.addreceipt=true;
	$scope.checkregistry=false;
	var date = new Date();
	$scope.receiptFeeDate = date.getFullYear() + '-' + ('0' + (date.getMonth() + 1)).slice(-2) + '-' + ('0' + date.getDate()).slice(-2);
	/*$scope.amount=300;*/
	$scope.accountName = global_LicenseType;
	
		/*['Bottled Water and Carbonated Non-Alcoholic Beverages (In-State)','Methyl Alcohol','Processor, Baked Goods','Processor, Food','Processor, Frozen Desserts','Processor, Residential Kitchen','Processor, Seafood','Distributor, Food','Warehouse',
		'Cold Storage Warehouse','Out-of-State Bakeries','Vending Machines, Food and Beverages','Vending Machines, Water Only','Bedding','Upholstered Furniture','Stuffed Toys', 'Sterilization',
		'Out-of-State Frozen Desserts', 'Processor, Milk(IMS Rating)','Processor, Milk(Single Service Manufacturer Rating)','Research Animals(cats and dogs)',
		'Export Statements','Health Certificate','Bottled Water and Carbonated Non-Alcoholic Beverages (Out-of-State)','Processor, Meat & Poultry(>$10 million annual sales)','Processor, Meat & Poultry(all other M&P processors)','Milk Laboratory State Certification',
		'Milk Laboratory Inspection per Procedural Specialty','Milk Laboratory Interstate Licenses','Mics.Revenue']*/
	$scope.status = ['RECEIVED','PROCESSED','RETURNED','APPROVED','REPLACEMENT CHECK','BOUNCE CHECK']
	$scope.certification = ['Renewal','Fee Charged','Schedule Update','Pending','Active was Pending','Refund']
	$scope.size=10;
	console.log(' AddRecieptCtrl- $scope.isAdmin = '+$scope.isAdmin);
	console.log('$scope.params   = ',$scope.params);
	$scope.data={};
	//$scope.data.amount=300;
	$scope.back=function(){
		$location.url('/');
	}
	//$scope.isReadonly=true;
	 $scope.markReadonly = function(toggle){
		  $scope.isReadonly=toggle;
	 }
	 
	 $scope.editAppFn = function(toggle){
		 $scope.markReadonly(false);
		 $scope.isEditEnabled=true;
	 }
	 console.log("$route.current.searchField  -- "+$route.current.searchField);
	 console.log("$routeParams.recieptId "+$routeParams.recieptId);
	 if(($scope.params!=undefined && $scope.params.recieptId!=undefined) || $routeParams.recieptId != undefined){
	 	var rcpid;
		 $scope.info.title='Search Receipt Details';
			$scope.isReadonly=true;
			$scope.addreceipt=false;
			if($scope.checkReg){
				
				$route.current.searchField ="check";
			}
			if($route.current.searchField =="check"){
				$scope.info.title='Check Registry Details';
				$scope.checkregistry=true;
			}
			console.log("$routeParams.recieptId  -- "+$routeParams.recieptId);
			if($scope.params!=undefined && $scope.params.recieptId!=undefined) rcpid=$scope.params.recieptId;
			else rcpid=$routeParams.recieptId;			
			$http.get('api/gl/receiptoffees/get/'+rcpid)
		    .then(
		    		function(response) {
		    			$scope.data = response.data;
		    			console.log("$scope.data ="+$scope.data.status); 
		    			console.log($scope.data);
		    			$scope.data.status=$scope.data.status.trim();
		    			console.log("$scope.data after trim  ="+$scope.data.status);
		    			console.log("$scope.data after trim  ="+$scope.data.accountName);
		    			$scope.data.checkNumber=$scope.data.checkNumber.trim();
		    			
		    			$scope.receiptFeeDate=$scope.data.receiptFeeDate;
		    			if($scope.data.amount!=null) {
		    				$scope.data.amount=parseInt($scope.data.amount);
		    			}
		    			
		    			
		    			console.log("$scope.data after trim  ="+$scope.data.accountName);
		    			$scope.markReadonly(true);
		    			//Cloning to avoid the mutability fo the source date -- moments is function provided by moment.js
		    			// $scope.data.thirdDOB = moment(response.data.dateOfBirth).clone().add(3, 'month').format('YYYY-MM-DD');; 
		    			// console.log("scope.data.thirdDOB= : "+ $scope.data.thirdDOB);
		    		}, 
		    		function(response) {
		    			$location.path('error');
		    			console.log("Error While getting the data"); 
		    		}
		    );
		}
	 else{
		 console.log("$routeParams.recieptId is empty "+$routeParams.recieptId );
		 console.log("$scope.recieptId is empty "+$scope.recieptId );
		// console.log("recieptId is empty "+recieptId );
		 
	 }
	 $scope.facilityNameArr=[];
	 $scope.showSearchResults = function(){
		console.log("getFacilityName::"+$scope.data.appfacyname);
		
		
		if($scope.data.appfacyname.length > 4)
		{
		
		$http.get('api/facility/all?facilityName='+$scope.data.appfacyname)
	    .then(
	    		function(response) {
	    			console.log("$scope.facilityNameArr length ="+response.data.length); 
	    			if(response!=null && response.data!="undefined" && response.data.length>0){
		    			for(var i=0;i<response.data.length;i++){
		    				$scope.facilityNameArr.push(response.data[i].facilityName+response.data[i].facilityAddress1+" Id:"+response.data[i].id);
		    			}
	    			} else {console.log("elsseeeeeeeeeeeeeeeeeeeee");
	    				$scope.facilityNameArr=[];
	    			}
	    			console.log("$scope.facilityNameArr ="+$scope.facilityNameArr); 
	    		}, 
	    		function(response) {
	    			console.log("Error While getting the data"); 
	    		}
	    );
		
		
	 }
		
	 };

	 $scope.fillFacilityNameTextBox= function(string){
		 console.log("string:"+string+"  Length : "+string.length);
		 $scope.data.appfacyname=string;
		 $scope.facilityNameArr=[];
		 $scope.data.appfacid = string.slice(-6) ;
		 $scope.data.applicant = string.substr(0, string.indexOf(',')); 
		 console.log('$scope.data.appfacid :'+$scope.data.appfacid+'  Sliced : '+string.slice(-6)  +'$scope.data.application = '+$scope.data.applicant) ;
	 }
	 
	 var ModalInstanceAppPersonCtrl = function($scope, $uibModalInstance) {
		   $scope.ok = function() {
		    // location.reload();
			   $location.path('/');
			   $uibModalInstance.dismiss('cancel');
		   };
		   $scope.cancel = function() {
		     $uibModalInstance.dismiss('cancel');
		   };
		  };
		 
		  
	 $scope.addPerson = function(){
		  	
		 	$scope.master = {};
		 	$scope.data.receiptFeeDate=$scope.receiptFeeDate;

	  		var inventory = $scope.data;
	  		console.log('Inventory Data '+JSON.stringify($scope.data));
	  		console.log('inventory.facilityName '+inventory.appfacyname); 
	        $http.post('api/gl/receiptoffees/create', inventory)
	        .then(
	        		function(response) {
	        			
	        			var message = '<div class="text-center"  ><h3><b>Your Details Saved Successfully</b></h3></div>';
	        		     var modalHtml = '<div class="modal-body">' + message + '</div>';
	        		     modalHtml += '<div class="modal-footer" style="text-align:center;border-top:;"><button class="btn btn" ng-click="ok()">Ok</button></div>';
	        		     var modalInstance = $uibModal.open({
	        		       template: modalHtml,
	        		       controller: ModalInstanceAppPersonCtrl
	        		     });
	        		     modalInstance.result.then(function() {
	        	$scope.markReadonly(false);
	        			});
	        		     
	        			$scope.data = response.data;
	        			$scope.markReadonly(true);
	        			console.log('Added Reciept : '+response.location);
	        			$scope.data.hasInserted=true;
	        			
	        		}, 
	        		function(response) {
	        			/*console.log("Error While posting the data ---> "+response.status );
	        			if(response.status==409){
        					$scope.data.isDuplicateApp=true;
        				}*/
	        			$location.path('error');
	        		}
	        		
	        );  
	
	 }
	 
	 
	 $scope.copyAppName   = function(applicant){
		 console.log("appName "+applicant);
		 $scope.data.payer = $scope.data.applicant;
		 
	 }
	 $scope.editPerson 	= function(){
 var message = '<div class="text-center"  ><h3><b>Are you sure to edit these details</b></h3></div>';
	     var modalHtml = '<div class="modal-body">' + message + '</div>';
	     modalHtml += '<div class="modal-footer" style="text-align:center;border-top:;"><button class="btn btn" ng-click="ok()">Ok</button><button class="btn btn" style="margin-left: 12%" ng-click="cancel()">Cancel</button></div>';
	     var modalInstance = $uibModal.open({
	       template: modalHtml,
	       controller: ModalInstanceCtrl
	     });
	     modalInstance.result.then(function() {
$scope.markReadonly(false);
		});
	 }
	 
	  var ModalInstanceCtrl2 = function($scope, $uibModalInstance) {
		   $scope.cancel = function() {
		     $uibModalInstance.dismiss('cancel');
		   };
		   $scope.back=function(){
			   $uibModalInstance.dismiss('cancel');
				//$location.url('/');
				$window.location.reload();
			}
		  };
	 
	 $scope.savePerson = function(){
		 $scope.data.receiptFeeDate=$scope.receiptFeeDate;
		 var inventory = $scope.data;
	  		console.log('Inventory Data put   '+JSON.stringify($scope.data)); 
	  		$scope.markReadonly(true);
	  		$scope.data.hasInserted=false;
	  		console.log('Marking readonly '+$scope.isReadonly); 
	        $http.put('api/gl/receiptoffees/modify', inventory)
	        .then(
	        		function(response) {
					     var message = "Details Saved Successfully..!";
					     var modalHtml = '<div class="modal-body">' + message + '</div>';
					     modalHtml += `<div class="modal-footer" style="text-align:center;border-top:;">
					    	 <button class="btn" style="margin-left: 12%" ng-click="back()">OK</button></div>`;
					     var modalInstance = $uibModal.open({
					       template: modalHtml,
					       controller: ModalInstanceCtrl2
					     });
					     modalInstance.result.then(function() {
					     	console.log("calling print");
					       $scope.getDataForURI('api/gl/batchnumbers/print');
					     });	
					  
					     
	        			$scope.detail = response.data;
	        			console.log('Reciept Data put after response '+response.data); 
		    			$scope.isSuccess=true;
	        			console.log("isSuccess "+$scope.isSuccess);
	        			//$location.path('dsiweb/dashboard#!/detail/'+$scope.data.id);
		        		}, 
		        		function(response) {
		        			$window.location.reload();
		        			$location.path('error');
		        			console.log("Error While modifying the Reciept data "+response); 
		        		}
	        );  
	
	 }

 var ModalInstanceCtrl = function($scope, $uibModalInstance) {
	   $scope.ok = function() {
	     $uibModalInstance.close();
	   };
	   $scope.cancel = function() {
	     $uibModalInstance.dismiss('cancel');
	   };
	  };
	 
	  $scope.addTransaction = function(){
	 var message = '<div class="text-center"  ><h3><b>By Clicking Ok your details will be saved and You can Add New Transaction</b></h3></div>';
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
		  		$scope.data.receiptFeeDate= $filter('date')($scope.receiptFeeDate, "yyyy-MM-dd");
		  		
		  		console.log('Inventory Data '+$scope.data); 
		  		
		        $http.post('api/gl/receiptoffees/create', inventory)
		        .then(
		        		function(response) {
		        			//$scope.data = response.data;
		        			//$scope.markReadonly(true);
		        			$scope.data.routinCode='';
		        			$scope.data.accountNumber=response.data.accountNumber;
		        			$scope.data.accountName=response.data.accountName;
		        			$scope.data.checkNumber='';
		        			$scope.data.amount=response.data.amount;
		        			$scope.data.applicant='';
		        			$scope.data.appfacyname='';
		        			$scope.data.scanPrintKey='';
		        			$scope.data.appfacid='';
		        			$scope.data.payer='';
		        			$scope.data.status=response.data.status;
		        			$scope.data.commentOntheFacility='';
		        			$scope.data.certification='';
		        			$scope.data.checkboxStatus=false;
		        			
		        			console.log('test');
		        			console.log(response.data);
		        			console.log('Added Reciept : '+response.location);
		        			//$scope.data.hasInserted=true;
		        			
		        		
		        		},
		        		function(response) {
		        			//$window.location.reload();
		        			$location.path('error');
		        			console.log("Error While modifying the Reciept data "+response); 
		        		}
		        		
		        ); 
 }); 

	  }   
	 
	 
/*	 
	 $scope.removePerson = function($location, $window){
		 if(confirm('Are you sure to delete these details')){
			 console.log('Inventory ss Data delete '+$scope.data.id); 
			 $scope.markReadonly(false);
			 //var inventory = $scope.data;
			  $http.delete('api/gl/receiptoffees/delete/'+$scope.data.id)
		        .then(
		        		
		        		function(response) {
		        			 //$scope.reset();
		        			$scope.data = response.data;
		        			 console.log('Reciept Data deleted successfully '); 
			        		//$location.path('#!detail');
			        		//console.log('location.path = '+$location.absUrl());
		        			 window.location.href = '#!detail';
		        			 //$location.url = '#!detail';

		        		}, 
		        		function(response) {
		        			console.log("Error While deleting the Reciept data"+response); 
		        		}
		        		
		        );   
		 }
	 }*/
	 
	  
 $scope.removePerson = function(){
		  
		  var message = "<h3><b>Confirmation <b></h3><div>Do you want to delete receipt?</div>";
      		var modalHtml = '<div class="modal-body">' + message + '</div>';
      		modalHtml += '<div class="modal-footer" style="text-align:center;border-top:;"><button class="btn btn" ng-click="ok()">Yes</button><button class="btn btn" style="margin-left: 12%" ng-click="cancel()">No</button></div>';
      		var modalInstance = $uibModal.open({
      			template : modalHtml,
      			controller : ModalInstanceCtrl4,
      			scope: $scope
      		});
      		
      		

	 }
	 
	 
	          var ModalInstanceCtrl4 = function($scope, $uibModalInstance) {
     		$scope.ok = function() {
     			

     			 $scope.markReadonly(false);
    			 //var inventory = $scope.data;
    			  $http.delete('api/gl/receiptoffees/delete/'+$scope.data.id)
    		        .then(
    		        		
    		        		function(response) {
    		        			 //$scope.reset();
    		        			$scope.data = response.data;
    		        			 console.log('Reciept Data deleted successfully '); 
    			        		//$location.path('#!detail');
    			        		//console.log('location.path = '+$location.absUrl());
    		        			 //window.location.href = '#search1';
    		        			$location.url('/DbContent');

    		        		}, 
    		        		function(response) {
    		        			$location.path('error');
    		        			console.log("Error While deleting the Reciept data"+response); 
    		        		}
    		        		
    		        );
			  
     			//alert("test"+$scope.data.id);
     			//$rootScope.refresh=true;
     			//$uibModalInstance.close();
     			//$location.url('/');
     			$window.location.reload();
     		};
     		$scope.cancel = function() {
     			$uibModalInstance.dismiss('cancel');
     			//$window.location.reload();
     		};
     	}
	  
	  
	 $scope.reset = function(){
		 $scope.data = angular.copy($scope.master);
	 }
	 
	 $scope.ProdCategory =global_LicenseType;
		
	 $scope.productsByCat=global_RevenueSrCode;
	 
	 
	/* $scope.ProdCategory = ['','Bottled Water and Carbonated Non-Alcoholic Beverages (In-State)','Methyl Alcohol','Processor, Baked Goods','Processor, Food','Processor, Frozen Desserts','Processor, Residential Kitchen','Processor, Seafood','Distributor, Food','Warehouse',
			'Cold Storage Warehouse','Out-of-State Bakeries','Vending Machines, Food and Beverages','Vending Machines, Water Only','Bedding','Upholstered Furniture','Stuffed Toys', 'Sterilization',
			'Out-of-State Frozen Desserts', 'Processor, Milk(IMS Rating)','Processor, Milk(Single Service Manufacturer Rating)','Research Animals(cats and dogs)',
			'Export Statements','Health Certificate','Bottled Water and Carbonated Non-Alcoholic Beverages (Out-of-State)','Processor, Meat & Poultry(>$10 million annual sales)','Processor, Meat & Poultry(all other M&P processors)','Milk Laboratory State Certification',
			'Milk Laboratory Inspection per Procedural Specialty','Milk Laboratory Interstate Licenses','Mics.Revenue'];*/
	 
	/*	$scope.productsByCat[1] = ['3066'];
		$scope.productsByCat[2] = ['3065'];
		$scope.productsByCat[3] = ['0604'];
		$scope.productsByCat[4] = ['0604'];
		$scope.productsByCat[5] = ['0604'];
		$scope.productsByCat[6] = ['0604'];
		$scope.productsByCat[7] = ['0604'];
		$scope.productsByCat[8] = ['0604'];
		$scope.productsByCat[9] = ['0604'];
		$scope.productsByCat[10] = ['0604'];
		$scope.productsByCat[11] = ['0606'];
		$scope.productsByCat[12] = ['3024'];
		$scope.productsByCat[13] = ['3024'];
		$scope.productsByCat[14] = ['3022'];
		$scope.productsByCat[15] = ['3022'];
		$scope.productsByCat[16] = ['3022'];
		$scope.productsByCat[17] = ['3022'];
		$scope.productsByCat[18] = ['3068'];
		$scope.productsByCat[19] = ['3000'];
		$scope.productsByCat[20] = ['3005'];
		$scope.productsByCat[21] = ['0605'];
		$scope.productsByCat[22] = ['3029'];
		$scope.productsByCat[23] = ['3029'];
		$scope.productsByCat[24] = ['3066'];
		$scope.productsByCat[25] = ['3025'];
		$scope.productsByCat[26] = ['3025'];
		$scope.productsByCat[27] = ['0684'];
		$scope.productsByCat[28] = ['0684'];
		$scope.productsByCat[29] = ['0684'];
		$scope.productsByCat[30] = ['6900'];*/
		
		
		console.log("test");
		
		$scope.getProductsforCat=function(index){
			var element="accountName";
			var key = $scope.ProdCategory.indexOf($scope.data[element]);
			$scope.data.accountName=$scope.data[element];
			var element="product"+index+"_products";
			$scope.data.accountNumber=$scope.productsByCat[key];
			$scope.data.amount=global_Fee[key];
			//console.log ('amount 1'+glob_licensetypeWithFee[key].fee);
			
			console.log ('amount '+global_Fee[key]);
		}
		
		if($rootScope.revise!=0){
			/*alert($rootScope.amount);*/
			/*alert("test"+$scope.data.amount+$rootScope.amount);*/
			if($rootScope.amount)
			$scope.data.amount=$rootScope.amount;
			$rootScope.revise=0;
		}

}