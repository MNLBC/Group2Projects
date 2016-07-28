/*
 * File: app.js
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

// @require @packageOverrides
Ext.Loader.setConfig({

});


Ext.application({
    models: [
        'CategoryModel',
        'ProductModel',
        'CartProductModel',
        'CountryModel',
        'SPModel',
        'UserModel',
        'UserTypeModel',
        'OrdersModel',
        'OrderProductModel',
        'FavoriteItemsModel',
        'RequestModel',
        'ProdReviewModel',
        'OnlineUsersModel'
    ],
    stores: [
        'ProductStoreB',
        'CategoryStore',
        'CartProductStore',
        'UserTypeStore',
        'CountryStore',
        'SPStore',
        'UserStore',
        'ProductStore',
        'FavoriteItemsStore',
        'OrdersStore',
        'OrderProductStore',
        'RequestStore',
        'UserLevelStore',
        'ProdReviewStore',
        'RatingStore',
        'FavoriteProductsStore',
        'OnlineUsersStore',
        'AllProductsStore'
    ],
    views: [
        'MainView',
        'CartProductWindow',
        'ProductImageWindow',
        'OrderWin',
        'OrderProductWin',
        'UserInfoWin',
        'ProdInfoWin',
        'BrowseProductsWin'
    ],
    controllers: [
        'MainController',
        'ShopController',
        'CartProductController',
        'ProductController',
        'UserMainController',
        'AccountController',
        'ProdInfoController',
        'FavoriteItemsController',
        'AllProductsController',
        'OrderMgmtController',
        'AdminController',
        'UserMgmtController',
        'ProductMgmtController',
        'RequestController',
        'OnlineUsersController',
        'BrowseProductController'
    ],
    name: 'W5D5_Project',

    launch: function() {
        Ext.create('W5D5_Project.view.MainView');
        Ext.define('ProductTemplate', {
            extend: 'Ext.container.Container',
            alias: 'widget.producttemplate',

            requires: ['Ext.container.Container', 'Ext.panel.Panel',
                       'Ext.Img',
                       'Ext.form.field.Display',
                       'Ext.button.Button'],

            config: {
                qid: ''
            },
            cls: 'prodblock',
            layout: 'hbox',

            items: [
                {xtype: 'panel',
                 height: 350,
                 width: 300,
                 title: '',
                 layout: {
                     type: 'vbox',
                     align: 'center'
                 },
                 items: [
                     {
                         xtype: 'image',
                         height: 200,
                         width: 200,
                         style: {
                             cursor: 'pointer'
                         },
                         listeners: {
                             el: {
                                 click: function() {
                                     var record = Ext.getCmp(this.id).up('panel').recordData;
                                     var controller = W5D5_Project.app.getController('ProdInfoController');
                                     controller.showProdInfoWin(record);
                                 }
                             }
                         }
                     },
                     {
                         xtype: 'displayfield',
                         fieldLabel: '',
                         hidden: true,
                         value: 'id'
                     },
                     {
                         xtype: 'displayfield',
                         fieldLabel: '',
                         value: 'Product Name'
                     },
                     {
                         xtype: 'displayfield',
                         fieldLabel: '',
                         value: 'Price'
                     },
                     {
                         xtype: 'button',
                         text: '',
                         cls: 'addToCartBtnCls',
                         focusCls: '(none)',
                         listeners: {
                             'click': function(button, e, eOpts){
                                 console.log(button);
                                 console.log(e);
                                 console.log(button.up('panel').recordData);
                                 var store = Ext.getStore('CartProductStore'),
                                     record = button.up('panel').recordData,
                                     isExists = false,
                                     cartCount = Ext.getCmp('cartCount');
                                 Ext.each(store.data.items,function(rec){
                                     if(rec.data.prodId==record.prodId){
                                         rec.data.prodQty=parseInt(rec.data.prodQty)+1;
                                         rec.data.prodSubtotal=rec.data.prodSubtotal+rec.data.prodPrice;
                                         isExists = true;
                                         record=rec.data;
                                         Ext.getCmp('cartProductGrid').getView().refresh();
                                     }
                                 });
                                 if(!isExists){
                                     record.cartprodId='';
                                     record.prodQty=1;
                                     store.add(record);
                                 }
                                 Ext.Msg.alert('Status', 'Added item to cart');
                                 console.log(store);
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

                             }
                         }
                     },
                     {
                         xtype: 'button',
                         text: '',
                         cls: 'addToFaveBtnCls',
                         focusCls: '(none)',
                         listeners: {
                             'click': function(button, e, eOpts){
                                 console.log(button);
                                 console.log(e);
                                 console.log(button.up('panel').recordData);
                                 var store = Ext.getStore('FavoriteItemsStore'),
                                     record = button.up('panel').recordData,
                                     item = '',
                                     isExists = false;
                                 Ext.each(store.data.items, function(rec){
                                     if(rec.data.prodId==record.prodId){
                                         isExists=true;
                                         item=rec;
                                     }
                                 });
                                 if(isExists){
                                     store.remove(item);
                                     button.removeCls('addToFaveBtnPinkCls');
                                     button.addCls('addToFaveBtnCls');
                                     Ext.Ajax.request({
                                         url : 'deleteFavoriteItems',
                                         method : 'POST',
                                         params : {
                                             userId : Ext.getCmp('idField').getValue(),
                                             prodId : record.prodId
                                         },
                                         callback : function(options, success, response){
                                             if(!Ext.isEmpty(response.responseText)){
                                                 console.log("success!");
                                                 Ext.Msg.alert("Favorite Items", "Product removed from your favorite items.");
                                             }
                                         }
                                     });
                                 }else{
                                     var prod = {faveItemId: '', prodId: record.prodId, userId: Ext.getCmp('userField').getValue()};
                                     store.add(prod);
                                     button.removeCls('addToFaveBtnCls');
                                     button.addCls('addToFaveBtnPinkCls');
                                     Ext.Ajax.request({
                                         url : 'addFavoriteItems',
                                         method : 'POST',
                                         params : {
                                             userId : Ext.getCmp('idField').getValue(),
                                             prodId : record.prodId
                                         },
                                         callback : function(options, success, response){
                                             if(!Ext.isEmpty(response.responseText)){
                                                 console.log("success!");
                                                 Ext.Msg.alert("Favorite Items", "Product added to your favorite items.");
                                             }
                                         }
                                     });
                                 }
                             }
                         }
                     }
                 ]}
            ]

        });

        var key= Ext.util.Cookies.get("key");

        if (key === undefined || key == 'null' || key === null || key.length <= 0){
                // load login UI as user is not logged in
        } else {

        //     For client side

        //     load main UI as user is already logged in


        //     var store = Ext.getStore('UserStore');
        //     var email = Ext.getCmp('emailLoginField').getValue();
        //     var password = Ext.getCmp('passLoginField').getValue();
        //     var main = Ext.getCmp('setPanel');
        //     var home1 = Ext.getCmp('headerPanel');
        //     var home2 = Ext.getCmp('subHeaderPanel');
        //     var home3 = Ext.getCmp('categoryPanel');
        //     var admin1 = Ext.getCmp('userMgmtBtn');
        //     var admin2 = Ext.getCmp('prodMgmtBtn'),
        //         admin3 = Ext.getCmp('userReqBtn'),
        //         admin4 = Ext.getCmp('adminSystemBtn');
        //         record = '';
        //     var isExist = false;
        //     email = key;
        //     Ext.Ajax.request({
        //                 url : "getUserByEmail",
        //                 method : "GET",
        //                 async : false,
        //                 params : {
        //                     email : email
        //                 },
        //                 callback : function(options, success, response) {
        //                     if (!Ext.isEmpty(response.responseText)) {
        //                         record = Ext.decode(response.responseText);
        //                         record = record[0];
        //                         isExist = true;
        //                         if (record.userType == 'Admin') {
        //                             // 							admin1.show();
        //                             // 							admin2.show();
        //                             Ext.Ajax.request({
        //                                 url : "runAdminConsumer",
        //                                 method : "GET",
        //                                 async : false,
        //                                 callback : function(options, success, response){
        //                                     if(response.responseText==1){
        //                                         console.log('Run Admin Topic Subscriber');
        //                                     }
        //                                 }
        //                             });
        //                             admin3.show();
        //                             admin4.show();
        //                         }
        //                         store.add(record);
        //                         Ext.Ajax.request({
        //                             url : "getAllProducts",
        //                             method : 'GET',
        //                             async : false,
        //                             callback : function(options, success, response) {
        //                                 if (Ext.isEmpty(response.responseText)) {
        //                                     Ext.Msg.alert("Products",
        //                                                   "Error in getting products");
        //                                 } else {
        //                                     var prodStore = Ext.getStore('ProductStore');
        //                                     var jsonResponse = Ext.JSON.decode(response.responseText);
        //                                     prodStore.loadData(jsonResponse);
        //                                     var panel = Ext.getCmp('mainTabPanel');
        //                                     var tab = Ext.getCmp('digitalPanel');
        //                                     var userField = Ext.getCmp('userField');
        //                                     var countField = Ext.getCmp('countField'),
        //                                         idField = Ext.getCmp('idField'),
        //                                         addField = Ext.getCmp('addField'),
        //                                         emailField = Ext.getCmp('emailField'),
        //                                         levelField = Ext.getCmp('levelField');
        //                                     panel.setActiveTab(tab);
        //                                     var controller = W5D5_Project.app.getController('ShopController');
        //                                     controller.clearItems();
        //                                     controller.addProductsToPage('digital');
        //                                     home1.show();
        //                                     home2.show();
        //                                     home3.show();
        //                                     userField.setValue(record.userFname);
        //                                     idField.setValue(record.userId);
        //                                     if(Ext.isEmpty(record.userAddress2)){
        //                                        addField.setValue(record.userAddress1 + ', ' + record.userCity + ', ' + record.userSp + ', ' + record.userCountry);
        //                                     }else{
        //                                        addField.setValue(record.userAddress1 + ', ' + record.userAddress2 + ', ' + record.userCity + ', ' + record.userSp + ', ' + record.userCountry);
        //                                     }

        //                                     emailField.setValue(record.userEmail);
        //                                     levelField.setValue(record.userLevel);

        //                                     Ext.Ajax.request ({
        //                                         url: "visitorCount",
        //                                         method: 'GET',
        //                                         async: false,
        //                                         callback : function(options, success, response) {
        //                                             if (success === true) {
        //                                                 var count = response.responseText;
        //                                                 countField.setValue(count);
        //                                             }
        //                                         }
        //                                     });

        //                                     Ext.Ajax.request ({
        //                                         url: "favoriteItems",
        //                                         method: 'POST',
        //                                         params: {
        //                                             userId:Ext.getCmp('idField').getValue()
        //                                         },
        //                                         async: false,
        //                                         callback : function(options, success, response) {
        //                                             if (success === true) {
        //                                                 var faveStore = Ext.getStore('FavoriteItemsStore');
        //                                                 var result = Ext.JSON.decode(response.responseText);
        //                                                 faveStore.loadData(result);
        //                                             }
        //                                         }
        //                                     });
        //                                     Ext.Ajax.request ({
        //                                         url: "getCartByUser",
        //                                         method: 'POST',
        //                                         params: {
        //                                             userid:Ext.getCmp('idField').getValue()
        //                                         },
        //                                         async: false,
        //                                         callback : function(options, success, response) {
        //                                             if (success === true) {
        //                                                 var cartStore = Ext.getStore('CartProductStore');
        //                                                 var resultSet = Ext.JSON.decode(response.responseText);
        //                                                 cartStore.loadData(resultSet);
        //                                             }
        //                                         }
        //                                     });
        //                                 }
        //                             }
        //                         });
        //                     }
        //                 }
        //             });


            // For Admin
        var store = Ext.getStore('UserStore');
        var email = Ext.getCmp('adminEmail').getValue();
        var password = Ext.getCmp('adminPassword').getValue();
        var main = Ext.getCmp('setPanel');
        var home1 = Ext.getCmp('headerPanel');
        var home2 = Ext.getCmp('subHeaderPanel');
        var home3 = Ext.getCmp('categoryPanel');
        var admin1 = Ext.getCmp('userMgmtBtn');
        var admin2 = Ext.getCmp('prodMgmtBtn'),
            admin3 = Ext.getCmp('userReqBtn'),
            admin4 = Ext.getCmp('adminSystemBtn'),
            menuPanel = Ext.getCmp('adminMenuPanel'),
            tabPanel = Ext.getCmp('adminTabPanel'),
            adminMenuContainer = Ext.getCmp('adminMenuContainer'),
            adminBackContainer = Ext.getCmp('adminBackContainer');
            record = '';
        var isExist = false;

        Ext.Ajax.request({
            url : "getUserByEmail",
            method : "GET",
            async : false,
            params : {
                email : Ext.getCmp('emailLoginField').getValue()
            },
            callback : function(options, success, response) {
                if (!Ext.isEmpty(response.responseText)) {
                    record = Ext.decode(response.responseText);
                    record = record[0];
                    isExist = true;
                    if (record.userType == 'Admin') {
                        Ext.Ajax.request({
                            url : "runAdminConsumer",
                            method : "GET",
                            async : false,
                            callback : function(options, success, response){
                                if(response.responseText==1){
                                    console.log('Run Admin Topic Subscriber');
                                    store.add(record);
                                    Ext.Ajax.request({
                                        url : "getAllProducts",
                                        method : 'GET',
                                        async : false,
                                        callback : function(options, success, response) {
                                            if (Ext.isEmpty(response.responseText)) {
                                                Ext.Msg.alert("Products",
                                                              "Error in getting products");
                                            } else {
                                                var prodStore = Ext.getStore('ProductStore');
                                                var jsonResponse = Ext.JSON.decode(response.responseText);
                                                prodStore.loadData(jsonResponse);
                                                var userField = Ext.getCmp('userField');
                                                var countField = Ext.getCmp('countField'),
                                                    idField = Ext.getCmp('idField'),
                                                    addField = Ext.getCmp('addField'),
                                                    emailField = Ext.getCmp('emailField'),
                                                    levelField = Ext.getCmp('levelField');
                                                admin3.show();
                                                admin4.show();
                                                menuPanel.show();
                                                adminMenuContainer.show();
                                                adminBackContainer.show();
                                                var controller = W5D5_Project.app.getController('ShopController');
                                                controller.clearItems();
                                                controller.addProductsToPage('digital');
                                                userField.setValue(record.userFname);
                                                idField.setValue(record.userId);
                                                if(Ext.isEmpty(record.userAddress2)){
                                                   addField.setValue(record.userAddress1 + ', ' + record.userCity + ', ' + record.userSp + ', ' + record.userCountry);
                                                }else{
                                                   addField.setValue(record.userAddress1 + ', ' + record.userAddress2 + ', ' + record.userCity + ', ' + record.userSp + ', ' + record.userCountry);
                                                }
                                                emailField.setValue(record.userEmail);
                                                levelField.setValue(record.userLevel);
                                                var adminController = W5D5_Project.app.getController('AdminController');
                                                adminController.onAdminUserMgmtBtnClick();
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
                                                Ext.Ajax.request ({
                                                    url: "favoriteItems",
                                                    method: 'POST',
                                                    params: {
                                                        userId:Ext.getCmp('idField').getValue()
                                                    },
                                                    async: false,
                                                    callback : function(options, success, response) {
                                                        if (success === true) {
                                                            var faveStore = Ext.getStore('FavoriteItemsStore');
                                                            var result = Ext.JSON.decode(response.responseText);
                                                            faveStore.loadData(result);
                                                        }
                                                    }
                                                });
                                                Ext.Ajax.request ({
                                                    url: "getCartByUser",
                                                    method: 'POST',
                                                    params: {
                                                        userid:Ext.getCmp('idField').getValue()
                                                    },
                                                    async: false,
                                                    callback : function(options, success, response) {
                                                        if (success === true) {
                                                            var cartStore = Ext.getStore('CartProductStore');
                                                            var resultSet = Ext.JSON.decode(response.responseText);
                                                            cartStore.loadData(resultSet);
                                                        }
                                                    }
                                                });
                                            }
                                        }
                                    });
                                }
                            }
                        });
                    }else{
                        Ext.Msg.alert("User", "Sorry but you are prohibited to access this site");
                    }
                }
            }
        });

        }
    }

});
