/*
 * File: app/view/OrderProductWin.js
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

Ext.define('W5D5_Project.view.OrderProductWin', {
    extend: 'Ext.window.Window',
    alias: 'widget.orderproductwin',

    requires: [
        'W5D5_Project.view.OrderProductWinViewModel',
        'Ext.grid.Panel',
        'Ext.grid.column.Column',
        'Ext.grid.View'
    ],

    viewModel: {
        type: 'orderproductwin'
    },
    height: 322,
    width: 408,
    layout: 'fit',
    title: 'Order Products',
    modal: true,

    items: [
        {
            xtype: 'gridpanel',
            id: 'orderProdWin',
            itemId: 'orderProdWin',
            title: '',
            store: 'OrderProductStore',
            columns: [
                {
                    xtype: 'gridcolumn',
                    width: 124,
                    align: 'center',
                    dataIndex: 'orderId',
                    text: 'Order Id'
                },
                {
                    xtype: 'gridcolumn',
                    width: 126,
                    align: 'center',
                    dataIndex: 'prodId',
                    text: 'Product Id'
                },
                {
                    xtype: 'gridcolumn',
                    width: 135,
                    align: 'center',
                    dataIndex: 'orderProdQty',
                    text: 'Quantity'
                }
            ]
        }
    ]

});