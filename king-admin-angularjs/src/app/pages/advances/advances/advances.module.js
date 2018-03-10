(function() {
    'use strict';

    angular.module('KingAdmin.pages.advances.advances', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('advances.advances', {
                url: '/advances',
                templateUrl: 'app/pages/advances/advances/advances.list.html',
                controller: 'AdvancesListCtrl',
                controllerAs: 'kt',
                title: '客户分类',
                sidebarMeta: {
                    order: 1,
                },
            });
    }

})();