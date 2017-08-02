var app = angular.module('app', []);

app.controller('getcontroller', function($scope, $http, $location) {
	
	$scope.showCustomer = false;
	$scope.showOrder = false;

	$scope.getfunction = function() {
		var url = $location.absUrl() + "getcustomer/" + $scope.customerId;
		var orderUrl;

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.get(url, config).then(function(response) {

			if (response.data.status == "Done") {
				$scope.customer = response.data;
				orderUrl = $scope.customer.data.links[1].href;
				$scope.showCustomer = true;

				$http.get(orderUrl, config).then(function(response) {

					if (response.data.status == "Done") {
						$scope.orders = response.data;
						$scope.showOrder = true;
					} else {
						$scope.getResultMessage = "Customer/Order Data Error!";
					}

				}, function(response) {
					$scope.getResultMessage = "Fail!";
				});

			} else {
				$scope.getResultMessage = "Customer Data Error!";
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});

	}
});