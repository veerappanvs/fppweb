function FacilityRegViewCtrl($uibModal, $rootScope, $scope, $http,$routeParams, $window, $location,$filter) {

	
//	 $scope.$parent.dismiss('cancel');
	$scope.addTranDisabled=true;
	$scope.data=[];
	$scope.data.facreg=[];
	$scope.defaultmailingaddress=false;
	/*$scope.status = ['Active','Pending','Withdrawn','Refund Issued','Suspended','Deceased','Moved out of Mass','Out of Business'];*/
	$scope.status=glob_status;
	
	/*$scope.LicenseType = ['Bedding-Toys Sterilization','Food Processors','Frozen Desserts','IMS Rating','Non-alcoholic (in-of-state)','Non-alcoholic (out-of-state)','Out of State Bakeries','Vending Machines','Water Vending','Stuffed Toy','Single Service Rating','Residential Kitchen','Methyl Wood','Health Certificate'];*/
	/*$scope.LicenseType = ['Bottled Water and Carbonated Non-Alcoholic Beverages (In-State)','Methyl Alcohol','Processor, Baked Goods','Processor, Food','Processor, Frozen Desserts','Processor, Residential Kitchen','Processor, Seafood','Distributor, Food','Warehouse',
		'Cold Storage Warehouse','Out-of-State Bakeries','Vending Machines, Food and Beverages','Vending Machines, Water Only','Bedding','Upholstered Furniture','Stuffed Toys', 'Sterilization',
		'Out-of-State Frozen Desserts', 'Processor, Milk(IMS Rating)','Processor, Milk(Single Service Manufacturer Rating)','Research Animals(cats and dogs)',
		'Export Statements','Health Certificate','Bottled Water and Carbonated Non-Alcoholic Beverages (Out-of-State)','Processor, Meat & Poultry(>$10 million annual sales)','Processor, Meat & Poultry(all other M&P processors)','Milk Laboratory State Certification',
		'Milk Laboratory Inspection per Procedural Specialty','Milk Laboratory Interstate Licenses','Mics.Revenue'];*/
	$scope.countries=glob_countries;
	$scope.countries1 = $scope.countries;
	
	$scope.LicenseType=glob_LicenseType;
	
	$scope.PrimOperation = ['Seafood and/or Shellfish','Meat and/or Poultry','Dairy Products','Frozen Desserts','Baked Goods','Multiple Foods','No food processing'];
	$scope.OtherOperation = ['Wholesale Distribution','Bottling Plant','Cold Storage Warehouse','Warehouse','Packing and/or Repacking'];
	$scope.TypeBuilding = ['Non-Residential(i.e. commercial)','Residential','On-Farm Processing'];
	
	$scope.ProdCategory = ['','Bakery Products','Grain Products','Fishery/Seafood Products','Meat and Poultry Products','Dairy Products','Other Food Products','Fruit and Vegetable Products','Water and Beverages','Candy, Chocolate and Sweeteners','Dinners, Gravies, Sauces and Soups','Seasonings and Additives'];
	
	$scope.productsByCat=[];
	
	$scope.productsByCat[1] = ['Bread/Rolls','Prepared Dry Mix','Crackers','Cookies, Biscuits and Wafers','Other Bakery Products'];
	$scope.productsByCat[2] = ['Whole Grain/Milled Grain','Macaroni/Noodle/Pasta Products','Cereal/Breakfast Food','Snack Food Items'];
	$scope.productsByCat[3] = ['Fish/Fish Products','Shellfish','Crustaceans','Other SeafoodProducts'];
	$scope.productsByCat[4] = ['Red Meat/Meat Products','Poultry Products','Beef/Beef Products','Lamb/Mutton/Sheep Products','Pork Products','Other Meat Products'];
	$scope.productsByCat[5] = ['Fluid/Dry Milk Products','Butter Products','Goat Milk','Sheep Milk','Standard Cheese','Soft Cheese','Other Cheese Products','Ice cream/Frozen Desserts','Filled Milk/Imitation Milk Products'];
	$scope.productsByCat[6] = ['Egg and Egg Products','Baby Food Products','Pet Foods','Dietary Supplements'];
	$scope.productsByCat[7] = ['Fruits(Raw)','Apple Cider/Fruit Juice','Fruit Products (Non-Juice)','Nuts/Edible Seeds','Vegetables/Vegetable Products (Raw)','Sprouts from seeds, Beans or Peas','Mixed Vegetables', 'Mushrooms/Fungi Products','Other Vegetable Products','Vegetable Oils','Vegetable Protein(Tofu, Simulated Meats)'];
	$scope.productsByCat[8] = ['Noncarbonated Water(Bottled Water)','Carbonated Water','Non-Carbonated Soft Drink','Carbonated Soft Drink','Ice','Beverage Bases','Coffe/Tea'];
	$scope.productsByCat[9] = ['Candy/Gum(Non-Choclate)','Choclate & Cocoa Products','Gelatin/Pudding/Pie Fillings','Food Sweeteners','Honey'];
	$scope.productsByCat[10] = ['Dinner with Components','Food Package Requires Mixing/Cooking','Stews/Sauces/Gravies','Sandwiches','Multiple Foods','Soups','Prepared Salad Products(Deli Salads)'];
	$scope.productsByCat[11] = ['Dressing/Condiment','Spices, Flavors and Salts','Food Additives'];
	
	console.log("test");
	
	
	
	
	

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
	
	$scope.place_holder.corp_id='Corporation ID';
	$scope.place_holder.corp_name='Corporation name';
	$scope.place_holder.dba='DBA';
	$scope.place_holder.incDate='Inspection Date';
	$scope.place_holder.fac_address1='Line 1';
	$scope.place_holder.fac_address2='Line 2';
	$scope.place_holder.fac_address_city='City';
	$scope.place_holder.fac_address_state='State';
	$scope.place_holder.fac_address_zip='Zip';
	$scope.place_holder.fac_address_country='Country';
	$scope.place_holder.fac_phone='Phone';
	$scope.place_holder.fac_phone_ext='phone ext';
	$scope.place_holder.fac_phone2='Emergency Phone';
	$scope.place_holder.fax='Fax';
	$scope.place_holder.email='Email';
	$scope.place_holder.fac_prt_cmts='Facility Comments';
	$scope.place_holder.fac_pri_op='Select Your Primary Operation';
	$scope.place_holder.fac_other_op='Select Your Other Operation';
	$scope.place_holder.fac_building_type='Select Your Type of Building';
	$scope.place_holder.fac_product1_type='Product category';
	$scope.place_holder.fac_product1='Product List';
	$scope.place_holder.fac_product2_type=' Product category';
	$scope.place_holder.fac_product2='Product List';
	$scope.place_holder.fac_product3_type='Product category';
	$scope.place_holder.fac_product3='Product List';
	$scope.place_holder.fac_product4_type='Product category';
	$scope.place_holder.fac_product4='Product List';
	$scope.place_holder.fac_license_no='License Number';
	$scope.place_holder.issued='Issuance Date';
	$scope.place_holder.expries='Expiration Date';
	$scope.place_holder.urn='URN';
	$scope.test='tests1';
	$scope.fac_id=0;
	// $scope.facilityRegistrations=[];
	$scope.data={facreg:{facilities:{}}};
	$scope.facilityRegistrations=[{ 'certaction':'RENEWAL','rcpfeedt': 'RECIPET','checkno': '12345','amount': '500','tUserid': 'USER','tEntrytm': 'PQR'},
                  { 'certaction':'ACTION1','rcpfeedt': 'RECIPET1','checkno': 'CHECK NO','amount': 'AMOUNT','tUserid': 'USER','tEntrytm': 'ABC'},
                  { 'certaction':'ACTION2','rcpfeedt': 'RECIPET2','checkno': 'CHECK NO','amount': 'AMOUNT','tUserid': 'USER','tEntrytm': 'DEF'},
                  { 'certaction':'ACTION3','rcpfeedt': 'RECIPET3','checkno': 'CHECK NO','amount': 'AMOUNT','tUserid': 'USER','tEntrytm': 'GHI'},
                  { 'certaction':'ACTION4','rcpfeedt': 'RECIPET4','checkno': 'CHECK NO','amount': 'AMOUNT','tUserid': 'USER','tEntrytm': 'JKL'},
                    ];

	$scope.checkAddtrans=function(){
		$scope.isReadOnly=false;
		$scope.selectChange();
		//$scope.data.facreg.registration=[];
		/*console.log("insdate:"+$scope.data.facreg.facilities.inspectionCompleted);
		console.log("regLicense:"+$scope.data.facreg.registration.regLicense);
		console.log("dateIssue:"+$scope.data.facreg.registration.dateIssue);
		console.log("dateExpire:"+$scope.data.facreg.registration.dateExpire);*/
		//if($scope.data.facreg.facilities.inspectionCompleted && ($scope.data.facreg.registration.regLicense && $scope.data.facreg.registration.dateIssue && $scope.data.facreg.registration.dateExpire)){
	
		/*if(($scope.data.facreg.registration.regLicense && $scope.data.facreg.registration.dateIssue && $scope.data.facreg.registration.dateExpire)){
						
			$scope.addTranDisabled=false;		
		}*/
	}
	
	$scope.getProductsforCat=function(index){
		var element="prodCat"+index;
		var key = $scope.ProdCategory.indexOf($scope.data.facreg.foodProcesorInfo[element]);
		var element="product"+index+"_products";
		$scope[element]=$scope.productsByCat[key];
	}
	$scope.getFacilityRegistration = function(){
		var facId = $rootScope.facId;
		  $http.get('api/trans/facid/'+facId)
		  	.then(function (response) {
		  		console.log("transaction list "+response.data);
		  		/*$scope.facilityRegistrations=[{ 'certAction':'ACTION','receipt': 'RECIPET','checkNo': 'CHECK NO','amount': 'AMOUNT','user': 'USER','enter': 'PQR'},
                  { 'certAction':'ACTION1','receipt': 'RECIPET1','checkNo': 'CHECK NO','amount': 'AMOUNT','user': 'USER','enter': 'ABC'},
                  { 'certAction':'ACTION2','receipt': 'RECIPET2','checkNo': 'CHECK NO','amount': 'AMOUNT','user': 'USER','enter': 'DEF'},
                  { 'certAction':'ACTION3','receipt': 'RECIPET3','checkNo': 'CHECK NO','amount': 'AMOUNT','user': 'USER','enter': 'GHI'},
                  { 'certAction':'ACTION4','receipt': 'RECIPET4','checkNo': 'CHECK NO','amount': 'AMOUNT','user': 'USER','enter': 'JKL'},
                    ];*/

		  		$scope.facilityRegistrations=response.data;
		  		
		    },
		    
		    function(response) {
    			$location.path('error');
    			console.log("Error While getting the data"); 
    		}
		  	
		  	);
	  };
	  
	  //Load transaction details
	$scope.getFacilityRegistration();

	$scope.corp=[];
	$scope.val=[];
	$scope.fac=[];

	if($rootScope.facModelEnabled){
		//alert("model"+$rootScope.facId);
		var value=$rootScope.facId;
		$scope.fac_id=value;
		$scope.tmp_facId=value;
		 $rootScope.tmp_facId=$scope.tmp_facId;
		$rootScope.facId=0;
		$http.get('api/facility/detail/id/'+value)
		 //$http.get('api/facility/detail/id/59')
		  	.then(function (response) {
		  		var facinfo= response.data;
		  		
		  		//console.log(facinfo.fclass.facClass);
		  		//console.log('glob_food_processors.indexOf(data.facreg.fclass.facClass ) '+glob_food_processors.indexOf(facinfo.fclass.facClass ) );
		  		
		  		 $scope.data.facreg =facinfo;
		  		 /*if(facinfo.facilities.inspectionCompletedDate!=null) {
		  			 
		  			 console.log('Changin the date');
		  			 var firstDay =new Date(facinfo.facilities.inspectionCompletedDate); 

		  			 $scope.data.facreg.facilities.inspectionCompletedDate=firstDay.getFullYear()+'-'+("0" + (firstDay.getMonth()+1)).slice(-2)+'-'+("0" + firstDay.getDate()).slice(-2);
		  		 }*/
//$scope.data.facreg.facilities.inspectionCompletedDate=("0" + (firstDay.getMonth()+1)).slice(-2)+'/'+("0" + firstDay.getDate()).slice(-2)+'/'+firstDay.getFullYear();
			//	alert($scope.data.facreg.facilities.inspectionCompletedDate);
		  		/*alert(facinfo.facilities.facilityZip);*/
		  		console.log('FacilityRegview Js - Response as facinfo before trim---> '+JSON.stringify( $scope.data.facreg));
		  		 if(facinfo.fclass!=null) {
		  			 if(facinfo.fclass.facClass!=null){
		  				 $scope.data.facreg.fclass.facClass=(facinfo.fclass.facClass.trim()) ;
		  			 }
		  		 }
		  		 
		  		 if(facinfo.facilities.facilityZip!=null) {
		  			 $scope.data.facreg.facilities.facilityZip=(facinfo.facilities.facilityZip).trim();
		  		 }

		  		 if(facinfo.facilities.facilityPhone!=null) {
		  			 $scope.data.facreg.facilities.facilityPhone=(facinfo.facilities.facilityPhone).trim();
		  		 }
		  		 if(facinfo.facilities.facilityFax!=null) {
		  			 $scope.data.facreg.facilities.facilityFax=(facinfo.facilities.facilityFax).trim();
		  		 }
		  		 if(facinfo.facilities.facilityStatus!=null) {
		  			 $scope.data.facreg.facilities.facilityStatus=(facinfo.facilities.facilityStatus).trim();
		  		 }
		  		
		  		console.log('FacilityRegview Js - Response as facinfo ---> '+JSON.stringify( $scope.data.facreg));
		  		 
		  		$scope.defaultmailingaddress=facinfo.defaultMailingAddress;
		  		 if(facinfo.foodProcesorInfo!=null) {
		  		$scope.data.facreg.foodProcesorInfo.primaryop=facinfo.foodProcesorInfo.primaryop;
				$scope.data.facreg.foodProcesorInfo.secondaryop=facinfo.foodProcesorInfo.secondaryop;
				$scope.data.facreg.foodProcesorInfo.buildingtype=facinfo.foodProcesorInfo.buildingtype;
				$scope.data.facreg.foodProcesorInfo.prodCat1=facinfo.foodProcesorInfo.prod_cat1;
				$scope.data.facreg.foodProcesorInfo.prodCat4=facinfo.foodProcesorInfo.prod_cat4;
				$scope.data.facreg.foodProcesorInfo.prodCat2=facinfo.foodProcesorInfo.prod_cat2;
				$scope.data.facreg.foodProcesorInfo.prodCat3=facinfo.foodProcesorInfo.prod_cat3;
			//
				$scope.getProductsforCat(1);
				$scope.getProductsforCat(2);
				$scope.getProductsforCat(3);
				$scope.getProductsforCat(4);
			
				$scope.data.facreg.foodProcesorInfo.prodSubCat1=facinfo.foodProcesorInfo.prod_sub_cat1;
				$scope.data.facreg.foodProcesorInfo.prodSubCat2=facinfo.foodProcesorInfo.prod_sub_cat2;
				$scope.data.facreg.foodProcesorInfo.prodSubCat3=facinfo.foodProcesorInfo.prod_sub_cat3;
				$scope.data.facreg.foodProcesorInfo.prodSubCat4=facinfo.foodProcesorInfo.prod_sub_cat4;
				
		  		 }		
				
				//$scope.data.facreg.facilities.inspectionCompletedDate = $filter('date')(facinfo.facilities.inspectionCompletedDate, 'dd/MM/yyyy');
		  		 
		  		 if(facinfo.registration!=null) {
		  			 if(facinfo.registration.dateExpire!=null) {
		  				 $scope.data.facreg.registration.dateExpire = $filter('date')(facinfo.registration.dateExpire, 'dd/MM/yyyy');
		  			 }
		  			 if(facinfo.registration.dateIssue!=null) {
		  				 $scope.data.facreg.registration.dateIssue = $filter('date')(facinfo.registration.dateIssue, 'dd/MM/yyyy');
		  			 }
		  			if(facinfo.facilities.inspectionCompletedDate!=null) {
		  				 $scope.data.facreg.facilities.inspectionCompletedDate = $filter('date')(facinfo.facilities.inspectionCompletedDate, 'dd/MM/yyyy');
		  				 console.log('$scope.data.facreg.facilities.inspectionCompletedDate '+$scope.data.facreg.facilities.inspectionCompletedDate);
		  			 }
		  		 }
			 		
				
		  		console.log("After modifying  the prod cat info "+JSON.stringify( $scope.data.facreg));
		  	},
		  	function(response) {
    			$location.path('error');
    			console.log("Error While getting the data"); 
    		}
		  	
		  	);
		
		 
/*		 $http.get('api/registration/facid/'+value)
		  	.then(function (response) {
		  		var facinfo= response.data[0];
		  		
				$scope.data.facreg.regLicense=facinfo.regLicense;
				$scope.data.facreg.dateIssue=facinfo.dateIssue;
				$scope.data.facreg.dateExpire=facinfo.dateExpire;
				$scope.data.facreg.urn='';Not found
				
		  		console.log(facinfo);
		  	});*/
		
	/*	$scope.corp.corp_name='';
		$scope.corp.corp_address1='';
		$scope.corp.corp_address2='';
		$scope.corp.corp_address_city='';
		$scope.corp.corp_address_state='';
		$scope.corp.corp_address_zip='';
		$scope.corp.corp_address_country='';
		$scope.corp.corp_lname='';
		$scope.corp.corp_fname='';
		$scope.corp.corp_mname='';
		$scope.corp.corp_suffix='';
		$scope.corp.corp_title='';
		$scope.corp.corp_prt_cmts='';
		$scope.corp.corp_phone='';
		$scope.corp.corp_phone_ext='';
		$scope.corp.corp_email='';
		$scope.fac.corp_id='';
		$scope.fac.corp_name='';
		$scope.fac.dba='';
		$scope.fac.fac_type='';
		$scope.fac.incDate='';
		$scope.fac.status='';
		$scope.fac.fac_address2='';
		$scope.fac.fac_address_city='';
		$scope.fac.fac_address_state='';
		$scope.fac.fac_address_zip='';
		$scope.fac.fac_address_country='';
		$scope.fac.fac_phone='';
		$scope.fac.fac_phone_ext='';
		$scope.fac.fac_phone2='';
		$scope.fac.fax='';
		$scope.fac.email='';
		$scope.fac.fac_prt_cmts='';
		$scope.fac.fac_pri_op='';
		$scope.fac.fac_other_op='';
		$scope.fac.fac_building_type='';
		$scope.fac.fac_product1_type='';
		$scope.fac.fac_product1='';
		$scope.fac.fac_product2_type='';
		$scope.fac.fac_product2='';
		$scope.fac.fac_product3_type='';
		$scope.fac.fac_product3='';
		$scope.fac.fac_product4_type='';
		$scope.fac.fac_product4='';
		$scope.fac.fac_license_no='';
		$scope.fac.issued='';
		$scope.fac.expries='';
		$scope.fac.urn='';
		$scope.fac.tran.certAction='';
		$scope.fac.tran.receipt='';
		$scope.fac.tran.checkNo='';
		$scope.fac.tran.amount='';
		$scope.fac.tran.user='';
		$scope.fac.tran.enter='';
		$scope.fac.tran.certAction='';
		$scope.fac.tran.receipt='';
		$scope.fac.tran.checkNo='';
		$scope.fac.tran.amount='';
		$scope.fac.tran.user='';
		$scope.fac.tran.enter='';
		$scope.fac.tran.certAction='';
		$scope.fac.tran.receipt='';
		$scope.fac.tran.checkNo='';
		$scope.fac.tran.amount='';
		$scope.fac.tran.user='';
		$scope.fac.tran.enter='';
		$scope.fan.fan_checkbox='';
	*/	
		$rootScope.facModelEnabled=0;
	}
	
    $scope.navigateReports=function()
    {
 	   $scope.modalInstance.dismiss('cancel');
 	   window.location.href='#!fiscreceipt';
    }
    $scope.editFRecit=function(recId)
    {
 	   $scope.modalInstance.dismiss('cancel');
 	   var passingValues=$scope.facilityRegistrations[recId];
 	 	 $rootScope.transactionEditDetails = passingValues;
 	   console.log('Facility reg view trl  ---passingValues'+  JSON.stringify(passingValues));
	   $rootScope.revise=1;
	  // $rootScope.fdata=[];

	/*   $rootScope.tmp_facId=$scope.tmp_facId;
	   $rootScope.fdata.amount=passingValues.amount;
	   $rootScope.fdata.batchNo=passingValues.batchNo;
	   $rootScope.fdata.certaction=passingValues.certaction;
	   $rootScope.fdata.checkno=passingValues.checkno;
	   $rootScope.fdata.id=passingValues.id;
	   $rootScope.fdata.printTm=passingValues.printTm;
	   $rootScope.fdata.rcpfeedt=passingValues.rcpfeedt;
	   $rootScope.fdata.regId=passingValues.regId;
	   $rootScope.fdata.tEntrytm=passingValues.tEntrytm;
	   $rootScope.fdata.tUserid=passingValues.tUserid;
		$rootScope.fdata.printed=passingValues.printed;*/
 		
		
 	   window.location.href='#!fiscreceipt';
    }
 
    
    $scope.saveData = function(){
	  	
	 	//$scope.master = {};
    	$scope.validation=[];
   	 var valid=1;
   	 
/*   		  if(!$scope.data.facreg.facilities.facilityPhone || $scope.data.facreg.facilities.facilityPhone=='undefined'){
   			 $scope.validation.facilityPhone=1;
   			 valid=0;
   		  } 
   		  
   		  if(!$scope.data.facreg.facilities.phoneExt || $scope.data.facreg.facilities.phoneExt=='undefined'){
   				 $scope.validation.phoneExt=1;
   				 valid=0;
   			  } 
   		  if(!$scope.data.facreg.facilities.emergencyPhone || $scope.data.facreg.facilities.emergencyPhone=='undefined'){
   				 $scope.validation.emergencyPhone=1;
   				 valid=0;
   			  } 
   		  if(!$scope.data.facreg.facilities.facilityFax || $scope.data.facreg.facilities.facilityFax=='undefined'){
   				 $scope.validation.facilityFax=1;
   				 valid=0;
   			  } 
   		 if(!$scope.data.facreg.facilities.facilityZip || $scope.data.facreg.facilities.facilityZip=='undefined'){
				 $scope.validation.facilityZip=1;
				 valid=0;
			  } */
   		  if(valid!=1){
   			  $scope.validation.status=1;
   			  return 0;
   		  }
   	
	 	console.log("$scope.data.facreg.facilities.corporationId"+JSON.stringify($scope.data.facreg.facilities));
  		if($scope.data.facreg.facilities.isDefaultMailingAdd || $scope.data.facreg.facilities.isDefaultMailingAdd == 'true' || $scope.data.facreg.facilities.isDefaultMailingAdd == true || $scope.data.facreg.facilities.isDefaultMailingAdd == 1 ){
  			$scope.data.facreg.facilities.facilityMailingAddressOne=$scope.data.facreg.facilities.facilityAddress1;
  			$scope.data.facreg.facilities.facilityMailingAddress2=$scope.data.facreg.facilities.facilityAddress2;
  			$scope.data.facreg.facilities.facilityMailingCity=$scope.data.facreg.facilities.facilityCity;
  			$scope.data.facreg.facilities.facilityMailingState=$scope.data.facreg.facilities.facilityState;
  			$scope.data.facreg.facilities.facilityMailingZip=$scope.data.facreg.facilities.facilityZip;
  			
  			//TODO Check the names should be copied or not
  			$scope.data.facreg.facilities.facilityMailingLastName=$scope.data.facreg.corp.cLast;
  			$scope.data.facreg.facilities.facilityMailingFirstName=$scope.data.facreg.corp.cFirst;
  			$scope.data.facreg.facilities.facilityMailingMiddleName=$scope.data.facreg.corp.cMiddle;
  			$scope.data.facreg.facilities.facilityMailingSuffix=$scope.data.facreg.corp.cSuffix;
  			$scope.data.facreg.facilities.facilityMailingTitle=$scope.data.facreg.corp.cTitle;
  			$scope.data.facreg.facilities.isDefaultMailingAdd=true;

  		}else{
  			$scope.data.facreg.facilities.facilityMailingAddressOne=$scope.data.facreg.corp.cMailadd1;
  			$scope.data.facreg.facilities.facilityMailingAddress2=$scope.data.facreg.corp.cMailadd2;
  			$scope.data.facreg.facilities.facilityMailingCity=$scope.data.facreg.corp.cMailcity;
  			$scope.data.facreg.facilities.facilityMailingState=$scope.data.facreg.corp.cMailstate;
  			$scope.data.facreg.facilities.facilityMailingZip=$scope.data.facreg.corp.cMailzip;
  			$scope.data.facreg.facilities.facilityMailingLastName=$scope.data.facreg.corp.cLast;
  			$scope.data.facreg.facilities.facilityMailingFirstName=$scope.data.facreg.corp.cFirst;
  			$scope.data.facreg.facilities.facilityMailingMiddleName=$scope.data.facreg.corp.cMiddle;
  			$scope.data.facreg.facilities.facilityMailingSuffix=$scope.data.facreg.corp.cSuffix;
  			$scope.data.facreg.facilities.facilityMailingTitle=$scope.data.facreg.corp.cTitle;
  			$scope.data.facreg.facilities.isDefaultMailingAdd=false;

  		}
  		
	 	if($scope.data.facreg.foodProcesorInfo!=null){
  			$scope.data.facreg.foodProcesorInfo.prod_cat1=$scope.data.facreg.foodProcesorInfo.prodCat1;
  			$scope.data.facreg.foodProcesorInfo.prod_cat2=$scope.data.facreg.foodProcesorInfo.prodCat2;
  			$scope.data.facreg.foodProcesorInfo.prod_cat3=$scope.data.facreg.foodProcesorInfo.prodCat3;
  			$scope.data.facreg.foodProcesorInfo.prod_cat4=$scope.data.facreg.foodProcesorInfo.prodCat4;

  			$scope.data.facreg.foodProcesorInfo.prod_sub_cat1=$scope.data.facreg.foodProcesorInfo.prodSubCat1;
  			$scope.data.facreg.foodProcesorInfo.prod_sub_cat2=$scope.data.facreg.foodProcesorInfo.prodSubCat2;
  			$scope.data.facreg.foodProcesorInfo.prod_sub_cat3=$scope.data.facreg.foodProcesorInfo.prodSubCat3;
  			$scope.data.facreg.foodProcesorInfo.prod_sub_cat4=$scope.data.facreg.foodProcesorInfo.prodSubCat4;

  		}
		if($scope.data.facreg.registration!=null){
			//$scope.data.facreg.registration.dateExpire=$scope.data.facreg.registration.expries;
  			//$scope.data.facreg.registration.dateIssue=$scope.data.facreg.registration.issued;
  			//$scope.data.facreg.registration.regLicense=$scope.data.facreg.registration.fac_license_no;
		
		 	
			console.log('$scope.data.facreg.registration.dateIssue '+$scope.data.facreg.registration.dateIssue);
			if($scope.data.facreg.registration.dateIssue != null && $scope.data.facreg.registration.dateIssue != undefined && $scope.data.facreg.registration.dateIssue.substring(2, 3 ) != '-'){
					var issueDate = $scope.data.facreg.registration.dateIssue;
					$scope.data.facreg.registration.dateIssue =issueDate.substring(5,7)+'-'+issueDate.substring(8,10)+'-'+issueDate.substring(0,4);
			}
			
			if($scope.data.facreg.registration.dateExpire != null && $scope.data.facreg.registration.dateExpire != undefined  && $scope.data.facreg.registration.dateExpire.substring(2, 3 ) != '-'){
				var expireDate = $scope.data.facreg.registration.dateExpire;
			    $scope.data.facreg.registration.dateExpire =expireDate.substring(5,7)+'-'+expireDate.substring(8,10)+'-'+expireDate.substring(0,4);
			}
			
		    
			console.log('newdateIssue '+$scope.data.facreg.registration.dateIssue);
			console.log('newdateExpire '+$scope.data.facreg.registration.dateExpire);
		}
		
		console.log('inspectionCompletedDate before modifying'+$scope.data.facreg.facilities.inspectionCompletedDate);

		if($scope.data.facreg.facilities.inspectionCompletedDate != null && $scope.data.facreg.facilities.inspectionCompletedDate !=undefined  &&  $scope.data.facreg.facilities.inspectionCompletedDate.substring(2, 3 ) != '-'){
			var inspectionCompledDate = $scope.data.facreg.facilities.inspectionCompletedDate;
			$scope.data.facreg.facilities.inspectionCompletedDate =inspectionCompledDate.substring(5,7)+'-'+inspectionCompledDate.substring(8,10)+'-'+inspectionCompledDate.substring(0,4);
		}
	console.log('inspectionCompletedDate '+$scope.data.facreg.facilities.inspectionCompletedDate);
	//console.log('inspectionCompletedDate formatted date  '+$scope.data.facreg.facilities.inspectionCompletedDate.format('yyyy-MM-dd'));

	/*if($scope.data.facreg.registration.inspectionCompletedDate.substring(2, 3 ) != '-'){
		var expireDate = $scope.data.facreg.registration.dateExpire;
	    $scope.data.facreg.registration.dateExpire =expireDate.substring(5,7)+'-'+expireDate.substring(8,10)+'-'+expireDate.substring(0,4);
	}*/
		

	/*	console.log('$filte($scope.data.facreg.registration.inspectionCompletedDate1, ' +($filter('date')($scope.data.facreg.registration.inspectionCompletedDate, 'yyyy-MM-dd'), 'EST'));
		console.log('$filte($scope.data.facreg.registration.inspectionCompletedDate2, ' +($filter('date')($scope.data.facreg.registration.inspectionCompletedDate, '"MM/dd/yyyy')));
		console.log('$filte($scope.data.facreg.registration.inspectionCompletedDate3, ' +($filter('date')($scope.data.facreg.registration.inspectionCompletedDate, 'MM-dd-yyyy')));


		

		if($scope.data.facreg.registration.inspectionCompletedDate.substring(2, 3 ) != '-'){
			var expireDate = $scope.data.facreg.registration.dateExpire;
		    $scope.data.facreg.registration.dateExpire =expireDate.substring(5,7)+'-'+expireDate.substring(8,10)+'-'+expireDate.substring(0,4);
		}
		
		 $scope.data.facreg.registration.inspectionCompletedDate = $filter('date')(new Date( $scope.data.facreg.registration.inspectionCompletedDate), "MM-dd-yyyy");
		 console.log('inspectionCompletedDate after format '+$scope.data.facreg.facilities.inspectionCompletedDate);*/
	 //	 $scope.data.facreg.facilities.corporationId=123444;
	  		
	  		//$scope.data.facreg.facilities.inspectionCompletedDate=new Date($scope.data.facreg.facilities.inspectionCompletedDate);

	  		
		var facility = $scope.data.facreg;
	  		console.log("Facereg before save "+JSON.stringify(facility));
        $http.put('api/facility/modify', facility)
        .then(
        		function(response) {
        		/*	$scope.fac = response.data;
        			console.log('Facility created : '+re.
        			sponse.location);
        			$scope.hasInserted=true;
        			$scope.data.facreg.facilities.facilityName="";
        			$scope.data.facreg.facilities.facilityType="";
        			$scope.data.facreg.facilities.inspectionCompleted="";
        			$scope.data.facreg.facilities.facilityStatus="";
        			$scope.data.facreg.facilities.facilityAddress1="";
        			$scope.data.facreg.facilities.facilityAddress2="";
        			$scope.data.facreg.facilities.facilityCity="";
        			$scope.data.facreg.facilities.facilityState="";
        			$scope.data.facreg.facilities.facilityZip="";
        			$scope.data.facreg.facilities.facilityCNT="";
        			$scope.data.facreg.facilities.facilityPhone="";
        			$scope.data.facreg.facilities.fac_phone_ext="";
        			$scope.data.facreg.facilities.fac_phone2="";
        			$scope.data.facreg.facilities.facilityFax="";
        			$scope.data.facreg.facilities.facilityEmail="";
        			$scope.data.facreg.facilities.facilityComments="";*/
        			var message = '<div class="text-center"  ><h3><b>Facility Details Updated Successfully</b></h3></div>';
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
    $scope.cancel=function(){
    	alert("test");
   		//$scope.modalInstance.dismiss('cancel');
   	}	
    
    var ModalInstanceCtrl1 = function($scope, $uibModalInstance) {
		$scope.ok = function() {
			//$uibModalInstance.close();
			//$scope.modalInstance.close();
			//$location.url('/FCsearch');
			$window.location.reload();
		};
		
	};
    $scope.disableInputs = true;
	 $scope.selectChange = function(){
		 switch($scope.data.facreg.fclass.facClass){
			case '06' : 
		    case '23' : 
		    case '18' : 
		    case '05' : 
		    case '20' : 
		    case '07' : 
		    case '071' : 
		    case '19' : 
		    case '21' : 
		    case '04' :  
	      $scope.disableInputs = false;
	      break;
   default :
   $scope.disableInputs = true;
     console.log("no value");
 }
}     
       
	    
         $scope.deleteFRecit = function(recId) {
      		var message = '<div class="text-center"  ><h3><b>Do you want to delete transcation</b></h3></div>';
      		var modalHtml = '<div class="modal-body">' + message + '</div>';
      		modalHtml += '<div class="modal-footer" style="text-align:center;border-top:;"><button class="btn btn" ng-click="ok()">Yes</button><button class="btn btn" style="margin-left: 12%" ng-click="cancel()">No</button></div>';
      		var modalInstance = $uibModal.open({
      			template : modalHtml,
      			controller : ModalInstanceCtrl
      		});
      		modalInstance.result.then(function() {
      			var transcation = $scope.facilityRegistrations[recId];
      			var id=transcation.id;
      			//$rootScope.tmp_facId=$scope.tmp_facId;
      			// $rootScope.fdata.id=passingValues.id;
      			$http.get('api/trans/delete/'+id).then(
      					function(response) {
      				
     	        			$scope.facilityRegistrations.splice(recId,1);

      					},
      					function(response) {
      						console.log("Error While posting the data ---> "+ response.status);
      						$scope.facilityRegistrations.splice(recId,1);
      						if (response.status == 409) {
      							$scope.data.isDuplicateApp = true;
      						}
      					}

      					/*function(response) {
    		    			$location.path('error');
    		    			console.log("Error While getting the data"); 
    		    		}*/
      			);

      		});

      	}
     
         
         var ModalInstanceCtrl = function($scope, $uibModalInstance) {
     		$scope.ok = function() {
     			$uibModalInstance.close();
     		};
     		$scope.cancel = function() {
     			$uibModalInstance.dismiss('cancel');
     		};
     	};
 	  	
     	$scope.print_renual=function(){  
     		//$scope.fac_id
     		
    		api='api/facility/renewals/generate1stnotice?facid='+$scope.fac_id;
    		$http.get(api)
    		  	.then(function (response) {
    		  		console.log('response data for print renewal'+response.data);
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

     	
     	$scope.print_licence=function(){    
     		
    		api='api/facility/print/license?facId='+$scope.fac_id;
    		$http.get(api)
    		  	.then(function (response) {
    		  		console.log(response.data);
    		  		 var link = document.createElement('a');
                     link.href = response.data;//window.URL.createObjectURL(blob);
                     link.download = "License_output.pdf";
                     link.click();
    		 },
    		 function(response) {
	    			$location.path('error');
	    			console.log("Error While getting the data"); 
	    		});
     	}
     	
     	$scope.printRecord = function(){

     		console.log("$scope.data.facreg.facilities.corporationId"+$scope.data.facreg.facilities);
     		if($scope.data.facreg.facilities!=null) {
     			$scope.data.facreg.facilities.facilityMailingAddressOne=$scope.data.facreg.facilities.facilityAddress1;
     			$scope.data.facreg.facilities.facilityMailingAddress2=$scope.data.facreg.facilities.facilityAddress2;
     			$scope.data.facreg.facilities.facilityMailingCity=$scope.data.facreg.facilities.facilityCity;
     			$scope.data.facreg.facilities.facilityMailingState=$scope.data.facreg.facilities.facilityState;
     			$scope.data.facreg.facilities.facilityMailingZip=$scope.data.facreg.facilities.facilityZip;
     			if($scope.data.facreg.facilities.inspectionCompletedDate!=null){
     				//$scope.data.facreg.facilities.inspectionCompletedDate=new Date($scope.data.facreg.facilities.inspectionCompletedDate);
     				$scope.data.facreg.facilities.inspectionCompletedDate= $filter('date')($scope.data.facreg.facilities.inspectionCompletedDate, 'yyyy-MM-dd'); 
     			}
     			console.log('$scope.data.facreg.facilities.facilityStatus  '+$scope.data.facreg.facilities.facilityStatus);
         		if($scope.data.facreg.facilities.facilityStatus!=null) {
         			var facStatus =$filter('filter')($scope.status, {'code':$scope.data.facreg.facilities.facilityStatus.trim()},true)[0];
         			if(facStatus!=null) {
         				$scope.data.facreg.facilities.facilityStatus=facStatus.name;
         			}
         		}
         		
         		if($scope.data.facreg.facilities.facilityCNT!=null) {
         			var facCNT =$filter('filter')($scope.countries, {'code':$scope.data.facreg.facilities.facilityCNT.trim()},true)[0];
         			if(facCNT!=null) {
         				$scope.data.facreg.facilities.facilityCNT=facCNT.name;
         			}
         		}
         		
         		/*if($scope.data.facreg.facilities.facType!=null) {
         			var facType =$filter('filter')($scope.LicenseType, {'code':$scope.data.facreg.facilities.facType.trim()},true)[0];
         			if(facType!=null) {
         				$scope.data.facreg.facilities.facType=facType.name;
         			}
         		}*/
         		if($scope.data.facreg.fclass!=null) {
         			if($scope.data.facreg.fclass.facClass!=null) {
         				var facType =$filter('filter')($scope.LicenseType, {'code':$scope.data.facreg.fclass.facClass.trim()},true)[0];
         				if(facType!=null) {
         					$scope.data.facreg.facilities.facType=facType.name;
         				}
         			}
         		}
         		
         		

     		}
     		
     		if($scope.data.facreg.corp!=null) {
     			$scope.data.facreg.facilities.facilityMailingLastName=$scope.data.facreg.corp.cLast;
     			$scope.data.facreg.facilities.facilityMailingFirstName=$scope.data.facreg.corp.cFirst;
     			$scope.data.facreg.facilities.facilityMailingMiddleName=$scope.data.facreg.corp.cMiddle;
     			$scope.data.facreg.facilities.facilityMailingSuffix=$scope.data.facreg.corp.cSuffix;
     			$scope.data.facreg.facilities.facilityMailingTitle=$scope.data.facreg.corp.cTitle;
     			if($scope.data.facreg.corp.corpCountry!=null) {
     				var corpCNT =$filter('filter')($scope.countries, {'code':$scope.data.facreg.corp.corpCountry},true)[0];
     				if(corpCNT!=null) {
     					$scope.data.facreg.corp.corpCountry=corpCNT.name;
     				}
     			}
     		}
     		
     		if($scope.data.facreg.foodProcesorInfo!=null){
     			$scope.data.facreg.foodProcesorInfo.prod_cat1=$scope.data.facreg.foodProcesorInfo.prodCat1;
     			$scope.data.facreg.foodProcesorInfo.prod_cat2=$scope.data.facreg.foodProcesorInfo.prodCat2;
     			$scope.data.facreg.foodProcesorInfo.prod_cat3=$scope.data.facreg.foodProcesorInfo.prodCat3;
     			$scope.data.facreg.foodProcesorInfo.prod_cat4=$scope.data.facreg.foodProcesorInfo.prodCat4;

     			$scope.data.facreg.foodProcesorInfo.prod_sub_cat1=$scope.data.facreg.foodProcesorInfo.prodSubCat1;
     			$scope.data.facreg.foodProcesorInfo.prod_sub_cat2=$scope.data.facreg.foodProcesorInfo.prodSubCat2;
     			$scope.data.facreg.foodProcesorInfo.prod_sub_cat3=$scope.data.facreg.foodProcesorInfo.prodSubCat3;
     			$scope.data.facreg.foodProcesorInfo.prod_sub_cat4=$scope.data.facreg.foodProcesorInfo.prodSubCat4;

     		}
     		if($scope.data.facreg.registration!=null){
//     			$scope.data.facreg.registration.dateExpire=$scope.data.facreg.registration.dateExpire;
//     			$scope.data.facreg.registration.dateIssue=$scope.data.facreg.registration.dateIssue;
     			
     			if($scope.data.facreg.registration.dateExpire!=null) {
     				var dateExpire = $scope.data.facreg.registration.dateExpire;
     				var newExpiredate = dateExpire.split("/").reverse().join("-");
     			}else {
     				var newExpiredate=null;
     			}
     			if($scope.data.facreg.registration.dateIssue!=null) {
     				var dateIssue = $scope.data.facreg.registration.dateIssue;
     				var newIssuedate = dateIssue.split("/").reverse().join("-");
     			}else {
     				var newIssuedate=null;
     			}
     			$scope.data.facreg.registration.dateExpire=newExpiredate;
     			
     			$scope.data.facreg.registration.dateIssue=newIssuedate; 
     			$scope.data.facreg.registration.regLicense=$scope.data.facreg.registration.regLicense;
     		}
     		if($scope.facilityRegistrations!=null) {
     			$scope.data.facreg.transactions=$scope.facilityRegistrations;
     		}
     		var facility = $scope.data.facreg;


     		$http.post('api/facility/reports/printRecord', facility)
     		.then(
     				function(response) {
     					console.log("Downloading Fiscal report ");
     					if($scope.data.facreg.facilities!=null) {
     						if($scope.data.facreg.facilities.facilityStatus!=null) {
     							var facStatus =$filter('filter')($scope.status, {'name':$scope.data.facreg.facilities.facilityStatus.trim()},true)[0];
     							if(facStatus!=null) {
     								$scope.data.facreg.facilities.facilityStatus=facStatus.code;
     							}
     						}

     						if($scope.data.facreg.facilities.facilityCNT!=null) {
     							var facCNT =$filter('filter')($scope.countries, {'name':$scope.data.facreg.facilities.facilityCNT.trim()},true)[0];
     							if(facCNT!=null) {
     								$scope.data.facreg.facilities.facilityCNT=facCNT.code;
     							}
     						}
     					}
     					
     					if($scope.data.facreg.corp!=null) {
     						if($scope.data.facreg.corp.corpCountry!=null) {
     							var corpCNT =$filter('filter')($scope.countries, {'name':$scope.data.facreg.corp.corpCountry},true)[0];
     							if(corpCNT!=null) {
     								$scope.data.facreg.corp.corpCountry=corpCNT.code;
     							}
     						}
     					}
     					var link = document.createElement('a');
     					link.href = response.data;//window.URL.createObjectURL(blob);
     					link.download = "FacilitiesReport.xlsx";
     					link.click();

     				},/*function(error){
     					console.log("errror occured");
     				}*/
     				function(response) {
		    			$location.path('error');
		    			console.log("Error While getting the data"); 
		    		}		
     		
     		);  

     	}
}
