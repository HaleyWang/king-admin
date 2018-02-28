(function() {
    'use strict';

    angular.module('KingAdmin.pages.customer.customer')
        .controller('CustomerListCtrl', CustomerListCtrl);

    /** @ngInject */
    function CustomerListCtrl($scope, $filter, toastr, CustomerService, CustomerGroupService, $uibModal) {
        var kt = this;
        kt.dictlist = [];
        kt.dictClassList = [];

        $scope.open = function(page, size) {
            $uibModal.open({
                animation: true,
                templateUrl: page,
                size: size,
                resolve: {
                    items: function() {
                        return $scope.items;
                    }
                }
            });
        };



        CustomerGroupService.getList({}, function(data) {
            kt.dictClassList = data.result;
        });
        kt.showGroupName = function(customerGroupId) {
            var selected = [];
            if (customerGroupId) {
                selected = $filter('filter')(kt.dictClassList, { id: customerGroupId });
            }
            return selected.length ? selected[0].name : '请选择分类';
        };
        kt.addRow = function() {
            kt.inserted = {
                id: null,
                customerGroupId: '',
                name: null,
                phone: null,
                phone1: null,
                remark: null,
            };
            kt.dictlist.push(kt.inserted);
        }
        kt.save = function(dict) {
            if (dict.name == null || dict.name == '') {
                toastr.warning('名称不能为空', "提示:", { "progressBar": true, });
                return;
            }
            CustomerService.save(dict, function(data) {
                kt.LoadPage();
            });
        }

        kt.LoadPage = function(tableState) {
            tableState = tableState || kt.tableState;
            tableState.pagination.number = tableState.pagination.number || 5;
            CustomerService.getSmartData(tableState,
                function(data) {
                    tableState.pagination.numberOfPages = data.result.pages;
                    tableState.pagination.totalItemCount = data.result.total;
                    kt.tableState = tableState;
                    kt.dictlist = data.result.records;
                });
        };

        //删除
        kt.del = function(id) {
            if (id == null) {
                kt.LoadPage();
                return;
            }
            CustomerService.del({ id: id },
                function(data) {
                    kt.LoadPage();
                })
        };
        kt.checkboxes = {
            checked: false,
            items: {}
        };
        $scope.$watch('kt.checkboxes.checked', function(value) {
            angular.forEach(kt.dictlist, function(item) {
                kt.checkboxes.items[item.id] = value;
            });
        });

    }

})();