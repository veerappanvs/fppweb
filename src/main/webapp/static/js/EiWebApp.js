var app = angular.module("EiWebApp", ['ngRoute', 'ngTouch',  'ui.bootstrap',  'ui.grid', 
	'ui.grid.selection', 'ui.grid.exporter', 'ui.grid.treeView',  'ui.grid.resizeColumns', 
	'ui.grid.expandable', 'ui.grid.selection', 'ui.grid.pinning','ui.grid.edit']);

app.directive('onlyNumbers1',function(){
	return {
		 template : "<h1>Made by a directive!</h1>"
		//console.log("test");
	};
});
app.directive('onlyNumbers', function () {
    return  {
        restrict: 'A',
        link: function (scope, elm, attrs, ctrl) {
            elm.on('keydown', function (event) {
            	alert("teeeees");
                if(event.shiftKey){event.preventDefault(); return false;}
                //console.log(event.which);
                if ([8, 13, 27, 37, 38, 39, 40].indexOf(event.which) > -1) {
                    // backspace, enter, escape, arrows
                    return true;
                } else if (event.which >= 48 && event.which <= 57) {
                    // numbers 0 to 9
                    return true;
                } else if (event.which >= 96 && event.which <= 105) {
                    // numpad number
                    return true;
                } 
                // else if ([110, 190].indexOf(event.which) > -1) {
                //     // dot and numpad dot
                //     return true;
                // }
                else {
                    event.preventDefault();
                    return false;
                }
            });
        }
    }
});


/*var global_LicenseType=['Bottled Water and Carbonated Non-Alcoholic Beverages (In-State)','Methyl Alcohol','Processor, Baked Goods','Processor, Food','Processor, Frozen Desserts','Processor, Residential Kitchen','Processor, Seafood','Distributor, Food','Warehouse',
	'Cold Storage Warehouse','Out-of-State Bakeries','Vending Machines, Food and Beverages','Vending Machines, Water Only','Bedding','Upholstered Furniture','Stuffed Toys', 'Sterilization',
	'Out-of-State Frozen Desserts', 'Processor, Milk(IMS Rating)','Processor, Milk(Single Service Manufacturer Rating)','Research Animals(cats and dogs)',
	'Export Statements','Health Certificate','Bottled Water and Carbonated Non-Alcoholic Beverages (Out-of-State)','Processor, Meat & Poultry(>$10 million annual sales)','Processor, Meat & Poultry(all other M&P processors)','Milk Laboratory State Certification',
	'Milk Laboratory Inspection per Procedural Specialty','Milk Laboratory Interstate Licenses','Mics.Revenue']
*/

var  global_LicenseType = ["","Baked Goods Processor",
	"Cold Storage Warehouse",
	"Export Statements",
	"Food Distributor",
	"Food Processor",
	"In-State Bottled Water or Carbonated Non-Alcoholic Beverages",
	"Juice or Apple Cider Processor",
	"Meat and Poultry Processor (less than $10 million annual sales)",
	"Meat and Poultry Processor (greater than $10 million annual sales)",
	"Methyl Alcohol",
	"Milk Laboratory [IMS] (Interstate)",
	"Milk Laboratory [non-IMS] (Intrastate)",
	"Milk Laboratory Procedures",
	"Milk Processor (IMS Rating)",
	"Milk Processor(Single Service Manufacturer Rating)",
	"Miscellaneous Revenues",
	"Mobile Poultry Processing Unit",
	"Out-of-State Bakeries",
	"Out-of-State Bottled Water or Carbonated Non-Alcoholic Beverages",
	"Out-of-State Frozen Desserts",
	"Research Animals (cats and dogs)",
	"Residential Kitchen Processor",
	"Seafood and/or Shellfish Processor",
	"Sterilization",
	"Stuffed Toys",
	"Upholstered Furniture or Bedding",
	"Vending Machines (Food and Beverages)",
	"Vending Machines (Water Only)",
	"Warehouse"	]

var  global_LicenseType_shifted = ["Baked Goods Processor",
	"Cold Storage Warehouse",
	"Export Statements",
	"Food Distributor",
	"Food Processor",
	"In-State Bottled Water or Carbonated Non-Alcoholic Beverages",
	"Juice or Apple Cider Processor",
	"Meat and Poultry Processor (less than $10 million annual sales)",
	"Meat and Poultry Processor (greater than $10 million annual sales)",
	"Methyl Alcohol",
	"Milk Laboratory [IMS] (Interstate)",
	"Milk Laboratory [non-IMS] (Intrastate)",
	"Milk Laboratory Procedures",
	"Milk Processor (IMS Rating)",
	"Milk Processor(Single Service Manufacturer Rating)",
	"Miscellaneous Revenues",
	"Mobile Poultry Processing Unit",
	"Out-of-State Bakeries",
	"Out-of-State Bottled Water or Carbonated Non-Alcoholic Beverages",
	"Out-of-State Frozen Desserts",
	"Research Animals (cats and dogs)",
	"Residential Kitchen Processor",
	"Seafood and/or Shellfish Processor",
	"Sterilization",
	"Stuffed Toys",
	"Upholstered Furniture or Bedding",
	"Vending Machines (Food and Beverages)",
	"Vending Machines (Water Only)",
	"Warehouse"	]


var global_RevenueSrCode = ["", "0604",
	"0604",
	"3029",
	"0604",
	"0604",
	"3066",
	"0604",
	"3025",
	"3025",
	"3065",
	"0684",
	"0684",
	"0684",
	"3000",
	"3005",
	"6900",
	"3025",
	"0606",
	"3066",
	"3068",
	"0605",
	"0604",
	"0604",
	"3022",
	"3022",
	"3022",
	"3024",
	"3024",
	"0604"]



var global_Fee = ["", 
	"300",
	"300",
	"75",
	"300",
	"300",
	"75",
	"300",
	"225",
	"375",
	"150",
	"300",
	"225",
	"300",
	"750",
	"300",
	"0",
	"225",
	"300",
	"300",
	"300",
	"150",
	"300",
	"300",
	"300",
	"300",
	"300",
	"10",
	"10",
	"300"
				]

var glob_licensetypeWithFee=[{"code":"06","name":"Baked Goods Processor","fee":"300"},
	{"code":"23","name":"Cold Storage Warehouse","fee":"300"},
	{"code":"30","name":"Export Statements","fee":"75"},
	{"code":"18","name":"Food Distributor","fee":"300"},
	{"code":"05","name":"Food Processor","fee":"300"},
	{"code":"01","name":"In-State Bottled Water or Carbonated Non-Alcoholic Beverages","fee":"75"},
	{"code":"20","name":"Juice or Apple Cider Processor","fee":"300"},
	{"code":"071","name":"Meat and Poultry Processor (less than $10 million annual sales)","fee":"225"},
	{"code":"07","name":"Meat and Poultry Processor (greater than $10 million annual sales)","fee":"375"},
	{"code":"08","name":"Methyl Alcohol","fee":"150"},
	{"code":"25","name":"Milk Laboratory [IMS] (Interstate)","fee":"300"},
	{"code":"26","name":"Milk Laboratory [non-IMS] (Intrastate)","fee":"225"},
	{"code":"27","name":"Milk Laboratory Procedures","fee":"300"},
	{"code":"16","name":"Milk Processor (IMS Rating)","fee":"750"},
	{"code":"24","name":"Milk Processor(Single Service Manufacturer Rating)","fee":"300"},
	{"code":"31","name":"Miscellaneous Revenues","fee":"0"},
	{"code":"MSF1","name":"Mobile Poultry Processing Unit","fee":"225"},
	{"code":"29","name":"Out-of-State Bakeries","fee":"300"},
	{"code":"28","name":"Out-of-State Bottled Water or Carbonated Non-Alcoholic Beverages","fee":"300"},
	{"code":"02","name":"Out-of-State Frozen Desserts","fee":"300"},
	{"code":"11","name":"Research Animals (cats and dogs)","fee":"150"},
	{"code":"19","name":"Residential Kitchen Processor","fee":"300"},
	{"code":"21","name":"Seafood and/or Shellfish Processor","fee":"300"},
	{"code":"15","name":"Sterilization","fee":"300"},
	{"code":"10","name":"Stuffed Toys","fee":"300"},
	{"code":"09","name":"Upholstered Furniture or Bedding","fee":"300"},
	{"code":"04","name":"Vending Machines (Food and Beverages)","fee":"10"},
	{"code":"04W","name":"Vending Machines (Water Only)","fee":"10"},
	{"code":"22","name":"Warehouse","fee":"300"}]


var glob_LicenseType=[{"code":"06","name":"Baked Goods Processor"},
	{"code":"23","name":"Cold Storage Warehouse"},
	{"code":"30","name":"Export Statements"},
	{"code":"18","name":"Food Distributor"},
	{"code":"05","name":"Food Processor"},
	{"code":"01","name":"In-State Bottled Water or Carbonated Non-Alcoholic Beverages"},
	{"code":"20","name":"Juice or Apple Cider Processor"},
	{"code":"071","name":"Meat and Poultry Processor (less than $10 million annual sales)"},
	{"code":"07","name":"Meat and Poultry Processor (greater than $10 million annual sales)"},
	{"code":"08","name":"Methyl Alcohol"},
	{"code":"25","name":"Milk Laboratory [IMS] (Interstate)"},
	{"code":"26","name":"Milk Laboratory [non-IMS] (Intrastate)"},
	{"code":"27","name":"Milk Laboratory Procedures"},
	{"code":"16","name":"Milk Processor (IMS Rating)"},
	{"code":"24","name":"Milk Processor(Single Service Manufacturer Rating)"},
	{"code":"31","name":"Miscellaneous Revenues"},
	{"code":"MSF1","name":"Mobile Poultry Processing Unit"},
	{"code":"29","name":"Out-of-State Bakeries"},
	{"code":"28","name":"Out-of-State Bottled Water or Carbonated Non-Alcoholic Beverages"},
	{"code":"02","name":"Out-of-State Frozen Desserts"},
	{"code":"11","name":"Research Animals (cats and dogs)"},
	{"code":"19","name":"Residential Kitchen Processor"},
	{"code":"21","name":"Seafood and/or Shellfish Processor"},
	{"code":"15","name":"Sterilization"},
	{"code":"10","name":"Stuffed Toys"},
	{"code":"09","name":"Upholstered Furniture or Bedding"},
	{"code":"04","name":"Vending Machines (Food and Beverages)"},
	{"code":"04W","name":"Vending Machines (Water Only)"},
	{"code":"22","name":"Warehouse"}				
						]

/*var glob_countries=[{"code":"1","name":"AUSTRALIA"},{"code":"2","name":"BRAZIL"},{"code":"3","name":"CANADA"},{"code":"4","name":"CHINA"},{"code":"5","name":"DENMARK"},{"code":"6","name":"ENGLAND"},{"code":"7","name":"FRANCE"},{"code":"8","name":"GERMANY"},{"code":"9","name":"HONG KONG"},{"code":"10","name":"ICELAND"}
					,{"code":"11","name":"INDIA"},{"code":"12","name":"INDONESIA"},{"code":"13","name":"ISRAEL"},{"code":"14","name":"ITALY"},{"code":"15","name":"KOREA"},{"code":"16","name":"MALAYSIA"},{"code":"17","name":"MEXICO"},{"code":"18","name":"NEW ZEALAND"}
					,{"code":"19","name":"NORWAY"},{"code":"20","name":"PAKISTAN"},{"code":"21","name":"PHILIPPINES"},{"code":"22","name":"POLAND"},{"code":"23","name":"PORTUGAL"},{"code":"24","name":"SELANGOR"},{"code":"25","name":"SLOVAKIA"},{"code":"26","name":"SOUTH KOREA"},{"code":"27","name":"SPAIN"},{"code":"28","name":"SRI LANKA"}
					,{"code":"29","name":"TAIWAN"},{"code":"30","name":"THAILAND"},{"code":"31","name":"TURKEY"},{"code":"32","name":"UNITED KINGDOM"},{"code":"33","name":"USA"},{"code":"34","name":"VIETNAM"},{"code":"36","name":"IRELAND"}
					,{"code":"37","name":"DOMINICAN REPUBLIC"},{"code":"38","name":"GREAT BRITIAN"},{"code":"41","name":"SWEDEN"},{"code":"42","name":"AFRICA"},{"code":"43","name":"SINGAPORE"},{"code":"45","name":"ROMANIA"}
					,{"code":"46","name":"CHILE"},{"code":"47","name":"HUNGARY"},{"code":"48","name":"EGYPT"},{"code":"49","name":"LITHUANIA"},{"code":"50","name":"PERU"},{"code":"51","name":"HONDURAS"},{"code":"52","name":"BELGIUM"},{"code":"53","name":"FINLAND"}
					,{"code":"54","name":"CZEC REPUBLIC"},{"code":"55","name":"BANGLADESH"},{"code":"56","name":"MOROCCO"},{"code":"58","name":"CAMBODIA"},{"code":"59","name":"BAHRAIN"},{"code":"39","name":"JAPAN"},{"code":"57","name":"AUSTRIA"}]
*/



var glob_countries=[{"code":"42","name":"AFRICA"},
	{"code":"62","name":"ALBANIA"},
	{"code":"63","name":"ALGERIA"},
	{"code":"64","name":"AMERICAN SAMOA"},
	{"code":"65","name":"ANDORRA"},
	{"code":"66","name":"ANGOLA"},
	{"code":"67","name":"ANTARCTICA"},
	{"code":"68","name":"ANTIGUA AND BARBUDA"},
	{"code":"69","name":"ARGENTINA"},
	{"code":"70","name":"ARMENIA"},
	{"code":"71","name":"ARUBA"},
	{"code":"1","name":"AUSTRALIA"},
	{"code":"57","name":"AUSTRIA"},
	{"code":"74","name":"AZERBAIJAN"},
	{"code":"75","name":"BAHAMAS"},
	{"code":"59","name":"BAHRAIN"},
	{"code":"55","name":"BANGLADESH"},
	{"code":"78","name":"BARBADOS"},
	{"code":"79","name":"BELARUS"},
	{"code":"52","name":"BELGIUM"},
	{"code":"81","name":"BELIZE"},
	{"code":"82","name":"BENIN"},
	{"code":"83","name":"BERMUDA"},
	{"code":"84","name":"BHUTAN"},
	{"code":"85","name":"BOLIVIA"},
	{"code":"86","name":"BOSNIA AND HERZEGOVINA"},
	{"code":"87","name":"BOTSWANA"},
	{"code":"88","name":"BOUVET ISLAND"},
	{"code":"2","name":"BRAZIL"},
	{"code":"90","name":"BRITISH INDIAN OCEAN TERRITORY"},
	{"code":"91","name":"BRUNEI DARUSSALAM"},
	{"code":"92","name":"BULGARIA"},
	{"code":"93","name":"BURKINA FASO"},
	{"code":"94","name":"BURUNDI"},
	{"code":"58","name":"CAMBODIA"},
	{"code":"96","name":"CAMEROON"},
	{"code":"3","name":"CANADA"},
	{"code":"98","name":"CAPE VERDE"},
	{"code":"99","name":"CAYMAN ISLANDS"},
	{"code":"100","name":"CENTRAL AFRICAN REPUBLIC"},
	{"code":"101","name":"CHAD"},
	{"code":"46","name":"CHILE"},
	{"code":"4","name":"CHINA"},
	{"code":"104","name":"CHRISTMAS ISLAND"},
	{"code":"105","name":"COCOS (KEELING) ISLANDS"},
	{"code":"106","name":"COLOMBIA"},
	{"code":"107","name":"COMOROS"},
	{"code":"108","name":"CONGO"},
	{"code":"110","name":"COOK ISLANDS"},
	{"code":"111","name":"COSTA RICA"},
	{"code":"112","name":"CÔTE DIVOIRE"},
	{"code":"113","name":"CROATIA"},
	{"code":"114","name":"CUBA"},
	{"code":"115","name":"CYPRUS"},
	{"code":"54","name":"CZECH REPUBLIC"},
	{"code":"5","name":"DENMARK"},
	{"code":"118","name":"DJIBOUTI"},
	{"code":"119","name":"DOMINICA"},
	{"code":"37","name":"DOMINICAN REPUBLIC"},
	{"code":"121","name":"ECUADOR"},
	{"code":"48","name":"EGYPT"},
	{"code":"123","name":"EL SALVADOR"},
	{"code":"6","name":"ENGLAND"},
	{"code":"124","name":"EQUATORIAL GUINEA"},
	{"code":"125","name":"ERITREA"},
	{"code":"126","name":"ESTONIA"},
	{"code":"127","name":"ETHIOPIA"},
	{"code":"128","name":"FALKLAND ISLANDS (MALVINAS)"},
	{"code":"129","name":"FAROE ISLANDS"},
	{"code":"130","name":"FIJI"},
	{"code":"53","name":"FINLAND"},
	{"code":"7","name":"FRANCE"},
	{"code":"133","name":"FRENCH GUIANA"},
	{"code":"134","name":"FRENCH POLYNESIA"},
	{"code":"135","name":"FRENCH SOUTHERN TERRITORIES"},
	{"code":"136","name":"GABON"},
	{"code":"137","name":"GAMBIA"},
	{"code":"8","name":"GERMANY"},
	{"code":"140","name":"GHANA"},
	{"code":"141","name":"GIBRALTAR"},
	{"code":"38","name":"GREAT BRITIAN"},
	{"code":"142","name":"GREECE"},
	{"code":"143","name":"GREENLAND"},
	{"code":"144","name":"GRENADA"},
	{"code":"145","name":"GUADELOUPE"},
	{"code":"146","name":"GUAM"},
	{"code":"147","name":"GUATEMALA"},
	{"code":"148","name":"GUINEA"},
	{"code":"149","name":"GUINEA-BISSAU"},
	{"code":"150","name":"GUYANA"},
	{"code":"151","name":"HAITI"},
	{"code":"152","name":"HEARD ISLAND AND MCDONALD ISLANDS"},
	{"code":"51","name":"HONDURAS"},
	{"code":"9","name":"HONG KONG"},
	{"code":"47","name":"HUNGARY"},
	{"code":"10","name":"ICELAND"},
	{"code":"11","name":"INDIA"},
	{"code":"12","name":"INDONESIA"},
	{"code":"160","name":"IRAQ"},
	{"code":"36","name":"IRELAND"},
	{"code":"13","name":"ISRAEL"},
	{"code":"14","name":"ITALY"},
	{"code":"164","name":"JAMAICA"},
	{"code":"39","name":"JAPAN"},
	{"code":"166","name":"JORDAN"},
	{"code":"167","name":"KAZAKHSTAN"},
	{"code":"168","name":"KENYA"},
	{"code":"169","name":"KIRIBATI"},
	{"code":"15","name":"KOREA"},
	{"code":"170","name":"KOREA, DEMOCRATIC PEOPLES REPUBLIC OF"},
	{"code":"171","name":"KOREA, REPUBLIC OF"},
	{"code":"172","name":"KUWAIT"},
	{"code":"173","name":"KYRGYZSTAN"},
	{"code":"174","name":"LAO PEOPLES DEMOCRATIC REPUBLIC (LAOS)"},
	{"code":"175","name":"LATVIA"},
	{"code":"176","name":"LEBANON"},
	{"code":"177","name":"LESOTHO"},
	{"code":"178","name":"LIBERIA"},
	{"code":"179","name":"LIBYAN ARAB JAMAHIRIYA"},
	{"code":"49","name":"LITHUANIA"},
	{"code":"182","name":"LUXEMBOURG"},
	{"code":"183","name":"MACAO"},
	{"code":"184","name":"MACEDONIA, THE FORMER YUGOSLAV REPUBLIC OF"},
	{"code":"185","name":"MADAGASCAR"},
	{"code":"186","name":"MALAWI"},
	{"code":"16","name":"MALAYSIA"},
	{"code":"188","name":"MALDIVES"},
	{"code":"189","name":"MALI"},
	{"code":"190","name":"MALTA"},
	{"code":"191","name":"MARSHALL ISLANDS"},
	{"code":"192","name":"MARTINIQUE"},
	{"code":"193","name":"MAURITANIA"},
	{"code":"194","name":"MAURITIUS"},
	{"code":"195","name":"MAYOTTE"},
	{"code":"17","name":"MEXICO"},
	{"code":"197","name":"MICRONESIA, FEDERATED STATES OF"},
	{"code":"198","name":"MOLDOVA, REPUBLIC OF"},
	{"code":"199","name":"MONACO"},
	{"code":"200","name":"MONGOLIA"},
	{"code":"201","name":"MONTENEGRO"},
	{"code":"202","name":"MONTSERRAT"},
	{"code":"56","name":"MOROCCO"},
	{"code":"204","name":"MOZAMBIQUE"},
	{"code":"205","name":"MYANMAR"},
	{"code":"206","name":"NAMIBIA"},
	{"code":"207","name":"NAURU"},
	{"code":"208","name":"NEPAL"},
	{"code":"209","name":"NETHERLANDS"},
	{"code":"210","name":"NETHERLANDS ANTILLES"},
	{"code":"211","name":"NEW CALEDONIA"},
	{"code":"18","name":"NEW ZEALAND"},
	{"code":"213","name":"NICARAGUA"},
	{"code":"215","name":"NIGERIA"},
	{"code":"216","name":"NIUE"},
	{"code":"217","name":"NORFOLK ISLAND"},
	{"code":"218","name":"NORTHERN MARIANA ISLANDS"},
	{"code":"19","name":"NORWAY"},
	{"code":"220","name":"OMAN"},
	{"code":"20","name":"PAKISTAN"},
	{"code":"222","name":"PALAU"},
	{"code":"223","name":"PALESTINIAN TERRITORY, OCCUPIED"},
	{"code":"224","name":"PANAMA"},
	{"code":"225","name":"PAPUA NEW GUINEA"},
	{"code":"226","name":"PARAGUAY"},
	{"code":"50","name":"PERU"},
	{"code":"21","name":"PHILIPPINES"},
	{"code":"229","name":"PITCAIRN"},
	{"code":"22","name":"POLAND"},
	{"code":"23","name":"PORTUGAL"},
	{"code":"232","name":"PUERTO RICO"},
	{"code":"233","name":"QATAR"},
	{"code":"234","name":"RÉUNION"},
	{"code":"45","name":"ROMANIA"},
	{"code":"236","name":"RUSSIAN FEDERATION"},
	{"code":"237","name":"RWANDA"},
	{"code":"238","name":"SAINT HELENA"},
	{"code":"239","name":"SAINT KITTS AND NEVIS"},
	{"code":"240","name":"SAINT LUCIA"},
	{"code":"241","name":"SAINT PIERRE AND MIQUELON"},
	{"code":"242","name":"SAINT VINCENT AND THE GRENADINES"},
	{"code":"243","name":"SAMOA"},
	{"code":"244","name":"SAN MARINO"},
	{"code":"245","name":"SAO TOME AND PRINCIPE"},
	{"code":"246","name":"SAUDI ARABIA"},
	{"code":"24","name":"SELANGOR"},
	{"code":"247","name":"SENEGAL"},
	{"code":"248","name":"SERBIA"},
	{"code":"249","name":"SEYCHELLES"},
	{"code":"43","name":"SINGAPORE"},
	{"code":"25","name":"SLOVAKIA"},
	{"code":"254","name":"SOLOMON ISLANDS"},
	{"code":"256","name":"SOUTH AFRICA"},
	{"code":"257","name":"SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS"},
	{"code":"26","name":"SOUTH KOREA"},
	{"code":"27","name":"SPAIN"},
	{"code":"28","name":"SRI LANKA"},
	{"code":"260","name":"SUDAN"},
	{"code":"261","name":"SURINAME"},
	{"code":"262","name":"SVALBARD AND JAN MAYEN"},
	{"code":"263","name":"SWAZILAND"},
	{"code":"41","name":"SWEDEN"},
	{"code":"60","name":"SWITZERLAND"},
	{"code":"266","name":"SYRIAN ARAB REPUBLIC"},
	{"code":"29","name":"TAIWAN"},
	{"code":"268","name":"TAJIKISTAN"},
	{"code":"269","name":"TANZANIA, UNITED REPUBLIC OF"},
	{"code":"30","name":"THAILAND"},
	{"code":"271","name":"TIMOR-LESTE"},
	{"code":"272","name":"TOGO"},
	{"code":"273","name":"TOKELAU"},
	{"code":"274","name":"TONGA"},
	{"code":"275","name":"TRINIDAD AND TOBAGO"},
	{"code":"276","name":"TUNISIA"},
	{"code":"31","name":"TURKEY"},
	{"code":"278","name":"TURKMENISTAN"},
	{"code":"279","name":"TURKS AND CAICOS ISLANDS"},
	{"code":"280","name":"TUVALU"},
	{"code":"281","name":"UGANDA"},
	{"code":"282","name":"UKRAINE"},
	{"code":"283","name":"UNITED ARAB EMIRATES"},
	{"code":"32","name":"UNITED KINGDOM"},
	{"code":"286","name":"UNITED STATES MINOR OUTLYING ISLANDS"},
	{"code":"287","name":"URUGUAY"},
	{"code":"33","name":"USA"},
	{"code":"288","name":"UZBEKISTAN"},
	{"code":"289","name":"VANUATU"},
	{"code":"290","name":"VENEZUELA"},
	{"code":"34","name":"VIETNAM"},
	{"code":"292","name":"VIRGIN ISLANDS, BRITISH"},
	{"code":"293","name":"VIRGIN ISLANDS, U.S."},
	{"code":"294","name":"WALLIS AND FUTUNA"},
	{"code":"295","name":"WESTERN SAHARA"},
	{"code":"296","name":"YEMEN"},
	{"code":"297","name":"ZAMBIA"},
	{"code":"298","name":"ZIMBABWE"}];

/*var glob_status=[{"code":" ","name":"ACTIVE"},{"code":"S","name":"SUSPENDED"},{"code":"R","name":"REVOKED"},{"code":"G","name":"DRUG RESTRICTION: Full"},{"code":"D","name":"DECEASED"},{"code":"T","name":"RETIRED"}
				,{"code":"M","name":"MOVED OUT OF MA"},{"code":"E","name":"EXPIRED MA CS#"},{"code":"P","name":"DRUG RESTRICTION: Partial"},{"code":"F","name":"EXEMPT: Federal"},{"code":"L","name":"EXEMPT: Fellow"},{"code":"U","name":"EXPIRED: Mailing undeliverable"},{"code":"V","name":"EXPIRED: Mailing unresponsive "}
				,{"code":"N","name":"EXPIRED: Mailing declined"},{"code":"I","name":"LIMITED LICENSE"},{"code":"O","name":"VOLUTARY SURRENDER"},{"code":"X","name":"RESIGNED"},{"code":"B","name":"OUT OF BUSINESS"},{"code":"?","name":"PENDING"},{"code":"W","name":"WITHDREW"}
				,{"code":"Y","name":"REFUND ISSUED"},{"code":"Z","name":"DENIED"}]


*/

var glob_status=[{"code":"A","name":"ACTIVE"},
				{"code":"D","name":"DECEASED"},
				{"code":"M","name":"MOVED OUT OF MA"},
				{"code":"B","name":"OUT OF BUSINESS"},
				{"code":"?","name":"PENDING"},
				{"code":"Y","name":"REFUND ISSUED"},
				{"code":"W","name":"WITHDREW"}]

/*app.config(['$httpProvider', function($httpProvider) {
	  $httpProvider.interceptors.push('AuthInterceptor');
	}]);*/

app.config(
		
		function($routeProvider) {
		    $routeProvider
		    .when("/login", {
		        templateUrl : "login.html"
		    })
		     .when("/", {
		        templateUrl : "DbContent.html"
		    }) 
		     .when("/dashboard", {
		        templateUrl : "dashboard.html"
		    })
		    .when("/DbContent", {
		        templateUrl : "DbContent.html"
		    })
		    .when("/error", {
		        templateUrl : "errorpage.html"
		    })
		    .when("/search1", {
		        templateUrl : "Receipts-home.html", 
		    })
		    .when("/fiscalreports", {
		        templateUrl : "FiscalReport.html", 
		        controller  : "FiscalReportCtrl"
		    })
		    .when("/RenewlNotice", {
		        templateUrl : "RenewalNotices.html", 
		        controller  : "RenewalNoticesCtrl"
		    })
		      .when("/fiscreceipt", {
		        templateUrl : "FacilityReceiptReg.html", 
		        controller  : "FacilityReceiptRegCtrl"   
		    })
		     .when("/addreciept", {
		        templateUrl : "AddReciept.html", 
		        controller  : "AddRecieptCtrl"
		    })
		    .when("/searchreciept", {
		        templateUrl : "search-receipt.html", 
		        controller  : "SearchReceiptCtrl"
		    })
		     .when("/recieptdetail/:recieptId", {
		        templateUrl : "AddReciept.html", 
		        controller  : "AddRecieptCtrl"
		    })
		    .when("/recieptdetail/check/:recieptId", {
		    	searchField:"check",
		        templateUrl : "AddReciept.html", 
		        controller  : "AddRecieptCtrl"
		    })
		    .when("/searchcheckreg", {
		        templateUrl : "CheckRegistry.html", 
		        controller  : "checkregistryCtrl"
		    })
		   	  .when("/batchnumgeneration", {
		   		  templateUrl : "GenerateBatchNum.html",
		           controller : "GenerateBatchNumCtrl"	  
		   	  }) 
		   	  .when("/FCsearch", {
		   		  templateUrl : "FacilityCorpSearch.html",
		           controller : "FacilityCorpSearchCtrl"	 
		   	 }) 
		   	 .when("/CorpRegist", {
		   		  templateUrl : "CorpRegistration.html",
		           controller : "CorpRegistrationCtrl"	 
		   	 })
		   	 .when("/PrintLicense", {
		   		  templateUrl : "PrintLicenses.html",
		           controller : "PrintLicensesCtrl"	 
		   	 })
		   	/* .when("/Reports", {
		   		  templateUrl : "Reports.html",
		           controller : "ReportsCtrl"	 
		   	 })*/
		   	
		   	 .when("/FacRegist", {
		   		  templateUrl : "FacilityRegistration.html",
		           controller : "FacilityRegistrationCtrl"	 
		   	 }) 
		    .otherwise( {
		        templateUrl : "/login"
		    });
		    
		}
);

app.controller("AddRecieptCtrl", AddRecieptCtrl);
app.controller("checkregistryCtrl",checkregistryCtrl);
app.controller("FiscalReportCtrl",FiscalReportCtrl);
app.controller("FacilityCorpSearchCtrl",FacilityCorpSearchCtrl);
app.controller("GenerateBatchNumCtrl",GenerateBatchNumCtrl);
app.controller("CorpRegistrationCtrl",CorpRegistrationCtrl);
app.controller("CorpRegViewCtrl",CorpRegViewCtrl);
/*app.controller("ReportsCtrl",ReportsCtrl);*/
app.controller("FacilityRegViewCtrl",FacilityRegViewCtrl);
app.controller("FacilityRegistrationCtrl",FacilityRegistrationCtrl);
app.controller("MailMergeListCtrl",MailMergeListCtrl);
app.controller("PrintLicensesCtrl",PrintLicensesCtrl);
app.controller("RenewalNoticesCtrl",RenewalNoticesCtrl);
app.controller("FacilityReceiptRegCtrl",FacilityReceiptRegCtrl);
app.controller("SearchReceiptCtrl", SearchReceiptCtrl);
//app.controller("EIWebUtilCtrl", EIWebUtilCtrl);

app.controller('userCtrl', function($rootScope, $scope, $http,$location){
//alert($location.path());
	console.log("Getting User detail ");
	$http.get("user").then(
			
			function(response) {
				$rootScope.userName = response.data.name;
				$scope.user = response.data.name;
				console.log('$rootScope.userName =='+$scope.userName);
				$rootScope.userRole = response.data.authorities[0].authority;
				$scope.role = response.data.authorities[0].authority;
				console.log('$rootScope.userRole == '+$scope.userRole);
				$rootScope.isAdmin=angular.equals($rootScope.userRole, 'ROLE_ADMIN');
				console.log($rootScope.userName+" rootScope.isAdmin is "+$rootScope.isAdmin);
	});
	
	$scope.logout = function(){
		console.log('$Logout  =='+$scope.userName);
		//delete $cookies["JSESSIONID"];
		$scope.user=undefined;
		$scope.role=undefined;
		
		$http.get('logout')
        .then(
        		function(response) {
        			
        			console.log('Logout Success : ');
        			//$location.path('dsiweb/dashboard#!/detail/'+$scope.data.id);
        		}, 
        		function(response) {
        			console.log("Error While logging out the data"); 
        		}
        		
        );  		
				
				
				
	}
	
});


