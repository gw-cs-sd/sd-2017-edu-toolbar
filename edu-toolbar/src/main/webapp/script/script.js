// create the module and name it scotchApp
var scotchApp = angular.module('scotchApp', ['ngRoute', 'ui.codemirror']);
// configure our routes
scotchApp.config(function($routeProvider) {
    $routeProvider

    // route for the home page
        .when('/', {
        templateUrl: 'pages/home.html',
        controller: 'mainController'
    })

    // route for the about page
    .when('/tutorial', {
        templateUrl: 'pages/tutorial.html',
        controller: 'tutorialController'
    })
});

// create the controller and inject Angular's $scope
scotchApp.controller('mainController', function($scope) {
    // create a message to display in our view
    $scope.message = 'Welcome to JavaScript Tutorials by "Austin Moon"';
});

scotchApp.controller('tutorialController', ['$scope', function($scope) {
    $scope.next = 0;
    $scope.piecesOfCode = [{
        code: '//Question 1. sumDouble(2,3) --> 5\n' +
            'function func() {\nreturn null;\n} \n\t var result = func();\n\t result;',
        options: {
            mode: "javascript",
            lineNumbers: true,
            indentWithTabs: true
        }
    }, {
        code: '//Question 2. multipleDouble(2,3) --> 6\n' +
            'function func() {\nreturn null;\n} \n\t var result = func();\n\t result;',
        options: {
            mode: "javascript",
            lineNumbers: true,
            indentWithTabs: true
        }
    }, {
        code: '//Question 3. divideDouble(10,5) --> 2\n' +
            'function func() {\nreturn null;\n} \n\t var result = func();\n\t result;',
        options: {
            mode: "javascript",
            lineNumbers: true,
            indentWithTabs: true
        }
    }];
    $scope.myFunction = function() {
        $scope.output = null;
        $scope.error = null;
        if ($scope.next == 0) {
            var el = $scope.piecesOfCode[0].code;
            var result = eval(el);
            if (typeof result != 'undefined') {
                if (result == 5) {
                    $scope.output = "You got it Right. Let's try next.";
                } else {
                    $scope.output = "You got wrong answer. Try again!";
                }
            } else {
                $scope.error = "Syntax error!";
            }
        } else if ($scope.next == 1) {
            var el = $scope.piecesOfCode[1].code;
            var result = eval(el);
            if (typeof result != 'undefined') {
                if (result == 6) {
                    $scope.output = "You got it Right. Let's try next.";
                } else {
                    $scope.output = "You got wrong answer. Try again!";
                }
            } else {
                $scope.error = "Syntax error!";
            }
        } else {
            var el = $scope.piecesOfCode[2].code;
            var result = eval(el);
            if (typeof result != 'undefined') {
                if (result == 2) {
                    $scope.output = "You got it Right. Let's try next.";
                } else {
                    $scope.output = "You got wrong answer. Try again!";
                }
            } else {
                $scope.error = "Syntax error!";
            }
        }
    };

    $scope.next1 = function() {
      $scope.output = 0;
        $scope.next = $scope.next + 1;
        if ($scope.next > 1) {
            $scope.next = 2;
        }
    }
    $scope.previous1 = function() {
        $scope.next = $scope.next - 1;
        if ($scope.next < 1) {
            $scope.next = 0;
        }
    }
}
]);
