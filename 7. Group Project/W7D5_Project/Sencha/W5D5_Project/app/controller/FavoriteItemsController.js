/*
 * File: app/controller/FavoriteItemsController.js
 *
 * This file was generated by Sencha Architect version 3.1.0.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 5.0.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 5.0.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('W5D5_Project.controller.FavoriteItemsController', {
    extend: 'Ext.app.Controller',

    control: {
        "#faveProdsGrid": {
            rowdblclick: 'onFaveProdsGridRowDblClick'
        },
        "#faveProdsSearch": {
            change: 'onFaveProdsSearchChange'
        }
    },

    onFaveProdsGridRowDblClick: function(tableview, record, tr, rowIndex, e, eOpts) {
        var controller = W5D5_Project.app.getController('ProdInfoController');
        controller.showProdInfoWin(record.data);
    },

    onFaveProdsSearchChange: function(field, newValue, oldValue, eOpts) {
        var store = Ext.getStore('FavoriteProductsStore');
        if(Ext.isEmpty(field.getValue())){
            store.clearFilter();
        }else{
            store.filter('prodName',field.getValue());
        }
    }

});
