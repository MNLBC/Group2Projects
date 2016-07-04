/*
 * File: app/controller/MyController.js
 *
 * This file was generated by Sencha Architect version 3.1.0.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 4.2.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 4.2.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('W3D5_Project.controller.MyController', {
    extend: 'Ext.app.Controller',

    onBookCreateClick: function() {
        var store = Ext.getStore('BookStore');
        var title = Ext.getCmp('BookTitle').getValue();
        var img = Ext.getCmp('BookCover').getValue();
        var author = Ext.getCmp('BookAuthor').getValue();
        var desc = Ext.getCmp('BookDesc').getValue();
        var date = Ext.getCmp('BookDate').getValue();
        var percent = Ext.getCmp('BookPerc').getValue();
        var oprice = Ext.getCmp('BookOPrice').getValue();
        var sprice = Ext.getCmp('BookSPrice').getValue();
        var avail = Ext.getCmp('BookAvail').getValue();
        var checked = Ext.getCmp('BookCheck').getValue();
        var bestseller = Ext.getCmp('BookBest').getValue();
        var status,id,onsale;


        if (store.getCount() > 0)
        {
            var maxId = store.getAt(0).get('id'); // initialise to the first record's id value.
            store.each(function(rec) // go through all the records
                       {
                           maxId = Math.max(maxId, rec.get('id'));
                       });
        }

        id = maxId + 1;

        if((Ext.isEmpty(avail)||avail==='0')&&(Ext.isEmpty(checked)||checked==='0')){
            status = 'Out of stock';
        }else if((Ext.isEmpty(avail)||avail==='0')&&!(Ext.isEmpty(checked)||checked==='0')){
            status = 'Checked out';
        }else{
            status = 'Available';
        }

        if(bestseller){
            bestseller = '1';
        }else{
            bestseller = '0';
        }

        if(Ext.isEmpty(sprice)){
            onsale = '0';
        }else{
            onsale = '1';
        }

        var book = {
            id: id,
            img: img,
            title: title,
            author: author,
            desc: desc,
            date: date,
            oprice: oprice,
            sprice: sprice,
            percent: percent,
            onsale: onsale,
            bestseller: bestseller,
            avail: avail,
            checked: checked,
            status: status
        };

        store.add(book);

    },

    init: function(application) {
        this.control({
            "#BookCreate": {
                click: this.onBookCreateClick
            }
        });
    }

});
