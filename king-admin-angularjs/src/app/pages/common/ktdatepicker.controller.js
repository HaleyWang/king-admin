(function() {
    'use strict';

    angular.module('KingAdmin.pages.common')
        .controller('KtDatePickerCtrl', KtDatePickerCtrl);

    /** @ngInject */
    function KtDatePickerCtrl($scope, $uibModalInstance, dateFilterOptions) {

        $scope.opened = { start: false, end: false };
        $scope.formats = ['yyyy-MM-dd', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
        $scope.format = $scope.formats[0];
        $scope.options = {
            showWeeks: false
        };
        $scope.dateFilterOptions = dateFilterOptions;

        $scope.openDatePicker = function(key) {
            $scope.opened[key] = true;
        };

        $scope.changeDatePicker = function() {
            $uibModalInstance.close($scope.dateFilterOptions);

        };


    }

})();