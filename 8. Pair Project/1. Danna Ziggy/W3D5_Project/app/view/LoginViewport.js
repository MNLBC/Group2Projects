/*
 * File: app/view/LoginViewport.js
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

Ext.define('W3D5_Project.view.LoginViewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Ext.form.Panel',
        'Ext.form.field.Text',
        'Ext.toolbar.Spacer',
        'Ext.button.Button'
    ],

    layout: 'fit',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'container',
                    height: 595,
                    width: 800,
                    layout: {
                        type: 'vbox',
                        align: 'center',
                        pack: 'center'
                    },
                    items: [
                        {
                            xtype: 'form',
                            height: 211,
                            width: 363,
                            bodyPadding: 10,
                            title: 'Log in',
                            layout: {
                                type: 'vbox',
                                align: 'center',
                                pack: 'center'
                            },
                            items: [
                                {
                                    xtype: 'container',
                                    flex: 0,
                                    height: 82,
                                    layout: {
                                        type: 'vbox',
                                        align: 'center',
                                        pack: 'center'
                                    },
                                    items: [
                                        {
                                            xtype: 'textfield',
                                            flex: 0,
                                            id: 'loginusername',
                                            itemId: 'loginusername',
                                            width: 263,
                                            fieldLabel: '',
                                            emptyText: 'Username'
                                        },
                                        {
                                            xtype: 'textfield',
                                            flex: 0,
                                            id: 'loginpassword',
                                            itemId: 'loginpassword',
                                            width: 263,
                                            fieldLabel: '',
                                            inputType: 'password',
                                            emptyText: 'Password'
                                        }
                                    ]
                                },
                                {
                                    xtype: 'container',
                                    flex: 0,
                                    height: 10,
                                    width: 266,
                                    items: [
                                        {
                                            xtype: 'tbspacer'
                                        }
                                    ]
                                },
                                {
                                    xtype: 'container',
                                    flex: 0,
                                    layout: {
                                        type: 'hbox',
                                        align: 'middle',
                                        pack: 'center'
                                    },
                                    items: [
                                        {
                                            xtype: 'container',
                                            flex: 0,
                                            height: 29,
                                            layout: {
                                                type: 'hbox',
                                                align: 'stretch'
                                            },
                                            items: [
                                                {
                                                    xtype: 'button',
                                                    id: 'LoginBtn',
                                                    itemId: 'LoginBtn',
                                                    width: 105,
                                                    text: 'Login'
                                                },
                                                {
                                                    xtype: 'tbspacer',
                                                    flex: 1,
                                                    width: 18
                                                },
                                                {
                                                    xtype: 'button',
                                                    id: 'RegisterBtn',
                                                    itemId: 'RegisterBtn',
                                                    width: 103,
                                                    text: 'Register'
                                                }
                                            ]
                                        }
                                    ]
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