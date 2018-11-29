/**
 * Customized Ext.grid.GridPanel for user details display
 */
Ext.namespace("com.info.market");

com.info.market.GridPanelTemplate = Ext.extend(Ext.grid.GridPanel, {
    constructor: function(cfg) {
        //Todo: add config params to cfg.jsonStoreConfig
        var jsonStoreConfig = cfg.jsonStoreConfig;
        console.log(jsonStoreConfig);
        jsonStoreConfig['autoDestroy'] = true;
        //jsonstore
        var jsonStore = new Ext.data.JsonStore(cfg.jsonStoreConfig);
        //define callback function of jsonstore after record loaded
        jsonStore.load({
            callback: function(r, options, success) {
                if (success) {
                	console.log(r);
                    console.log("json recieved");
                } else {
                    alert("request failed");
                }
            }
        });
        //define colmodel of the gridpanel
        var colModel = cfg.colModel;
        // combine configurations
        config = Ext.apply({store: jsonStore, colModel: colModel, selModel:new Ext.grid.RowSelectionModel({singleSelect:true, width:100})}, cfg);
        // Call super class constructor, initialize the component with config
        com.info.market.GridPanelTemplate.superclass.constructor.call(this, config);
    },
    /*接口，为gridpanel的selModel添加事件监听
    * 参数：selectHandler, deSelectHandler
    */
    setSelectChangeHandler:function(selectHandler,deSelectHandler) {
        this.getSelectionModel().addListener('rowSelect', function() {
                console.log(this.getSelected());
                selectHandler(this.getSelected().data.uid);
            });
        this.getSelectionModel().addListener('rowDeSelect', function(){
            deSelectHandler();
        });
    }
});
Ext.reg('gpaneltemplate', com.info.market.GridPanelTemplate);