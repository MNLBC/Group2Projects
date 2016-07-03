/*
 * File: app/controller/MainController.js
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

Ext.define('W3D5_Project.controller.MainController', {
    extend: 'Ext.app.Controller',

    id: 'MainController',

    onBookCreateClick: function() {
        var controller = W3D5_Project.app.getController('MainController');
        var store = Ext.getStore('BookStore');
        var book = controller.getFormValues();
        store.add(book);
        controller.resetFormValues();
    },

    onBookUpdateClick: function() {
        var controller = W3D5_Project.app.getController('MainController');
        var store = Ext.getStore('BookStore');
        var book = controller.getFormValues();
        var id = Ext.getCmp('BookId').getValue();
        var grid = Ext.getCmp('ConfigBooksGrid');

        if(Ext.isEmpty(id)){
            Ext.Msg.show({
            title:'Status',
            msg: 'Please select a record to update.',
            buttons: Ext.Msg.OK,
            icon: Ext.Msg.WARNING
        });
        }else{
           Ext.each(store.data.items, function(rec){
            if(rec.data.id == id){
                rec.data.title = book.title;
                rec.data.img = book.img;
                rec.data.author = book.author;
                rec.data.desc = book.desc;
                rec.data.date = book.date;
                rec.data.genre = book.genre;
                rec.data.percent = book.percent;
                rec.data.oprice = book.oprice;
                rec.data.sprice = book.sprice;
                rec.data.avail = book.avail;
                rec.data.checked = book.checked;
                rec.data.bestseller = book.bestseller;
                rec.data.status = book.status;
                rec.data.onsale = book.onsale;
            }
        });
        }

        grid.getView().refresh();
        controller.resetFormValues();

    },

    onBookDeleteClick: function() {
                var controller = W3D5_Project.app.getController('MainController');
                var store = Ext.getStore('BookStore');
                var id = Ext.getCmp('BookId').getValue();

                if(Ext.isEmpty(id)){
                    Ext.Msg.show({
                    title:'Status',
                    msg: 'Please select a record to delete.',
                    buttons: Ext.Msg.OK,
                    icon: Ext.Msg.WARNING
                });
                }else{
                   Ext.each(store.data.items, function(rec){
                    if(rec.data.id == id){
                        controller.resetFormValues();
                        store.remove(rec);
                    }
                  });
                }
    },

    onConfigBooksGridSelectionChange: function() {
        var controller = W3D5_Project.app.getController('MainController');
        var grid = Ext.getCmp('ConfigBooksGrid');
        var selected;
        if(!Ext.isEmpty(grid.getSelectionModel().selected)){
            selected = grid.getSelectionModel().selected.items[0].data;
            controller.setFormValues(selected);
        }
    },

    onSearchBtnClick: function() {
        var searchVal = Ext.getCmp('BookSearch').getValue();
         var store = Ext.getStore('BookStore');
        if(Ext.isEmpty(searchVal)){
            store.clearFilter();
        }else{
            store.filter('title', searchVal);
        }
    },

    onBookResetClick: function() {
        var controller = W3D5_Project.app.getController('MainController');
        controller.resetFormValues();
    },

    onResetBtnClick: function() {
        Ext.getCmp('BookSearch').setValue('');
    },

    onMenuPanelTabChange: function(tabPanel, newCard, oldCard, eOpts) {
        var store = Ext.getStore('BookStore');
        var grid = Ext.getCmp('BooksGrid');
        store.clearFilter();
        grid.getView().refresh();
        if(newCard.title=='Best Seller'){
            store.filter('bestseller','1');
        }else if(newCard.title=='On Sale'){
            store.filter('onsale','1');
        }
    },

    onRomanceCatClick: function(item, e, eOpts) {
        var controller = W3D5_Project.app.getController('MainController');
        controller.changeCategory(item);
    },

    onMysteryCatClick: function(item, e, eOpts) {
        var controller = W3D5_Project.app.getController('MainController');
        controller.changeCategory(item);
    },

    onHorrorCatClick: function(item, e, eOpts) {
        var controller = W3D5_Project.app.getController('MainController');
        controller.changeCategory(item);
    },

    getFormValues: function() {
        var store = Ext.getStore('BookStore');
        var title = Ext.getCmp('BookTitle').getValue();
        var img = Ext.getCmp('BookCover').getValue();
        var author = Ext.getCmp('BookAuthor').getValue();
        var desc = Ext.getCmp('BookDesc').getValue();
        var date = Ext.getCmp('BookDate').getValue();
        var genre = Ext.getCmp('BookGenre').getValue();
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

        if((Ext.isEmpty(avail)||avail=='0')&&(Ext.isEmpty(checked)||checked=='0')){
            status = 'Out of stock';
        }else if((Ext.isEmpty(avail)||avail=='0')&&!(Ext.isEmpty(checked)||checked=='0')){
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
            genre: genre,
            oprice: oprice,
            sprice: sprice,
            percent: percent,
            onsale: onsale,
            bestseller: bestseller,
            avail: avail,
            checked: checked,
            status: status
        };

        return book;

    },

    setFormValues: function(book) {

        Ext.getCmp('BookTitle').setValue(book.title);
        Ext.getCmp('BookCover').setValue(book.img);
        Ext.getCmp('BookAuthor').setValue(book.author);
        Ext.getCmp('BookDesc').setValue(book.desc);
        Ext.getCmp('BookDate').setValue(book.date);
        Ext.getCmp('BookGenre').setValue(book.genre);
        Ext.getCmp('BookPerc').setValue(book.percent);
        Ext.getCmp('BookOPrice').setValue(book.oprice);
        Ext.getCmp('BookSPrice').setValue(book.sprice);
        Ext.getCmp('BookAvail').setValue(book.avail);
        Ext.getCmp('BookCheck').setValue(book.checked);
        Ext.getCmp('BookBest').setValue(book.bestseller);
        Ext.getCmp('BookId').setValue(book.id);
        Ext.getCmp('BookStatus').setValue(book.status);

    },

    resetFormValues: function() {

        Ext.getCmp('BookTitle').setValue('');
        Ext.getCmp('BookCover').setValue('');
        Ext.getCmp('BookAuthor').setValue('');
        Ext.getCmp('BookDesc').setValue('');
        Ext.getCmp('BookDate').setValue('');
        Ext.getCmp('BookGenre').setValue('');
        Ext.getCmp('BookPerc').setValue('');
        Ext.getCmp('BookOPrice').setValue('');
        Ext.getCmp('BookSPrice').setValue('');
        Ext.getCmp('BookAvail').setValue('');
        Ext.getCmp('BookCheck').setValue('');
        Ext.getCmp('BookBest').setValue(0);
        Ext.getCmp('BookId').setValue('');
        Ext.getCmp('BookStatus').setValue('');

    },

    changeCategory: function(cat) {
        var store = Ext.getStore('BookStore');
        var grid = Ext.getCmp('BooksGrid');
        var menu = Ext.getCmp('MenuPanel');
        var tab = menu.activeTab;
        store.clearFilter();
        grid.getView().refresh();
        if(cat.title == 'All Books'){
             if(tab.title=='Best Seller'){
            store.filter('bestseller','1');
        }else if(tab.title=='On Sale'){
            store.filter('onsale','1');
        }
        }else{
           if(tab.title=='Best Seller'){
            store.filter('bestseller','1');
            store.filter('genre',cat.text);
        }else if(tab.title=='On Sale'){
            store.filter('onsale','1');
            store.filter('genre',cat.text);
        }else{
            store.filter('genre',cat.text);
        }
        }

    },

    init: function(application) {
        this.control({
            "#BookCreate": {
                click: this.onBookCreateClick
            },
            "#BookUpdate": {
                click: this.onBookUpdateClick
            },
            "#BookDelete": {
                click: this.onBookDeleteClick
            },
            "#ConfigBooksGrid": {
                selectionchange: this.onConfigBooksGridSelectionChange
            },
            "#SearchBtn": {
                click: this.onSearchBtnClick
            },
            "#BookReset": {
                click: this.onBookResetClick
            },
            "#ResetBtn": {
                click: this.onResetBtnClick
            },
            "#MenuPanel": {
                tabchange: this.onMenuPanelTabChange
            },
            "#RomanceCat": {
                click: this.onRomanceCatClick
            },
            "#MysteryCat": {
                click: this.onMysteryCatClick
            },
            "#HorrorCat": {
                click: this.onHorrorCatClick
            }
        });
    }

});
