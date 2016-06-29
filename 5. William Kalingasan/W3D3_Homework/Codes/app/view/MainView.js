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

Ext.define('SampleExtJS.view.MainView', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Ext.panel.Panel',
        'Ext.form.Label',
        'Ext.form.field.Text',
        'Ext.button.Button'
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
                    height: 100,
                    itemId: 'headerPanel',
                    title: 'Week 03',
                    layout: {
                        type: 'vbox',
                        align: 'center'
                    },
                    items: [
                        {
                            xtype: 'label',
                            text: 'Day 3 Homework'
                        }
                    ]
                },
                {
                    xtype: 'panel',
                    flex: 0,
                    region: 'center',
                    itemId: 'contentPanel',
                    bodyPadding: 10,
                    title: 'Content',
                    layout: {
                        type: 'vbox',
                        align: 'center'
                    },
                    items: [
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Name:'
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Email:'
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Address:'
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Mobile Number:'
                        },
                        {
                            xtype: 'button',
                            text: 'SUBMIT'
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});