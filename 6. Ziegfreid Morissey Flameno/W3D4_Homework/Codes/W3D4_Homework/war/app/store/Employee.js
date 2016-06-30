/**
 * Ziggy
 */

Ext.define('Company.store.Employee',
{
    extend: 'Ext.data.Store',
    model: 'Company.model.Employee',
    autoLoad: true,
    autoSync: true,
    storeId: 'Employee'
});