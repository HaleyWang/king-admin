/**
 * @author v.lugovsky
 * created on 16.12.2015
 */
(function() {
    'use strict';

    angular.module('KingAdmin.pages.print', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('print', {
                url: '/print',
                templateUrl: 'app/pages/print/print.html',
                controller: 'PrintControlller',
                controllerAs: 'kt',
                title: '首页',
                sidebarMeta: {
                    icon: 'ion-android-home',
                    order: 0,
                },
            });
    }

})();