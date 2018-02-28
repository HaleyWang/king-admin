(function() {
    'use strict';

    angular.module('KingAdmin.pages.customer.customer', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('customer.customer', {
                url: '/customer',
                templateUrl: 'app/pages/customer/customer/customer.list.html',
                controller: 'CustomerListCtrl',
                controllerAs: 'kt',
                title: '客户管理',
                sidebarMeta: {
                    order: 1,
                },
            }).state('customer.customer.edit', {
                url: '/edit/:id',
                title: '编辑菜单',
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'app/pages/customer/customer/customer.html',
                        controller: 'CustomerCtrl',
                        controllerAs: 'kt',
                        backdrop: 'static',
                        size: 'lg'
                    }).result.then(function() {
                        $state.go('customer.customer', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    });
                }]
            }).state('customer.customer.add', {
                url: '/add/:id?isAdd',
                title: '新增菜单',
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'app/pages/customer/customer/customer.html',
                        controller: 'CustomerCtrl',
                        controllerAs: 'kt',
                        backdrop: 'static',
                        size: 'lg'
                    }).result.then(function() {
                        $state.go('customer.customer', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    });
                }]
            });
    }

})();