/*
 * File: app/view/MainView.js
 *
 * This file was generated by Sencha Architect version 3.0.4.
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

Ext.define('MyApp.view.MainView', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Ext.toolbar.Spacer',
        'Ext.button.Button',
        'Ext.form.Panel',
        'Ext.form.field.Date',
        'Ext.form.field.ComboBox',
        'Ext.Img'
    ],

    itemId: 'mainView',
    layout: 'border',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    region: 'north',
                    height: 71,
                    itemId: 'headerPanel',
                    header: false,
                    title: 'Header',
                    layout: {
                        type: 'hbox',
                        align: 'middle',
                        pack: 'center'
                    },
                    items: [
                        {
                            xtype: 'container',
                            height: 26,
                            id: 'containerHeader',
                            width: 397,
                            layout: {
                                type: 'hbox',
                                align: 'middle',
                                pack: 'end'
                            },
                            items: [
                                {
                                    xtype: 'textfield',
                                    flex: 1,
                                    id: 'searchBar',
                                    width: 155,
                                    fieldLabel: 'Search'
                                },
                                {
                                    xtype: 'tbspacer',
                                    flex: 1,
                                    maxWidth: 5,
                                    minWidth: 5,
                                    width: 5
                                },
                                {
                                    xtype: 'button',
                                    flex: 1,
                                    id: 'btnSearch',
                                    maxWidth: 110,
                                    minWidth: 110,
                                    width: 110,
                                    text: 'Search Product'
                                }
                            ]
                        }
                    ]
                },
                {
                    xtype: 'panel',
                    region: 'west',
                    split: true,
                    itemId: 'menuPanel',
                    width: 250,
                    layout: 'accordion',
                    collapseDirection: 'left',
                    header: false,
                    title: 'Menu',
                    items: [
                        {
                            xtype: 'panel',
                            id: 'panelWelcome',
                            title: 'Welcome'
                        },
                        {
                            xtype: 'panel',
                            id: 'panelLogin',
                            title: 'Login',
                            items: [
                                {
                                    xtype: 'form',
                                    height: 200,
                                    id: 'formLogin',
                                    bodyPadding: 10,
                                    header: false,
                                    title: 'My Form',
                                    trackResetOnLoad: true,
                                    items: [
                                        {
                                            xtype: 'tbspacer',
                                            height: 35,
                                            id: 'spacerLogin1',
                                            maxHeight: 35,
                                            maxWidth: 220,
                                            minHeight: 35,
                                            minWidth: 220,
                                            width: 220
                                        },
                                        {
                                            xtype: 'textfield',
                                            anchor: '100%',
                                            id: 'loginEmail',
                                            fieldLabel: 'Email',
                                            inputType: 'email'
                                        },
                                        {
                                            xtype: 'textfield',
                                            anchor: '100%',
                                            id: 'loginPassword',
                                            fieldLabel: 'Password',
                                            inputType: 'password',
                                            minLength: 8
                                        },
                                        {
                                            xtype: 'tbspacer',
                                            height: 25,
                                            id: 'spaceLogin2',
                                            maxHeight: 25,
                                            maxWidth: 220,
                                            minHeight: 25,
                                            minWidth: 220,
                                            width: 220
                                        },
                                        {
                                            xtype: 'container',
                                            id: 'containerBtn',
                                            layout: {
                                                type: 'hbox',
                                                align: 'middle',
                                                pack: 'end'
                                            },
                                            items: [
                                                {
                                                    xtype: 'button',
                                                    formBind: true,
                                                    id: 'btnLogin',
                                                    text: 'Login'
                                                }
                                            ]
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            xtype: 'panel',
                            id: 'panelSignup',
                            title: 'Signup',
                            items: [
                                {
                                    xtype: 'form',
                                    height: 279,
                                    id: 'formSignup',
                                    bodyPadding: 10,
                                    header: false,
                                    title: 'My Form',
                                    trackResetOnLoad: true,
                                    items: [
                                        {
                                            xtype: 'textfield',
                                            anchor: '100%',
                                            id: 'signupFname',
                                            fieldLabel: 'First Name'
                                        },
                                        {
                                            xtype: 'textfield',
                                            anchor: '100%',
                                            id: 'signupLname',
                                            fieldLabel: 'Last Name'
                                        },
                                        {
                                            xtype: 'datefield',
                                            id: 'signupBdate',
                                            width: 221,
                                            fieldLabel: 'Birthdate'
                                        },
                                        {
                                            xtype: 'textfield',
                                            anchor: '100%',
                                            id: 'signupEmail',
                                            fieldLabel: 'Email',
                                            inputType: 'email'
                                        },
                                        {
                                            xtype: 'textfield',
                                            anchor: '100%',
                                            id: 'signupPassword',
                                            fieldLabel: 'Password',
                                            inputType: 'password',
                                            minLength: 8
                                        },
                                        {
                                            xtype: 'textfield',
                                            anchor: '100%',
                                            id: 'signupAddress',
                                            fieldLabel: 'Address'
                                        },
                                        {
                                            xtype: 'textfield',
                                            anchor: '100%',
                                            id: 'signupCity',
                                            fieldLabel: 'City'
                                        },
                                        {
                                            xtype: 'combobox',
                                            anchor: '100%',
                                            id: 'signupCountry',
                                            fieldLabel: 'Country'
                                        },
                                        {
                                            xtype: 'container',
                                            id: 'containerBtn1',
                                            layout: {
                                                type: 'hbox',
                                                align: 'middle',
                                                pack: 'end'
                                            },
                                            items: [
                                                {
                                                    xtype: 'button',
                                                    id: 'btnSignup',
                                                    text: 'Signup'
                                                }
                                            ]
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    xtype: 'panel',
                    flex: 1,
                    region: 'center',
                    itemId: 'contentPanel',
                    layout: 'fit',
                    title: 'Content',
                    items: [
                        {
                            xtype: 'container',
                            layout: 'hbox',
                            items: [
                                {
                                    xtype: 'image',
                                    flex: 3,
                                    height: 98,
                                    width: 498,
                                    src: 'resources/images/image4.png'
                                }
                            ]
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});