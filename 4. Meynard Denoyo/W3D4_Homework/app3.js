Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'Company',
    views: ['Company.view.MainPage'],
    controllers: ['MainPage'],

    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
            {
                xtype: 'MainPage'
            }]
        });
    }
});