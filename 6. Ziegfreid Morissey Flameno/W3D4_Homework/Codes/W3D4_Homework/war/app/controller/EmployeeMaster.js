/**
 * Ziggy
 */
Ext.define('Company.controller.EmployeeMaster',
{
    extend: 'Ext.app.Controller',
    models: ['Company.model.Employee'],
    stores: ['Company.store.Employee'],
    views: ['Company.view.EmployeeGrid'],

    refs: [{
        ref: 'employeeGrid',
        selector: 'viewport > EmployeeGrid'
    }],

    init: function () {

        this.control({

            'viewport > EmployeeGrid button[itemId=btnCreate]':
            {
                click: this.onCreateClick
            },
            'viewport > EmployeeGrid button[itemId=btnDelete]':
            {
                click: this.onDeleteClick
            }
        }
        );
    },

    onCreateClick: function () {

        var employeeGrid = this.getEmployeeGrid();
        var employeeStore = employeeGrid.getStore();

        var employeeModel = Ext.create('Company.model.Employee');
        employeeModel.set("firstName", "New employee's first name");
        employeeModel.set("middleName", "New employee's middle name");
        employeeModel.set("lastName", "New employee's last name");
        employeeModel.set("birthDate", "11/01/2011");
        employeeModel.set("city", "New city");
        employeeModel.set("state", "New state");

        employeeStore.add(employeeModel);


    },
    onDeleteClick: function () {

        var employeeGrid = this.getEmployeeGrid(); 
        var employeeStore = employeeGrid.getStore();

        //delete selected rows if selModel is checkboxmodel
        var selectedRows = employeeGrid.getSelectionModel().getSelection();

        if (selectedRows.length)
            employeeStore.remove(selectedRows);
        else
            Ext.Msg.alert('Status', 'Please select at least one record to delete!');
    }
});