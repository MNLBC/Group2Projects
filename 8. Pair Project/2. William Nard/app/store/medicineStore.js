/*
 * File: app/store/medicineStore.js
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

Ext.define('MedicineInvoicingSystem.store.medicineStore', {
    extend: 'Ext.data.Store',

    requires: [
        'MedicineInvoicingSystem.model.medicineModel'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            storeId: 'medicineStore',
            model: 'MedicineInvoicingSystem.model.medicineModel',
            data: [
                {
                    id: 1,
                    medicineName: 'Paracetamol',
                    brandName: 'Biogesic',
                    price: 5.00,
                    expiryDate: '10/25/2018',
                    quantity: 153
                },
                {
                    id: 2,
                    medicineName: 'Paracetamol',
                    brandName: 'Generic',
                    price: 2.50,
                    expiryDate: '6/24/2018',
                    quantity: 38
                },
                {
                    id: 3,
                    medicineName: 'Salbutamol',
                    brandName: 'Ventulin',
                    price: 50.00,
                    expiryDate: '1/24/2020',
                    quantity: 409
                },
                {
                    id: 4,
                    medicineName: 'Ibruprofen',
                    brandName: 'Advil',
                    price: 10.00,
                    expiryDate: '9/6/2017',
                    quantity: 357
                },
                {
                    id: 5,
                    medicineName: 'Sample',
                    brandName: 'Generic',
                    price: 488.38,
                    expiryDate: '1/17/2017',
                    quantity: 617
                }
            ]
        }, cfg)]);
    }
});