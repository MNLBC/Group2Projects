Ext.define('School.controller.StudentMaster2',
{
    extend: 'Ext.app.Controller',
    models: ['School.model.Student2'],
    stores: ['School.store.Student2'],
    views: ['School.view.StudentGrid2'],
    refs: [{
        ref: 'studentGrid',
        selector: 'viewport StudentGrid2'
    }],

    init: function () {

        this.control({

            'viewport > StudentGrid2 button[itemId=btnCreate]':
            {
                click: this.onCreateClick
            },
            'viewport > StudentGrid2 button[itemId=btnLoad]':
            {
                click: this.onLoadClick
            },
            'viewport > StudentGrid2 button[itemId=btnSave]':
            {
                click: this.onSaveClick
            },
            'viewport > StudentGrid2 button[itemId=btnDelete]':
            {
                click: this.onDeleteClick
            }
        });
    },

    onCreateClick: function () {

        var studentGrid = this.getStudentGrid();
        var studentStore = studentGrid.getStore();

        var studentModel = Ext.create('School.model.Student2');
        studentModel.set("firstName", "New employee's first name");
        studentModel.set("middleName", "New employee's middle name");
        studentModel.set("lastName", "New employee's last name");
        studentModel.set("birthDate", "11/01/2011");
        studentModel.set("city", "New city");
        studentModel.set("state", "New state");

        studentStore.add(studentModel);

        studentGrid.editingPlugin.startEdit(studentModel, 3);

    },

    onSaveClick: function () {
        var studentGrid = this.getStudentGrid();
        var studentStore = studentGrid.getStore();

        //fires create, update and delete request when calling sync and commit changes in the store when autoSync=false
        studentStore.sync({
            success: function (batch, eOpts) {
                Ext.Msg.alert('Status', 'Changes saved successfully.');
            },
            failure: function (batch, eOpts) {
                Ext.Msg.alert('Status', 'Request failed.');
            }
        });
    },
    onLoadClick: function () {
        var studentStore = Ext.getStore('School.store.Student2');
        studentStore.load();
    },

    onDeleteClick: function () {

        var studentGrid = this.getStudentGrid();
        var studentStore = studentGrid.getStore();

        //delete selected rows if selModel is checkboxmodel
        var selectedRows = studentGrid.getSelectionModel().getSelection();

        if (selectedRows.length)
            studentStore.remove(selectedRows);
        else
            Ext.Msg.alert('Status', 'Please select at least one record to delete!');
    }
});