/*
 * File: app/view/customerViewport.js
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

Ext.define('MedicineInvoicingSystem.view.customerViewport', {
    extend: 'Ext.container.Viewport',
    alias: 'widget.customerviewport',

    requires: [
        'MedicineInvoicingSystem.view.customerViewportViewModel',
        'Ext.form.field.Text',
        'Ext.grid.Panel',
        'Ext.grid.column.Number',
        'Ext.grid.column.Date',
        'Ext.grid.View',
        'Ext.selection.RowModel',
        'Ext.toolbar.Spacer',
        'Ext.button.Button',
        'Ext.form.Label'
    ],

    viewModel: {
        type: 'customerviewport'
    },

    layout: {
        type: 'vbox',
        align: 'stretch',
        pack: 'center'
    },
    items: [
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
                    xtype: 'textfield',
                    flex: 0,
                    emptyText: 'Search',
                    bind: {
                        width: '50%'
                    }
                }
            ]
        },
        {
            xtype: 'container',
            flex: 0,
            height: 203,
            layout: {
                type: 'hbox',
                align: 'stretch',
                pack: 'end'
            },
            items: [
                {
                    xtype: 'container',
                    flex: 1,
                    layout: {
                        type: 'vbox',
                        align: 'stretch'
                    },
                    items: [
                        {
                            xtype: 'gridpanel',
                            flex: 1,
                            height: 225,
                            id: 'GridPanel',
                            itemId: 'GridPanel',
                            collapsible: false,
                            title: 'Cutomer View - Medicine Inventory',
                            allowDeselect: true,
                            store: 'medicineStore',
                            columns: [
                                {
                                    xtype: 'gridcolumn',
                                    width: '40%',
                                    dataIndex: 'medicineName',
                                    text: 'Medicine Name'
                                },
                                {
                                    xtype: 'gridcolumn',
                                    width: '30%',
                                    dataIndex: 'brandName',
                                    text: 'Brand Name'
                                },
                                {
                                    xtype: 'numbercolumn',
                                    width: '15%',
                                    dataIndex: 'price',
                                    text: 'Price'
                                },
                                {
                                    xtype: 'datecolumn',
                                    width: '15%',
                                    dataIndex: 'expiryDate',
                                    text: 'Expiry Date'
                                }
                            ],
                            selModel: {
                                selType: 'rowmodel',
                                allowDeselect: true,
                                mode: 'SINGLE'
                            }
                        },
                        {
                            xtype: 'container',
                            flex: 0,
                            width: 560,
                            layout: {
                                type: 'hbox',
                                align: 'middle',
                                pack: 'end'
                            },
                            items: [
                                {
                                    xtype: 'tbspacer',
                                    flex: 0,
                                    width: 10
                                },
                                {
                                    xtype: 'textfield',
                                    id: 'txtboxQuantity',
                                    itemId: 'txtboxQuantity',
                                    fieldLabel: 'Quantity',
                                    inputType: 'number'
                                },
                                {
                                    xtype: 'button',
                                    id: 'btnAddToCart',
                                    itemId: 'btnAddToCart',
                                    text: 'Add To Cart'
                                }
                            ]
                        }
                    ]
                },
                {
                    xtype: 'gridpanel',
                    flex: 1,
                    animCollapse: true,
                    collapseDirection: 'right',
                    collapseFirst: false,
                    collapsed: false,
                    collapsible: false,
                    title: 'Order Summary',
                    columns: [
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'string',
                            text: 'Medicine'
                        },
                        {
                            xtype: 'numbercolumn',
                            dataIndex: 'number',
                            text: 'Price'
                        },
                        {
                            xtype: 'numbercolumn',
                            text: 'Quantity'
                        },
                        {
                            xtype: 'numbercolumn',
                            text: 'Subtotal'
                        }
                    ]
                }
            ]
        },
        {
            xtype: 'panel',
            flex: 1,
            height: 573,
            title: 'Receipt/Invoice',
            items: [
                {
                    xtype: 'container',
                    layout: {
                        type: 'hbox',
                        align: 'stretch'
                    },
                    items: [
                        {
                            xtype: 'container',
                            width: '50%',
                            layout: {
                                type: 'vbox',
                                align: 'stretch'
                            },
                            items: [
                                {
                                    xtype: 'label',
                                    height: 16,
                                    width: 53,
                                    text: 'Something Something Pharmacy'
                                },
                                {
                                    xtype: 'label',
                                    flex: 1,
                                    id: 'labelDateTime',
                                    itemId: 'labelDateTime',
                                    text: 'Date Time'
                                },
                                {
                                    xtype: 'label',
                                    text: 'Invoice Summary:'
                                },
                                {
                                    xtype: 'container',
                                    flex: 1,
                                    items: [
                                        {
                                            xtype: 'label',
                                            id: 'labelInvoice',
                                            itemId: 'labelInvoice',
                                            text: 'Invoice will be here'
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            width: '50%',
                            items: [
                                {
                                    xtype: 'label',
                                    id: 'labelTotal',
                                    itemId: 'labelTotal',
                                    text: 'Total :'
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    ]

});