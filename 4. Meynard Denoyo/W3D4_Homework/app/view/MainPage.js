Ext.define('Company.view.MainPage', 
{
    extend : 'Ext.form.Panel',
    alias : 'widget.MainPage',
    config : {},
    constructor : function(config){
        this.initConfig(config);
        return this.callParent(arguments);
    },
    
  
    initComponent : function(){
        
        Ext.apply(this, 
        {

            id : 'EmployeeMasterId',
            title : 'Employee Information',
            resizable : false,
            collapsible : true,
            bodyPadding : '5',
            buttonAlign : 'center',
            border : false,
            trackResetOnLoad : true,
            layout : 
            {
                type : 'vbox'
            },
            fieldDefaults : 
            {
                xtype : 'textfield',
                msgTarget : 'side',
                labelAlign : 'top',
                labelStyle : 'font-weight:bold'
            },
            items : [{
           	 xtype : 'button',
               text : '1st Page',
               itemId : 'button1',
               id : 'button1'
               
           }, 
           {
           	 xtype : 'button',
               text : '2nd Page',
               itemId : 'button2'
           }, 
           
           {
           	 xtype : 'button',
               text : '3rd Page (Dyanamic Table)',
               itemId : 'button3',
               id : 'button3'
           }]
        
            
        });
        this.callParent(arguments);
    }
});