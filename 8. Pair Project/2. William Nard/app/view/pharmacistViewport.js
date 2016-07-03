/*
 * File: app/view/pharmacistViewport.js
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

Ext.define('MedicineInvoicingSystem.view.pharmacistViewport', {
    extend: 'Ext.container.Viewport',
    alias: 'widget.pharmacistviewport',

    requires: [
        'MedicineInvoicingSystem.view.pharmacistViewportViewModel',
        'Ext.button.Button',
        'Ext.grid.Panel',
        'Ext.grid.column.Number',
        'Ext.grid.column.Date',
        'Ext.grid.View',
        'Ext.toolbar.Spacer',
        'Ext.form.Panel',
        'Ext.form.field.Date'
    ],

    viewModel: {
        type: 'pharmacistviewport'
    },
    id: 'pharmacistview1',
    itemId: 'pharmacistview1',

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
                        type: 'hbox',
                        align: 'stretch',
                        pack: 'end'
                    },
                    items: [
                        {
                            xtype: 'textfield',
                            id: 'famacissearch',
                            itemId: 'famacissearch',
                            fieldLabel: '',
                            emptyText: 'Search'
                        }
                    ]
                },
                {
                    xtype: 'container',
                    width: '50%',
                    layout: {
                        type: 'hbox',
                        align: 'middle',
                        pack: 'end'
                    },
                    items: [
                        {
                            xtype: 'button',
                            id: 'pharmacistlogout',
                            itemId: 'pharmacistlogout',
                            text: 'Logout'
                        }
                    ]
                }
            ]
        },
        {
            xtype: 'gridpanel',
            id: 'pharmacistGrid',
            itemId: 'pharmacistGrid',
            title: 'Pharmacist View - Medicine Inventory',
            store: 'medicineStore',
            columns: [
                {
                    xtype: 'numbercolumn',
                    id: 'pharmacistview',
                    itemId: 'pharmacistview',
                    dataIndex: 'id',
                    text: 'ID'
                },
                {
                    xtype: 'gridcolumn',
                    dataIndex: 'medicineName',
                    text: 'Medicine Name'
                },
                {
                    xtype: 'gridcolumn',
                    dataIndex: 'brandName',
                    text: 'Brand Name'
                },
                {
                    xtype: 'numbercolumn',
                    dataIndex: 'price',
                    text: 'Price'
                },
                {
                    xtype: 'numbercolumn',
                    dataIndex: 'quantity',
                    text: 'Quantity'
                },
                {
                    xtype: 'datecolumn',
                    dataIndex: 'expiryDate',
                    text: 'Expiration Date'
                }
            ]
        },
        {
            xtype: 'container',
            layout: {
                type: 'hbox',
                align: 'stretch',
                pack: 'center'
            },
            items: [
                {
                    xtype: 'button',
                    id: 'btncreatemed',
                    itemId: 'btncreatemed',
                    text: 'Create'
                },
                {
                    xtype: 'tbspacer'
                },
                {
                    xtype: 'button',
                    id: 'btnupdatemed',
                    itemId: 'btnupdatemed',
                    text: 'Update'
                },
                {
                    xtype: 'tbspacer',
                    width: ''
                },
                {
                    xtype: 'button',
                    id: 'deletemed',
                    itemId: 'deletemed',
                    text: 'Delete'
                }
            ]
        },
        {
            xtype: 'form',
            height: 216,
            id: 'medform',
            itemId: 'medform',
            bodyPadding: 10,
            title: 'Medicine Details',
            items: [
                {
                    xtype: 'textfield',
                    anchor: '100%',
                    id: 'textmedname',
                    itemId: 'textmedname',
                    fieldLabel: 'Medicine Name'
                },
                {
                    xtype: 'textfield',
                    anchor: '100%',
                    id: 'textbrandname',
                    itemId: 'textbrandname',
                    fieldLabel: 'Brand Name'
                },
                {
                    xtype: 'textfield',
                    anchor: '100%',
                    id: 'textprice',
                    itemId: 'textprice',
                    fieldLabel: 'Price'
                },
                {
                    xtype: 'textfield',
                    anchor: '100%',
                    id: 'textquantity',
                    itemId: 'textquantity',
                    fieldLabel: 'Quantity',
                    inputType: 'number'
                },
                {
                    xtype: 'datefield',
                    anchor: '100%',
                    id: 'textexpdate',
                    itemId: 'textexpdate',
                    fieldLabel: 'Expiry Date'
                }
            ]
        },
        {
            xtype: 'container',
            layout: {
                type: 'hbox',
                align: 'middle',
                pack: 'center'
            },
            items: [
                {
                    xtype: 'button',
                    hidden: true,
                    id: 'savemed',
                    itemId: 'savemed',
                    text: 'Save'
                }
            ]
        }
    ]

});