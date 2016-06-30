Ext.define('School.controller.EmployeeMaster2', {
    extend: 'Ext.app.Controller',
    models: ['School.model.Employee2'],
    views: ['School.view.EmployeeMaster2'],

    refs: [{
        ref: 'EmployeeMasterForm',
        selector: 'viewport > EmployeeMaster2'
    }],

    init: function () {
        this.control({

            'viewport > EmployeeMaster2 button[itemId=btnCreate]': {
                click: this.onCreateClick
            },
            'viewport > EmployeeMaster2 button[itemId=btnLoad]': {
                click: this.onLoadClick
            },
            'viewport > EmployeeMaster2 button[itemId=btnUpdate]': {
                click: this.onUpdateClick
            },
            'viewport > EmployeeMaster2 button[itemId=btnDelete]': {
                click: this.onDeleteClick
            },
            'viewport > EmployeeMaster2 button[itemId=btnReset]': {
                click: this.onResetClick
            },
            'viewport > EmployeeMaster2 button[itemId=btnClear]': {
                click: this.onClearClick
            }
        }
            );
    },

    onUpdateClick: function () {

        var stdMaster = this.getEmployeeMaster2Form();

        if (!stdMaster.isDirty()) {
            Ext.Msg.alert('Status', 'No pending changes to save.');
            return;
        }
        else if (!stdMaster.isValid()) {
            Ext.Msg.alert('Status', 'Invalid data.');
            return;
        }

        var EmployeeModel = Ext.create('School.model.Employee2');

        EmployeeModel.set(stdMaster.getValues());

        var mask = new Ext.LoadMask(stdMaster, { msg: "Updating..." });
        mask.show();

        EmployeeModel.save({
            scope: this, //controller would be accessible inside load
            success: function (record, operation) {
                try {
                    var resp = Ext.decode(operation.response.responseText);
                    if (resp.success) {
                        //set the root in proxy to indicate where the Employee data in the response
                        var Employee = Ext.create('School.model.Employee2');
                        Employee.set(resp.data[0]);
                        this.getEmployeeMaster2Form().loadRecord(Employee);

                        Ext.Msg.alert('Status', 'Employee updated successfully.');
                    }
                    else
                        Ext.Msg.alert('Status', resp.message);
                }
                catch (ex) {
                    Ext.Msg.alert('Status', 'Invalid data in server response: ' + ex.Message);

                }
                mask.hide();
            },
            failure: function (record, operation) {
                Ext.Msg.alert('Save Failed', operation.response.responseText);
                try {
                    var resp = Ext.decode(operation.response.responseText);
                    Ext.Msg.alert('Status', resp.message);

                }
                catch (ex) {
                    Ext.Msg.alert('Status', 'Not a valid data.' + ex.Message);
                }
                mask.hide();
            }
        });

    },

    onLoadClick: function () {

        var existingEmployee = Ext.ModelMgr.getModel('School.model.Employee2');
        var stdMaster = this.getEmployeeMaster2Form();
        var mask = new Ext.LoadMask(stdMaster, { msg: "Loading..." });
        mask.show();

        existingEmployee.load(1, {
            scope: this, //controller would be accessible inside load
            failure: function (record, operation) {
                mask.hide();
                Ext.Msg.alert('Status', 'Service request faild.');
            },
            success: function (record, operation) { //do something if the load succeeded
                //if service response object has same properties and heirarchy as model object then you can model.loadRecord(record)
                //otherwise you have to decode operation.response.responseText, create model object and populate valudes of decoded response into model and then use model.loadRecord()
                try {
                    //                    var resp = Ext.decode(operation.response.responseText);
                    //                    if (resp.success) {
                    //                        //set the root in proxy to indicate where the Employee data in the response
                    //                        var Employee = Ext.create('School.model.Employee');
                    //                        Employee.set(resp.data[0]);

                    //                        this.getEmployeeMaster2Form().loadRecord(Employee);
                    //                        Ext.Msg.alert('Status', 'Records loaded successfully.');
                    //                    }
                    //                    else
                    //                        Ext.Msg.alert('Status', resp.message);

                    //following also valid
                    this.getEmployeeMaster2Form().loadRecord(record);
                    Ext.Msg.alert('Status', 'Records loaded successfully.');

                }
                catch (ex) {
                    Ext.Msg.alert('Status', 'Invalid data in server response: ' + ex.Message);

                }
                mask.hide();
            }
        });

    },

    onCreateClick: function () {
        var stdMaster = this.getEmployeeMaster2Form();

        if (!stdMaster.isDirty()) {
            Ext.Msg.alert('Status', 'No new data to create.');
            return;
        }
        else if (!stdMaster.isValid()) {
            Ext.Msg.alert('Status', 'Invalid data.');
            return;
        }

        var EmployeeModel = Ext.create('School.model.Employee2');

        EmployeeModel.set(stdMaster.getValues());

        var mask = new Ext.LoadMask(stdMaster, { msg: "Saving..." });
        mask.show();

        EmployeeModel.save({
            scope: this, //controller would be accessible inside load
            success: function (record, operation) { //do something if the load succeeded
                //if service response object has same properties and heirarchy as model object then you can model.loadRecord(record)
                //otherwise you have to decode operation.response.responseText, create model object and populate valudes of decoded response into model and then use model.loadRecord()
                try {
                    //                    var resp = Ext.decode(operation.response.responseText);
                    //                    if (resp.success) {
                    //                        //set the root in proxy to indicate where the Employee data in the response
                    //                        var Employee = Ext.create('School.model.Employee');
                    //                        Employee.set(resp.data[0]);
                    //                        this.getEmployeeMaster2Form().loadRecord(Employee);
                    //                          Ext.Msg.alert('Status', resp.message);
                    //                    }
                    //                    else
                    //                        Ext.Msg.alert('Status', resp.message);
                    //or
                    this.getEmployeeMaster2Form().loadRecord(record);
                    Ext.Msg.alert('Status', 'Employee Saved Successfully!');


                }
                catch (ex) {
                    Ext.Msg.alert('Status', 'Invalid data in server response: ' + ex.Message);
                }
                mask.hide();
            },
            failure: function (record, operation) {
                mask.hide();
                Ext.Msg.alert('Status', 'Service request faild.');
            }

        });

    },

    onDeleteClick: function () {

        var stdMaster = this.getEmployeeMaster2Form();

        if (!stdMaster.getValues(false, false, false, true).Id) {
            Ext.Msg.alert('Status', 'Invalid or no data.');
            return;
        }

        var EmployeeModel = stdMaster.getRecord();
        var mask = new Ext.LoadMask(stdMaster, { msg: "Deleting..." });
        mask.show();

        EmployeeModel.destroy({
            scope: this, //controller would be accessible inside load
            failure: function (record, operation) {
                mask.hide();
                Ext.Msg.alert('Status', 'Service request failwd.');
            },
            success: function (record, operation) {
                try {
                    var resp = Ext.decode(operation.response.responseText);
                    if (resp.success) { // check if delete succeded at server side
                        this.getEmployeeMaster2Form().clearForm();
                    }

                    Ext.Msg.alert('Status', resp.message);
                }
                catch (ex) {
                    Ext.Msg.alert('Status', 'Exception: ' + ex.Message);
                }
                mask.hide();
            }
        });
    },
    onResetClick: function () {
        this.getEmployeeMaster2Form().getForm().reset();
    },
    onClearClick: function () {
        this.getEmployeeMaster2Form().clearForm();
    }
});