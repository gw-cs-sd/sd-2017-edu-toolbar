'use strict';
 
angular.module('Home')
.controller('HomeController', 
    ['$scope','AuthenticationService',
    function ($scope, AuthenticationService) {
    }])
.controller('WLANController',  
	    ['$scope', 'AuthenticationService',
	    function ($scope, AuthenticationService) {
	    	var i = 1;
	    	var questionNo = 1;
	    	var par1 = 2;
	    	var par2 = 3;
	    	var question = "sumDouble";
	    	$scope.score = 0;
	    	var result = 5;
	    	var intrim = 0;
	    	$scope.questions = "//Question "+questionNo+", "+question+"("+par1+","+par2+")";
			document.getElementById("my-text").value = "public class ExampleClass { \n public static int "+question+"() { \n return 0; \n } \n }";
	    	var text = document.getElementById('my-text');

	    	var editableCodeMirror = CodeMirror.fromTextArea(text, {
	    	    mode: "text/x-java",
	    	    theme: "default",
	    	    lineNumbers: true,
	    	    theme: "eclipse",
	    	});
	    	editableCodeMirror.on('change', function (cm) {
	    	    text.value = cm.getValue();
	    	});
	    	document.getElementById('test').onclick = function () {
	    	    console.log(text.value);
	    	    $.post("edu/resources/code"+"/"+result, text.value, function(data, status){
	    	    	if(data=="true"){
	    	    		intrim = intrim+1;
	    	    		$scope.score = intrim/questionNo*100;
	    	    	}
	    	    	else if(data =="false"){
	    	    		$scope.score = intrim/questionNo*100;
	    	    	}
	    	    	else{
	    	    		alert(data);
	    	    	}
    	        });
	    	};
	    	document.getElementById('next').onclick = function () {
	    		i = i+1;
		    	par1 = Math.floor(Math.random() * 100) + 1;
		    	par2 = Math.floor(Math.random() * 100) + 1;
	    	    var myArray = ['sum', 'multiple', 'subtract', 'divide'];  
	    	    var rand = myArray[Math.floor(Math.random() * myArray.length)];
	    	    console.log(rand);
	    	    questionNo = i;
	    	    if(rand=="sum"){
	    	    	result = par1+par2;
	    	    }
	    	    else if(rand=="multiple"){
	    	    	result = par1*par2;
	    	    }
	    	    else if(rand=="subtract"){
	    	    	result = par1-par2;
	    	    }
	    	    else if(rand=="divide"){
	    	    	result = par1/par2;
	    	    }
		    	$scope.questions = "//Question "+questionNo+", "+rand+"("+par1+","+par2+")";
	    	};
	    }])
	    