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

        if(!Ext.isEmpty(grid.getSelectionModel().selected.items[0])){
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

        var store = Ext.getStore('BookStore');
        store.clearFilter();

        Ext.getCmp('BookSearch').setValue('');
    },

    onMenuPanelTabChange: function(tabPanel, newCard, oldCard, eOpts) {
        var controller = W3D5_Project.app.getController('MainController');
        var store = Ext.getStore('BookStore');
        var grid = Ext.getCmp('BooksGrid');
        var gridPanel = Ext.getCmp('GenreAll');

        gridPanel.setTitle('All Books');
        controller.enableCategories();
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
        controller.enableCategories();
        item.disable();
    },

    onMysteryCatClick: function(item, e, eOpts) {
        var controller = W3D5_Project.app.getController('MainController');
        controller.changeCategory(item);
        controller.enableCategories();
        item.disable();
    },

    onHorrorCatClick: function(item, e, eOpts) {
        var controller = W3D5_Project.app.getController('MainController');
        controller.changeCategory(item);
        controller.enableCategories();
        item.disable();
    },

    onAllBooksCatClick: function(item, e, eOpts) {
        var controller = W3D5_Project.app.getController('MainController');
        controller.changeCategory(item);
        controller.enableCategories();
        item.disable();
    },

    onConfigOrderGridSelectionChange: function() {
        var controller = W3D5_Project.app.getController('MainController');
        var grid = Ext.getCmp('ConfigOrderGrid');
        var selected;

        if(!Ext.isEmpty(grid.getSelectionModel().selected.items[0])){
            selected = grid.getSelectionModel().selected.items[0].data;
            controller.setOrderValues(selected);
        }
    },

    onOrderResetClick: function() {
        var controller = W3D5_Project.app.getController('MainController');
        controller.resetOrderValues();
    },

    onOrderCreateClick: function() {
        var controller = W3D5_Project.app.getController('MainController');
        var store = Ext.getStore('OrderStore');
        var order = controller.getOrderValues();
        store.add(order);
        controller.resetOrderValues();
    },

    onOrderUpdateClick: function() {
        var controller = W3D5_Project.app.getController('MainController');
        var store = Ext.getStore('OrderStore');
        var order = controller.getOrderValues();
        var id = Ext.getCmp('OrderId').getValue();
        var grid = Ext.getCmp('ConfigOrderGrid');

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
                rec.data.userid = order.userid;
                rec.data.username = order.username;
                rec.data.bookid = order.bookid;
                rec.data.booktitle = order.booktitle;
                rec.data.bookprice = order.bookprice;
                rec.data.bookquantity = order.bookquantity;
                rec.data.booktotal = order.booktotal;
                rec.data.remarks = order.remarks;
                rec.data.date = order.date;
            }
        });
        }

        grid.getView().refresh();
        controller.resetOrderValues();

    },

    onOrderDeleteClick: function() {
                var controller = W3D5_Project.app.getController('MainController');
                var store = Ext.getStore('OrderStore');
                var id = Ext.getCmp('OrderId').getValue();

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
                        controller.resetOrderValues();
                        store.remove(rec);
                    }
                  });
                }
    },

    onBooksGridCellDblClick: function(tableview, td, cellIndex, record, tr, rowIndex, e, eOpts) {
        var controller = W3D5_Project.app.getController('MainController');
        controller.openOrderWin(record);
    },

    onOSearchBtnClick: function() {
        var searchVal = Ext.getCmp('OrderSearch').getValue();
         var store = Ext.getStore('OrderStore');
        if(Ext.isEmpty(searchVal)){
            store.clearFilter();
        }else{
            store.filter('booktitle', searchVal);
        }
    },

    onOResetBtnClick: function() {

        var store = Ext.getStore('OrderStore');
        store.clearFilter();

        Ext.getCmp('OrderSearch').setValue('');
    },

    onBuyBtnClick: function() {
        var controller = W3D5_Project.app.getController('MainController');
        var store = Ext.getStore('OrderStore');
        var bookStore = Ext.getStore('BookStore');
        var order = controller.getOrderInfo(false);
        var activeTab = Ext.getCmp('MenuPanel').activeTab.title;
        var scope = this;
        var grid;
        store.add(order);
        Ext.each(bookStore.data.items,function(rec){
            if(rec.data.id==order.bookid){
                rec.data.avail = rec.data.avail - order.bookquantity;
            }
        });

        Ext.Msg.show({
            title:'Order Successful',
            msg: 'Your purchase is on its way. Please prepare cash on delivery. Thank you.',
            buttons: Ext.Msg.OK,
            icon: Ext.Msg.Info,
            fn: function(btn) {
                if (btn === 'ok') {
                    scope.orderWin.hide();
                    scope.orderWin.mask();
                    if(activeTab=='All Books'){
                        grid = Ext.getCmp('BooksGrid');
                    }else if(activeTab=='Best Seller'){
                        grid = Ext.getCmp('BestBooksGrid');
                    }else{
                        grid = Ext.getCmp('SaleBooksGrid');
                    }
                    grid.getView().refresh();
                }
            }
        });
    },

    onCancelBtnClick: function() {
        this.orderWin.hide();
        this.orderWin.mask();
    },

    onCheckBtnClick: function() {
        var controller = W3D5_Project.app.getController('MainController');
        var store = Ext.getStore('OrderStore');
        var bookStore = Ext.getStore('BookStore');
        var order = controller.getOrderInfo(true);
        var activeTab = Ext.getCmp('MenuPanel').activeTab.title;
        var scope = this;
        var grid;
        store.add(order);
        Ext.each(bookStore.data.items,function(rec){
            if(rec.data.id==order.bookid){
                rec.data.check = rec.data.check + order.bookquantity;
            }
        });

        Ext.Msg.show({
            title:'Order Successful',
            msg: 'The borrowed book is on its way. Please return after 7 days. Thank you.',
            buttons: Ext.Msg.OK,
            icon: Ext.Msg.Info,
            fn: function(btn) {
                if (btn === 'ok') {
                    scope.orderWin.hide();
                    scope.orderWin.mask();
                    if(activeTab=='All Books'){
                        grid = Ext.getCmp('BooksGrid');
                    }else if(activeTab=='Best Seller'){
                        grid = Ext.getCmp('BestBooksGrid');
                    }else{
                        grid = Ext.getCmp('SaleBooksGrid');
                    }
                    grid.getView().refresh();
                }
            }
        });
    },

    onBestBooksGridCellDblClick: function(tableview, td, cellIndex, record, tr, rowIndex, e, eOpts) {
        var controller = W3D5_Project.app.getController('MainController');
        controller.openOrderWin(record);
    },

    onSaleBooksGridCellDblClick: function(tableview, td, cellIndex, record, tr, rowIndex, e, eOpts) {
        var controller = W3D5_Project.app.getController('MainController');
                controller.openOrderWin(record);
    },

    onLogOutBtnClick: function() {

                Ext.Msg.show({
                    title:'Log Out',
                    msg: 'Are you sure you want to log out?',
                    buttons: Ext.Msg.YESNO,
                    icon: Ext.Msg.Question,
                    fn: function(btn) {
                        if (btn === 'yes') {
                            alert('Logged Out!')
                        }
                    }
                });
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
        var gridPanel = Ext.getCmp('GenreAll');

        gridPanel.setTitle(cat.text);
        store.clearFilter();
        grid.getView().refresh();
        if(cat.text == 'All Books'){
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

    enableCategories: function() {
        var menu = Ext.getCmp('CategoriesMenu');
        Ext.each(menu.items.items,function(item){
           if(item.xtype=='menuitem'){
               item.enable();
           }
        });
    },

    getOrderValues: function() {
        var store = Ext.getStore('OrderStore');
        var userid = Ext.getCmp('OrderUId').getValue();
        var username = Ext.getCmp('OrderUName').getValue();
        var bookid = Ext.getCmp('OrderBId').getValue();
        var booktitle = Ext.getCmp('OrderBTitle').getValue();
        var bookprice = Ext.getCmp('OrderBPrice').getValue();
        var bookquantity = Ext.getCmp('OrderBQty').getValue();
        var booktotal = Ext.getCmp('OrderBTotal').getValue();
        var remarks = Ext.getCmp('OrderRemarks').getValue();
        var date = Ext.getCmp('OrderDate').getValue();


        if (store.getCount() > 0)
        {
            var maxId = store.getAt(0).get('id'); // initialise to the first record's id value.
            store.each(function(rec) // go through all the records
                       {
                           maxId = Math.max(maxId, rec.get('id'));
                       });
        }

        id = maxId + 1;

        var order = {
                            id: id,
                            userid: userid,
                            username: username,
                            bookid: bookid,
                            booktitle: booktitle,
                            bookprice: bookprice,
                            bookquantity: bookquantity,
                            booktotal: booktotal,
                            remarks: remarks,
                            date: date
                  };

        return order;
    },

    setOrderValues: function(order) {

                Ext.getCmp('OrderId').setValue(order.id);
                Ext.getCmp('OrderUId').setValue(order.userid);
                Ext.getCmp('OrderUName').setValue(order.username);
                Ext.getCmp('OrderBId').setValue(order.bookid);
                Ext.getCmp('OrderBTitle').setValue(order.booktitle);
                Ext.getCmp('OrderBPrice').setValue(order.bookprice);
                Ext.getCmp('OrderBQty').setValue(order.bookquantity);
                Ext.getCmp('OrderBTotal').setValue(order.booktotal);
                Ext.getCmp('OrderRemarks').setValue(order.remarks);
                Ext.getCmp('OrderDate').setValue(order.date);
    },

    resetOrderValues: function() {

        Ext.getCmp('OrderId').setValue('');
        Ext.getCmp('OrderUId').setValue('');
        Ext.getCmp('OrderUName').setValue('');
        Ext.getCmp('OrderBId').setValue('');
        Ext.getCmp('OrderBTitle').setValue('');
        Ext.getCmp('OrderBPrice').setValue('');
        Ext.getCmp('OrderBQty').setValue('');
        Ext.getCmp('OrderBTotal').setValue('');
        Ext.getCmp('OrderRemarks').setValue('');
        Ext.getCmp('OrderDate').setValue('');

    },

    getOrderInfo: function(checkout) {
        var store = Ext.getStore('OrderStore');
        var userid = 0;
        var username = 'Test';
        var bookid = Ext.getCmp('BookWinId').getValue();
        var booktitle = Ext.getCmp('BookWinTitle').getValue();
        var bookprice = Ext.getCmp('BookWinPrice').getValue();
        var bookquantity = 1;
        var booktotal = Ext.getCmp('BookWinPrice').getValue();
        var remarks = 'Default';
        var date = (new Date()).toDateString();

        if(checkout){
            renarks = 'Check-out';
        }
        if (store.getCount() > 0)
        {
            var maxId = store.getAt(0).get('id'); // initialise to the first record's id value.
            store.each(function(rec) // go through all the records
                       {
                           maxId = Math.max(maxId, rec.get('id'));
                       });
        }

        id = maxId + 1;

        var order = {
                            id: id,
                            userid: userid,
                            username: username,
                            bookid: bookid,
                            booktitle: booktitle,
                            bookprice: bookprice,
                            bookquantity: bookquantity,
                            booktotal: booktotal,
                            remarks: remarks,
                            date: date
                  };

        return order;
    },

    openOrderWin: function(record) {
        var price, bestseller;
        if(Ext.isEmpty(this.orderWin)){
            this.orderWin = Ext.create('W3D5_Project.view.OrderWin', {});
        }
        this.orderWin.show();
        this.orderWin.unmask();
        if(record.data.avail>0){
            if(record.data.onsale){
            price = record.data.sprice;
            }else{
            price = record.data.oprice;
            }
            Ext.getCmp('BuyBtn').enable();
            Ext.getCmp('CheckBtn').enable();
        }else if(record.data.check>0){
            price = 'Checked-out';
            Ext.getCmp('BuyBtn').disable();
            Ext.getCmp('CheckBtn').disable();
        }else{
            price = 'Out of stock';
            Ext.getCmp('BuyBtn').disable();
            Ext.getCmp('CheckBtn').disable();
        }
        if(record.data.bestseller){
            bestseller = 'Best Seller';
        }else{
            bestseller = '';
        }
        Ext.getCmp('BookWinImg').setSrc('resources/img/' + record.data.img +'.jpg');
        Ext.getCmp('BookWinId').setValue(record.data.id);
        Ext.getCmp('BookWinTitle').setValue(record.data.title);
        Ext.getCmp('BookWinAuthor').setValue(record.data.author);
        Ext.getCmp('BookWinDate').setValue(record.data.date);
        Ext.getCmp('BookWinDesc').setValue(record.data.desc);
        Ext.getCmp('BookWinPrice').setValue(price);
        Ext.getCmp('BookWinBest').setValue(bestseller);
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
            },
            "#AllBooksCat": {
                click: this.onAllBooksCatClick
            },
            "#ConfigOrderGrid": {
                selectionchange: this.onConfigOrderGridSelectionChange
            },
            "#OrderReset": {
                click: this.onOrderResetClick
            },
            "#OrderCreate": {
                click: this.onOrderCreateClick
            },
            "#OrderUpdate": {
                click: this.onOrderUpdateClick
            },
            "#OrderDelete": {
                click: this.onOrderDeleteClick
            },
            "#BooksGrid": {
                celldblclick: this.onBooksGridCellDblClick
            },
            "#OSearchBtn": {
                click: this.onOSearchBtnClick
            },
            "#OResetBtn": {
                click: this.onOResetBtnClick
            },
            "#BuyBtn": {
                click: this.onBuyBtnClick
            },
            "#CancelBtn": {
                click: this.onCancelBtnClick
            },
            "#CheckBtn": {
                click: this.onCheckBtnClick
            },
            "#BestBooksGrid": {
                celldblclick: this.onBestBooksGridCellDblClick
            },
            "#SaleBooksGrid": {
                celldblclick: this.onSaleBooksGridCellDblClick
            },
            "#LogOutBtn": {
                click: this.onLogOutBtnClick
            }
        });
    }

});
