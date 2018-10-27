<@c.shared title="user details" cssList=[] prioJsList=["market/userdetails/public/gridPanel.js"] jsList=[]>
	<script>
		Ext.onReady(function(){
			console.log("is data type of array: "+((data instanceof Array)?"yes":"no"));
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
					width:'300'}]
			});
		});
	</script>	
</@c.shared>