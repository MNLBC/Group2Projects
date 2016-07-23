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
        'FavoriteItemsModel'
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
        'OrderProductStore'
    ],
    views: [
        'MainView',
        'CartProductWindow',
        'ProductImageWindow',
        'OrderWin'
    ],
    controllers: [
        'MainController',
        'ShopController',
        'CartProductController',
        'ProductController',
        'UserMainController',
        'UserMgmtController',
        'AccountController',
        'RequestController'
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
                         width: 200
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
                                         rec.data.prodQty=rec.data.prodQty+1;
                                         rec.data.prodSubtotal=rec.data.prodSubtotal+rec.data.prodPrice;
                                         isExists = true;
                                         Ext.getCmp('cartProductGrid').getView().refresh();
                                     }
                                 });
                                 if(!isExists){
                                     record.prodQty=1;
                                     store.add(record);
                                 }
                                 Ext.Msg.alert('Status', 'Added item to cart');
                                 console.log(store);

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
                                 }else{
                                     var prod = {faveItemId: '', prodId: record.prodId, userId: Ext.getCmp('userField').getValue()};
                                     store.add(prod);
                                     button.removeCls('addToFaveBtnCls');
                                     button.addCls('addToFaveBtnPinkCls');
                                 }
                             }
                         }
                     }
                 ]}
            ]

        });
    }

});
