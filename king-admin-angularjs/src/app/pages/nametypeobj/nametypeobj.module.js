(function() {
    'use strict';

    angular.module('KingAdmin.pages.nametypeobj', [
        'KingAdmin.pages.nametypeobj.nametypeobj',
        'KingAdmin.pages.nametypeobj.nametype',
    ]).config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('nametypeobj', {
                url: '/nametypeobj',
                template: '<ui-view></ui-view>',
                abstract: true,
                title: '元数据管理',
                sidebarMeta: {
                    icon: 'ion-grid',
                    order: 300,
                },
            });
    }

})();