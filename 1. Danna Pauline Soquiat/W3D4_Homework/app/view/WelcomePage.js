Ext.define('Company.view.WelcomePage', 
{
    extend : 'Ext.form.Panel',
    alias : 'widget.WelcomePage',
    config : {},
    constructor : function(config){
        this.initConfig(config);
        return this.callParent(arguments);
    },
    
  
    initComponent : function(){
        
        Ext.apply(this, 
        {
            items : [{
            	 xtype : 'button',
                text : 'Employee Data Store',
                itemId : 'btnEmpData',
                
            }, 
            {
            	 xtype : 'button',
                text : 'Create Employee Data',
                itemId : 'btnEmpForm'
            }, 
            
            {
            	 xtype : 'button',
                text : 'Dynamic Table',
                itemId : 'btnTable'
            }]
        });
        this.callParent(arguments);
    }
});