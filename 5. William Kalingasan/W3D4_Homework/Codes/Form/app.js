Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'School',
    views: ['School.view.StudentMaster'],
    controllers: ['School.controller.StudentMaster'],

    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
            {
                xtype: 'StudentMaster'
            }]
        });
    }
});