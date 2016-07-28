/*
 * File: app/controller/OrderMgmtController.js
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

Ext.define('W5D5_Project.controller.OrderMgmtController', {
    extend: 'Ext.app.Controller',

    control: {
        "#adminOrderMgmtBtn": {
            click: 'onOrderMgmtClick'
        },
        "#orderMgmtGrid": {
            selectionchange: 'onOrderMgmtGridSelect',
            rowdblclick: 'onOrderMgmtGridDblClick'
        },
        "#orderMgmtSearch": {
            change: 'onOrderMgmtSearchChange'
        },
        "#orderMgmtReset": {
            click: 'onOrderMgmtResetClick'
        },
        "#orderMgmtDelete": {
            click: 'onOrderMgmtDeleteClick'
        },
        "#orderMgmtCreate": {
            click: 'onOrderMgmtCreateClick'
        },
        "#orderMgmtUpdate": {
            click: 'onOrderMgmtUpdateClick'
        },
        "#orderMgmtField1": {
            beforeadd: 'onOrderMgmtField1BeforeAdd'
        },
        "#orderMgmtField2": {
            beforeadd: 'onOrderMgmtField2BeforeAdd'
        }
    },

    onOrderMgmtClick: function(button, e, eOpts) {
        Ext.Ajax.request({
            url : "getOrders",
            method : "GET",
            async : false,
            callback : function(options,success,response){
                if (Ext.isEmpty(response.responseText)) {
                    Ext.Msg.alert("Orders",
                                  "Error in retrieving orders");
                } else {
                    var orderStore = Ext.getStore('OrdersStore');
                    var jsonResponse = Ext.JSON.decode(response.responseText);
                    orderStore.loadData(jsonResponse);
                }
            }
        });
        Ext.getCmp('orderMgmtGrid').getView().refresh();
    },

    onOrderMgmtGridSelect: function(model, selected, eOpts) {
        var selected;
        this.selected = selected;

        Ext.getCmp('orderMgmtId').setValue(selected[0].data.orderId);
        Ext.getCmp('orderMgmtUserId').setValue(selected[0].data.userId);
        Ext.getCmp('orderMgmtTotal').setValue(selected[0].data.orderTotal);
        var date1 = selected[0].data.orderDate;
        var date2 = new Date(date1.substr(0,4)+'-'+date1.substr(4,2)+'-'+date1.substr(6,2));
        Ext.getCmp('orderMgmtDate').setValue(date2);

    },

    onOrderMgmtSearchChange: function(field, newValue, oldValue, eOpts) {
        var orderId, orderStore;
                orderId = Ext.getCmp('orderMgmtSearch').getValue();
                orderStore = Ext.getStore('OrdersStore');

                if(Ext.isEmpty(orderId)){
                    orderStore.clearFilter();
                } else{
                    orderStore.filter('orderId',orderId);
                }
    },

    onOrderMgmtResetClick: function(button, e, eOpts) {
        Ext.getCmp('orderMgmtId').setValue('');
        Ext.getCmp('orderMgmtUserId').setValue('');
        Ext.getCmp('orderMgmtTotal').setValue('');
        Ext.getCmp('orderMgmtDate').setValue('');
        Ext.getCmp('orderMgmtSearch').setValue('');
    },

    onOrderMgmtDeleteClick: function(button, e, eOpts) {
        var orderId, store;
        orderId = Ext.getCmp('orderMgmtGrid').getSelectionModel().selected.items[0].data.orderId;
        store = Ext.getStore('OrdersStore');

        Ext.each(store.data.items, function(record){
            if(orderId == record.data.orderId){
                Ext.Msg.alert('Success', 'Record successfully deleted!');
                Ext.getCmp('orderMgmtId').setValue('');
                Ext.getCmp('orderMgmtUserId').setValue('');
                Ext.getCmp('orderMgmtTotal').setValue('');
                Ext.getCmp('orderMgmtDate').setValue('');
                Ext.Ajax.request({
                    url : "deleteOrderById",
                    method : "POST",
                    async : false,
                    params : {
                        orderId: orderId
                    },
                    callback : function(options,success,response){
                        if (Ext.isEmpty(response.responseText)) {
                            Ext.Msg.alert("Orders",
                                          "Error in deleting orders");
                        } else {
                            Ext.Msg.alert("Orders","Order Deleted!");
                            Ext.Ajax.request({
                                url : "getOrders",
                                method : "GET",
                                async : false,
                                callback : function(options,success,response){
                                    if (Ext.isEmpty(response.responseText)) {
                                        Ext.Msg.alert("Orders",
                                                      "Error in retrieving orders");
                                    } else {
                                        var orderStore = Ext.getStore('OrdersStore');
                                        var jsonResponse = Ext.JSON.decode(response.responseText);
                                        orderStore.loadData(jsonResponse);
                                    }
                                }
                            });
                            Ext.getCmp('orderMgmtGrid').getView().refresh();
                        }
                    }
                });
                Ext.getCmp('orderMgmtGrid').getView().refresh();
            }
        });
    },

    onOrderMgmtCreateClick: function(button, e, eOpts) {
        var userId,orderTotal,orderDate,orderDate2,orderStore;
        userId = Ext.getCmp('orderMgmtUserId').getValue();
        orderTotal = Ext.getCmp('orderMgmtTotal').getValue();
        orderDate = Ext.getCmp('orderMgmtDate').getValue();
        orderStore = Ext.getStore('OrdersStore');
        orderDate2 = Ext.Date.format(orderDate,'Ymdhis');

        if(userId !== ""){
        var orderObj = {
            orderId : 0,
            userId : userId,
            orderTotal : orderTotal,
            orderDate : orderDate2 + '.000'
        };
        Ext.Ajax.request({
            url : "createOrder",
            method : "POST",
            async : false,
            params : {
                order : Ext.encode(orderObj)
            },
            jsonData: Ext.util.JSON.encode(orderObj),
            callback : function(options,success,response){
                if (Ext.isEmpty(response.responseText)) {
                    Ext.Msg.alert("Orders","Error in retrieving orders");
                } else {
                    Ext.Msg.alert("Orders","Order Created!");
                    Ext.Ajax.request({
                        url : "getOrders",
                        method : "GET",
                        async : false,
                        callback : function(options,success,response){
                            if (Ext.isEmpty(response.responseText)) {
                                Ext.Msg.alert("Orders","Error in retrieving orders");
                            } else {
                                var orderStore1 = Ext.getStore('OrdersStore');
                                var jsonResponse = Ext.JSON.decode(response.responseText);
                                orderStore1.loadData(jsonResponse);
                            }
                        }
                    });
                    Ext.getCmp('orderMgmtGrid').getView().refresh();
                    Ext.getCmp('orderMgmtId').setValue('');
                    Ext.getCmp('orderMgmtUserId').setValue('');
                    Ext.getCmp('orderMgmtTotal').setValue('');
                    Ext.getCmp('orderMgmtDate').setValue('');
                }
            }
        });
        } else{
            Ext.Msg.alert("Orders","USERID must have a value");
        }

    },

    onOrderMgmtUpdateClick: function(button, e, eOpts) {
        var orderId,userId,orderTotal,orderDate,orderDate2,orderStore;
        orderId = Ext.getCmp('orderMgmtGrid').getSelectionModel().selected.items[0].data.orderId;
        userId = Ext.getCmp('orderMgmtUserId').getValue();
        orderTotal = Ext.getCmp('orderMgmtTotal').getValue();
        orderDate = Ext.getCmp('orderMgmtDate').getValue();
        orderStore = Ext.getStore('OrdersStore');
        orderDate2 = Ext.Date.format(orderDate,'Ymdhis');

        if(userId !== ""){
        Ext.each(orderStore.data.items, function(record){
                   if(orderId == record.data.orderId){
                       var orderObj = {
                           orderId : orderId,
                           userId : userId,
                           orderTotal : orderTotal,
                           orderDate : orderDate2 + '.000'
                       };
                       Ext.Ajax.request({
                            url : "updateOrder",
                            method : "POST",
                            async : false,
                            params : {
                                order : Ext.encode(orderObj)
                            },
                           jsonData: Ext.util.JSON.encode(orderObj),
                            callback : function(options,success,response){
                                if (Ext.isEmpty(response.responseText)) {
                                    Ext.Msg.alert("Orders","Error in updating orders");
                                } else {
                                    Ext.Msg.alert("Orders","Order Updated!");
                                    Ext.Ajax.request({
                                        url : "getOrders",
                                        method : "GET",
                                        async : false,
                                        callback : function(options,success,response){
                                            if (Ext.isEmpty(response.responseText)) {
                                                Ext.Msg.alert("Orders","Error in retrieving orders");
                                            } else {
                                                var orderStore1 = Ext.getStore('OrdersStore');
                                                var jsonResponse = Ext.JSON.decode(response.responseText);
                                                orderStore1.loadData(jsonResponse);
                                            }
                                        }
                                    });
                                }
                            }
                       });
                   }
        });
        Ext.getCmp('orderMgmtGrid').getView().refresh();
        } else{
            Ext.Msg.alert("Orders","USERID must have a value");
        }
    },

    onOrderMgmtGridDblClick: function(tableview, record, tr, rowIndex, e, eOpts) {
        var orderId;
        orderId = Ext.getCmp('orderMgmtGrid').getSelectionModel().selected.items[0].data.orderId;

        if(Ext.isEmpty(this.cartProdWindow)){
            this.orderProductWindow = Ext.create('W5D5_Project.view.OrderProductWin');
        }

        Ext.Ajax.request({
            url : "getOrderProductsByOrder",
            method : "GET",
            async : false,
            params :{
                id : orderId
            },
            callback : function(options,success,response){
                if (Ext.isEmpty(response.responseText)) {
                    Ext.Msg.alert("Orders","Error in retrieving orders");
                } else {
                    var orderStore1 = Ext.getStore('OrdersStore');
                    var jsonResponse = Ext.JSON.decode(response.responseText);
                    orderStore1.loadData(jsonResponse);
                }
            }
        });

        Ext.getCmp('orderProdWin').getView().refresh();
    },

    onOrderMgmtField1BeforeAdd: function(me, field) {
        if (!field.allowBlank){
            field.labelSeparator += '<span style="color: rgb(255, 0, 0); padding-left: 2px;">*</span>';
        }
    },

    onOrderMgmtField2BeforeAdd: function(me, field) {
        if (!field.allowBlank){
            field.labelSeparator += '<span style="color: rgb(255, 0, 0); padding-left: 2px;">*</span>';
        }
    }

});
