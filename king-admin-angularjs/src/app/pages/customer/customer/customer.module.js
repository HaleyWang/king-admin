(function() {
    'use strict';

    angular.module('KingAdmin.pages.customer.customer', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('customer.customer', {
                url: '/customer',
                templateUrl: 'app/pages/customer/customer/customer.list.html',
                controller: 'CustomerListCtrl',
                controllerAs: 'kt',
                title: '客户管理',
                sidebarMeta: {
                    order: 1,
                },
            });
    }

})();