(function() {
    'use strict';

    angular.module('KingAdmin.pages.nametypeobj.nametypeobj', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('nametypeobj.nametypeobj', {
                url: '/nametypeobj',
                templateUrl: 'app/pages/nametypeobj/nametypeobj/nametypeobj.list.html',
                controller: 'NameTypeObjListCtrl',
                controllerAs: 'kt',
                title: '客户管理',
                sidebarMeta: {
                    order: 1,
                },
            });
    }

})();