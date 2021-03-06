/*
 * File: app/controller/UserMainController.js
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

Ext.define('W5D5_Project.controller.UserMainController', {
    extend: 'Ext.app.Controller',

    id: 'userMainController',

    control: {
        "#countryRegCombo": {
            change: 'onCountryRegComboChange'
        },
        "#loginBtn": {
            click: 'onLoginBtnClick'
        },
        "#registerBtn": {
            click: 'onRegisterBtnClick'
        },
        "#contactSendBtn": {
            click: 'onContactSendBtnClick'
        },
        "#loginForgotBtn": {
            click: 'onLoginForgotBtnClick'
        }
    },

    onCountryRegComboChange: function() {
                var state = Ext.getStore('SPStore');
                var country = Ext.getCmp('countryRegCombo').value;
                state.filter('CountryName', country);
    },

    onLoginBtnClick: function() {
        var store = Ext.getStore('UserStore');
        var email = Ext.getCmp('emailLoginField').getValue();
        var password = Ext.getCmp('passLoginField').getValue();
        var main = Ext.getCmp('setPanel');
        //             var admin = Ext.getCmp('userPanel');
        var home1 = Ext.getCmp('headerPanel');
        var home2 = Ext.getCmp('subHeaderPanel');
        var home3 = Ext.getCmp('categoryPanel');
        var admin1 = Ext.getCmp('userMgmtBtn');
        var admin2 = Ext.getCmp('prodMgmtBtn'),
            record = '';
        var isExist = false;

        if(email=='Scott'||email=='John'){
            Ext.Msg.alert("User", "Sorry but you are prohibited to access this site");
            return;
        }
        Ext.Ajax.request({
            url : "getUser",
            method : "GET",
            async: 'false',
            params : {
                email: email,
                password: password
            },
            callback : function(options, success, response){
                if(Ext.isEmpty(response.responseText)){
                    console.log('Failed :(');
                     Ext.Msg.alert("User", "Account does not exist. Login again or register");
                }else{
                    console.log('Success! :)');
                    record = Ext.decode(response.responseText);
                    isExist = true;
                    if (record.userType == 'A') {
                    admin1.show();
                    admin2.show();
                    }
                    store.add(record);
                    Ext.Ajax.request({
            url : "getProducts",
            method: 'POST',
                async: 'false',
            callback : function(options, success, response){
                if(Ext.isEmpty(response.responseText)){
                    console.log('Failed ');
                }else{
                    console.log('Success! ');
                    var prodStore = Ext.getStore('ProductStore');
                    var jsonResponse = Ext.JSON.decode(response.responseText);
                    prodStore.loadData(jsonResponse);
                     var panel = Ext.getCmp('mainTabPanel');
            var tab = Ext.getCmp('digitalPanel');
            var userField = Ext.getCmp('userField');
            var countField = Ext.getCmp('countField'),
                idField = Ext.getCmp('idField'),
                addField = Ext.getCmp('addField');
            panel.setActiveTab(tab);
            var controller = W5D5_Project.app.getController('ShopController');
            controller.clearItems();
            controller.addProductsToPage('digital');
            home1.show();
            home2.show();
            home3.show();
            userField.setValue(record.userFname);
            idField.setValue(record.userId);
            addField.setValue(record.userAddress1 + ', ' + record.userAddress2 + ', ' + record.userCity + ', ' + record.userSp + ', ' + record.userCountry);
            countField.setValue(1);
                }
            }
            });
                }
            }
        });

        // Ext.each(store.data.items, function(x){
        //     if (x.data.userEmail == email && x.data.userPass == password){
        //         isExist = true;
        //         var type = x.data.userType;
        //         if (type == 'A') {
        //             admin1.show();
        //             admin2.show();
        //         }
        //         record = x;
        //     }
        //     else{

        //     }
        // });
    },

    onRegisterBtnClick: function() {
        var fname = Ext.getCmp('fnameRegField').getValue();
        var lname = Ext.getCmp('lnameRegField').getValue();
        var email = Ext.getCmp('emailRegField').getValue();
        var address1 = Ext.getCmp('address1RegField').getValue();
        var address2 = Ext.getCmp('address2RegField').getValue();
        var city = Ext.getCmp('cityRegField').getValue();
        var sp = Ext.getCmp('spRegCombo').getValue();
        var country = Ext.getCmp('countryRegCombo').getValue();
        var pass = Ext.getCmp('passRegField').getValue();

        if(fname=='Scott'||fname=='John'){
            Ext.Msg.alert("User", "Sorry but you are prohibited to access this site");
            return;
        }

        var user = {
            "userId":'',
            "userFname":fname,
            "userLname":lname,
            "userEmail":email,
            "userAddress1":address1,
            "userAddress2":address2,
            "userPass":pass,
            "userCity":city,
            "userSp":sp,
            "userCountry":country,
            "userType":'C'
        };


        Ext.Ajax.request({
            url : "createUser",
            method: 'POST',
            params : {
                user: Ext.encode(user)
            },
            jsonData: Ext.util.JSON.encode(user),
            callback : function(options, success, response){
                if(response.responseText===''){
                    console.log('Failed :(');
                }else{
                    console.log('Success! :)');
                    Ext.MessageBox.show({
                        msg: 'Saving your data, please wait...',
                        progressText: 'Saving...',
                        width:300,
                        wait:true,
                        waitConfig: {interval:200},
                        icon:'ext-mb-download', //custom class in msg-box.html
                        iconHeight: 50,
                        animateTarget: 'register'
                    });

                    setTimeout(function(){
                        Ext.MessageBox.hide();
                        Ext.MessageBox.show({
                            title: 'User Registration',
                            msg: 'User "' + email + '" successfully registered!',
                            buttons: Ext.MessageBox.OK
                        });
                    }, 1000);

                    main.hide();
                    home1.show();
                    home2.show();
                }
            }
        });



    },

    onContactSendBtnClick: function() {
        var fname = Ext.getCmp('contactFnameField').getValue();
        var lname = Ext.getCmp('contactLnameField').getValue();
        var concern = Ext.getCmp('contactConcernCombo').getValue();
        var msg = Ext.getCmp('contactMessageText').getValue();

        //send email
    },

    onLoginForgotBtnClick: function() {
        var contact = Ext.getCmp('contactPanel');
        var home1 = Ext.getCmp('mainController');

        contact.show();
        home1.hide();
    }

});
