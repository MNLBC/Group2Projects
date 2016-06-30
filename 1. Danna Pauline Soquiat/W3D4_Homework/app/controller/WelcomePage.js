Ext.define('Company.controller.WelcomePage', {
    extend: 'Ext.app.Controller',
    views: ['Company.view.WelcomePage'],

    refs: [{
        ref: 'WelcomePageForm',
        selector: 'viewport > WelcomePage'
    }],

    init: function () {
        this.control({

            'viewport > WelcomePage button[itemId=btnEmpData]': {
                click: this.onFirstPageClick
            },
            'viewport > WelcomePage button[itemId=btnEmpForm]': {
                click: this.onSecondPageClick
            },
            'viewport > WelcomePage button[itemId=btnTable]': {
                click: this.onThirdPageClick
            }
        }
            );
    },
    onFirstPageClick: function () {
    	window.location.assign("/W3D4/EmployeeInfo.html");
    	
    	
    },
    onSecondPageClick: function () {
    	window.location.assign("/W3D4/EmployeeCreate.html");
    },
    onThirdPageClick: function () {
    	window.location.assign("/W3D4/EmployeeCreate.html");
    }
});