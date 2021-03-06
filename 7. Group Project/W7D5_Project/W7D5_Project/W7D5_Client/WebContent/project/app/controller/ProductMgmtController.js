/*
 * File: app/controller/ProductMgmtController.js
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

Ext.define('W5D5_Project.controller.ProductMgmtController', {
    extend: 'Ext.app.Controller',

    id: 'productMgmtController',

    refs: {
        prodMgmtGrid: '#prodMgmtGrid'
    },

    control: {
        "textfield": {
            change: 'onProdMgmtSearchChange'
        },
        "#prodMgmtDelete": {
            click: 'onProdMgmtDeleteClick'
        },
        "#prodMgmtUpdate": {
            click: 'onProdMgmtUpdateClick'
        },
        "#prodMgmtCreate": {
            click: 'onProdMgmtCreateClick'
        },
        "#prodMgmtReset": {
            click: 'onProdMgmtResetClick'
        },
        "#prodMgmtGrid": {
            selectionchange: 'onProdMgmtGridSelectionChange'
        },
        "#prodMgmtField1": {
            beforeadd: 'onProdMgmtField1BeforeAdd'
        },
        "#prodMgmtField2": {
            beforeadd: 'onProdMgmtField2BeforeAdd'
        }
    },

    onProdMgmtSearchChange: function(field, newValue, oldValue, eOpts) {
        var searchVal = Ext.getCmp('prodMgmtSearch').getValue();
        var store = Ext.getStore('ProductStore');
        if(Ext.isEmpty(searchVal)){
            store.clearFilter();
        }else{
            store.filter('prodName', searchVal);
        }
    },

    onProdMgmtDeleteClick: function() {
        var controller = W5D5_Project.app.getController('ProductMgmtController');
        var store = Ext.getStore('ProductStore');
        var id = Ext.getCmp('prodMgmtId').getValue();
        var record = '';
        if(Ext.isEmpty(id)){
            Ext.Msg.show({
             title:'',
             msg: 'Please select a record to delete.',
             buttons: Ext.Msg.OK,
             icon: Ext.Msg.WARNING
           });
        }else{
            Ext.each(store.data.items, function(rec){
               if(rec.data.prodId == id){
               record = rec;
            }
         });
        if(!Ext.isEmpty(record)){
            Ext.Ajax.request({
                url : 'removeProduct',
                method : 'POST',
                params : {
                    id : id
                },
                callback : function(options, success, response){
                    if(!Ext.isEmpty(response.responseText)){
                        console.log("success!");
                    }
                }
            });
        }
        store.remove(record);
        Ext.Msg.alert('Success', 'Product successfully deleted');
        Ext.getCmp('prodMgmtGrid').getView().refresh();
        controller.productResetFormValues();
        }
    },

    onProdMgmtUpdateClick: function() {
        var field1 = Ext.getCmp('prodMgmtField1');
        var field2 = Ext.getCmp('prodMgmtField2');
        var controller = W5D5_Project.app.getController('ProductMgmtController');
        var id = Ext.getCmp('prodMgmtId').getValue();
        var product;

        if(Ext.isEmpty(id)){
            Ext.Msg.show({
             title:'',
             msg: 'Please select a record to update.',
             buttons: Ext.Msg.OK,
             icon: Ext.Msg.WARNING
           });
        } else {
            if(field1.isValid() && field2.isValid()){
        	product = controller.getProductFormValues();
            Ext.Ajax.request({
                url : "updateProduct",
                method: 'POST',
                params : {
                    product: Ext.encode(product)
                },
                async: false,
                jsonData: Ext.util.JSON.encode(product),
                callback : function(options, success, response){
                    if(response.responseText===''){
                        Ext.Msg.alert("Update Products", "Error encountered in updating product.");
                    }else {
                        Ext.Msg.alert("Update Products", "Product information successfully updated.");
                        controller.productResetFormValues();
                        controller.productRefresh();
                    }
                }
            });
        }else{
            Ext.Msg.alert("Update Products", "Please check the field values.");
        }
        }
    },

    onProdMgmtCreateClick: function() {
        var controller = W5D5_Project.app.getController('ProductMgmtController');
        var product = controller.getProductFormValues();
        var cat = Ext.getCmp('prodMgmtCat').getValue();
        var name = Ext.getCmp('prodMgmtName').getValue();

        if ((!Ext.getCmp('prodMgmtField1').isValid()) || (!Ext.getCmp('prodMgmtField2').isValid())) {
        	Ext.Msg.alert('Create Product', "Please fill out required fields");
        	return;
        } else {
        	product.prodId = '';
        	Ext.Ajax.request({
        		url : "addProduct",
        		method : 'POST',
        		params : {
        			product : Ext.encode(product)
        		},
        		async : false,
        		jsonData : Ext.util.JSON.encode(product),
        		callback : function(options, success, response) {
        			if (success === true) {
        				Ext.Msg.alert('Add Products', 'Product "' + name + '" successfully added to ' + cat + '!');
        			} else {
        				Ext.Msg.alert('Add Products', 'Error in adding product');
        			}
        		}
        	});
        }
        controller.productResetFormValues();
        controller.productRefresh();
    },

    onProdMgmtResetClick: function() {
        var controller = W5D5_Project.app.getController('ProductMgmtController');
        controller.productResetFormValues();
    },

    onProdMgmtGridSelectionChange: function(model, selected, eOpts) {

        if(!Ext.isEmpty(selected)){
            Ext.getCmp('prodMgmtId').setValue(selected[0].data.prodId);
            Ext.getCmp('prodMgmtName').setValue(selected[0].data.prodName);
            Ext.getCmp('prodMgmtCat').setValue(selected[0].data.prodCat);
            Ext.getCmp('prodMgmtDesc').setValue(selected[0].data.prodDesc);
            Ext.getCmp('prodMgmtPrice').setValue(selected[0].data.prodPrice);
            Ext.getCmp('prodMgmtSale').setValue(selected[0].data.prodSale);
            Ext.getCmp('prodMgmtStock').setValue(selected[0].data.prodStock);
            Ext.getCmp('prodMgmtImg').setValue(selected[0].data.prodImg);
        }else{
            var controller = W5D5_Project.app.getController('ProductMgmtController');
            controller.productResetFormValues();
        }


    },

    onProdMgmtField1BeforeAdd: function(me, field) {
        if (!field.allowBlank){
            field.labelSeparator += '<span style="color: rgb(255, 0, 0); padding-left: 2px;">*</span>';
        }
    },

    onProdMgmtField2BeforeAdd: function(me, field) {
        if (!field.allowBlank){
            field.labelSeparator += '<span style="color: rgb(255, 0, 0); padding-left: 2px;">*</span>';
        }
    },

    getProductFormValues: function() {

        var prodId = Ext.getCmp('prodMgmtId').getValue();
        var prodName = Ext.getCmp('prodMgmtName').getValue();
        var prodCat = Ext.getCmp('prodMgmtCat').getValue();
        var prodPrice = Ext.getCmp('prodMgmtPrice').getValue();
        var prodDesc = Ext.getCmp('prodMgmtDesc').getValue();
        var prodStock = Ext.getCmp('prodMgmtStock').getValue();
        var prodSale = Ext.getCmp('prodMgmtSale').getValue();
        var prodImg = Ext.getCmp('prodMgmtImg').getValue();

        var product = {
            "prodId":prodId,
            "prodName":prodName,
            "prodCat":prodCat,
            "prodPrice":prodPrice,
            "prodDesc":prodDesc,
            "prodStock":prodStock,
            "prodSale":prodSale,
            "prodImg":prodImg
        };

        return product;
    },

    productResetFormValues: function() {
          Ext.getCmp('prodMgmtId').setValue('');
          Ext.getCmp('prodMgmtName').setValue('');
          Ext.getCmp('prodMgmtCat').setValue('');
          Ext.getCmp('prodMgmtPrice').setValue('');
          Ext.getCmp('prodMgmtDesc').setValue('');
          Ext.getCmp('prodMgmtStock').setValue('');
          Ext.getCmp('prodMgmtSale').setValue('');
          Ext.getCmp('prodMgmtImg').setValue('');
          Ext.getCmp('prodMgmtSearch').setValue('');
          Ext.getStore('ProductStore').clearFilter();
    },

    productRefresh: function() {
        Ext.Ajax.request({
            url : "getAllProducts",
            method : "GET",
            async : false,
            callback : function(options,success,response){
                if (Ext.isEmpty(response.responseText)) {
                    Ext.Msg.alert("Products",
                                  "Error in getting products");
                } else {
                    var prodStore = Ext.getStore('ProductStore');
                    var jsonResponse = Ext.JSON.decode(response.responseText);
                    prodStore.loadData(jsonResponse);
                }
            }
        });
    }

});
