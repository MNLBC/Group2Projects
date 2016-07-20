/*
 * File: app/controller/MainController.js
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

Ext.define('W5D5_Project.controller.MainController', {
    extend: 'Ext.app.Controller',

    id: 'mainController',

    control: {
        "#menuBtn": {
            click: 'onMenuBtnClick'
        },
        "#cartBtn": {
            click: 'onCartBtnClick'
        },
        "#digitalBtn": {
            click: 'onDigitalBtnClick'
        },
        "#luxuryBtn": {
            click: 'onLuxuryBtnClick'
        },
        "#casualBtn": {
            click: 'onCasualBtnClick'
        },
        "#sportsBtn": {
            click: 'onSportsBtnClick'
        },
        "#dressBtn": {
            click: 'onDressBtnClick'
        },
        "#menuPanel": {
            blur: 'onMenuPanelBlur'
        },
        "#menuCont": {
            blur: 'onMenuContBlur'
        },
        "#prodMgmtBtn": {
            click: 'onProdMgmtBtnClick'
        },
        "#checkOutBtn": {
            click: 'onCheckOutBtnClick'
        },
        "#logoutBtn": {
            click: 'onLogoutBtnClick'
        },
        "#userMgmtBtn": {
            click: 'onUserMgmtBtnClick'
        },
        "#orderConfirm": {
            click: 'onOrderConfirmClick'
        },
        "#orderCancel": {
            click: 'onOrderCancelClick'
        }
    },

    onMenuBtnClick: function() {
        var menu = Ext.getCmp('menuPanel'),
            btn = Ext.getCmp('menuBtn');
        if(menu.hidden){
        //     btn.update({cls: 'actmenuBtnCls'});
            menu.show();
        }else{
        //     btn.update({cls: 'menuBtnCls'});
            menu.hide();
        }
    },

    onCartBtnClick: function() {
        var cart = Ext.getCmp('cartPanel');
        if(cart.hidden){
            cart.show();
        }else{
            cart.hide();
        }
    },

    onDigitalBtnClick: function() {
        var panel = Ext.getCmp('mainTabPanel');
        var tab = Ext.getCmp('digitalPanel');
        panel.setActiveTab(tab);
        var controller = W5D5_Project.app.getController('ShopController');
        controller.clearItems();
        controller.addProductsToPage('digital');
    },

    onLuxuryBtnClick: function() {
        var panel = Ext.getCmp('mainTabPanel');
        var tab = Ext.getCmp('luxuryPanel');
        panel.setActiveTab(tab);
        var controller = W5D5_Project.app.getController('ShopController');
        controller.clearItems();
        controller.addProductsToPage('luxury');
    },

    onCasualBtnClick: function() {
        var panel = Ext.getCmp('mainTabPanel');
        var tab = Ext.getCmp('casualPanel');
        panel.setActiveTab(tab);
        var controller = W5D5_Project.app.getController('ShopController');
        controller.clearItems();
        controller.addProductsToPage('casual');
    },

    onSportsBtnClick: function() {
        var panel = Ext.getCmp('mainTabPanel');
        var tab = Ext.getCmp('sportsPanel');
        panel.setActiveTab(tab);
        var controller = W5D5_Project.app.getController('ShopController');
        controller.clearItems();
        controller.addProductsToPage('sports');
    },

    onDressBtnClick: function() {
        var panel = Ext.getCmp('mainTabPanel');
        var tab = Ext.getCmp('dressPanel');
        panel.setActiveTab(tab);
        var controller = W5D5_Project.app.getController('ShopController');
        // controller.clearItems();
        controller.addProductsToPage('dress');
    },

    onMenuPanelBlur: function() {
        var panel = Ext.getCmp('mainTabPanel');
        panel.hide();
    },

    onMenuContBlur: function() {
        var panel = Ext.getCmp('mainTabPanel');
        panel.hide();
    },

    onProdMgmtBtnClick: function() {
        var panel = Ext.getCmp('mainTabPanel');
        var tab = Ext.getCmp('productPanel');
        panel.setActiveTab(tab);
        var controller = W5D5_Project.app.getController('ShopController');
        controller.clearItems();
    },

    onCheckOutBtnClick: function() {
        var store = Ext.getStore('CartProductStore'),
            total = 0, count = 0,
            address = Ext.getCmp('addField'),
            scope = this;
        Ext.each(store.data.items, function(rec){
            count = count + rec.data.prodQty;
            total = total + rec.data.prodSubtotal;
        });

        Ext.Msg.show({
            title:'Confirm Checkout',
            message: 'Are you sure you want to check out?',
            buttons: Ext.Msg.YESNO,
            icon: Ext.Msg.QUESTION,
            fn: function(btn) {
                if (btn === 'yes') {
                    console.log('Yes pressed');
                    if(Ext.isEmpty(scope.orderWin)){
                     scope.orderWin = Ext.create('W5D5_Project.view.OrderWin');
                    }
                    Ext.getCmp('sumAdd').setValue(address.getValue());
                    Ext.getCmp('sumAmount').setValue(total);
                    Ext.getCmp('sumProds').setValue(count);
                    scope.orderWin.show();
                } else if (btn === 'no') {
                    console.log('No pressed');
                }
            }
        });
    },

    onLogoutBtnClick: function() {
        Ext.Msg.show({
            title:'Confirm Logout',
            message: 'Are you sure you want to log out?',
            buttons: Ext.Msg.YESNO,
            icon: Ext.Msg.QUESTION,
            fn: function(btn) {
                if (btn === 'yes') {
                    console.log('Yes pressed');
                    var home1 = Ext.getCmp('headerPanel');
                    var home2 = Ext.getCmp('subHeaderPanel');
                    var home3 = Ext.getCmp('categoryPanel');
                    var admin1 = Ext.getCmp('userMgmtBtn');
                    var admin2 = Ext.getCmp('prodMgmtBtn');
                    var panel = Ext.getCmp('mainTabPanel');
                    var tab = Ext.getCmp('setPanel');
                    var userField = Ext.getCmp('userField');
                    var countField = Ext.getCmp('countField'),
                        idField = Ext.getCmp('idField');
                    panel.setActiveTab(tab);
                    var controller = W5D5_Project.app.getController('ShopController');
                    controller.clearItems();
                    controller.addProductsToPage('digital');
                    home1.hide();
                    home2.hide();
                    home3.hide();
                    admin1.hide();
                    admin2.hide();
                    userField.setValue('Visitor');
                    idField.setValue(0);
                    countField.setValue(parseInt(0));
                } else if (btn === 'no') {
                    console.log('No pressed');
                }
            }
        });
    },

    onUserMgmtBtnClick: function() {
        var panel = Ext.getCmp('mainTabPanel');
        var tab = Ext.getCmp('userPanel');
        panel.setActiveTab(tab);
        var controller = W5D5_Project.app.getController('ShopController');
        controller.clearItems();
    },

    onOrderConfirmClick: function() {
        var items =[];

        if(!Ext.isEmpty(this.orderWin)){
            this.orderWin.hide();
        }
        Ext.Msg.alert("Order Success!", "Your order has been processed! Please wait for your items to be delivered.");
        var store = Ext.getStore('CartProductStore');
        Ext.each(store.data.items,function(rec){
            items.push(Ext.encode(rec.data));
        });

        store.removeAll();

        Ext.Ajax.request({
            url : "checkout",
            method : "GET",
            params : {
                userid: Ext.getCmp('idField').getValue(),
                cartprod: Ext.util.JSON.encode(items)
            },
            jsonData: Ext.util.JSON.encode(items),
            callback : function(options, success, response){
                if(response.responseText===''){
                    console.log('Failed :(');
                }else{
                    console.log('Success! :)');
                }
            }
        });
    },

    onOrderCancelClick: function() {
        if(!Ext.isEmpty(this.orderWin)){
                             this.orderWin.hide();
                            }
    }

});
