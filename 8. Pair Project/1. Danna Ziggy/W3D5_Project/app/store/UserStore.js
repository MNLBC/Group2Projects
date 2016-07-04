/*
 * File: app/store/UserStore.js
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

Ext.define('W3D5_Project.store.UserStore', {
    extend: 'Ext.data.Store',

    requires: [
        'W3D5_Project.model.UserModel'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            model: 'W3D5_Project.model.UserModel',
            storeId: 'UserStore',
            data: [
                {
                    fname: 'autem',
                    lname: 'rerum',
                    email: 'aroberts@thoughtworks.net',
                    username: 'admin',
                    password: 'admin',
                    address: '2 Monument Trail',
                    id: 193
                }
            ]
        }, cfg)]);
    }
});