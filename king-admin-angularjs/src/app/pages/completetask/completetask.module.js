(function() {
    'use strict';

    angular.module('KingAdmin.pages.completetask', [
        'KingAdmin.pages.completetask.completetask'
    ]).config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('completetask', {
                url: '/completetask',
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