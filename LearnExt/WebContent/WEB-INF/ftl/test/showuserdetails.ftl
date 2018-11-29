<@c.shared title="user details" cssList=[] 
								prioJsList=['market/userdetails/public/crudPanel.js'] jsList=[]>
	<script>
		Ext.onReady(function(){
			// 选中行数据
			var selectedRecord = null;
			var panel = new Ext.Panel(
			{
				renderTo:Ext.getBody(),
				layout:'border',
				autoWidth:true,
				height:'auto',
				id:'mainPanel',
				height:document.body.clientHeight,
				items:[{//中间gridpanel展示数据
					xtype:'grid',
					region:'center',
					width:400,
					height:'auto',
					title:'User Details',
					colModel:new Ext.grid.ColumnModel([
						new Ext.grid.RowNumberer({header:'No.', width:50}),
						{header:'User Id', width:80, dataIndex:'userId', sortable:true, id:'userDetails'},
						{header:'User Name', width:200, dataIndex:'userName', sortable:false},
						{header:'User Description', width:400, dataIndex:'userDescription', sortable:false}
					]),
					store:new Ext.data.Store({
						autoDestroy:true,
						url:rootPath+'/test/getuserdetailslist',
						reader:new Ext.data.JsonReader({
							idProperty:'userId',
							root:'userDetails',
							totalProperty:'userDetailsCount',
							fields:[{
								name:'userId'
							},{
								name:'userName'
							},{
								name:'userDescription'
							}]
						}),
						autoLoad:true
					}),
					sm:new Ext.grid.RowSelectionModel({
						listeners:{//行选中后设置selectedRecord
							'rowselect':function(sm, rowId, rec){
								console.log(rec);
								console.log(rowId);
								selectedRecord = rec;
							}
						}
					})
				},{//左侧树结构
					xtype:'treepanel',
					region:'west',
					height:'auto',
					title:'tree',
					autoScroll:true,
					root:new Ext.tree.AsyncTreeNode({
						expanded:false,
						text:'root'
					}),
					width:170
				},{//顶部选项卡
					xtype:'tabpanel',
					region:'north',
					height:50,
					activeTab:0,
					items:{
						xtype:'panel',
						height:'auto',
						title:'crud',
						layout:'column',
						items:[{
							xtype:'button',
							text:'add',
							height:'auto',
							handler:function(){

							}
						},{
							xtype:'button',
							text:'modify',
							height:'auto',
							handler:function(){}
						},{
							xtype:'button',
							text:'view',
							height:'auto',
							handler:function(){
								console.log('clicked');
								if (selectedRecord == null || selectedRecord.data == null || selectedRecord.data.userId == null) {
									new Ext.Window({
										title:'notice',
										html:'<div style="font-size:14px;width:200px;height:64px;display:table-cell;vertical-align:center;text-align:center">please select a user</p>',
										width:200,
										height:100
									}).show();
									return;
								}
								crudPanel.doView(selectedRecord.data.userId);
								console.log('click done');
							}
						},{
							xtype:'button',
							text:'delete',
							height:'auto',
							handler:function(){}
						}]
					}
				}]
			});
			window.onresize = resizePanel;
			function resizePanel() {
				if(panel == undefined || panel == null || panel.getHeight() == null) {
					return;
				}
				if (panel.getHeight() != document.body.clientHeight)
					panel.setHeight(document.body.clientHeight);
				if(panel.getWidth() == document.body.clientWidth)
					panel.setWidth(document.body.clientWidth);
			}
		});
	</script>	
</@c.shared>