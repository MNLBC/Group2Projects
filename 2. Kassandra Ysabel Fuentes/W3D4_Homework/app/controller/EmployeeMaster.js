Ext.define('School.controller.EmployeeMaster',
{
    extend: 'Ext.app.Controller',
    models: ['School.model.Employee'],
    stores: ['School.store.Employee'],
    views: ['School.view.EmployeeGrid'],
    refs: [{
        ref: 'EmployeeGrid',
        selector: 'viewport EmployeeGrid'
    }],

    init: function () {

        this.control({

            'viewport > EmployeeGrid button[itemId=btnCreate]':
            {
                click: this.onCreateClick
            },
            'viewport > EmployeeGrid button[itemId=btnLoad]':
            {
                click: this.onLoadClick
            },
            'viewport > EmployeeGrid button[itemId=btnSave]':
            {
                click: this.onSaveClick
            },
            'viewport > EmployeeGrid button[itemId=btnDelete]':
            {
                click: this.onDeleteClick
            }
        });
    },

    onCreateClick: function () {

        var EmployeeGrid = this.getEmployeeGrid();
        var EmployeeStore = EmployeeGrid.getStore();

        var EmployeeModel = Ext.create('School.model.Employee');
        EmployeeModel.set("firstName", "New employee's first name");
        EmployeeModel.set("middleName", "New employee's middle name");
        EmployeeModel.set("lastName", "New employee's last name");
        EmployeeModel.set("birthDate", "11/01/2011");
        EmployeeModel.set("city", "New city");
        EmployeeModel.set("state", "New state");

        EmployeeStore.add(EmployeeModel);

        EmployeeModel.editingPlugin.startEdit(EmployeeModel, 3);

    },

    onSaveClick: function () {
        var EmployeeGrid = this.getEmployeeGrid();
        var EmployeeStore = EmployeeGrid.getStore();

        //fires create, update and delete request when calling sync and commit changes in the store when autoSync=false
        EmployeeStore.sync({
            success: function (batch, eOpts) {
                Ext.Msg.alert('Status', 'Changes saved successfully.');
            },
            failure: function (batch, eOpts) {
                Ext.Msg.alert('Status', 'Request failed.');
            }
        });
    },
    onLoadClick: function () {
        var EmployeeStore = Ext.getStore('School.store.Employee');
        EmployeeStore.load();
    },

    onDeleteClick: function () {

        var EmployeeGrid = this.getEmployeeGrid();
        var EmployeeStore = EmployeeGrid.getStore();

        //delete selected rows if selModel is checkboxmodel
        var selectedRows = EmployeeGrid.getSelectionModel().getSelection();

        if (selectedRows.length)
            EmployeeStore.remove(selectedRows);
        else
            Ext.Msg.alert('Status', 'Please select at least one record to delete!');
    }
});