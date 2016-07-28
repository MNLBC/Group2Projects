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
        },
        "#accForm": {
            beforeadd: 'onAccFormBeforeAdd'
        },
        "#userAccBtn": {
            click: 'onUserAccBtnClick'
        },
        "#userReqBtn": {
            click: 'onUserReqBtnClick'
        },
        "#orderHistBtn": {
            click: 'onOrderHistBtnClick'
        },
        "#adminSystemBtn": {
            click: 'onAdminSystemBtnClick'
        },
        "#allBtn": {
            click: 'onAllBtnClick'
        },
        "#faveBtn": {
            click: 'onFaveBtnClick'
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

        if(Ext.isEmpty(store.data.items)){
            Ext.Msg.alert('Check-out','Please add products to cart before checking out.');
            return;
        }

        Ext.each(store.data.items, function(rec){
            count = parseInt(count) + parseInt(rec.data.prodQty);
            total = total + rec.data.prodSubtotal;
        });

        Ext.Msg.show({
            title:'Confirm Checkout',
            message: 'Are you sure you want to check out?',
            buttons: Ext.Msg.YESNO,
            icon: Ext.Msg.QUESTION,
            fn: function(btn) {
                if (btn === 'yes') {
                    if(Ext.isEmpty(scope.orderWin)){
                        scope.orderWin = Ext.create('W5D5_Project.view.OrderWin');
                    }
                    if(Ext.getCmp('levelField').getValue()==2){
                        total = total - (total * 0.10);
                        Ext.getCmp('sumAmount').setValue(total + ' (10% OFF)');
                    }else{
                        Ext.getCmp('sumAmount').setValue(total);
                    }
                    Ext.getCmp('sumAdd').setValue(address.getValue());
                    Ext.getCmp('sumProds').setValue(count);
                    scope.orderWin.show();
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
                    var home1 = Ext.getCmp('headerPanel');
                    var home2 = Ext.getCmp('subHeaderPanel');
                    var home3 = Ext.getCmp('categoryPanel');
                    var admin1 = Ext.getCmp('userMgmtBtn');
                    var admin2 = Ext.getCmp('prodMgmtBtn');
                    var admin3 = Ext.getCmp('userReqBtn');
                    var panel = Ext.getCmp('mainTabPanel');
                    var panel2 = Ext.getCmp('cartPanel');
                    var panel3 = Ext.getCmp('menuPanel');
                    var tab = Ext.getCmp('setPanel');
                    var userField = Ext.getCmp('userField');
                    var countField = Ext.getCmp('countField'),
                        idField = Ext.getCmp('idField'),
                        admin4 = Ext.getCmp('adminSystemBtn');
                    panel.setActiveTab(tab);
                    var controller = W5D5_Project.app.getController('ShopController');
                    controller.clearItems();
                    controller.addProductsToPage('digital');
                    home1.hide();
                    home2.hide();
                    home3.hide();
                    admin1.hide();
                    admin2.hide();
                    admin3.hide();
                    admin4.hide();
                    panel2.hide();
                    panel3.hide();
                    userField.setValue('');
                    idField.setValue(0);
                    countField.setValue(parseInt(countField.getValue())-1);
                    Ext.Ajax.request({
                        url : "logout",
                        method : 'POST',
                        async : false,
                        callback : function(options, success, response) {
                            if (success!==true) {
                                console.log('Failed ');
                                Ext.Msg.alert("Logout", "Error logging out. Try again later.");
                            } else {
                                console.log('Success! ');
                                Ext.Msg.alert("Logout", "Successfully logged out!");
                                var mainControl = W5D5_Project.app.getController('MainController');
                                mainControl.clearFrontPage();
                                Ext.util.Cookies.clear("key");
                                Ext.Ajax.request ({
                                    url: "visitorCount",
                                    method: 'GET',
                                    async: false,
                                    callback : function(options, success, response) {
                                        if (success === true) {
                                            var count = response.responseText;
                                            countField.setValue(count);
                                        }
                                    }
                                });
                            }
                        }
                    });
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
            method : "POST",
            params : {
                userid: Ext.getCmp('idField').getValue(),
                cartprod: Ext.util.JSON.encode(items)
            },
            jsonData: Ext.util.JSON.encode(items),
            callback : function(options, success, response){
                if(response.responseText===''){
                    console.log('Failed');
                }else{
                    console.log('Success');
                }
            }
        });
    },

    onOrderCancelClick: function() {
        if(!Ext.isEmpty(this.orderWin)){
                             this.orderWin.hide();
                            }
    },

    onAccFormBeforeAdd: function(me, field) {
        if (!field.allowBlank){
            field.labelSeparator += '<span style="color: rgb(255, 0, 0); padding-left: 2px;">*</span>';
        }
    },

    onUserAccBtnClick: function() {
        var panel = Ext.getCmp('mainTabPanel');
        var tab = Ext.getCmp('accountPanel');
        panel.setActiveTab(tab);
        var controller = W5D5_Project.app.getController('ShopController');
        controller.clearItems();

        Ext.Ajax.request({
            url : "getUserByEmail",
            method : "GET",
            async : false,
            params : {
                email: Ext.getCmp('emailField').getValue()
            },
            callback : function(options,success,response){
                if(!Ext.isEmpty(response.responseText)){
                    var record = Ext.decode(response.responseText),
                        accControl = W5D5_Project.app.getController('AccountController');
                    record = record[0];
                    accControl.setFieldValues(record);
                    if(record.userLevel==2){
                        Ext.getCmp('accPremBtn').hide();
                    }else{
                        Ext.getCmp('accPremBtn').show();
                    }
                    Ext.getCmp('levelField').setValue(record.userLevel);
                }
            }
        });
    },

    onUserReqBtnClick: function() {
        var panel = Ext.getCmp('mainTabPanel');
        var tab = Ext.getCmp('requestPanel');
        panel.setActiveTab(tab);
        var controller = W5D5_Project.app.getController('ShopController');
        controller.clearItems();
        Ext.Ajax.request({
            url : "getAllRequest",
            method : "GET",
            async : false,
            callback : function(options,success,response){
                if (Ext.isEmpty(response.responseText)) {
                    Ext.Msg.alert("Requests",
                                  "Error in getting requests");
                } else {
                    var reqStore = Ext.getStore('RequestStore');
                    var jsonResponse = Ext.JSON.decode(response.responseText);
                    reqStore.loadData(jsonResponse);
                }
            }
        });
    },

    onOrderHistBtnClick: function() {
                var panel = Ext.getCmp('mainTabPanel');
                var tab = Ext.getCmp('orderHistPanel');
                panel.setActiveTab(tab);
                var controller = W5D5_Project.app.getController('ShopController');
                controller.clearItems();
                Ext.Ajax.request({
                    url : "GET/user/items/" + Ext.getCmp('idField').getValue(),
                    method : "GET",
                    async : false,
                    callback : function(options,success,response){
                        if (Ext.isEmpty(response.responseText)) {
                            Ext.Msg.alert("Order History",
                                          "Error in getting order history");
                        } else {
                            var orderStore = Ext.getStore('OrdersStore');
                            var jsonResponse = Ext.JSON.decode(response.responseText);
                            orderStore.loadData(jsonResponse);
                        }
                    }
                });
    },

    onAdminSystemBtnClick: function() {
        var panel = Ext.getCmp('mainTabPanel');
        var tab = Ext.getCmp('adminPanel');
        panel.setActiveTab(tab);
        var panel1 = Ext.getCmp('headerPanel'),
            panel2 = Ext.getCmp('subHeaderPanel'),
            panel3 = Ext.getCmp('categoryPanel'),
            panel4 = Ext.getCmp('cartPanel'),
            panel5 = Ext.getCmp('menuPanel'),
            menuPanel = Ext.getCmp('adminMenuPanel'),
            adminMenuContainer = Ext.getCmp('adminMenuContainer'),
            adminBackContainer = Ext.getCmp('adminBackContainer'),
            adminTabPanel = Ext.getCmp('adminTabPanel'),
            userMgmtTab = Ext.getCmp('userMgmtTab');

        adminTabPanel.setActiveTab(userMgmtTab);
        panel1.hide();
        panel2.hide();
        panel3.hide();
        panel4.hide();
        panel5.hide();
        menuPanel.show();
        adminMenuContainer.show();
        adminBackContainer.show();
        Ext.Ajax.request({
            url : "getAllUsers",
            method : "GET",
            async : false,
            callback : function(options,success,response){
                if (Ext.isEmpty(response.responseText)) {
                    Ext.Msg.alert("Users","Error in getting users");
                } else {
                    var userStore = Ext.getStore('UserStore');
                    var jsonResponse = Ext.JSON.decode(response.responseText);
                    userStore.loadData(jsonResponse);
                }
            }
        });
    },

    onAllBtnClick: function() {
        var panel = Ext.getCmp('mainTabPanel');
        var tab = Ext.getCmp('allProdsPanel');
        panel.setActiveTab(tab);
        var controller = W5D5_Project.app.getController('ShopController');
        controller.clearItems();

        var prodStore = Ext.getStore('ProductStore'),
            store = Ext.getStore('AllProductsStore');

        prodStore.clearFilter();
        store.clearFilter();

        Ext.each(prodStore.data.items, function(record){
           store.add(record);
        });
    },

    onFaveBtnClick: function() {
        var panel = Ext.getCmp('mainTabPanel');
        var tab = Ext.getCmp('faveProdsPanel');
        panel.setActiveTab(tab);
        var controller = W5D5_Project.app.getController('ShopController');
        controller.clearItems();

        var faveStore = Ext.getStore('FavoriteItemsStore'),
            prodStore = Ext.getStore('ProductStore'),
            store = Ext.getStore('FavoriteProductsStore');

        faveStore.clearFilter();
        prodStore.clearFilter();
        store.clearFilter();

        Ext.each(prodStore.data.items, function(record){
           Ext.each(faveStore.data.items, function(rec){
              if(record.data.prodId == rec.data.prodId){
                  store.add(record);
              }
           });
        });
    },

    clearFrontPage: function() {
        Ext.getCmp('emailLoginField').setValue('');
        Ext.getCmp('passLoginField').setValue('');

        Ext.getCmp('fnameRegField').setValue('');
        Ext.getCmp('lnameRegField').setValue('');
        Ext.getCmp('countryRegCombo').setValue('');
        Ext.getCmp('spRegCombo').setValue('');
        Ext.getCmp('cityRegField').setValue('');
        Ext.getCmp('address1RegField').setValue('');
        Ext.getCmp('address2RegField').setValue('');
        Ext.getCmp('occupRegField').setValue('');
        Ext.getCmp('emailRegField').setValue('');
        Ext.getCmp('passRegField').setValue('');
        Ext.getCmp('pCodeField').setValue('');
    }

});
