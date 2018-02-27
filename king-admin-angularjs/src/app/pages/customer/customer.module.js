(function() {
    'use strict';

    angular.module('KingAdmin.pages.customer', [
        'KingAdmin.pages.customer.customer',
        'KingAdmin.pages.customer.customergroup',
    ]).config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('customer', {
                url: '/customer',
                template: '<ui-view></ui-view>',
                abstract: true,
                title: '客户管理',
                sidebarMeta: {
                    icon: 'ion-grid',
                    order: 300,
                },
            });
    }

})();