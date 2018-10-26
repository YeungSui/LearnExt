<@c.shared title="test js load up" cssList=["test/test.css"] jsList=["test/test.js"]>
	<script>
		Ext.onReady(function(){
			var view = new Ext.Viewport({
				layout:"border",
				title:"Main Frame",
				height:"400",
				autoWidth:'true',
				items:[{
				xtype:'treepanel',
				region:'center',
				title:'tree',
				root:{id:'root', text:'root'},
				height:'400',
				width:'100'}]
			});
		});
	</script>
</@c.shared>