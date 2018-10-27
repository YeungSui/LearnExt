<@c.shared title="test js load up" cssList=["test/test.css"] prioJsList=["market/userdetails/public/gridPanel.js"] jsList=["test/test.js"] >
	<script>
		Ext.onReady(function(){
			var data = [[1,'user1','no1'],[2,'user2','no2']];
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
					{xtype:'userdetailsgrid',
					region:'center',
					title:'data grid',
					height:'400',
					width:'300',
					mdata:data}]
			});
		});
	</script>
</@c.shared>