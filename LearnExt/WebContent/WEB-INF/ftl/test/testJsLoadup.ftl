<@c.shared title="test js load up" cssList=["test/test.css"] jsList=["test/test.js"]>
	<script>
		Ext.onReady(function(){
			var data = new Array
			var dataRecord = Ext.data.Record.create([
							{name:'id',type:'int'},
							{name:'name', type:'string'},
							{name:'description','type':'string'}]);
			var data = [[1,'user1','no1'],[2,'user2','no2']];
			var dataStore = new Ext.data.Store({
							proxy:new Ext.data.MemoryProxy(data),
							reader:new Ext.data.ArrayReader({},dataRecord),							
							sortInfo:{'field':'name','direction':'DESC'}});
			dataStore.load();
			var columns = [{id:'id', header:'user id', sortable:true, dataIndex:'id'},
							{header:'user name', dataIndex:'name'},
							{header:'user description', dataIndex:'description'}];
			var colModel = new Ext.grid.ColumnModel({
							defaults:{
								width:100,
								sortable:true
							},
							columns: columns});
			var view = new Ext.Viewport({
				layout:"border",
				title:"Main Frame",
				height:"400",
				autoWidth:'true',
				items:[
					{xtype:'treepanel',
					region:'west',
					title:'tree',
					root:{id:'root', text:'root'},
					height:'400',
					width:'100'},
					{xtype:'grid',
					region:'center',
					title:'data grid',
					height:'400',
					width:'300',
					colModel:colModel,
					store:dataStore}]
			});
		});
	</script>
</@c.shared>