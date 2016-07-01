

Ext.define('School.view.TableView', {
    extend: 'Ext.container.Container',
    alias : 'widget.TableView',
    layout: {type:'vbox'},


    initComponent: function() {
        var me = this;

        Ext.apply(me, {
            items: [
                {
                    xtype: 'form',
                    id:'tableForm',
                    hidden:true,
                    height: 900,
                    width: 1920,
                    bodyPadding: 10,
                    title: 'Create dynamic table',
                    items: [
                        {
                            xtype: 'button',
                            style: 'margin-left:100px; margin-right: 30px;margin-bottom:50px;',
                             itemId : 'btnCreate',
                            text: 'Create Table',
                            listeners: {
                                      click: {
                                          fn: me.onbtnCreateClick,
                                          scope: me
                                      }
                                  }

                        }
                     
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }, 

    onbtnCreateClick: function(button, e, eOpts) {
           Ext.getCmp('tableForm').add({
                  xtype: 'grid',
                  title: 'Table 1',
                  columns: [
                     { text: 'Col1', dataIndex: 'col1' },
                     { text: 'Col2', dataIndex: 'col2' },
                     { text: 'Col3', dataIndex: 'col3' },
                     { text: 'Col4', dataIndex: 'col4' },
                     { text: 'Col5', dataIndex: 'col5' },
                     { text: 'Col6', dataIndex: 'col6' }
                  ],
                  height: 600,
                  width: 800
               })
            }
  


});