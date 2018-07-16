(function() {
    'use strict';

    angular.module('KingAdmin.pages.customer.customergroup', [])
        .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider) {
        $stateProvider
            .state('customer.customergroup', {
                url: '/customergroup',
                templateUrl: 'app/pages/customer/customergroup/customergroup.list.html',
                controller: 'CustomerGroupListCtrl',
                controllerAs: 'kt',
                title: '客户分类',
                sidebarMeta: {
                    order: 1,
                },
            }).state('customer.customergroup.edit', {
                url: '/edit/:id',
                title: '编辑菜单',
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'app/pages/customer/customergroup/customergroup.html',
                        controller: 'CustomerGroupCtrl',
                        controllerAs: 'kt',
                        backdrop: 'static',
                        size: 'lg'
                    }).result.then(function() {
                        $state.go('customer.customergroup', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    });
                }]
            }).state('customer.customergroup.add', {
                url: '/add/:id?isAdd',
                title: '新增菜单',
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'app/pages/customer/customergroup/customergroup.html',
                        controller: 'CustomerGroupCtrl',
                        controllerAs: 'kt',
                        backdrop: 'static',
                        size: 'lg'
                    }).result.then(function() {
                        $state.go('customer.customergroup', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    });
                }]
            });
    }

})();