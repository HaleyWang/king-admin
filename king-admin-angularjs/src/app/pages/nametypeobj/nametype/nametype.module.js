(function() {
    'use strict';

    angular.module('KingAdmin.pages.nametypeobj.nametype', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('nametypeobj.nametype', {
                url: '/nametype',
                templateUrl: 'app/pages/nametypeobj/nametype/nametype.list.html',
                controller: 'NameTypeListCtrl',
                controllerAs: 'kt',
                title: '客户分类',
                sidebarMeta: {
                    order: 1,
                },
            });
    }

})();