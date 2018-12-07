function GenerateBatchNumCtrl($uibModal, $rootScope, $scope, $http,$routeParams, $window, $location) {

	$scope.checked=false;
	$scope.isEditEnabled=false;
	$scope.isSuccess=false;
	$scope.isAdmin=$rootScope.isAdmin;
	$scope.batchNumberToExport=[];
	$scope.isBatchExportEnable=false;
	
	$scope.master = {};
	console.log(' GenerateBatchCtrl- $scope.isAdmin = '+$scope.isAdmin);
	 
	$scope.init=function() {
		$scope.getLastBatchNo('api/gl/batchnumbers/get-last-batch');
	}
	 $scope.markReadonlyDetail = function(toggle){
		 

		 zscope.isReadonly=toggle;
	 }
	 var dateTemplate = '<div ng-if="row.entity.code">{{row.entity.code}}</div>' +
	    '<div ng-if="!row.entity.code">___/___/_____</div>';

	  var assignTemplate = '<div ng-if="row.entity.name">{{row.entity.name}}</div>' +
	    '<div ng-if="!row.entity.name">________________________</div>';
	  var amountTemplate = '<div ng-if="row.entity.name">{{row.entity.name}}</div>' +
	    '<div ng-if="!row.entity.name">$__.__</div>';
	  var revenuesourcecodeTemplate = '<div ng-if="row.entity.name">{{row.entity.name}}</div>' +
	    '<div ng-if="!row.entity.name">________________________</div>';

	 $scope.gridOptions = {
			 columnDefs: [
				/* {name: 'batchNumber', displayName: 'batchNumber', width: '10%', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <a ng-href="#!batchnumgeneration/{{COL_FIELD}}">{{COL_FIELD}}</a></div>'},*/
				 { name:  'batchNumber', displayName: 'Batch Number', width: '20%',   enableCellEdit: false },
				 { name:'receiptFeeDate', displayName: 'Receipt of fees date', width: '20%', cellTemplate: dateTemplate, enableCellEdit: false, }, 
		        {name:'runBy', displayName: 'Assigned to', width: '20%', cellTemplate: assignTemplate, enableCellEdit: false, },
		        { name:'amount', displayName: 'Received Amt',  width: '20%', cellTemplate: amountTemplate, enableCellEdit: false}, 
		        {name:'acct_no', displayName: 'Revenue Source Code',  width: '20%', cellTemplate: revenuesourcecodeTemplate, enableCellEdit: false},
		        ], 
				rowHeight: 38,
				enableColumnResize: false,
			    enableFiltering: false,     
			    enableRowSelection: false,
			    enableRowHeaderSelection: false,
			    selectionRowHeaderWidth: 35,  
			    noUnselect: true,
				exporterMenuPdf: false,
				enableGridMenu: false,
			    enableSelectAll: false,
			    exporterCsvFilename: 'myFile.csv',    
			    exporterCsvLinkElement: angular.element(document.querySelectorAll(".custom-csv-link-location")),
			    onRegisterApi: function(gridApi){
			    $scope.gridApi = gridApi;
			    }
			  };

	 $scope.getDataForURI = function(uri){
		 // console.log("Getting the detail page1 "+$scope.searchText);
		  $http.get(uri)
		  	.then(function (response) {
		  		console.log(response.data);
		      $scope.gridOptions.data = response.data;
		      if(response.data.length>1){
		      $scope.lastBatchNumber=response.data[response.data.length-1].batchNumber;
		      }	
		  		//$scope.gridOptions.data =GetDataForURIFactorySvc;
		  		$scope.data = response.data;
		      console.log("response.data Text :  "+response.data.BatchNumbers);
		  		console.log("Created batch Number gridOptions="+$scope.gridOptions.data.length)
		  		if(response.data.length >0){
		    	  	$scope.checked=true;
		    	  	$scope.isBatchExportEnable=true;
		  		}
		    },
		  	function(response) {
    			$location.path('error');
    			console.log("Error While getting the data"); 
    		}
		  	
		  	);
	  }; 
	 

	  var ModalInstanceCtrl = function($scope, $uibModalInstance) {
	   $scope.ok = function() {
	     $uibModalInstance.close();
	   };
	   $scope.cancel = function() {
	     $uibModalInstance.dismiss('cancel');
	   };
	  };

	  $scope.generatebatchNumbers = function(){
	  console.log("generatebatchNumbers");

	     var message = '<div class="text-center"  ><h3><b>Are you sure You want to Generate 22 Batch Numbers</b></h3></div>';
	     var modalHtml = '<div class="modal-body">' + message + '</div>';
	     modalHtml += '<div class="modal-footer" style="text-align:center;border-top:;"><button class="btn btn" ng-click="ok()">Yes</button><button class="btn btn" style="margin-left: 12%" ng-click="cancel()">No</button></div>';
	     var modalInstance = $uibModal.open({
	       template: modalHtml,
	       controller: ModalInstanceCtrl
	     });
	     modalInstance.result.then(function() {
	     	console.log("calling print");
	       $scope.getDataForURI('api/gl/batchnumbers/print');
	     }
	     /* , function(response) {
 			$location.path('error');
 			console.log("Error While getting the data"); } 
 */		
	     
	     );	
	  };
	  
//	 $scope.generatebatchNumbers = function(){
//		 console.log("generatebatchNumbers");
//		 
//		 
//		
//              if ($window.confirm("Are you sure want to generate batch numbers")) {
//                  $scope.Message = " YES ";
//                  $scope.getDataForURI('api/gl/batchnumbers/print');
//              } else {
//                  $scope.Message = " NO ";
//                  //$scope.getDataForURI('');
//              }
//                          
//	 };
	 
	 $scope.getlastbatchNumbers = function(){
		 console.log("getlastbatchNumbers");
		  $scope.getDataForURI('api/gl/batchnumbers/get-last-batch');
	 };
	 
	 $scope.batchNumberExportToPdf = function(){
		 console.log("batchNumExportToPdf ",$scope.gridOptions.data);
		 $scope.batchNumberToExport=[];
		 angular.forEach($scope.gridOptions.data,function(value,key){
			 console.log(value+" "+key);
			 $scope.batchNumberToExport.push(parseInt(value.batchNumber));
		 });		 
		 console.log("$scope.batchNumberToExport",$scope.batchNumberToExport);
		  $http.post('api/gl/batchnumbers/generateBatchPdf',$scope.batchNumberToExport)
		  	.then(function (response) {
		  	//	window.open(response.data);
		  		var link = document.createElement('a');
				   link.href = response.data;//window.URL.createObjectURL(blob);
				   link.download = "BatchReport.pdf";
				   link.click();
		    },/*function(error){
		    	console.log("errror occured");
		    	}
		    	*/
		    function(response) {
    			$location.path('error');
    			console.log("Error While getting the data"); 
    		}
		    );
	 };
	 
	
	 $scope.getLastBatchNo = function(uri){
		 // console.log("Getting the detail page1 "+$scope.searchText);
		  $http.get(uri)
		  	.then(function (response) {
		  		console.log(response.data);
		      $scope.gridOptions.data = response.data;
		      if(response.data.length>1){
		      $scope.lastBatchNumber=response.data[response.data.length-1].batchNumber;
		      }	
		  	
		  		
		    },
		    function(response) {
    			$location.path('error');
    			console.log("Error While getting the data"); 
    		}
		  	
		  	);
	  }; 
	 
}