(function() {
    'use strict';

    angular.module('KingAdmin.pages.customer.customer')
        .controller('CustomerListCtrl', CustomerListCtrl);

    /** @ngInject */
    function CustomerListCtrl($scope, Upload, $timeout, $filter, toastr, CustomerService, MarketService, CommonService, CustomerGroupService, $uibModal, $rootScope, $window) {
        var kt = this;
        kt.rows = [];
        kt.dictClassList = [];
        kt.marketList = [];
        kt.customersResp = {};
        kt.pageSize = $window.localStorage.getItem('pageSize') || 10;


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

        kt.openDateFilter = function() {

            var dateFilterOptions = {
                items: [
                    { id: "id", name: "name" },
                    { id: "id1", name: "name1" }
                ],
                id: '',
                startDate: '',
                endDate: ''
            };

            dateFilterOptions.id = dateFilterOptions.items[0].id;

            CommonService.showDateFilter(dateFilterOptions, function(dateFilterResult) {
                console.log('arg', arguments);
            });

        };

        //$scope.openDateFilter();


        $scope.uploadFiles = function(file, errFiles) {
            $scope.f = file;
            $scope.errFile = errFiles && errFiles[0];
            if (file) {
                file.upload = Upload.upload({
                    url: '/api/customer/import',
                    data: { file: file }
                });

                file.upload.then(function(response) {
                    $timeout(function() {
                        file.result = response.data;
                    });
                }, function(response) {
                    if (response.status > 0)
                        $scope.errorMsg = response.status + ': ' + response.data;
                }, function(evt) {
                    file.progress = Math.min(100, parseInt(100.0 *
                        evt.loaded / evt.total));
                });
            }
        }

        MarketService.getList({}, function(data) {
            kt.marketList = data.result;
        });
        kt.showGroupName = function(customerGroupId) {
            var selected = [];
            if (customerGroupId) {
                selected = $filter('filter')(kt.dictClassList, { id: customerGroupId });
            }
            return selected.length ? selected[0].name : '请选择分类';
        };
        //showMarketCode
        kt.showMarketCode = function(customerGroupId) {
            var selected = [];
            if (customerGroupId) {
                selected = $filter('filter')(kt.marketList, { id: customerGroupId });
            }
            return selected.length ? selected[0].marketCode : '请选择分类';
        };

        //showMarketName
        kt.showMarketName = function(customerGroupId) {
            var selected = [];
            if (customerGroupId) {
                selected = $filter('filter')(kt.marketList, { id: customerGroupId });
            }
            return selected.length ? selected[0].name : '';
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
        };

        kt.fillData = function(list) {
            if (!list) {
                return;
            }
            var showMarketCode = kt.showMarketCode;
            for (var i = 0, n = list.length; i < n; i++) {
                var item = list[i];
                item.marketShortName = showMarketCode(item.marketId);
            }
        };

        kt.LoadPage = function(tableState) {

            console.log('lll');

            tableState = tableState || kt.tableState || {};
            tableState.search || (tableState.search = {});
            var search = tableState.search;
            search.phone = search.name;
            search.phone1 = search.name;
            search.adress = search.name;
            search.identityNum = search.name;

            $window.localStorage.setItem('pageSize', kt.pageSize);


            tableState.pagination.number = tableState.pagination.number || 5;
            CustomerService.getSmartData(tableState,
                function(data) {
                    tableState.pagination.numberOfPages = data.result.pages;
                    tableState.pagination.totalItemCount = data.result.total;
                    kt.tableState = tableState;


                    var records = data.result.records;
                    kt.fillData(records);
                    kt.rows = records;
                    kt.customersResp = data;
                });
        };

        kt.exportExcel = function() {

            var data = kt.customersResp.grid;
            data.rows = kt.rows;

            CommonService.exportFile(
                'api/customer/export_excel',
                data,
                function(res) {

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