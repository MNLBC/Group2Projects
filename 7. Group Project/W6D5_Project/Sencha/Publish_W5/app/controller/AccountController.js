/*
 * File: app/controller/AccountController.js
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

Ext.define('W5D5_Project.controller.AccountController', {
    extend: 'Ext.app.Controller',

    id: 'accController',

    control: {
        "#accUpdateBtn": {
            click: 'onAccUpdateBtnClick'
        },
        "#accPremBtn": {
            click: 'onAccPremBtnClick'
        },
        "#accCheckStatus": {
            click: 'onAccCheckStatusClick'
        },
        "#accCountry": {
            change: 'onAccCountryChange'
        }
    },

    onAccUpdateBtnClick: function() {
        var id = Ext.getCmp('idField').getValue();
        var fname = Ext.getCmp('accFirstName').getValue();
        var lname = Ext.getCmp('accLastName').getValue();
        var email = Ext.getCmp('accEmail').getValue();
        var address1 = Ext.getCmp('accAddress1').getValue();
        var address2 = Ext.getCmp('accAddress2').getValue();
        var city = Ext.getCmp('accCity').getValue();
        var sp = Ext.getCmp('accSp').getValue();
        var country = Ext.getCmp('accCountry').getValue();
        var pass = Ext.getCmp('accPassword').getValue();
        var occupation = Ext.getCmp('accOccupation').getValue(),
            userLevel = Ext.getCmp('accUserLevel').getValue(),
            accountType = Ext.getCmp('accAccountType').getValue();
            field = Ext.getCmp('accForm');
        var user;
        if(field.isValid()){
            user = {
                        "userId":id,
                        "userFname":fname,
                        "userLname":lname,
                        "userEmail":email,
                        "userPass":pass,
                        "userOccupation":occupation,
                        "userAddress1":address1,
                        "userAddress2":address2,
                        "userCity":city,
                        "userSp":sp,
                        "userCountry":country,
                        "userType":accountType,
                        "userLevel":userLevel
                    };
        Ext.Ajax.request({
            url : "updateUser",
            method: 'POST',
            params : {
                user: Ext.encode(user)
            },
            async: false,
            jsonData: Ext.util.JSON.encode(user),
            callback : function(options, success, response){
                if(response.responseText===''){
                    Ext.Msg.alert("Update User", "Error encountered in updating user.");
                }else {
                    Ext.Msg.alert("Update User", "User information successfully updated.");
                    Ext.getCmp('userField').setValue(user.userFname);
                    Ext.getCmp('idField').setValue(user.userId);
                    if(Ext.isEmpty(user.userAddress2)){
                        Ext.getCmp('addField').setValue(user.userAddress1 + ', ' + user.userCity + ', ' + user.userSp + ', ' + user.userCountry);
                    }else{
                        Ext.getCmp('addField').setValue(user.userAddress1 + ', ' + user.userAddress2 + ', ' + user.userCity + ', ' + user.userSp + ', ' + user.userCountry);
                    }
                    Ext.getCmp('emailField').setValue(user.userEmail);
                    Ext.getCmp('levelField').setValue(user.userType);
                }
            }
        });
        }else{
          Ext.Msg.alert("Update User", "Validation error. Please check the field values.");
        }

    },

    onAccPremBtnClick: function() {
        Ext.Ajax.request({
            url : "sendAdminMessage",
            async : false,
            params : {
                username: Ext.getCmp('accEmail').getValue(),
                message: 'Request for Premium Account'
            },
            callback : function(options,success,response){
                if(response.responseText == 1){
                    Ext.Msg.alert("Request", "You have requested for an account upgrade. Please wait for admin approval");
                } else {
                    Ext.Msg.alert("Request", "Error in sending request");
                }
            }
        });
    },

    onAccCheckStatusClick: function() {
        Ext.Ajax.request({
            url : "getRequestByUserEmail",
            method : "GET",
            async : false,
            params : {
                email : Ext.getCmp('emailField').getValue()
            },
            callback : function(options,success,response){
                request = Ext.decode(response.responseText);
                if(Ext.isEmpty(request.requestStatus)){
                    Ext.Msg.alert("Premium Account Request", "You have no pending requests");
                }else{
                    Ext.Msg.alert("Premium Account Request", "Request status is: " + request.requestStatus);
                }
            }
        });

    },

    onAccCountryChange: function() {
        var state = Ext.getStore('SPStore');
                var country = Ext.getCmp('accCountry').getValue();
                state.filter('CountryName', country);
    },

    setFieldValues: function(record) {
        Ext.getCmp('accFirstName').setValue(record.userFname);
        Ext.getCmp('accLastName').setValue(record.userLname);
        Ext.getCmp('accAddress1').setValue(record.userAddress1);
        Ext.getCmp('accAddress2').setValue(record.userAddress2);
        Ext.getCmp('accCountry').setValue(record.userCountry);
        Ext.getCmp('accSp').setValue(record.userSp);
        Ext.getCmp('accCity').setValue(record.userCity);
        Ext.getCmp('accOccupation').setValue(record.userOccupation);
        Ext.getCmp('accEmail').setValue(record.userEmail);
        Ext.getCmp('accPassword').setValue(record.userPass);
        if(record.userLevel=='1'){
            Ext.getCmp('accUserLevel').setValue("Normal");
        }else{
            Ext.getCmp('accUserLevel').setValue("Premium");
        }
        Ext.getCmp('accAccountType').setValue(record.userType);
    }

});
