function SearchReceiptCtrl($uibModal, $rootScope, $scope, $http, $location) {
	 
	$scope.isSuccess=false;
	$scope.isCheckRegister=false;
	$scope.isAdmin=$rootScope.isAdmin;
	
	$scope.batchNumber=null;
	$scope.accountNumber=null;
	$scope.receiptFeeDate=null;
	
	$scope.master = {};
	console.log(' SearchReceiptCtrl- $scope.isAdmin = '+$scope.isAdmin);
	 
	 $scope.markReadonlyDetail = function(toggle){
		  $scope.isReadonly=toggle;
	 }

	 

	 $scope.back=function(){
			$location.url('/search1');
		}
	  $scope.getDetail = function (id) {
		  console.log("openDetail "+id);
		  app.value("detailId", id);
		  
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
		    var modalInstance = $uibModal.open({
		    	//templateUrl: '#!/addreciept'
		    	 //templateUrl: '#/recieptdetail/'+receieptId,
		    	 templateUrl: 'AddReceiptModal.html',
			     controller: 'AddRecieptCtrl',
			     animation: true,
			     backdrop: true,
			      scope: scope
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
		      $scope.gridOptions.columnDefs[1].cellTemplate = '<div class="ui-grid-cell-contents"> <a ng-href="#!recieptdetail/{{COL_FIELD}}">{{COL_FIELD}}</a></div>';
		    }
		    $scope.gridApi.core.notifyDataChange(uiGridConstants.dataChange.COLUMN);
		  }
	  
	  
	  $scope.gridOptions = {
			  
	    columnDefs: [
	    	//{ name: 'id',  ,, enableCellEdit: false },
	    	//{name: 'id', displayName: 'Id', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <button class="btn" type="button"   ng-click="grid.appScope.showReceiptDetailModal(row.entity.id)">{{COL_FIELD}}	</button></div>'},
	        //{name: 'id', displayName: 'Id', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <button class="btn" type="button"  data-toggle="modal" data-target="#myModal"  ng-click="grid.appScope.getDetail(row.entity.id)">{{COL_FIELD}}	</button></div>'},
	    	//{name: 'id', displayName: 'Id', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <button class="btn-link" type="button"  data-toggle="modal" data-target="#myModal"  ng-click="grid.appScope.getDetail(row.entity.id)">{{COL_FIELD}}</button></div>'},
	        {name: 'id', displayName: 'Transaction Id', width: '12%', enableCellEdit: false,cellTemplate: '<div class="ui-grid-cell-contents"> <a ng-click="grid.appScope.showReceiptDetailModal(row.entity.id)">{{COL_FIELD}}	</a></div>'},
//kk	        {name: 'id', displayName: 'Transaction Id', width: '12%', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <a  data-toggle="modal" data-target="#myModal"  ng-click="grid.appScope.showReceiptDetailModal(row.entity.id)">{{COL_FIELD}}	</a></div>'},
	    	 

	    	{ name: 'applicant', displayName: 'Appplicant' ,width: '20%', enableCellEdit: false },
	        { name: 'payer', displayName: 'Payer', width: '20%', enableCellEdit: false }, 
	        { name: 'checkNumber', displayName: 'Check No', width: '10%', enableCellEdit: false},
	        { name: 'amount', displayName: 'Amount',  width: '10%',enableCellEdit: false}, 
	        { name: 'status', displayName: 'Status',  width: '10%',enableCellEdit: false},
	        { name: 'accountNumber', displayName: 'Revenue Src Code',  width: '20%',enableCellEdit: false}, 
	       // {name: 'button', displayName: 'View', enableCellEdit: false, cellTemplate: '<button ng-click="getExternalScopes().onClick(row.entity.id)">view1</button>'}
	        //{name: 'button', displayName: 'View', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <button class="btn" type="button" ng-click="grid.appScope.Main.openDetail(row.entity.id)">View Detail</button></div>'}, 

	        //{name: 'id', displayName: 'ID', width: '5%', enableCellEdit: false, cellTemplate: '<div class="ui-grid-cell-contents"> <a ng-href="#!detail/{{COL_FIELD}}">{{COL_FIELD}}</a></div>'},
	        //{name:'id', displayName: 'Id ',  width: '5%', cellTemplate: '<a href ng-click="detailPerson()" >{{COL_FIELD}}</a>'}
	  	], 
		rowHeight: 38,
		enableColumnResize: true,
	    enableFiltering: true,     
	    enableRowSelection: true,
	    enableRowHeaderSelection: false,
	    selectionRowHeaderWidth: 35,  
	    noUnselect: true,
		exporterMenuPdf: false,
		enableGridMenu: true,
	    enableSelectAll: true,
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
		  
		  if((batchNumber==null || batchNumber==undefined) && (receiptFeeDate==null || receiptFeeDate==undefined)) {
			  var message = "<h3>Please select BatchNumber or ReceiptFeeDate with Revenue Source Code to search. </h3>";
				var modalHtml = '<div class="modal-body">' + message + '</div>';
				modalHtml += '<div class="modal-footer" style="text-align:center;border-top:;"><button class="btn btn" ng-click="ok()">Ok</button>';
				var modalInstance = $uibModal.open({
					template : modalHtml,
					controller : ModalInstanceCtrl1
				});
		  }
		  
		  var str = $scope.batchNumber;
		 // console.log("Getting the detail page - length "+batchNumber.length);
		  if(!(batchNumber == null) || (SearchReceiptCtrl != null) ||  !(receiptFeeDate != null)  ){
			 // $scope.getDataForURI('http://localhost:8080/eiweb/person/get?name='+$scope.batchNumber);
			  //$scope.getDataForURI('inv/inventory/get?name='+$scope.batchNumber);
			  var formatteddate=null;
			  if(receiptFeeDate!=null) {
			  var d = new Date(receiptFeeDate);
			  

			   formatteddate = d.getFullYear()+'-'+(d.getMonth()+1)+'-'+d.getDate();
			  console.log("before formatteddate"+receiptFeeDate);
			  console.log("formatteddate"+formatteddate);
			  console.log("batchNumber : "+batchNumber +" SearchReceiptCtrl "+accountNumber+" receiptFeeDate  "+formatteddate);
			  }
			  $scope.getDataForURI('api/gl/receiptoffees/get/all/?batchNumber='+$scope.batchNumber+'&accountNumber='+accountNumber+'&receiptFeeDate='+formatteddate);
			  //$scope.getDataForURI('api/gl/receiptoffees/get/all/?batchNumber=0562365&accountNumber=3022&receiptFeeDate=2018-02-20');
			 // $scope.getDataForURI('api/gl/receiptoffees/get/all/?batchNumber=0562365&accountNumber=3022&receiptFeeDate=2018-02-20');
	      }else 
		  //$scope.getDataForURI('api/gl/receiptoffees/get/all/?batchNumber=0562365&accountNumber=3022&receiptFeeDate=2018-02-20');
			  $scope.checked=false;
	  };
	  
	  
	  var ModalInstanceCtrl1 = function($scope, $uibModalInstance) {
			$scope.ok = function() {
				$uibModalInstance.close();
				//$scope.modalInstance.close();
				$location.url('/search1');
			};
			
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
	  
	  
	  
	  $scope.ReceiptofFeeReport = function(batchNumber, accountNumber, receiptFeeDate){
		  var valid=true;
		  console.log("ReceiptofFeeReport scope.batchNumber"+batchNumber);
		  console.log("ReceiptofFeeReport scope.accountNumber"+accountNumber);
		  console.log("ReceiptofFeeReport scope.receiptFeeDate"+receiptFeeDate);
		  var d = new Date(receiptFeeDate);			  
		  var formatteddate = d.getFullYear()+'-'+(d.getMonth()+1)+'-'+d.getDate();
		  
		  console.log("before formatteddate"+receiptFeeDate);
		  console.log("formatteddate"+formatteddate);
		  console.log("batchNumber : "+batchNumber +" SearchReceiptCtrl "+accountNumber+" receiptFeeDate  "+formatteddate);
		  
		 // if(batchNumber==null || accountNumber==null || receiptFeeDate==null){
		  if(batchNumber==null){
			  valid=false;
		  }
		  
		  if(valid){
			  $http.post('api/gl/receiptoffees/rctfeereport/?batchnum='+batchNumber+'&accountNumber='+accountNumber+'&receiptFeeDate='+formatteddate)
			  	.then(function (response) {
			  		//window.open(response.data);
			  		
			  	  var link = document.createElement('a');
                  link.href = response.data;//window.URL.createObjectURL(blob);
                  link.download = "RctFeeReport.xlsx";
                  link.click();
			  		
			    },
			    //function(error){
			    	function(response) {
		    			$location.path('error');
		    			console.log("Error While getting the data"); 
		    		}
			    	//console.log("errror occured"); }
			    
			  	);
			  
		  } else {
			  //open popup with error text
			  
				 
				  console.log("generatebatchNumbers");

				     var message = '<div class="text-center"  ><h3><b>Plese Enter all the three fields</b></h3></div>';
				     var modalHtml = '<div class="modal-body">' + message + '</div>';
				     modalHtml += '<div class="modal-footer" style="text-align:center;border-top:;"><button class="btn " style="margin-left: 12%" ng-click="cancel()">OK</button></div>';
				     var modalInstance = $uibModal.open({
				       template: modalHtml,
				       controller: ModalInstanceCtrl2
				     });
				     modalInstance.result.then(function() {
				     	console.log("calling print");
				       $scope.getDataForURI('api/gl/batchnumbers/print');
				     });	
				  
		  }
		  
	  }
	
	  var ModalInstanceCtrl2 = function($scope, $uibModalInstance) {
		   $scope.cancel = function() {
		     $uibModalInstance.dismiss('cancel');
		   };
		  };

	  $scope.TransmitalReport = function(batchNumber, accountNumber, receiptFeeDate){
		  var valid=true;
		  console.log("scope.batchNumber"+batchNumber);
		  console.log("scope.accountNumber"+accountNumber);
		  console.log("scope.receiptFeeDate"+receiptFeeDate);
		  var d = new Date(receiptFeeDate);			  
		  var formatteddate = d.getFullYear()+'-'+(d.getMonth()+1)+'-'+d.getDate();
		  
		  console.log("before formatteddate"+receiptFeeDate);
		  console.log("formatteddate"+formatteddate);
		  console.log("batchNumber : "+batchNumber +" SearchReceiptCtrl "+accountNumber+" receiptFeeDate  "+formatteddate);
		  
		  //if(batchNumber==null || accountNumber==null || receiptFeeDate==null){
		  if(batchNumber==null &&  receiptFeeDate==null){
			  valid=false;
		  }
		  
		  if(valid){
			  $http.post('api/gl/receiptoffees/transmittalreport/?batchnum='+batchNumber+'&accountNumber='+accountNumber+'&receiptFeeDate='+formatteddate)
			  	.then(function (response) {
			  		//window.open(response.data);
			  		 console.log("Downloading Transmittal report ");
                     var link = document.createElement('a');
                     link.href = response.data;//window.URL.createObjectURL(blob);
                     link.download = "TransmittalReport.xlsx";
                     link.click();
			    },
			    /*function(error){
			    	console.log("errror occured");
			    }
			    */
			    function(response) {
	    			$location.path('error');
	    			console.log("Error While getting the data"); 
	    		}
			  	
			  	
			  	);
			  
		  } else {
			  //open popup with error text
			  
				 
				  console.log("generatebatchNumbers");

				     var message ='<div class="text-center"  ><h3><b>Plese Enter Batch Number & Receiptdate</b></h3></div>'; 
				     var modalHtml = '<div class="modal-body">' + message + '</div>';
				     modalHtml += '<div class="modal-footer" style="text-align:center;border-top:;"><button class="btn " style="margin-left: 12%" ng-click="cancel()">OK</button></div>';
				     var modalInstance = $uibModal.open({
				       template: modalHtml,
				       controller: ModalInstanceCtrl2
				     });
				     modalInstance.result.then(function() {
				     	console.log("calling print");
				       $scope.getDataForURI('api/gl/batchnumbers/print');
				     });	
				  
		  }
		  
	  }
	
	}