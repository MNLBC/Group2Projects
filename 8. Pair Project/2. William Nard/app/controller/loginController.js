/*
 * File: app/controller/loginController.js
 *
 * This file was generated by Sencha Architect version 3.1.0.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 5.0.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 5.0.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('MedicineInvoicingSystem.controller.loginController', {
    extend: 'Ext.app.Controller',

    control: {
        "#btnregister": {
            click: 'onRegisterClick'
        },
        "#btnlogin": {
            click: 'onLoginClick'
        },
        "#btncancel": {
            click: 'onCancelClick'
        },
        "#btncreateacct": {
            click: 'onCreateAcctClick'
        },
        "#btncreatemed": {
            click: 'onCreateMedClick'
        },
        "#savemed": {
            click: 'onSaveMedClick'
        },
        "#btnupdatemed": {
            click: 'onUpdateMedClick'
        },
        "#pharmacistGrid": {
            selectionchange: 'onPharmacistGridChange'
        },
        "#deletemed": {
            click: 'onDeleteMedClick'
        },
        "#btnAddToCart": {
            click: 'onBtnAddCartClick'
        },
        "#btnBuy": {
            click: 'onBuyClick'
        },
        "#cutomersearch": {
            change: 'onCutomerChange'
        },
        "#famacissearch": {
            change: 'onFamacisChange'
        },
        "#btnremove": {
            click: 'onRemoveClick'
        },
        "#cutomerlogout": {
            click: 'onCutomerLogoutClick'
        },
        "#pharmacistlogout": {
            click: 'onPharmacistLogoutClick'
        }
    },

    onRegisterClick: function(button, e, eOpts) {

        var registerwin = Ext.create('MedicineInvoicingSystem.view.registrationWindow');
        registerwin.show();
    },

    onLoginClick: function(button, e, eOpts) {
        var username = Ext.getCmp('textboxUsername').getValue();
        var password = Ext.getCmp('textboxPassword').getValue();
        var userStore = Ext.getStore("userStore");
        var isValid = false;
        Ext.each(userStore.data.items, function(data){
            if(data.data.username == username && data.data.password == password){
                if(data.data.accountType == "Customer"){
                    var customerview = Ext.create('MedicineInvoicingSystem.view.customerViewport');
                    customerview.show();
                    isValid = true;
                }
                else if(data.data.accountType == "Pharmacist"){
                    var pharmacistview = Ext.create('MedicineInvoicingSystem.view.pharmacistViewport');
                    pharmacistview.show();
                    isValid = true;
                }
            }
        });

        if(isValid == false){
         Ext.Msg.alert('Warning','Invalid Account');
        }

    },

    onCancelClick: function(button, e, eOpts) {
        // var loginview = Ext.create('MedicineInvoicingSystem.view.loginViewport');
        // loginview.show();
        Ext.getCmp('registerwin').close();

    },

    onCreateAcctClick: function(button, e, eOpts) {
        var name, email, accttype, username, password, store, userObj, form;
        name = Ext.getCmp('fullname').getValue();
        email = Ext.getCmp('email').getValue();
        accttype = Ext.getCmp('accttype').getValue();
        username = Ext.getCmp('createuname').getValue();
        password = Ext.getCmp('createpword').getValue();
        store = Ext.getStore('userStore');
        form = Ext.getCmp('registrationForm');
        userObj = [{
            fullName: name,
            email: email,
            accountType: accttype,
            username: username,
            password: password
        }];

        var regexemail = new RegExp('/^([A-Za-z0-9_.]+)@([A-Za-z0-9]+).([A-Za-z0-9]+)$/');
        if(regexemail.test(email)){
            if(form.isValid()){
            store.add(userObj);
            Ext.getCmp('registerwin').close();
            Ext.Msg.alert('Succes', 'Register Successful!');
            }else{
                Ext.Msg.alert('Warning', 'Please input required fields');
            }
        }else{
            Ext.getCmp('email').markInvalid('Invalid email');
        }



    },

    onCreateMedClick: function(button, e, eOpts) {
        var btnsavemed, medform;
        btnsavemed = Ext.getCmp('savemed');
        medform = Ext.getCmp('medform');
        medform.getForm().reset();
        btnsavemed.show();

    },

    onSaveMedClick: function(button, e, eOpts) {
        var id, medname, brandname, price, quantity, expdate, store, medObj, medform;
        medname = Ext.getCmp('textmedname').getValue();
        brandname = Ext.getCmp('textbrandname').getValue();
        price = Ext.getCmp('textprice').getValue();
        quantity = Ext.getCmp('textquantity').getValue();
        expdate = Ext.getCmp('textexpdate').getValue();
        store = Ext.getStore('medicineStore');

        if (store.getCount() > 0)
                {
                    var maxId = store.getAt(0).get('id'); // initialise to the first record's id value.
                    store.each(function(rec) // go through all the records
                               {
                                   maxId = Math.max(maxId, rec.get('id'));
                               });
                }

                id = maxId + 1;

        form = Ext.getCmp('medform');
        medObj = [{
            id : id,
            medicineName: medname,
            brandName: brandname,
            price: price,
            quantity: quantity,
            expiryDate: expdate
        }];

        if(form.isValid()){
        store.add(medObj);
        Ext.Msg.alert('Success', 'Medicine added successfully!');
        Ext.getCmp('savemed').hide();
        console.log(store);
        }else{
            Ext.Msg.alert('Warning', 'Please input required fields');
        }
    },

    onUpdateMedClick: function(button, e, eOpts) {
        var id, store, medname, brandname, price, quantity, expdate;

        id = Ext.getCmp('pharmacistGrid').getSelectionModel().selected.items[0].data.id;
        medname = Ext.getCmp('textmedname').getValue();
        brandname = Ext.getCmp('textbrandname').getValue();
        price = Ext.getCmp('textprice').getValue();
        quantity = Ext.getCmp('textquantity').getValue();
        expdate = Ext.getCmp('textexpdate').getValue();
        store = Ext.getStore('medicineStore');

        Ext.each(store.data.items, function(record){
           if(id == record.data.id){
               record.data.medicineName = medname;
               record.data.brandName = brandname;
               record.data.price = price;
               record.data.quantity = quantity;
               record.data.expiryDate = expdate;
           }
        });

        Ext.getCmp('pharmacistGrid').getView().refresh();
        Ext.Msg.alert('Success', 'Record successfully updated!');

    },

    onPharmacistGridChange: function(model, selected, eOpts) {
        var selected;
        this.selected = selected;

        Ext.getCmp('textmedname').setValue(selected[0].data.medicineName);
        Ext.getCmp('textbrandname').setValue(selected[0].data.brandName);
        Ext.getCmp('textprice').setValue(selected[0].data.price);
        Ext.getCmp('textquantity').setValue(selected[0].data.quantity);
        Ext.getCmp('textexpdate').setValue(selected[0].data.expiryDate);

        Ext.getCmp('savemed').hide();
    },

    onDeleteMedClick: function(button, e, eOpts) {
        var id, store;
        id = Ext.getCmp('pharmacistGrid').getSelectionModel().selected.items[0].data.id;
        store = Ext.getStore('medicineStore');

        Ext.each(store.data.items, function(record){
            if(id == record.data.id){
                Ext.Msg.alert('Success', 'Record successfully deleted!');
                Ext.getCmp('medform').getForm().reset();
                store.remove(record);
            }
        });
    },

    onBtnAddCartClick: function(button, e, eOpts) {
        var medName,brandName,price,qty,expDate,store,selectedrec, medObj;

        selectedrec = Ext.getCmp('cutomerGrid1').getSelectionModel().selected.items[0];
        medName = selectedrec.data.medicineName;
        brandName = selectedrec.data.brandName;
        expDate = selectedrec.data.expiryDate;
        price = selectedrec.data.price;
        qty = Ext.getCmp('txtboxQuantity').getValue();
        store = Ext.getStore('orderStore');

        var med = medName + '(' + brandName +')';
        var sub = price * qty;
        var id = selectedrec.data.id;

        if(qty > selectedrec.data.quantity || qty <= 0){
            if(selectedrec.data.quantity == 0){
                Ext.Msg.alert('Warning', 'Medicine out of stock');
            }else{
                    Ext.Msg.alert('Warning', 'Please input a value not exceeding ' + selectedrec.data.quantity);
            }
        }else{
            var exists = true;
        if(Ext.isEmpty(store.data.items)){
            medObj = [{id:id,medicine: med,price: price,quantity : qty,subtotal: sub}];
            store.add(medObj);
        }else{

            Ext.each(store.data.items,function(record){
           if(id == record.data.id){
               record.data.quantity = parseInt(record.data.quantity) + parseInt(qty);
               record.data.subtotal = parseFloat(price) * record.data.quantity;
               exists = true;
           }
            else{
                exists = false;
            }
            });
            if(!exists){
            medObj = [{id:id,medicine: med,price: price,quantity : qty,subtotal: sub}];
            store.add(medObj);
        }
        }
        }







        Ext.getCmp('orderSummaryPanel').getView().refresh();
    },

    onBuyClick: function(button, e, eOpts) {
        var store, receipt, store2, total;
        total = 0;
        receipt = "";
        store = Ext.getStore('orderStore');
        Ext.each(store.data.items,function(record){
            var medicine, price, qty,sub;
            medicine = record.data.medicine;
            price = record.data.price;
            qty = record.data.quantity;
            sub = record.data.subtotal;
            total = total + parseFloat(record.data.subtotal);
            receipt = '<p>' + receipt + medicine + '&emsp;&emsp;&emsp;&emsp;&emsp; x' + qty.toString() + '&emsp;&emsp;&emsp;&emsp;&emsp;' + price.toString() + '&emsp;&emsp;&emsp;&emsp;&emsp;' + sub.toString() + '</p>';
            //receipt.innerHTML = receipt+'<br';
            //receipt.html = receipt + medicine + '  x' + qty + '\\t' + price + '\\t' + sub + '<br>';

        });

        document.getElementById('labelInvoice').innerHTML = receipt;
        store2 = Ext.getStore('medicineStore');

        Ext.each(store2.data.items,function(rec){
            Ext.each(store.data.items,function(record){
                if(record.data.id == rec.data.id){
                    rec.data.quantity = parseInt(rec.data.quantity) - parseInt(record.data.quantity);
                }
            });
        });

        Ext.getCmp('cutomerGrid1').getView().refresh();
        Ext.getCmp('labelTotal').setText('Total: ' + total);
        store.removeAll();
        console.log(store2);
    },

    onCutomerChange: function(field, newValue, oldValue, eOpts) {
        var medName, store;

                        medName = Ext.getCmp('cutomersearch').getValue();
                store = Ext.getStore('medicineStore');

                if(Ext.isEmpty(medName)){
                    store.clearFilter();
                }else{
                store.filter('medicineName', medName);
                }
    },

    onFamacisChange: function(field, newValue, oldValue, eOpts) {

                        medName = Ext.getCmp('famacissearch').getValue();
                store = Ext.getStore('medicineStore');

                if(Ext.isEmpty(medName)){
                    store.clearFilter();
                }else{
                store.filter('medicineName', medName);
                }
    },

    onRemoveClick: function(button, e, eOpts) {
        var selectedrec = Ext.getCmp('orderSummaryPanel').getSelectionModel().selected.items[0];
        var store = Ext.getStore('orderStore');
        Ext.each(store.data.items,function(record){
           if(record.data.id == selectedrec.data.id){
               store.remove(record);
           }
        });
    },

    onCutomerLogoutClick: function(button, e, eOpts) {
        Ext.getCmp('cutomerview').destroy();
    },

    onPharmacistLogoutClick: function(button, e, eOpts) {
        Ext.getCmp('pharmacistview1').destroy();
    }

});
