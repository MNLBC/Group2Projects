/*
 * File: app/store/UserTypeStore.js
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

Ext.define('W5D5_Project.store.UserTypeStore', {
    extend: 'Ext.data.Store',

    requires: [
        'W5D5_Project.model.UserTypeModel'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            storeId: 'userTypeStore',
            model: 'W5D5_Project.model.UserTypeModel',
            data: [
                {
                    Name: 'Customer',
                    Type: 'C'
                },
                {
                    Name: 'Blacklist',
                    Type: 'B'
                },
                {
                    Name: 'Admin',
                    Type: 'A'
                }
            ]
        }, cfg)]);
    }
});