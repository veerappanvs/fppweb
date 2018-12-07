function checkregistryCtrl($uibModal, $rootScope, $scope, $http, $location) {
	 
	$scope.isSuccess=false;
	$scope.isCheckRegister=false;
	$scope.isAdmin=$rootScope.isAdmin;
	
	$scope.master = {};
	console.log(' SearchReceiptCtrl- $scope.isAdmin = '+$scope.isAdmin);
	 
	
	 $scope.items = ['','Low','Medium','High']
	 $scope.criticals = ['','Critical','Non-Critical']
	 $scope.hostedAts = ['','VG','MassIT', 'AWS', 'Hosted by Vendor', 'Other']		
     $scope.yesnos = ['', 'Yes', 'No']
	 $scope.dataclassficationvals = ['', 'Restricted', 'Private', 'Public']
		
	
	 $scope.markReadonlyDetail = function(toggle){
		  $scope.isReadonly=toggle;
	 }
	 
	 $scope.editAppFn = function(toggle){
		 console.log("Editapp");
		 $scope.markReadonlyDetail(false);
		 $scope.isEditEnabled=true;
	 }
	
	 $scope.savePersonDetail = function(){
		  
	  		var inventory = $scope.detail;
	  		console.log('Inventory Data put'+$scope.detail);
	  		
	  	 	if(!($scope.detail.hostedAt == 'Other'))
		 	{
		 		console.log('Changin the other value  '+$scope.detail.hostedAtOthers); 
		 		$scope.detail.hostedAtOthers = '';
		 		console.log('Changin the other value after  '+$scope.detail.hostedAtOthers); 
		 	}
	  	 	
	  	 	if(!($scope.detail.accessDatabaseYOrN == 'No'))
		 	{
		 		console.log('Changin the other value  '+$scope.detail.hostedAtOthers); 
		 		$scope.detail.nonAccessDatabaseType = '';
		 		console.log('Changin the other value after  '+$scope.detail.hostedAtOthers); 
		 	}
	  		
	  		$scope.markReadonlyDetail(true);
	  		console.log('Marking readonly '+$scope.isReadonly); 
	        $http.put('inv/inventory', inventory)
	        .then(
	        		
	        		function(response) {
	        			$scope.detail = response.data;
	        			console.log('Inventory Data put after response '+response.data); 
		    			$scope.isSuccess=true;
	        			console.log("isSuccess "+$scope.isSuccess);
	        			
	        		}, 
	        		function(response) {
	        			$location.path('error');
	        			console.log("Error While posting the data"+response); 
	        			//$location.path('/detail/'+$scope.data.id);
	        		}
	        );  
	 }
	 
	
	 $scope.reset = function(){
		// $scope.data = angular.copy($scope.master);
		// $scope.detail = angular.copy($scope.master);
	 }
	 
	 
	 $scope.removePersonDetail = function($location){
		 console.log('Inventory Data delete '+$scope.detail.id); 
			$scope.markReadonlyDetail(false);
		  $http.delete('api/gl/receiptoffees/delete/id/'+$scope.detail.id)
	        .then(
	        		
	        		function(response) {
	        			$scope.reset()
	        			$scope.detail = response.data;
	        			$scope.confidentiality = $scope.detail.confidentiality;
	        			//$scope.data = response.data;
	        			 console.log('Inventory Data deleted successfully '); 
	        			 //window.location.href = '#!detail';
	        			 //$location.url = '#!detail';
	        		}, 
	        		function(response) {
	        			$location.path('error');
	        			console.log("Error While posting the data --"+response); 
	        		}
	        		
	        );  
	 }
	
	  $scope.getDetail = function (id) {
		  console.log("openDetail "+id);
		 // $scope.showDetail(id);
		  app.value("detailId", id);
		  
		 // $http.get('inv/inventory/'+id)
		  $http.get('api/gl/receiptoffees/get/'+id)
		    .then(
		    		function(response) {
		    			$scope.detail = response.data;
		    			$scope.markReadonlyDetail(true);
		    			console.log("getting the data"+$scope.detail); 
		    		}, 
		    		function(response) {
		    			$location.path('error');
		    			console.log("Error While getting the data"); 
		    		}
		    );
		  };
		  

	$scope.showReceiptDetailModal = function (recieptId) {
		    //console.log($scope);
		  console.log("showReceiptDetailModal "+recieptId);
		 
		  
		    //$routeParams.class=b;
		    //$routeParams.recieptId=recieptId;
		    var scope = $rootScope.$new();
 			scope.params = {recieptId: recieptId};
 			scope.checkReg=true;
		    var modalInstance = $uibModal.open({
		    	//templateUrl: '#!/addreciept'
		    	 //templateUrl: '#/recieptdetail/'+receieptId,
		    	
		    	 templateUrl: 'AddReceiptModal.html',
			     controller: 'AddRecieptCtrl',
			     
			     animation: true,
			     backdrop: true,
			      scope: scope,
			      
			      //, 
			     // resolve: {
			     //       scope: function () {
			     //                        $scope.recieptId = recieptId;
			     //                       // $scope.properties.id = b;
			     //                        return $scope.recieptId;
			     //                    }
			     //       }
		    });
		  
	}

	  $scope.changCellTemplate = function () {
	    	console.log("Changing celltemplate");
		    if (!$scope.isCheckRegister) {
		    	console.log("Setting the value as search regis");
		      $scope.gridOptions.columnDefs[1].cellTemplate = 'I<div class="ui-grid-cell-contents"> <a ng-href="#!recieptdetail/{{COL_FIELD}}">{{COL_FIELD}}</a></div>';
		    } else {
		    	console.log("Setting the value as check regis");
		      $scope.gridOptions.columnDefs[1].cellTemplate = '<div class="ui-grid-cell-contents"> <a ng-href="#!recieptdetail/check/{{COL_FIELD}}">{{COL_FIELD}}</a></div>';
		    }
		    $scope.gridApi.core.notifyDataChange(uiGridConstants.dataChange.COLUMN);
		  }
	  
	  
	  $scope.gridOptions = {
			  
	    columnDefs: [
	    	//{ name: 'id',  ,, enableCellEdit: false },
	    	//{name: 'id', displayName: 'Id', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <button class="btn" type="button"   ng-click="grid.appScope.showReceiptDetailModal(row.entity.id)">{{COL_FIELD}}	</button></div>'},
	        //{name: 'id', displayName: 'Id', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <button class="btn" type="button"  data-toggle="modal" data-target="#myModal"  ng-click="grid.appScope.getDetail(row.entity.id)">{{COL_FIELD}}	</button></div>'},
	    	//{name: 'id', displayName: 'Id', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <button class="btn-link" type="button"  data-toggle="modal" data-target="#myModal"  ng-click="grid.appScope.getDetail(row.entity.id)">{{COL_FIELD}}</button></div>'},
	        //{name: 'id', displayName: 'Id', width: '6%', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <a ng-href="#!recieptdetail/check/{{COL_FIELD}}">{{COL_FIELD}}</a></div>'},
	        {name: 'id', displayName: 'Id', width: '6%', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <a   ng-click="grid.appScope.showReceiptDetailModal(row.entity.id)">{{COL_FIELD}}</a></div>'},
	    	 
	        /*href="#!recieptdetail/check/{{COL_FIELD}}"*/

	    	{ name: 'applicant', displayName: 'Appplicant' ,width: '15%', enableCellEdit: false },
	        { name: 'payer', displayName: 'Payer', width: '15%', enableCellEdit: false }, 
	        { name: 'checkNumber', displayName: 'Check No', width: '8%', enableCellEdit: false},
	        { name: 'amount', displayName: 'Amount',  width: '7%',enableCellEdit: false}, 
	        { name: 'status', displayName: 'Status',  width: '8%',enableCellEdit: false},
	        { name: 'batchNumber', displayName: 'Batch No',  width: '8%',enableCellEdit: false},
	        { name: 'dateReceived', displayName: 'Entry Time',  width: '9%',enableCellEdit: false}, 
	        { name: 'accountName', displayName: 'License Type',  width: '10%',enableCellEdit: false}, 
	        { name: 'transmittalDate', displayName: 'Transmittal Date',  width: '15%',enableCellEdit: false} 
	         
	       // {name: 'button', displayName: 'View', enableCellEdit: false, cellTemplate: '<button ng-click="getExternalScopes().onClick(row.entity.id)">view1</button>'}
	        //{name: 'button', displayName: 'View', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <button class="btn" type="button" ng-click="grid.appScope.Main.openDetail(row.entity.id)">View Detail</button></div>'}, 

	        //{name: 'id', displayName: 'ID', width: '5%', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <a ng-href="#!detail/{{COL_FIELD}}">{{COL_FIELD}}</a></div>'},
	        //{name:'id', displayName: 'Id ',  width: '5%', cellTemplate: '<a href ng-click="detailPerson()" >{{COL_FIELD}}</a>'}
	  	], 
		rowHeight: 38,
	    enableColumnResize: true,
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
		      $scope.gridOptions.data = response.data;
		  		//$scope.gridOptions.data =GetDataForURIFactorySvc;
		  		$scope.data = response.data;
		      //console.log("Search Text :  "+$scope.searchText);
		      if(response.data.length >0)
		    	  	$scope.checked=true;
		    },
		    function(response) {
    			$location.path('error');
    			console.log("Error While getting the data"); 
    		}
		  	
		  	);
	  };
	  
	  $scope.showSearchResults = function(batchNumber, accountNumber, receiptFeeDate ){
		  //console.log("Getting the detail page "+batchNumber);
		  var str = $scope.batchNumber;
		 // console.log("Getting the detail page - length "+batchNumber.length);
		  if(!(batchNumber == null) || (SearchReceiptCtrl !== null) ||  !(receiptFeeDate != null)  ){
			 // $scope.getDataForURI('http://localhost:8080/eiweb/person/get?name='+$scope.batchNumber);
			  //$scope.getDataForURI('inv/inventory/get?name='+$scope.batchNumber);
			  var d = new Date(receiptFeeDate);
			  
			  var formatteddate = d.getFullYear()+'-'+(d.getMonth()+1)+'-'+d.getDate();
			  console.log("before formatteddate"+receiptFeeDate);
			  console.log("formatteddate"+formatteddate);
			  console.log("batchNumber : "+batchNumber +" SearchReceiptCtrl "+accountNumber+" receiptFeeDate  "+formatteddate);
			  $scope.getDataForURI('api/gl/receiptoffees/get/all/?batchNumber='+$scope.batchNumber+'&accountNumber='+accountNumber+'&receiptFeeDate='+formatteddate);
			  //$scope.getDataForURI('api/gl/receiptoffees/get/all/?batchNumber=0562365&accountNumber=3022&receiptFeeDate=2018-02-20');
			 // $scope.getDataForURI('api/gl/receiptoffees/get/all/?batchNumber=0562365&accountNumber=3022&receiptFeeDate=2018-02-20');
	      }else 
		  //$scope.getDataForURI('api/gl/receiptoffees/get/all/?batchNumber=0562365&accountNumber=3022&receiptFeeDate=2018-02-20');
			  $scope.checked=false;
	  };
	  
	  
	  $scope.showCheckRegSearchResults = function(applicant, payer, checknumber ){
		  console.log("showCheckRegSearchResults");
		  $scope.isCheckRegister=true;
		 // $scope.changCellTemplate();
		 // $scope.gridOptions.columnDefs[1].cellTemplate = '<div class="ui-grid-cell-contents"> <a ng-href="#!recieptdetail/check/{{COL_FIELD}}">{{COL_FIELD}}</a></div>';
		  //$scope.gridApi.core.notifyDataChange(uiGridConstants.dataChange.COLUMN);
		  //console.log("Getting the detail page "+batchNumber);
		 // console.log("Getting the detail page - length "+batchNumber.length);
		  if(!(applicant == null) || (payer !== null) ||  !(checknumber != null)  ){
			 // $scope.getDataForURI('http://localhost:8080/eiweb/person/get?name='+$scope.batchNumber);
			  //$scope.getDataForURI('inv/inventory/get?name='+$scope.batchNumber);
			  console.log("applicant : "+applicant +" payer "+payer+" checknumber  "+checknumber);
			  $scope.getDataForURI('api/gl/receiptoffees/check/?applicant='+applicant+'&payer='+payer+'&checknumber='+checknumber);
	      }else 
		  //$scope.getDataForURI('api/gl/receiptoffees/check/?applicant=0562365&payer=3022&checknumber=2018-02-20');
			  $scope.checked=false;
	  };
	  
	  
	 
	  
/*	  $scope.detailPerson = function (){
		  console.log(" detailId : "+detailId);
		    $element.modal('show');

	  };*/

	}
