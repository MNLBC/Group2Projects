Ext.application({
    requires: ['Ext.container.Viewport' ],
    name : 'School',
    controllers : ['StudentMaster'],

    launch: function () {
        
        Ext.create('Ext.container.Viewport', 
        {
            layout : 'anchor',
            items : [{
                xtype: 'StudentGrid'
            }]
        });
    }
});