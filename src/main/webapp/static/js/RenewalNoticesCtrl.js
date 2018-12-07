function RenewalNoticesCtrl($uibModal, $rootScope, $scope, $http,$routeParams, $window, $location) {
	$scope.genNoticesFlag=true;
	$scope.showdates=true;
	$scope.checked=false;
	$scope.catName='';
	$scope.hasError=0;
	$scope.genNoticeBtnType=0;
	$scope.errorMsg='';
	$scope.acctname='';
	$scope.startDate='';
	$scope.endDate='';
	$scope.run1stdate='';
	$scope.type=[];
	$scope.genNoticeLbl='Generate Notices';
	$scope.type.startDate='text';
	$scope.genNoticeModelLbl='Mail Merge List';
	//$scope.accountName24 = ['','Bedding-Toys Sterilization','Food Processors','Frozen Desserts','IMS Rating','Non-alcoholic (in-of-state)','Non-alcoholic (out-of-state)','Out of State Bakeries','Vending Machines','Water Vending','Stuffed Toy','Single Service Rating','Residential Kitchen','Methyl Wood','Health Certificate']
	$scope.accountName24 = global_LicenseType;
	$scope.Showtable=function (catName){
		$scope.checked=true;
				
		$http.get('api/facility/renewals/all?category='+$scope.catName)
		  	.then(function (response) {
		  		console.log(response.data);
		  		$scope.gridOptions.data = response.data;
		  		if(response.data.length>0){
		  			
				//var date = new Date("2018-12-01 ");
				var date = new Date(response.data[0].dstart);
				date.setDate(date.getDate() + 1);
				//$scope.type.startDate='date';
				var y = date.getFullYear(); 
				var m = date.getMonth();
				var firstDay = new Date(y, m+1, 1);
				var lastDay = new Date(y, m+2, 0);
				var startDateVAlue=firstDay.getFullYear()+'-'+("0" + (firstDay.getMonth()+1)).slice(-2)+'-'+("0" + firstDay.getDate()).slice(-2);
				var endDateVAlue=lastDay.getFullYear()+'-'+("0" + (lastDay.getMonth()+1)).slice(-2)+'-'+("0" + lastDay.getDate()).slice(-2);
				$scope.startDate=startDateVAlue;
				$scope.endDate=endDateVAlue;
				
				console.log("date:"+date);
				console.log("StartDate:"+firstDay);
				console.log("endDate:"+lastDay);
				
				$scope.genNoticeLbl='Generate First Notices';
				$scope.genNoticeModelLbl='Generate First Notices';
				$scope.genNoticeBtnType=1;
				$scope.genNoticesFlag=false;

		  		}

			  		
		 },
		 
		 function(response) {
 			$location.path('error');
 			console.log("Error While getting the data"); 
 		}
		  	);
		
		
		
	}
	$scope.openModel=function(){
		$scope.errorMsg='';
		$scope.hasError=0;
		if($scope.startDate==''){
			$scope.hasError=1;
			$scope.errorMsg+='Please Select Start Data in Range.\n';
		}
		if($scope.endDate==''){
			$scope.hasError=1;
			$scope.errorMsg+='Please Select End Data in Range.\n';
		}
		if($scope.catName==''){
			$scope.hasError=1;
			$scope.errorMsg+='Please Select End Data in Range.\n';
		}
		if($scope.hasError!=1){
			$rootScope.startDate=$scope.startDate;
			$rootScope.endDate=$scope.endDate;
			$rootScope.catName=$scope.catName;
			
			var modalScope = $scope.$new();
			 var modalInstance = $uibModal.open({
			      templateUrl: 'MailMergeList.html',
			      scope: modalScope
			 });
			  modalScope.modalInstance = modalInstance;
		}
		 
	}
	
	/*
	$scope.checkDate=function(dt){
		
		var date = new Date(dt);
		var startDateVAlue=date.getFullYear()+'-'+("0" + (date.getMonth() + 2)).slice(-2)+'-'+("0" + date.getDate()).slice(-2);
		alert(startDateVAlue);
		$scope.startDate=startDateVAlue;
		
	}*/
	
	$scope.addMonth=function(startDate){
		console.log('Start Date'+startDate);
		var   sDate = $scope.startDate;
		//console.log('$scope.startDate' +$scope.startDate+'$scope.endDate '+$scope.endDate);
		var sDate = new Date(startDate);
		var lastDay = new Date(sDate.getFullYear(), sDate.getMonth() + 1, 0);

		console.log('$scope.type.startDate '+$scope.type.startDate);
		//$scope.type.startDate='text';
		//$scope.endDate =((lastDay.getMonth()+1)+'/'+lastDay.getDate()+'/'+lastDay.getFullYear());
		$scope.endDate =(lastDay.getFullYear()+'-'+(lastDay.getMonth()+1)+'-'+lastDay.getDate());
		$scope.genNoticeLbl='Generate First Notices';
		$scope.genNoticeBtnType=1;
		$scope.genNoticesFlag=false;
		console.log('lastDay '+lastDay);
		console.log('$scope.endDate '+$scope.endDate);
		
	}
	
$scope.checkDate=function(row){
		console.log('row.dstar'+row.dstart);//.dstart,row.entity.secondsent
		var dt=row.dstart;
		var tot2=row.secondsent;
		var date = new Date(dt);
	//	var date = new Date("2018-12-01");
		console.log('date before modification '+date);
		//date.setDate(date.getDate() + 1);
		//$scope.type.startDate='date';
		var y = date.getFullYear(); 
		var m = date.getMonth();
		//var firstDay = new Date(y, m, 1);
		var firstDay =  date;
		var lastDay = new Date(y, m+1, 0);
		var startDateVAlue=firstDay.getFullYear()+'-'+("0" + (firstDay.getMonth()+1)).slice(-2)+'-'+("0" + firstDay.getDate()).slice(-2);
		var endDateVAlue=lastDay.getFullYear()+'-'+("0" + (lastDay.getMonth()+1)).slice(-2)+'-'+("0" + lastDay.getDate()).slice(-2);
		
		console.log("date:"+date);
		console.log("StartDate:"+firstDay);
		console.log("endDate:"+lastDay);
		
		/*$scope.type.startDate='date';
		var y = date.getFullYear(); 
		var m = date.getMonth();
		var firstDay = new Date(y, m+1, 1);
		var lastDay = new Date(y, m+1, 0);
		var startDateVAlue=firstDay.getFullYear()+'-'+("0" + (firstDay.getMonth())).slice(-2)+'-'+("0" + firstDay.getDate()).slice(-2);
		var endDateVAlue=lastDay.getFullYear()+'-'+("0" + (lastDay.getMonth()+1)).slice(-2)+'-'+("0" + lastDay.getDate()).slice(-2);
		var run1st=new Date(row.run1st);
		$scope.run1stdate=run1st.getFullYear()+'-'+("0" + (run1st.getMonth()+1)).slice(-2)+'-'+("0" + run1st.getDate()).slice(-2);
*/
		$scope.startDate=startDateVAlue;
		$scope.endDate=endDateVAlue;
		if(tot2==0){
			$scope.chkDtate1=row.run1st;
			$scope.chkDtate2=row.run2nd;
			$scope.genNoticesFlag=false;
			$scope.showdates=false;
		} else {
			$scope.chkDtate2=row.run2nd;
			$scope.genNoticesFlag=true;
		}
		$scope.genNoticeBtnType=2;
		$scope.genNoticeLbl='Generate Second Notices';
		$scope.genNoticeModelLbl='Generate Second Notices';
	}
$scope.gridOptions = {
			
			enableColumnResize: true,
		    enableSorting: true,
		    enableFiltering: false,
		    
		    columnDefs: [
		    	
		    	{ name:  'catShort', displayName: 'Category', width: '25%', 	cellTemplate: '<a class="ui-grid-cell-contents mouse_cursor " ng-click="grid.appScope.checkDate(row.entity)">{{COL_FIELD CUSTOM_FILTERS}}</a>'},
		    	{ name:  'dstart', displayName: 'Start Range', width: '12.5%',	type:'date',cellFilter: 'date:"MM/dd/yyyy hh:mm"'},
		    	{ name:  'dend', displayName: 'End Range', width: '12.5%', type:'date',cellFilter: 'date:"MM/dd/yyyy hh:mm"'},
		    	{ name:  'totalsent', displayName: 'Total No 1st', width: '12.5%'},
		    	  { name:  'secondsent',displayName: 'Total No. 2nd', width: '12.5%' },
		    	  { name:  'whosent1',displayName: 'Who Sent 1st', width: '12.5%' },
			      { name:  'whosent2',displayName: 'Who Sent 2nd', width: '12.5%' }
			      
		    ],
		    onRegisterApi: function( gridApi ) {}
		    
	
		  };

/*$scope.chkDtate1=row.run1st;
$scope.chkDtate2=row.run2nd;*/
}
