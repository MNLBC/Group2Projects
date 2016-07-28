/*
 * File: app/controller/CartProductController.js
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

Ext.define('W5D5_Project.controller.CartProductController', {
    extend: 'Ext.app.Controller',

    id: 'cartProductController',

    control: {
        "#cartProductGrid": {
            rowdblclick: 'onCartProductGridDblClick'
        },
        "#cartProductUpdateButton": {
            click: 'onCartProductUpdateClick'
        },
        "#cartProductRemoveButton": {
            click: 'onCartProductRemoveClick'
        }
    },

    onCartProductGridDblClick: function(tableview, record, tr, rowIndex, e, eOpts) {
        if(Ext.isEmpty(this.cartProdWindow)){
            this.cartProdWindow = Ext.create('W5D5_Project.view.CartProductWindow');
        }
        Ext.getCmp('cartProductImg').setSrc('resources/img/' +record.data.prodImg + '.png');
        Ext.getCmp('cartProductNameField').setValue(record.data.prodName);
        Ext.getCmp('cartProductPriceField').setValue(record.data.prodPrice);
        Ext.getCmp('cartProductQtyField').setValue(record.data.prodQty);
        this.cartProdWindow.setTitle(record.data.prodName);
        this.cartProdWindow.show();
    },

    onCartProductUpdateClick: function(button, e, eOpts) {
        var prodId,prodQty,prodStore,selected,
            record = '';
        this.selected = selected;

        prodId = Ext.getCmp('cartProductGrid').getSelectionModel().selected.items[0].data.prodId;
        prodQty = Ext.getCmp('cartProductQtyField').getValue();
        prodStore = Ext.getStore('CartProductStore');

        Ext.each(prodStore.data.items,function(rec){
            if(prodId==rec.data.prodId){
                rec.data.prodQty = prodQty;
                rec.data.prodSubtotal = rec.data.prodPrice * rec.data.prodSale * rec.data.prodQty;
                record = rec.data;
                record.userId = Ext.getCmp('idField').getValue();
            }
        });
        Ext.getCmp('cartProductGrid').getView().refresh();
        Ext.Msg.alert("Success","Quantity Sucessfully Updated!");
        Ext.Ajax.request({
            url : 'addToCart',
            method : 'POST',
            params : {
                userId: Ext.getCmp('idField').getValue(),
                prodId: record.prodId,
                prodName: record.prodName,
                prodCat: record.prodCat,
                prodDesc: record.prodDesc,
                prodPrice: record.prodPrice,
                prodSale: record.prodSale,
                prodStock: record.prodStock,
                prodImg: record.prodImg,
                prodQty: record.prodQty,
                prodSubtotal: record.prodSubtotal
            },
            callback : function(options, success, response){
                if(!Ext.isEmpty(response.responseText)){
                    console.log("success!");
                }
            }
        });
        this.cartProdWindow.close();
    },

    onCartProductRemoveClick: function(button, e, eOpts) {
        var prodId,prodStore,selected,
            recordToDelete='';
        this.selected = selected;

        prodId = Ext.getCmp('cartProductGrid').getSelectionModel().selected.items[0].data.prodId;
        prodStore = Ext.getStore('CartProductStore');

        Ext.each(prodStore.data.items,function(record){
           if(prodId == record.data.prodId){
               recordToDelete = record;
           }
        });
        if(!Ext.isEmpty(recordToDelete)){
            Ext.Msg.alert('Success', 'Item removed from cart');
            Ext.getCmp('cartProductGrid').getView().refresh();
            prodStore.remove(recordToDelete);
        }
        Ext.Ajax.request({
            url : 'deleteCartByProduct',
            method : 'POST',
            params : {
                prodid : prodId,
                userid : Ext.getCmp('idField').getValue()
            },
            callback : function(options, success, response){
                if(!Ext.isEmpty(response.responseText)){
                    console.log("success!");
                }
            }
        });
        this.cartProdWindow.close();
    }

});
