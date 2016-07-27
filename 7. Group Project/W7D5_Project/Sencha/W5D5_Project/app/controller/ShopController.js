/*
 * File: app/controller/ShopController.js
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

Ext.define('W5D5_Project.controller.ShopController', {
    extend: 'Ext.app.Controller',

    id: 'shopController',

    addProductsToPage: function(pageName) {
        var items = [],
            store = Ext.getStore('ProductStore'),
            pageItemsList = [], pageItems = {}, page = 1,
            prodList = [], pageCtr = 1, part = 1,
            prod = [], partCtr = 1, partCnt, partRem;

        Ext.each(store.data.items, function(rec) {
            if (rec.data.prodCat.toUpperCase() == pageName.toUpperCase()) {
                items.push(rec);
            }
        });

        var itemSize = items.length;
        if (itemSize === 0) {
            return;
        }
        var pageCount = Math.ceil(itemSize / 9);
        var pageSize = [];

        for (var x = 1; x <= pageCount; x++) {
            if (x != pageCount) {
                pageSize.push(9);
            } else {
                pageSize.push(itemSize - (9 * (pageCount - 1)));
            }
        }

        partCnt = Math.ceil(pageSize[0] / 3);
        partRem = pageSize[0] % 3;
        for (var x = 0; x < items.length; x++) {
            if (partRem !== 0) {
                if (part == partCnt && partCtr <= partRem) {
                    prod.push(items[x]);
                    partCtr++;
                    if (partCtr > partRem) {
                        prodList.push({
                            'part' : part,
                            'prod' : prod
                        });
                        part++;
                        partCtr = 1;
                        prod = [];
                        if (part > partCnt) {
                            pageItemsList.push({
                                'page' : page,
                                'prod' : prodList
                            });
                            page++;
                            prodList = [];
                            partCnt = Math.ceil(pageSize[page - 1] / 3);
                            partRem = pageSize[page - 1] % 3;
                        }
                    }
                } else if (part < partCnt && partCtr <= 3) {
                    prod.push(items[x]);
                    partCtr++;
                    if (partCtr > 3) {
                        prodList.push({
                            'part' : part,
                            'prod' : prod
                        });
                        part++;
                        partCtr = 1;
                        prod = [];
                        if (part > partCnt) {
                            pageItemsList.push({
                                'page' : page,
                                'prod' : prodList
                            });
                            page++;
                            prodList = [];
                            partCnt = Math.ceil(pageSize[page - 1] / 3);
                            partRem = pageSize[page - 1] % 3;
                        }

                    }
                }
            } else {
                if (part <= partCnt && partCtr <= 3) {
                    prod.push(items[x]);
                    partCtr++;
                    if (partCtr > 3) {
                        prodList.push({
                            'part' : part,
                            'prod' : prod
                        });
                        part++;
                        partCtr = 1;
                        prod = [];
                        if (part > partCnt) {
                            pageItemsList.push({
                                'page' : page,
                                'prod' : prodList
                            });
                            page++;
                            prodList = [];
                            partCnt = Math.ceil(pageSize[page - 1] / 3);
                            partRem = pageSize[page - 1] % 3;
                        }
                    }
                }
            }
        }
        console.log(pageItemsList);

        for (var x = 1; x <= pageItemsList.length; x++) {
            for (var y = 1; y <= pageItemsList[x-1].prod.length; y++) {
                for(var z = 1; z<=pageItemsList[x-1].prod[y-1].prod.length; z++){
                    var panel = Ext.getCmp(pageName+'Page'+y),
                        item = pageItemsList[x-1].prod[y-1].prod[z-1],
                        qitems = panel.items.length,
                        pagetemplate = Ext.create('ProductTemplate', {
                            qid : qitems
                        });
                    pagetemplate.items.items[0].items.items[0].setSrc('resources/img/'+item.data.prodImg+'.png');
                    pagetemplate.items.items[0].items.items[1].setValue(item.data.prodId);
                    pagetemplate.items.items[0].items.items[2].setValue(item.data.prodName);
                    var price=item.data.prodPrice, special='';
                    if(item.data.prodSale!='1'){
                        price=item.data.prodSale*item.data.prodPrice;
                        special=' (On Sale)';
                    }
                    if(item.data.prodStock=='0'){
                        special=' (Out of Stock)';
                    }

                    pagetemplate.items.items[0].items.items[3].setValue('RMB '+price);
                    if(special!==''){
                        pagetemplate.items.items[0].items.items[3].setValue('RMB '+price + special);
                    }
                    pagetemplate.items.items[0].recordData = item.data;
                    //             pagetemplate.items.items[0].recordData.prodStock = 1;
                    pagetemplate.items.items[0].recordData.prodSubtotal = price;

                    var faveStore = Ext.getStore('FavoriteItemsStore'),
                        isExists = false;
                    for(var i = 0; i < faveStore.data.items.length; i++){
                        var rec = faveStore.data.items[i];
                        if(rec.data.prodId==item.data.prodId){
                            isExists=true;
                        }
                    }
                    if(isExists){
                        pagetemplate.items.items[0].items.items[5].removeCls('addToFaveBtnCls');
                        pagetemplate.items.items[0].items.items[5].addCls('addToFaveBtnPinkCls');
                    }else{
                        pagetemplate.items.items[0].items.items[5].removeCls('addToFaveBtnPinkCls');
                        pagetemplate.items.items[0].items.items[5].addCls('addToFaveBtnCls');
                    }
                    panel.add(pagetemplate);
                    panel.doLayout();
                }
            }
        }

    },

    createProduct: function(record) {
        var testPanel=Ext.getCmp('testPanel'),
        qitems = testPanel.items.length,
        testtemplate = Ext.create('ProductTemplate', {
        qid: qitems
        });
        console.log(qitems);
        testPanel.add(testtemplate);
        testPanel.doLayout();
    },

    clearItems: function() {
        var f, fields=[];
        fields.push(Ext.getCmp('digitalPage1'));
        fields.push(Ext.getCmp('digitalPage2'));
        fields.push(Ext.getCmp('digitalPage3'));
        fields.push(Ext.getCmp('luxuryPage1'));
        fields.push(Ext.getCmp('luxuryPage2'));
        fields.push(Ext.getCmp('luxuryPage3'));
        fields.push(Ext.getCmp('casualPage1'));
        fields.push(Ext.getCmp('casualPage2'));
        fields.push(Ext.getCmp('casualPage3'));
        fields.push(Ext.getCmp('sportsPage1'));
        fields.push(Ext.getCmp('sportsPage2'));
        fields.push(Ext.getCmp('sportsPage3'));
        fields.push(Ext.getCmp('dressPage1'));
        fields.push(Ext.getCmp('dressPage2'));
        fields.push(Ext.getCmp('dressPage3'));
        Ext.each(fields,function(field){
            while(!Ext.isEmpty(field.items.first())){
              field.remove(field.items.first(), true);
            }
        });

    }

});
