var app=angular.module("myApp",[]);

app.controller("ctrl",function($scope,$http){
	$http.get('http://localhost:8080/ManagingCart/carts/empContent').
	success(function(data){
		$scope.carts=data;
	});
});

/*app.controller("myCtrl",function($scope,$http){
	$http.get('http://localhost:8080/ManagingCart/carts/departContent').
	success(function(data){
		$scope.carts=data;
	});
});*/