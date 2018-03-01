(function() {
    'use strict';

    angular.module('KingAdmin.pages.customer.market', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('customer.market', {
                url: '/market',
                templateUrl: 'app/pages/customer/market/market.list.html',
                controller: 'MarketListCtrl',
                controllerAs: 'kt',
                title: '客户分类',
                sidebarMeta: {
                    order: 1,
                },
            });
    }

})();