/*外部依赖：
1.变量rootPath，来源common.ftl定义的公共变量
*/
GridAndStoreCfg = function() {
	//configure jsonStore, columnmodel
	// suffix 'Jsc' for jsonStoreCfg, 'Cmc' for columnModelCfg
	return {
		getUserDetailsListJsc: function() {
			var fields = [{name:'uid',type:'int'},'uname','udescription'];
			var url = rootPath +'/test/getuserdetailslist';
			var rootName = 'userDetails';
			var totalProperty = 'userDetailsCount';
			var jsonStoreConfig = {fields:fields, url:url, root:rootName, totalProperty:totalProperty};
			return jsonStoreConfig;
		},
		getUserDetailsListCmc: function() {
			var columns = [{index:'id', header:'user id', dataIndex:'uid', sortable:'true'},
							{header:'user name', dataIndex:'uname'},
							{header:'user description', dataIndex:'udescription'}];
			var defaultCfg = {sortable:false, width:100};
			return new Ext.grid.ColumnModel({
				default:defaultCfg,
				columns:columns
			});
		}
		//add other get... function here
	}
}();