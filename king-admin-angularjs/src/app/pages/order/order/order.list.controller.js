(function() {
    'use strict';

    angular.module('KingAdmin.pages.order.order')
        .controller('OrderListCtrl', OrderListCtrl);

    /** @ngInject */
    function OrderListCtrl($scope, toastr, OrderService, $filter, NameTypeObjService, CustomerService) {
        var kt = this;
        kt.dictlist = [];
        kt.addRow = function() {
            kt.inserted = {
                id: null,
                name: null,
                remark: null,
            };
            kt.dictlist.push(kt.inserted);
        }
        kt.save = function(dict) {
            if (dict.orderDate == null || dict.orderDate == '') {
                toastr.warning('日期不能为空', "提示:", { "progressBar": true, });
                return;
            }
            console.log("--orderitem", dict);
            OrderService.save(dict, function(data) {
                kt.LoadPage();
            });
        }
        kt.wholesalers = [];
        NameTypeObjService.getList("PIFASHANG", function(data) {
            console.log(data);
            kt.wholesalers = data.result;
        });
        kt.addressList = [];
        NameTypeObjService.getList("TUZAICHANG", function(data) {
            console.log(data);
            kt.addressList = data.result;
        });

        kt.customers = [];
        CustomerService.getList(function(data) {
            console.log(data);
            kt.customers = data.result;
        });

        kt.LoadPage = function(tableState) {
            tableState = tableState || kt.tableState;
            tableState.pagination.number = tableState.pagination.number || 5;
            tableState.search = {}; //todo search all
            OrderService.getSmartData(tableState,
                function(data) {
                    tableState.pagination.numberOfPages = data.result.pages;
                    tableState.pagination.totalItemCount = data.result.total;
                    kt.tableState = tableState;
                    kt.dictlist = data.result.records;

                    console.log("dictlist", kt.dictlist);

                });
        };

        //showWholesalerName
        kt.showWholesalerName = function(wholesalerId) {
            var selected = [];
            if (wholesalerId) {
                selected = $filter('filter')(kt.wholesalers, { id: wholesalerId });
            }
            return selected.length ? selected[0].name : '请选择分类';
        };

        kt.showDay = function(date) {
            var d = date.split(" ");
            if (d && d.length == 2) {
                return d[0];
            }
            return "";
        };

        kt.showAddressName = function(id) {
            var selected = [];
            if (id) {
                selected = $filter('filter')(kt.addressList, { id: id });
            }
            return selected.length ? selected[0].name : '请选择分类';
        };
        //showCustomerName
        kt.showCustomerName = function(customerId) {
            var selected = [];
            if (customerId) {
                selected = $filter('filter')(kt.customers, { id: customerId });
            }
            return selected.length ? selected[0].name : '请选择分类';
        };

        //删除
        kt.del = function(id) {
            if (id == null) {
                kt.LoadPage();
                return;
            }
            OrderService.del({ id: id },
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