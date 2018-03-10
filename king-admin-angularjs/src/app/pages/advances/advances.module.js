(function() {
    'use strict';

    angular.module('KingAdmin.pages.advances', [
        'KingAdmin.pages.advances.advances'
    ]).config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('advances', {
                url: '/advances',
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