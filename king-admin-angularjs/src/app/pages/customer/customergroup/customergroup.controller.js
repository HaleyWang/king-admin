(function() {
    'use strict';



    angular.module('KingAdmin.pages.customer.customergroup')
        .controller('CustomerGroupCtrl', CustomerGroupCtrl);

    /** @ngInject */
    function CustomerGroupCtrl($scope, $stateParams, $state, $uibModalInstance, $filter, toastr, CustomerService, MarketService, CustomerGroupService) {

        var kt = this;
        kt.menu = {};
        if ($stateParams.isAdd) {
            kt.isAdd = true;
        } else {
            kt.isAdd = false;
        }

        kt.marketList = [];
        if (!kt.isAdd && $stateParams.id) {

            CustomerGroupService.getInfo({ id: $stateParams.id },
                function(data) {
                    kt.entity = data;
                })

        } else {

        }



        kt.save = function(continueAdd) {
            console.log(11);
            console.log(kt.entity);
            CustomerGroupService.save(kt.entity, function(data) {
                if (!continueAdd) {
                    $uibModalInstance.close(true);

                }
            });

        }
    }

})();