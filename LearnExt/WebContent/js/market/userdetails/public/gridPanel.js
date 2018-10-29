/**
 * Customized Ext.grid.GridPanel for user details display
 */
console.log("customized gridpanel loading");
Ext.namespace("market.userdetails");

market.userdetails.UserDetailsGrid = Ext.extend(Ext.grid.GridPanel, {
	constructor: function(cfg) {
		var url = rootPath+"/test/getuserdetailslist";
		var fields = [{name:'id',type:'int'},'name','description'];
		// Define row data model
		/*var record = Ext.data.Record.create([
			{name:'id',type:'int'},
			{name:'name',type:'string'},
			{name:'description',type:'string'}
		]);*/
		var jsonStore = new Ext.data.JsonStore({
			autoDestroy:true,
			url:url,
			storeId:'userDetailsListStore',
			root:'userDetails',
			totalProperty:'userDetailsCount',
			fields:fields
		});
		/*var store = new Ext.data.Store({
			proxy:new Ext.data.HttpProxy(url),
			reader:new Ext.data.ArrayReader({},record),
			sortInfo:{field:'name',direction:'DESC'}
		})*/
		jsonStore.load();
		// Define columns params
		var columns = [{index:'id',header:'user id', sortable:true, dataIndex:'id'},
				{header:'user name', dataIndex:'name'},
				{header:'user description',dataIndex:'description'}];
		var colModel = new Ext.grid.ColumnModel({
			default:{
				width:100,
				sortable:false
			},
			columns:columns
		});
		// Set up a configuration
		config = Ext.apply({
			store: jsonStore,
			colModel: colModel
		}, cfg);
		// Call super class constructor
		market.userdetails.UserDetailsGrid.superclass.constructor.call(this, config);
	}
});
Ext.reg('userdetailsgrid',market.userdetails.UserDetailsGrid);
console.log("customized grid panel loaded");