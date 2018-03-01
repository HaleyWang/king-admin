(function() {
    'use strict';

    angular.module('KingAdmin.pages.order', [
        'KingAdmin.pages.order.order'
    ]).config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('order', {
                url: '/order',
                template: '<ui-view></ui-view>',
                abstract: true,
                title: '订单管理',
                sidebarMeta: {
                    icon: 'ion-grid',
                    order: 300,
                },
            });
    }

})();