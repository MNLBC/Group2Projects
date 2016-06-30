/**
 * Ziggy
 */
Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'Company',
    views:['Company.view.EmployeeGrid'],
    controllers : ['EmployeeMaster'],
    
    launch : function(){
        Ext.create('Ext.container.Viewport', 
        {
            layout : 'anchor',
            items : [{
                xtype: 'EmployeeGrid'
            }]
        });
    }
});