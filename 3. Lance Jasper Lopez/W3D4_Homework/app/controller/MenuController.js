/*
 * File: app/controller/MenuController.js
 *
 * This file was generated by Sencha Architect version 3.1.0.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 4.2.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 4.2.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('School.controller.MenuController', {
    extend: 'Ext.app.Controller',

 
    views: [
        'School.view.MenuView'
    ],

//    init: function() {
//    	 this.control({
//
//            'viewport > MenuView button[itemId=btnProject1]':
//            {
//                click: this.onProject1Click
//            },
//            'viewport > MenuView button[itemId=btnProject2]':
//            {
//                click: this.onProject2Click
//            },
//            'viewport > MenuView button[itemId=btnDynTable]':
//            {
//                click: this.onDynamicTableClick
//            }
//          
//        });
//    },

    onProject1Click: function() {
//    	  this.getView().destroy();
    	  console.log('here');
       var window =Ext.widget('widget.StudentMaster');
        window.show();
    },

    onProject2Click: function() {
//    	  this.getView().destroy();

    
        Ext.widget('widget.StudentGrid2');
    },

    onDynamicTableClick: function() {
//    	  this.getView().destroy();

        
        // Ext.widget('app-main');
    }

});
