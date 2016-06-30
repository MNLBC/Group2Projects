Ext.onReady(function() {
   var depV = Ext.create('Ext.Viewport', {
      title: 'Number 3',
      layout: 'fit',
      items: [{
         flex: 1,
         items: [{
            xtype: 'button',
            text: 'Add Table',
            handler: function(btn) {
               Ext.getCmp('cntr').add({
                  xtype: 'grid',
                  title: 'Dynamic Table',
                  columns: [
                     { text: 'Name', dataIndex: 'name' },
                     { text: 'Email', dataIndex: 'email', flex: 1 },
                     { text: 'Phone', dataIndex: 'phone' }
                  ],
                  height: 200,
                  width: 400
               })
            }
         },
         {
            xtype: 'container',
            id: 'cntr',
            flex: 3
         }]
      }]
  }).show();
});