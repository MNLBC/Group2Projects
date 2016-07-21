/*
 * File: app/store/CountryStore.js
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

Ext.define('W6D5_Project.store.CountryStore', {
    extend: 'Ext.data.Store',

    requires: [
        'W6D5_Project.model.CountryModel'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            storeId: 'countryStore',
            model: 'W6D5_Project.model.CountryModel',
            data: [
                {
                    CountryName: 'Afghanistan'
                },
                {
                    CountryName: 'Austria'
                },
                {
                    CountryName: 'Belgium'
                },
                {
                    CountryName: 'Cambodia'
                },
                {
                    CountryName: 'China'
                },
                {
                    CountryName: 'Colombia'
                },
                {
                    CountryName: 'Croatia'
                },
                {
                    CountryName: 'France'
                },
                {
                    CountryName: 'Japan'
                },
                {
                    CountryName: 'Macau'
                },
                {
                    CountryName: 'Madagascar'
                },
                {
                    CountryName: 'Malaysia'
                },
                {
                    CountryName: 'Philippines'
                },
                {
                    CountryName: 'Poland'
                },
                {
                    CountryName: 'Portugal'
                },
                {
                    CountryName: 'Singapore'
                },
                {
                    CountryName: 'Sweden'
                },
                {
                    CountryName: 'Taiwan'
                },
                {
                    CountryName: 'Thailand'
                },
                {
                    CountryName: 'USA'
                }
            ]
        }, cfg)]);
    }
});