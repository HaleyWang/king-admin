(function() {
    'use strict';

    angular.module('KingAdmin.pages.order.order', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('order.order', {
                url: '/order',
                templateUrl: 'app/pages/order/order/order.list.html',
                controller: 'OrderListCtrl',
                controllerAs: 'kt',
                title: '客户分类',
                sidebarMeta: {
                    order: 1,
                },
            });
    }

})();