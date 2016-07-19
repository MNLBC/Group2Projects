/*
 * File: app/model/ProductModel.js
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

Ext.define('W5D5_Project.model.ProductModel', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.field.Integer',
        'Ext.data.field.String',
        'Ext.data.field.Number'
    ],

    fields: [
        {
            type: 'int',
            name: 'prodId'
        },
        {
            type: 'string',
            name: 'prodName'
        },
        {
            type: 'string',
            name: 'prodCat'
        },
        {
            type: 'string',
            name: 'prodDesc'
        },
        {
            type: 'float',
            name: 'prodPrice'
        },
        {
            type: 'float',
            name: 'prodSale'
        },
        {
            type: 'int',
            name: 'prodStock'
        },
        {
            type: 'string',
            name: 'prodImg'
        }
    ]
});