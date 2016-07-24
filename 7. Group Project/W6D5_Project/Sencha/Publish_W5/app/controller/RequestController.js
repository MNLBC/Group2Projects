/*
 * File: app/controller/RequestController.js
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

Ext.define('W5D5_Project.controller.RequestController', {
    extend: 'Ext.app.Controller',

    id: 'requestController',

    control: {
        "#reqApproveBtn": {
            click: 'onReqApproveBtnClick'
        },
        "#reqRejectBtn": {
            click: 'onReqRejectBtnClick'
        },
        "#requestGrid": {
            selectionchange: 'onRequestGridChange'
        }
    },

    onReqApproveBtnClick: function() {
        var requestId,userEmail,userDate,requestStatus,request;

        requestId = Ext.getCmp('requestGrid').getSelectionModel().selected.items[0].data.requestId;
        userEmail = Ext.getCmp('requestGrid').getSelectionModel().selected.items[0].data.userEmail;
        userDate = Ext.getCmp('requestGrid').getSelectionModel().selected.items[0].data.userDate;

        request = {
            "requestId" : requestId,
            "userEmail" : userEmail,
            "userDate" : userDate,
            "requestStatus" : "APPROVED"
        };

        Ext.Ajax.request({
                            url : "updateRequest",
                            method: 'POST',
                            params : {
                                id : requestId,
                                email: userEmail,
                                date : userDate,
                                status : "APPROVED"
                            },
                            async: false,
                            callback : function(options, success, response){
                                if (Ext.isEmpty(response.responseText)) {
                                     Ext.Msg.alert("Request","Error in approving request");
                                     console.log('Failed ');
                                } else {
                                     console.log('Success! ');
                                     Ext.Msg.alert("Request","Success in approving request");
                                     console.log('Success ');
                                    Ext.Ajax.request({
                                        url : 'updateToPremium',
                                        method : 'POST',
                                        aync : false,
                                        param : {
                                            email : userEmail
                                        },
                                        callback : function(options, success, response){
                                            if(response.responseText===true){
                                                console.log('Success! ');
                                            }else{
                                                console.log('Failed! ');
                                            }
                                        }
                                     });
                                    Ext.Ajax.request({
                                        url : "getAllRequest",
                                        method : "GET",
                                        async : false,
                                        callback : function(options,success,response){
                                            if (Ext.isEmpty(response.responseText)) {
                                                Ext.Msg.alert("Requests", "Error in getting requests");
                                                console.log('Failed ');
                                            } else {
                                                console.log('Success! ');
                                                var reqStore = Ext.getStore('RequestStore');
                                                var jsonResponse = Ext.JSON.decode(response.responseText);
                                                reqStore.loadData(jsonResponse);
                                            }
                                        }
                                    });
                                   Ext.getCmp('requestGrid').getView().refresh();
                                }
                            }
                        });
    },

    onReqRejectBtnClick: function() {
        var requestId,userEmail,userDate,requestStatus,request;

        requestId = Ext.getCmp('requestGrid').getSelectionModel().selected.items[0].data.requestId;
        userEmail = Ext.getCmp('requestGrid').getSelectionModel().selected.items[0].data.userEmail;
        userDate = Ext.getCmp('requestGrid').getSelectionModel().selected.items[0].data.userDate;

        request = {
            "requestId" : requestId,
            "userEmail" : userEmail,
            "userDate" : userDate,
            "requestStatus" : "REJECTED"
        };

        Ext.Ajax.request({
                            url : "updateRequest",
                            method: 'POST',
                            params : {
                                id : requestId,
                                email: userEmail,
                                date : userDate,
                                status : "REJECTED"
                            },
                            async: false,
                            callback : function(options, success, response){
                                if (response.responseText=="false") {
                                     Ext.Msg.alert("Request","Error in rejecting request");
                                     console.log('Failed ');
                                } else {
                                     console.log('Success! ');
                                     Ext.Msg.alert("Request","Success in rejecting request");
                                     console.log('Success ');
                                    Ext.Ajax.request({
                                        url : "getAllRequest",
                                        method : "GET",
                                        async : false,
                                        callback : function(options,success,response){
                                            if (Ext.isEmpty(response.responseText)) {
                                                Ext.Msg.alert("Requests", "Error in getting requests");
                                                console.log('Failed ');
                                            } else {
                                                console.log('Success! ');
                                                var reqStore = Ext.getStore('RequestStore');
                                                var jsonResponse = Ext.JSON.decode(response.responseText);
                                                reqStore.loadData(jsonResponse);
                                            }
                                        }
                                    });
                                    Ext.getCmp('requestGrid').getView().refresh();
                                }
                            }
                        });
    },

    onRequestGridChange: function(model, selected, eOpts) {
        var selected;
                this.selected = selected;
                var gridEmail = selected[0].data.userEmail;
                Ext.Ajax.request({
                    url : "getUserByEmail",
                    method: 'GET',
                    params : {
                        email: gridEmail
                    },
                    async: false,
                    callback : function(options, success, response){
                        if (Ext.isEmpty(response.responseText)) {
                             Ext.Msg.alert("Users","Error in getting Users");
                             console.log('Failed ');
                        } else {
                             console.log('Success! ');
                             var userStore = Ext.getStore('UserStore');
                             var jsonResponse = Ext.JSON.decode(response.responseText);
                             userStore.loadData(jsonResponse);
                        }
                    }
                });
                Ext.getCmp('reqFirstName').setValue(Ext.getStore('UserStore').data.items[0].data.userFname);
                Ext.getCmp('reqLastName').setValue(Ext.getStore('UserStore').data.items[0].data.userLname);
                Ext.getCmp('reqAddress1').setValue(Ext.getStore('UserStore').data.items[0].data.userAddress1);
                Ext.getCmp('reqAddress2').setValue(Ext.getStore('UserStore').data.items[0].data.userAddress2);
                Ext.getCmp('reqCountry').setValue(Ext.getStore('UserStore').data.items[0].data.userCountry);
                Ext.getCmp('reqSp').setValue(Ext.getStore('UserStore').data.items[0].data.userSp);
                Ext.getCmp('reqCity').setValue(Ext.getStore('UserStore').data.items[0].data.userCity);
                Ext.getCmp('reqOccupation').setValue(Ext.getStore('UserStore').data.items[0].data.userOccupation);
                Ext.getCmp('reqEmail').setValue(Ext.getStore('UserStore').data.items[0].data.userEmail);
    }

});
