/*
 * File: app/view/UserInfoWin.js
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

Ext.define('W5D5_Project.view.UserInfoWin', {
    extend: 'Ext.window.Window',
    alias: 'widget.userinfowin',

    requires: [
        'W5D5_Project.view.UserInfoWinViewModel',
        'Ext.container.Container',
        'Ext.toolbar.Spacer',
        'Ext.Img',
        'Ext.form.field.Display'
    ],

    viewModel: {
        type: 'userinfowin'
    },
    height: 478,
    width: 381,
    title: 'Detailed User Information',
    modal: true,

    layout: {
        type: 'hbox',
        align: 'stretch'
    },
    items: [
        {
            xtype: 'container',
            flex: 1,
            height: 446,
            width: 314,
            layout: {
                type: 'vbox',
                align: 'center'
            },
            items: [
                {
                    xtype: 'tbspacer',
                    flex: 0,
                    height: 16,
                    width: 46
                },
                {
                    xtype: 'image',
                    height: 200,
                    id: 'userInfoImg',
                    itemId: 'userInfoImg',
                    width: 200,
                    src: 'resources/img/customer.png'
                },
                {
                    xtype: 'tbspacer',
                    flex: 0,
                    height: 16,
                    width: 10
                },
                {
                    xtype: 'container',
                    flex: 0,
                    height: 206,
                    width: 286,
                    layout: {
                        type: 'vbox',
                        align: 'stretch'
                    },
                    items: [
                        {
                            xtype: 'displayfield',
                            flex: 0,
                            id: 'userInfoId',
                            itemId: 'userInfoId',
                            fieldLabel: 'Id',
                            value: 'Display Field'
                        },
                        {
                            xtype: 'displayfield',
                            flex: 0,
                            id: 'userInfoFname',
                            itemId: 'userInfoFname',
                            fieldLabel: 'First Name',
                            value: 'Display Field'
                        },
                        {
                            xtype: 'displayfield',
                            flex: 0,
                            id: 'userInfoLname',
                            itemId: 'userInfoLname',
                            fieldLabel: 'Last Name',
                            value: 'Display Field'
                        },
                        {
                            xtype: 'displayfield',
                            flex: 0,
                            id: 'userInfoEmail',
                            itemId: 'userInfoEmail',
                            fieldLabel: 'Email',
                            value: 'Display Field'
                        },
                        {
                            xtype: 'displayfield',
                            flex: 0,
                            id: 'userInfoType',
                            itemId: 'userInfoType',
                            fieldLabel: 'User Type',
                            value: 'Display Field'
                        },
                        {
                            xtype: 'displayfield',
                            flex: 0,
                            id: 'userInfoLevel',
                            itemId: 'userInfoLevel',
                            fieldLabel: 'User Level',
                            value: 'Display Field'
                        }
                    ]
                },
                {
                    xtype: 'tbspacer',
                    flex: 1
                }
            ]
        }
    ]

});