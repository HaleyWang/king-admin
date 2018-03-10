(function() {
    'use strict';

    angular.module('KingAdmin.pages', [
            'ui.router',
            'KingAdmin.pages.config',
            'KingAdmin.pages.home',
            'KingAdmin.pages.common',
            'KingAdmin.pages.sys',
            'KingAdmin.pages.dict',
            'KingAdmin.pages.print',

            'KingAdmin.pages.nametypeobj',
            'KingAdmin.pages.customer',
            'KingAdmin.pages.advances',
            'KingAdmin.pages.completetask',
            'KingAdmin.pages.order'

        ])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($urlRouterProvider) {
        $urlRouterProvider.otherwise("/home");

    }

})();