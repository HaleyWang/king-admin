(function() {
    'use strict';

    angular.module('KingAdmin.pages.common')
        .factory('CommonService', CommonService);

    /** @ngInject */
    function CommonService($uibModal, $http) {
        function show(page, size, controller, items, callbackFunc) {
            $uibModal.open({
                animation: true,
                templateUrl: page,
                controller: controller || 'CommomCtrl',
                size: size || 'sm',
                resolve: {
                    items: function() {
                        return items;
                    }
                }
            }).result.then(function(opParams) {
                return callbackFunc(opParams);
            });
        };

        function common(items, callbackFunc, page) {
            show(page, 'sm', 'CommomCtrl', items, callbackFunc)
        }

        function info(items, callbackFunc) {
            common(items, callbackFunc, 'app/pages/common/modalTemplates/infoModal.html')
        };

        function success(items, callbackFunc) {
            common(items, callbackFunc, 'app/pages/common/modalTemplates/successModal.html')
        };

        function warning(items, callbackFunc) {
            common(items, callbackFunc, 'app/pages/common/modalTemplates/warningModal.html')
        };

        function danger(items, callbackFunc) {
            common(items, callbackFunc, 'app/pages/common/modalTemplates/dangerModal.html')
        };



        function exportFile(url, params, cb) {

            $http({
                url: url,
                method: "POST",
                data: params, //this is your json data string
                headers: {
                    'Content-type': 'application/json'
                },
                responseType: 'arraybuffer'
            }).success(function(data, status, headers, config) {

                    //$resource('api/customer/export_excel', { "a": 1 }, {
                    //    'query': { method: 'POST' }
                    //}).query(params,
                    //    function(data, status, headers, config) {
                    console.log(status, headers, config);


                    var blob = new Blob([data], { type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" });
                    var objectUrl = URL.createObjectURL(blob);
                    //window.open(objectUrl);



                    var a = document.createElement('a');
                    document.body.appendChild(a);
                    a.setAttribute('style', 'display:none');
                    a.setAttribute('href', objectUrl);
                    var filename = "记录.xls";
                    a.setAttribute('download', filename);
                    a.click();
                    URL.revokeObjectURL(objectUrl);

                    cb(data);
                },
                function(error) {
                    toastr.error(error, "提示", { "progressBar": true, });
                });
        };

        return {
            exportFile: exportFile,
            show: show,
            info: info,
            success: success,
            warning: warning,
            danger: danger
        }
    }

})();