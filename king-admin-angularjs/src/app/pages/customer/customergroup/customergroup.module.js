(function() {
    'use strict';

    angular.module('KingAdmin.pages.customer.customergroup', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('customer.customergroup', {
                url: '/customergroup',
                templateUrl: 'app/pages/customer/customergroup/customergroup.list.html',
                controller: 'CustomerGroupListCtrl',
                controllerAs: 'kt',
                title: '客户分类',
                sidebarMeta: {
                    order: 1,
                },
            });
    }

})();