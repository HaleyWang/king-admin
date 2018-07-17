(function() {
    'use strict';

    angular.module('KingAdmin.pages.common')
        .controller('KtDatePickerCtrl', KtDatePickerCtrl);

    /** @ngInject */
    function KtDatePickerCtrl($scope, $uibModalInstance, dateFilterOptions) {

        $scope.opened = { start: false, end: false };
        $scope.formats = ['yyyy-MM-dd', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
        $scope.format = $scope.formats[0];
        $scope.altInputFormats = $scope.format;
        $scope.options = {
            showWeeks: false
        };
        $scope.dateFilterOptions = dateFilterOptions;

        $scope.openDatePicker = function(key) {
            $scope.opened[key] = true;
        };

        $scope.changeDatePicker = function() {
            var op = $scope.dateFilterOptions;

            var sd = moment(op.startDate).format($scope.format.toUpperCase());
            var ed = moment(op.endDate).format($scope.format.toUpperCase());

            if (op.startDate) {
                op.dateRange = sd + ' - ' + ed;

            } else {
                op.dateRange = '';
            }
            op.name = _.find(op.items, { 'id': op.id }).name;

            $uibModalInstance.close(op);

        };


    }

})();