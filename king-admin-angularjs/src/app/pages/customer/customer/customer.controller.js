(function() {
    'use strict';



    angular.module('KingAdmin.pages.customer.customer')
        .controller('CustomerCtrl', CustomerCtrl);

    /** @ngInject */
    function CustomerCtrl($scope, $stateParams, $state, $uibModalInstance, $filter, toastr, CustomerService, CustomerGroupService) {

        var kt = this;
        kt.menu = {};
        if ($stateParams.isAdd) {
            kt.isAdd = true;
        } else {
            kt.isAdd = false;
        }

        kt.types = [];
        if (!kt.isAdd && $stateParams.id) {

            CustomerService.getInfo({ id: $stateParams.id },
                function(data) {
                    kt.customer = data;
                })

        } else {

        }

        kt.save = function() {
            console.log(kt.customer);
            CustomerService.save(kt.customer, function(data) {
                $uibModalInstance.close(true);
            });

        }
    }

})();