/*
 * File: app/store/OrderStore.js
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

Ext.define('W3D5_Project.store.OrderStore', {
    extend: 'Ext.data.Store',

    requires: [
        'W3D5_Project.model.OrderModel'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            model: 'W3D5_Project.model.OrderModel',
            storeId: 'OrderStore',
            data: [
                {
                    id: 117,
                    userid: 'saepe',
                    username: 'jjenkins',
                    bookid: 'officiis',
                    booktitle: 'adipisci',
                    bookprice: 'harum',
                    bookquantity: 707,
                    booktotal: 'rerum',
                    remarks: 'laboriosam',
                    date: 'quia'
                },
                {
                    id: 257,
                    userid: 'suscipit',
                    username: 'asullivan',
                    bookid: 'dicta',
                    booktitle: 'necessitatibus',
                    bookprice: 'autem',
                    bookquantity: 672,
                    booktotal: 'animi',
                    remarks: 'occaecati',
                    date: 'et'
                },
                {
                    id: 965,
                    userid: 'doloribus',
                    username: 'gdaniels',
                    bookid: 'fugit',
                    booktitle: 'architecto',
                    bookprice: 'qui',
                    bookquantity: 791,
                    booktotal: 'repudiandae',
                    remarks: 'sint',
                    date: 'non'
                }
            ]
        }, cfg)]);
    }
});