crudPanel = function(){
	return {
		doView:function(uid){
			new Ext.Window({
				title:'view',
				id:"userViewWin",
				autoLoad:{
					url:rootPath+'/test/userdetailsview',
					method:'POST',
					params:{
						uid:uid
					},
					scripts:true,
					nocache:true,
					text:'Loading...',
					timeout:900,
					callback:function(el, success, response, options) {
						if(!success) {
							Ext.getCmp('userViewWin').update('<div style="padding:10px;color:#3399FF;font-weight:light;font-family:arial;font-size:18px">No record</div>');
						}
					}
				},
				width:800,
				height:500
			}).show();
		}
	};
}();