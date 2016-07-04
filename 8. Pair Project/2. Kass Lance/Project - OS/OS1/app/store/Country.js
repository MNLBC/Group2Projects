/*
 * File: app/store/Country.js
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

Ext.define('MyApp.store.Country', {
    extend: 'Ext.data.Store',

    requires: [
        'MyApp.model.Country'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            model: 'MyApp.model.Country',
            storeId: 'Country',
            data: [
                {
                    CountryName: 'Philippines'
                },
                {
                    CountryName: 'China'
                },
                {
                    CountryName: 'USA'
                },
                {
                    CountryName: 'Thailand'
                },
                {
                    CountryName: 'Japan'
                }
            ]
        }, cfg)]);
    }
});