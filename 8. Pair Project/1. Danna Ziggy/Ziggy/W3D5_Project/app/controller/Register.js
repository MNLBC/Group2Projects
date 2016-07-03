/*
 * File: app/controller/Register.js
 *
 * This file was generated by Sencha Architect version 3.1.0.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 4.2.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 4.2.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('W3D5_Project.controller.Register', {
    extend: 'Ext.app.Controller',

    id: 'register',

    onRegButtonClick: function() {
        Ext.MessageBox.show({
            title: 'Please wait',
            msg: 'Register new account',
            progressText: 'Creating your new account',
            width:300,
            progress:true,
            closable:false,
            animateTarget: 'regbtn'
        });

        // this hideous block creates the bogus progress
        var f = function(v){
            return function(){
                if(v == 12){
                    Ext.MessageBox.hide();
                    Ext.Msg.show({
                        title:'Status',
                        msg: 'You have registered successfully.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.Msg.Info,
                        fn: function(btn){
                            if (btn === 'ok') {

                                //ADD TO STORE

                                var fname = Ext.getCmp('regfname').getValue();
                                var lname = Ext.getCmp('reglname').getValue();
                                var address = Ext.getCmp('regaddress').getValue();
                                var email = Ext.getCmp('regemail').getValue();
                                var username=Ext.getCmp('regusername').getValue();
                                var password = Ext.getCmp('regpassword').getValue();

                                var Object =  { "regfname": "fname",
                                               "reglname": "lname",
                                               "regemail": "address",
                                               "regusername": "email",
                                               "regpassword": "username",
                                               "regaddress": "password"

                                              };


                                var store = Ext.StoreManager.get('RegStore');
                                store.add(Object);



                                if(Ext.isEmpty(this.gridWin)){
                                    this.gridWin = Ext.create('W3D5_Project.view.LoginViewPort', {});
                                }
                                this.gridWin.show();
                                this.gridWin.unmask();
                            }
                        }
                    });
                }else{
                    var i = v/11;
                    Ext.MessageBox.updateProgress(i, Math.round(100*i)+'% completed');
                }
            };
        };
        for(var i = 1; i < 13; i++){
            setTimeout(f(i), i*500);
        }

    },

    init: function(application) {
        this.control({
            "#regbtn": {
                click: this.onRegButtonClick
            }
        });
    }

});
