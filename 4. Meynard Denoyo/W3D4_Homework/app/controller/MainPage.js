Ext.define('Company.controller.MainPage', {
    extend: 'Ext.app.Controller',
    views: ['Company.view.MainPage'],

    refs: [{
        ref: 'mainPageForm',
        selector: 'viewport > MainPage'
    }],

    init: function () {
        this.control({

            'viewport > MainPage button[itemId=button1]': {
                click: this.onDisplayUI1
            },
            'viewport > MainPage button[itemId=button2]': {
                click: this.onDisplayUI2
            },
            'viewport > MainPage button[itemId=button3]': {
                click: this.onCreateTable
            }
        }
            );
    },
    onDisplayUI1: function () {
    	window.location.assign("/W3D4_Homework/EmployeeInfo.html");
    	
    	
    },
    onDisplayUI2: function () {
    	window.location.assign("/W3D4_Homework/EmployeeCreate.html");
    },
    onCreateTable: function () {
    	Ext.apply('MainPage',{
    		xtype: 'gridpanel',
    		title: 'sample',
       		 columns : [{
       			 xtype: 'gridcolumn',
                    text: 'First Name'
       		 }]
    	});
    	

    }
});