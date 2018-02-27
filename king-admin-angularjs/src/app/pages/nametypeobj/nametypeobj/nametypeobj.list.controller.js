(function() {
    'use strict';

    angular.module('KingAdmin.pages.nametypeobj.nametypeobj')
        .controller('NameTypeObjListCtrl', NameTypeObjListCtrl);

    /** @ngInject */
    function NameTypeObjListCtrl($scope, $filter, toastr, NameTypeObjService, NameTypeService) {
        var kt = this;
        kt.dictlist = [];
        kt.dictClassList = [];

        NameTypeService.getList({}, function(data) {
            kt.dictClassList = data.result;
        });
        kt.showGroupName = function(nameTypeId) {
            var selected = [];
            if (nameTypeId) {
                selected = $filter('filter')(kt.dictClassList, { id: nameTypeId });
            }
            return selected.length ? selected[0].name : '请选择分类';
        };
        kt.addRow = function() {
            kt.inserted = {
                id: null,
                nameTypeId: '',
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
            NameTypeObjService.save(dict, function(data) {
                kt.LoadPage();
            });
        }

        kt.LoadPage = function(tableState) {
            tableState = tableState || kt.tableState;
            tableState.pagination.number = tableState.pagination.number || 5;
            NameTypeObjService.getSmartData(tableState,
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
            NameTypeObjService.del({ id: id },
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