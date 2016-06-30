Ext.application({
	requires : [ 'Ext.container.Viewport' ],
	name : 'School',
    views: ['School.view.EmployeeMaster'],
    controllers: ['EmployeeMaster'],
	

    launch: function () {
        
        Ext.create('Ext.container.Viewport', 
        {
        	type: 'hbox',
            pack: 'center',
            items : [{
            	xtype: 'form',
                flex: 1,
                height: 564,
                id: 'main',
                width: 629,
                layout: 'vbox',
                bodyPadding: 10,
                title: 'Employee Info',
                items: [
                    {
                        xtype: 'container',
                        formBind: false,
                        height: 390,
                        width: 518,
                        items: [
                                {
								xtype : 'button',
								id: 'btn1',
								text : 'Go to Page 1',
								handler : function() {
									Ext.create('Ext.container.Viewport', {
										layout : 'anchor',
										items : [ {
											xtype : 'EmployeeGrid'
										} ]
									});
								}
							},
					            {
                                    xtype: 'tbspacer',
                                    height: 40,
                                    width: 503
                                },
                                {
                                xtype : 'button',
                                id: 'btn2',
            					text : 'Go to Page 2',
            					handler : function() {
            						Ext.create('Ext.container.Viewport', {
            							layout : 'fit',
            							items : [ {
            								xtype : 'EmployeeMaster'
            								} ]
            							});
            						}
                                }]
                    	}
                    ]
           }]
        
        });
    }
});