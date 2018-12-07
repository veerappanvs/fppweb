function FacilityRegistrationCtrl($uibModal, $rootScope, $scope, $http,$routeParams, $window, $location) {
	
//	$scope.countries_key_value={'IN':'INDIA','USA':'USA'};
//	$scope.countries=[{"code":"IN","name":"INDIA"},{"code":"USA","name":"USA"}]
	$scope.countries=glob_countries;
	$scope.countries1 = $scope.countries;
	
	/*$scope.status = ['Active','Pending','Withdrawn','Refund Issued','Suspended','Deceased','Moved out of Mass','Out of Business'];*/
	
	$scope.status=glob_status;

	/*$scope.LicenseType = ['Bedding-Toys Sterilization','Food Processors','Frozen Desserts','IMS Rating','Non-alcoholic (in-of-state)','Non-alcoholic (out-of-state)','Out of State Bakeries','Vending Machines','Water Vending','Stuffed Toy','Single Service Rating','Residential Kitchen','Methyl Wood','Health Certificate'];*/
	/*$scope.LicenseType=[{"code":"09","name":"Bedding"},{"code":"05","name":"Food Processors"}]*/
	$scope.LicenseType=glob_LicenseType;
/*	alert(glob_LicenseType);
	console.log(glob_LicenseType);*/
	
	
	/*
	$scope.LicenseType = ['Bottled Water and Carbonated Non-Alcoholic Beverages (In-State)','Methyl Alcohol','Processor, Baked Goods','Processor, Food','Processor, Frozen Desserts','Processor, Residential Kitchen','Processor, Seafood','Distributor, Food','Warehouse',
		'Cold Storage Warehouse','Out-of-State Bakeries','Vending Machines, Food and Beverages','Vending Machines, Water Only','Bedding','Upholstered Furniture','Stuffed Toys', 'Sterilization',
		'Out-of-State Frozen Desserts', 'Processor, Milk(IMS Rating)','Processor, Milk(Single Service Manufacturer Rating)','Research Animals(cats and dogs)',
		'Export Statements','Health Certificate','Bottled Water and Carbonated Non-Alcoholic Beverages (Out-of-State)','Processor, Meat & Poultry(>$10 million annual sales)','Processor, Meat & Poultry(all other M&P processors)','Milk Laboratory State Certification',
		'Milk Laboratory Inspection per Procedural Specialty','Milk Laboratory Interstate Licenses','Mics.Revenue'];
	*/$scope.PrimOperation = ['Seafood and/or Shellfish','Meat and/or Poultry','Dairy Products','Frozen Desserts','Baked Goods','Multiple Foods','No food processing'];
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
	$scope.facilityRegistrations=[];
	$scope.fac = {};
	$scope.data={facreg:{facilities:{}}};
	$scope.data.facreg.facilities.facilityCNT='33';
	$scope.data.facreg.facilities.facilityStatus=' ';

	
	$scope.getProductsforCat=function(index){
		var element="prodCat"+index;
		var key = $scope.ProdCategory.indexOf($scope.data.facreg.foodProcesorInfo[element]);
		var element="product"+index+"_products";
		$scope[element]=$scope.productsByCat[key];
	}


      $scope.getFacilityRegistration = function(uri){
		  $http.get(uri)
		  	.then(function (response) {
		  		console.log(response.data);
		  		/*$scope.facilityRegistrations=[{ 'certAction':'ACTION1','receipt': 'RECIPET','checkNo': '100','amount': '100','user': 'ASD','enter': 'XYZ'},
                    { 'certAction':'ACTION1','receipt': 'RECIPET1','checkNo': '2','amount': '1','user': 'USER1','enter': 'A'},
                    { 'certAction':'ACTION2','receipt': 'RECIPET2','checkNo': '3','amount': '2','user': 'USER2','enter': 'B'},
                    { 'certAction':'ACTION3','receipt': 'RECIPET3','checkNo': '4','amount': '3','user': 'USER3','enter': 'C'},
                    { 'certAction':'ACTION4','receipt': 'RECIPET4','checkNo': '5','amount': '4','user': 'USER4','enter': 'D'},
                    { 'certAction':'ACTION5','receipt': 'RECIPET5','checkNo': '6','amount': '5','user': 'USER5','enter': 'ROHIT'},
            ];*/
		      if(response.data.length>0){
		     // $scope.facilityRegistrations=response.data;
		      }	
		  	
		  		
		    },
		    function(response) {
    			$location.path('error');
    			console.log("Error While getting the data"); 
    		}
		  	);
	  };
	  
	  	$scope.getFacilityRegistration('api/gl/batchnumbers/get-last-batch');
	  	
	  	
	 
	 
	 $scope.disableInputs = true;
	 $scope.selectChange = function(){
		 console.log($scope.disableInputs + ' select Change '+$scope.data.facreg.facilities.facType);
  switch($scope.data.facreg.facilities.facType){
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
      console.log("no value "+$scope.disableInputs);
  }
}

//$scope.validation=[];
 $scope.saveData = function(){
	 $scope.validation=[];
	 var valid=1;
	 
	/*	  if(!$scope.data.facreg.facilities.facilityPhone || $scope.data.facreg.facilities.facilityPhone=='undefined'){
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
			  }  */
		  if(!$scope.data.facreg.facilities.facilityStatus || $scope.data.facreg.facilities.facilityStatus=='undefined'){
				 $scope.validation.facilityStatus=1;
				 valid=0;
			  } 
		  if(valid!=1){
			  $scope.validation.status=1;
			  return 0;
		  }
		 	$scope.master = {};
            
		 	console.log("$scope.data.facreg.facilities.corporationId"+$scope.data.facreg.facilities);
		 //	console.log("$scope.data.facreg.corp.corporationId"+$scope.data.facreg.corp.corporationId);
		 	
		 	// $scope.data.facreg.facilities.corporationId=123444;
		  		var facility = $scope.data.facreg;
		  		console.log('data.facreg.facilities.isDefaultMailingAdd  ==>'+$scope.data.facreg.facilities.isDefaultMailingAdd);
		  		console.log('saveData  facility  -->'+JSON.stringify(facility));
		  		//$scope.data.facreg.fclass = 
		  		//$scope.data.facreg.fclass.facStatus = $scope.data.facreg.facilities.facStatus;
	  			//$scope.data.facreg.facilities.isDefaultMailingAdd = ($scope.data.facreg.facilities.isDefaultMailingAdd==true?'Y':'N');

		  		if(facility.facilities.isDefaultMailingAdd || facility.facilities.isDefaultMailingAdd == 'true' || facility.facilities.isDefaultMailingAdd == true || facility.facilities.isDefaultMailingAdd == 1){
		  		//if($scope.sameAddress){
		  			console.log('Copying facility addtess to facility mailing addresss');
		  			$scope.data.facreg.facilities.facilityMailingAddressOne=$scope.data.facreg.facilities.facilityAddress1;
		  			$scope.data.facreg.facilities.facilityMailingAddress2=$scope.data.facreg.facilities.facilityAddress2;
		  			$scope.data.facreg.facilities.facilityMailingCity=$scope.data.facreg.facilities.facilityCity;
		  			$scope.data.facreg.facilities.facilityMailingState=$scope.data.facreg.facilities.facilityState;
		  			$scope.data.facreg.facilities.facilityMailingZip=$scope.data.facreg.facilities.facilityZip;
		  			
		  			//TODO Check this is required
		  			$scope.data.facreg.facilities.facilityMailingLastName=$scope.data.facreg.corp.cLast;
		  			$scope.data.facreg.facilities.facilityMailingFirstName=$scope.data.facreg.corp.cFirst;
		  			$scope.data.facreg.facilities.facilityMailingMiddleName=$scope.data.facreg.corp.cMiddle;
		  			$scope.data.facreg.facilities.facilityMailingSuffix=$scope.data.facreg.corp.cSuffix;
		  			$scope.data.facreg.facilities.facilityMailingTitle=$scope.data.facreg.corp.cTitle;
		  			$scope.data.facreg.facilities.isDefaultMailingAdd = true;


		  		}else{
		  			
		  			console.log('Copying corp addtess to facility mailing addresss');
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
		  			$scope.data.facreg.facilities.isDefaultMailingAdd = false;
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
					$scope.data.facreg.registration.dateExpire=$scope.data.facreg.registration.expries;
		  			$scope.data.facreg.registration.dateIssue=$scope.data.facreg.registration.issued;
		  			$scope.data.facreg.registration.regLicense=$scope.data.facreg.registration.fac_license_no;
				}
		  		
	        $http.post('api/facility/create', facility)
	        
	        .then(
	        		
	        		function(response) 
	        		{
	        			$scope.data.facreg.fclass =[];
	        			console.log();
	        			//$scope.data.facreg.fclass.facStatus = $scope.data.facreg.facilities.facStatus;
	        			$scope.fac = response.data;
	        			console.log('Facility created : '+response.location);
	        			$scope.hasInserted=true;
	        		/*	$scope.data.facreg.facilities.facilityName="";
	        			$scope.data.facreg.facilities.facilityType="";
	        			$scope.data.facreg.facilities.inspectionCompleted="";
	        			$scope.data.facreg.facilities.facStatus="";
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
	        			var message = '<div class="text-center"  ><h3><b>Facility created Successfully</b></h3></div>';
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
	        		}
	        		*/
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
          /*  $scope.update = function(corp) {
			//	debugger;
				console.log("Error While posting the data ---> "+$scope.data.facreg.corp);
              $scope.data.facreg.facilities.facilityAddress1 = $scope.data.facreg.corp.corp_address1;
               $scope.data.facreg.facilities.facilityAddress2 = $scope.data.facreg.corp.corp_address2;
                $scope.data.facreg.facilities.facilityCity = $scope.data.facreg.corp.corp_address_city;
                 $scope.data.facreg.facilities.facilityState = $scope.data.facreg.corp.corp_address_state;
                  $scope.data.facreg.facilities.facilityCNT = $scope.data.facreg.corp.corp_address_country;
                $scope.data.facreg.facilities.facilityPhone = $scope.data.facreg.corp.corp_phone;
                 $scope.data.facreg.facilities.fac_phone_ext = $scope.data.facreg.corp.corp_phone_ext;
                  $scope.data.facreg.facilities.facilityEmail = $scope.data.facreg.corp.corp_email;   
                   $scope.data.facreg.facilities.facilityZip = $scope.data.facreg.corp.corp_address_zip;   
                   $scope.data.facreg.facilities.corporationId=$scope.data.facreg.corp.corporationId;
                   
            };
            */
            
        $scope.CorporationNameArr=[];
		$scope.showSearchResults = function(){
		console.log("getCorporationName Array::"+$scope.data.facreg.corp);
		if($scope.data.facreg.corp.corpName.length > 4)
			{
		$http.get('api/corp/all?corpName='+$scope.data.facreg.corp.corpName)
	    .then(
	    		function(response) {
					//debugger;
	    			console.log("$scope.orporationName Array length ="+response.data.length); 
	    				$scope.CorporationNameArr=[];
	    			if(response!=null && response.data!="undefined" && response.data.length>0){
		    			for(var i=0;i<response.data.length;i++){
			    			$scope.CorporationNameArr.push(response.data[i]);
		    			}
	    			} else {console.log("elsseeeeeeeeeeeeeeeeeeeee");
	    				$scope.CorporationNameArr=[];
	    			}
	    			console.log("$scope.getCorporationName Array ="+$scope.CorporationNameArr); 
	    		}, 
	    		/*function(response) {
	    			console.log("Error While getting the data"); 
	    		}*/
	    		function(response) {
	    			$location.path('error');
	    			console.log("Error While getting the data"); 
	    		}
	    );
			}
	 };
	 
	 $scope.CorporationName= function(corpDetails){
		// debugger;
		 console.log("corpDetails:"+corpDetails+"  Length : "+corpDetails.length);
		 $scope.data.facreg.corp.corpName=corpDetails.corpName;
		 $scope.data.facreg.corp=corpDetails;
		 
		 
/*		 $scope.data.facreg.corp.corp_address1=corpDetails.corpAdd1;
		 $scope.data.facreg.corp.corp_address2=corpDetails.corpAdd2;
		  $scope.data.facreg.corp.corp_address_city=corpDetails.corpCity;
		   $scope.data.facreg.corp.corp_address_state=corpDetails.corpState;
		   
		     $scope.data.facreg.corp.corp_phone=corpDetails.corpPhone;
		      $scope.data.facreg.corp.corp_address_zip=corpDetails.corpZip
		      
		       $scope.data.facreg.corp.corp_email=corpDetails.corpEmail;
		 $scope.data.facreg.corp.corp_lname=corpDetails.cLast;
		  $scope.data.facreg.corp.corp_fname=corpDetails.cFirst;
		  $scope.data.facreg.corp.corp_mname=corpDetails.cMiddle;
		 $scope.data.facreg.corp.corp_suffix=corpDetails.cSuffix;      
		 $scope.data.facreg.corp.corp_title=corpDetails.cTitle;   
		  $scope.data.facreg.corp.corp_prt_cmts=corpDetails.cComments;  
		  $scope.data.facreg.corp.corporationId=corpDetails.corporationId;*/
          
		
		
		 $scope.CorporationNameArr=[];
		 
	 }

$scope.editTranscation=function(index){
		console.log(" editTranscation index : "+index);
		var transcation = $scope.facilityRegistrations[index];
	console.log("editTranscation:"+transcation);
	$http.post('api/facility/create', transcation)
	        .then(
	        		function(response) {
	        			$scope.fac = response.data;
	        			console.log('Transcation Edited : '+response.data);
	        		
	        		}, 
	        		/*function(response) {
	        			console.log("Error While posting the data ---> "+response.status );
	        			$location.path('detail');
	        		}*/
	        		function(response) {
		    			$location.path('error');
		    			console.log("Error While getting the data"); 
		    		}
	        		
	        );  
	}
	
	$scope.deleteTranscation=function(index){
		console.log(" deleteTranscation index : "+index);
		var transcation = $scope.facilityRegistrations[index];
	
	console.log("deleteTranscation:"+transcation);
	$http.post('api/facility/create', transcation)
	        .then(
	        		function(response) {
	        			$scope.fac = response.data;
	        			$scope.facilityRegistrations.splice(index,1);
	        			console.log('Transcation deleted : '+response.data);
	        		
	        		}, 
/*	        		function(response) {
	        			console.log("Error While posting the data ---> "+response.status );
	        			$location.path('detail');
	        		}
*/				function(response) {
		    			$location.path('error');
		    			console.log("Error While getting the data"); 
		    		}        		
	        );  
	}
            
            
	 
}
