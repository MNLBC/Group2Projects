

Ext.define('School.view.MenuView', {
    extend: 'Ext.container.Container',

    alias : 'widget.MenuView',
    layout: {type:'vbox'},

  
    initComponent: function() {
        var me = this;

        Ext.apply(me, {
            items: [
                {
                    xtype: 'form',
                    height: 1080,
                    width: 1920,
                    bodyPadding: 10,
                    title: 'Main Menu',
                    items: [
                        {
                            xtype: 'button',
                            style: 'margin-left:100px; margin-right: 30px;',
                             itemId : 'btnProject1',
                            text: 'Project 1',
                            listeners: {
                                      click: {
                                          fn: me.onProject1Click,
                                          scope: me
                                      }
                                  }

                        },
                        {
                            xtype: 'button',
                            style: 'margin-right:30px;',
                            itemId : 'btnProject2',
                            text: 'Project 2',
                            listeners: {
                                click: {
                                    fn: me.onProject2Click,
                                    scope: me
                                }
                            }
                            	
                        },
                        {
                            xtype: 'button',
                            itemId : 'btnDynTable',
                            text: 'Dynamic table',
                            listeners: {
                                click: {
                                    fn: me.onDynamicTableClick,
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

    onProject1Click: function(button, e, eOpts) {
    	var viewport = button.up('form');
   	viewport.destroy();	

   	
   var compo =	Ext.getCmp('StudentMasterId');
   compo.show();
//     var window =Ext.widget('StudentMaster');
//     console.log('windowTest', window);
//      window.show(true);
  },

  onProject2Click: function(button, e, eOpts) {
//  	  this.getView().destroy();
		var viewport = button.up('form');
	   	viewport.destroy();	
		Ext.getCmp('studentsGrid').show();
//    var window =   Ext.widget('StudentGrid2');
//    window.show();
    
  },

  onDynamicTableClick: function(button, e, eOpts) {
//  	  this.getView().destroy();
		var viewport = button.up('form');
	   	viewport.destroy();	
      
      // Ext.widget('app-main');
  }
});