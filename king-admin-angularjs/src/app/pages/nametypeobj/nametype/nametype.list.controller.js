(function() {
    'use strict';

    angular.module('KingAdmin.pages.nametypeobj.nametype')
        .controller('NameTypeListCtrl', NameTypeListCtrl);

    /** @ngInject */
    function NameTypeListCtrl($scope, toastr, NameTypeService) {
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
            if (dict.name == null || dict.name == '') {
                toastr.warning('名称不能为空', "提示:", { "progressBar": true, });
                return;
            }
            NameTypeService.save(dict, function(data) {
                kt.LoadPage();
            });
        }

        kt.LoadPage = function(tableState) {
            tableState = tableState || kt.tableState;
            tableState.pagination.number = tableState.pagination.number || 5;
            NameTypeService.getSmartData(tableState,
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
            NameTypeService.del({ id: id },
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