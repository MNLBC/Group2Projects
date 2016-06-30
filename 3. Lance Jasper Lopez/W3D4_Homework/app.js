Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'School',
    views: ['School.view.StudentMaster', 'School.view.StudentGrid2', 'School.view.MenuView'],
    controllers: ['StudentMaster', 'StudentMaster2', 'MenuController'],

    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'vbox',
            items: [
            {
                xtype: 'MenuView'
            },
            {
            	xtype:'StudentMaster',
            
            },
            {
            	xtype:'StudentGrid2',
            	
            },
            ]
        });
    }
});