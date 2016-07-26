/*
 * File: app/view/MyWindow1.js
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

Ext.define('W5D5_Project.view.MyWindow1', {
    extend: 'Ext.window.Window',
    alias: 'widget.mywindow1',

    requires: [
        'W5D5_Project.view.MyWindow1ViewModel',
        'Ext.toolbar.Spacer',
        'Ext.Img',
        'Ext.form.field.Display',
        'Ext.form.field.TextArea',
        'Ext.grid.Panel',
        'Ext.grid.column.Column',
        'Ext.grid.View',
        'Ext.form.field.ComboBox',
        'Ext.button.Button'
    ],

    viewModel: {
        type: 'mywindow1'
    },
    height: 486,
    width: 839,
    title: 'Product Information',

    layout: {
        type: 'hbox',
        align: 'stretch'
    },
    items: [
        {
            xtype: 'tbspacer',
            flex: 0,
            height: 10,
            width: 28
        },
        {
            xtype: 'container',
            flex: 0,
            width: 318,
            layout: {
                type: 'vbox',
                align: 'center'
            },
            items: [
                {
                    xtype: 'image',
                    height: 200,
                    id: 'prodInfoImg',
                    itemId: 'prodInfoImg',
                    width: 200
                },
                {
                    xtype: 'container',
                    flex: 1,
                    layout: {
                        type: 'vbox',
                        align: 'stretch'
                    },
                    items: [
                        {
                            xtype: 'displayfield',
                            flex: 0,
                            id: 'prodInfoId',
                            itemId: 'prodInfoId',
                            fieldLabel: 'Id',
                            value: 'Display Field'
                        },
                        {
                            xtype: 'displayfield',
                            flex: 0,
                            id: 'prodInfoName',
                            itemId: 'prodInfoName',
                            fieldLabel: 'Name',
                            value: 'Display Field'
                        },
                        {
                            xtype: 'displayfield',
                            flex: 0,
                            id: 'prodInfoCat',
                            itemId: 'prodInfoCat',
                            fieldLabel: 'Category',
                            value: 'Display Field'
                        },
                        {
                            xtype: 'textareafield',
                            flex: 0,
                            id: 'prodInfoDesc',
                            itemId: 'prodInfoDesc',
                            fieldLabel: 'Description',
                            value: 'Display Field',
                            readOnly: true
                        },
                        {
                            xtype: 'displayfield',
                            flex: 0,
                            id: 'prodInfoPrice',
                            itemId: 'prodInfoPrice',
                            fieldLabel: 'Price',
                            value: 'Display Field'
                        }
                    ]
                }
            ]
        },
        {
            xtype: 'tbspacer',
            flex: 0,
            height: 10,
            width: 18
        },
        {
            xtype: 'container',
            flex: 1,
            height: 311,
            width: 369,
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            items: [
                {
                    xtype: 'panel',
                    height: 28,
                    title: '',
                    items: [
                        {
                            xtype: 'displayfield',
                            fieldLabel: '',
                            value: 'User Reviews:'
                        }
                    ]
                },
                {
                    xtype: 'gridpanel',
                    flex: 1,
                    id: 'prodInfoReviewGrid',
                    itemId: 'prodInfoReviewGrid',
                    title: '',
                    columns: [
                        {
                            xtype: 'gridcolumn',
                            align: 'center',
                            dataIndex: 'string',
                            text: 'User'
                        },
                        {
                            xtype: 'gridcolumn',
                            align: 'center',
                            dataIndex: 'number',
                            text: 'Rating'
                        },
                        {
                            xtype: 'gridcolumn',
                            width: 227,
                            align: 'center',
                            dataIndex: 'date',
                            text: 'Review'
                        }
                    ]
                },
                {
                    xtype: 'panel',
                    flex: 0,
                    height: 205,
                    title: '',
                    items: [
                        {
                            xtype: 'displayfield',
                            fieldLabel: '',
                            value: 'Your Review:'
                        },
                        {
                            xtype: 'container',
                            height: 133,
                            items: [
                                {
                                    xtype: 'combobox',
                                    id: 'prodInfoRating',
                                    itemId: 'prodInfoRating',
                                    fieldLabel: 'Rating'
                                },
                                {
                                    xtype: 'textareafield',
                                    height: 82,
                                    id: 'prodInfoReview',
                                    itemId: 'prodInfoReview',
                                    width: 438,
                                    fieldLabel: 'Review'
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            layout: {
                                type: 'hbox',
                                align: 'stretch'
                            },
                            items: [
                                {
                                    xtype: 'tbspacer',
                                    height: 25,
                                    width: 149
                                },
                                {
                                    xtype: 'button',
                                    cls: 'genericBtn',
                                    id: 'prodInfoPostBtn',
                                    itemId: 'prodInfoPostBtn',
                                    text: 'POST'
                                },
                                {
                                    xtype: 'tbspacer',
                                    width: 10
                                },
                                {
                                    xtype: 'button',
                                    cls: 'genericBtn',
                                    id: 'prodInfoUpdateBtn',
                                    itemId: 'prodInfoUpdateBtn',
                                    text: 'UPDATE'
                                },
                                {
                                    xtype: 'tbspacer',
                                    width: 10
                                },
                                {
                                    xtype: 'button',
                                    cls: 'genericBtn',
                                    id: 'prodInfoRemoveBtn',
                                    itemId: 'prodInfoRemoveBtn',
                                    text: 'REMOVE'
                                }
                            ]
                        }
                    ]
                }
            ]
        },
        {
            xtype: 'tbspacer',
            flex: 0,
            height: 10,
            width: 28
        }
    ]

});