(function() {
    'use strict';

    angular.module('KingAdmin.pages.completetask.completetask', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('completetask.completetask', {
                url: '/completetask',
                templateUrl: 'app/pages/completetask/completetask/completetask.list.html',
                controller: 'CompleteTaskListCtrl',
                controllerAs: 'kt',
                title: '客户分类',
                sidebarMeta: {
                    order: 1,
                },
            });
    }

})();