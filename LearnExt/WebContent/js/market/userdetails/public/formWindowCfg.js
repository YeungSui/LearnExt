//下一步 function(string operation, id), 一个函数完成对应的请求
userDetailsCrudFormCfg = function() {
	return {
		getCreatFormCfg: function() {
			//表单元素
			var fields = [{label:'user name', dataIndex: 'uname', maxLength:20, type:'text'},{label:'user description', dataIndex:'udescription', type:'text'}];
			//提交地址
			var postUrl = rootPath+'/test/addUserDetails';
			return {
				formMode:'create',
				fields:fields,
				postUrl:postUrl
			};
		},

		getViewUserFormCfg: function() {
			fields = [{label:'user id', dataIndex:'uid', type:'number'},{label:'user name', dataIndex: 'uname', type:'text'}, {label:'user description', dataIndex:'udescription', type:'text'}];
			return {
				formMode:'view',
				fields:fields,
			};
		},

		getModifyUserFormCfg: function() {
			var postUrl = rootPath+'/test/updateUserDetails';
			var fields = [{label:'user id', dataIndex:'udi', type:'number',readOnly:true},{label:'user name', dataIndex: 'uname', type:'text'}, {label:'user description', dataIndex:'udescription', type:'text'}];
			return {
				formMode:'modify',
				fields:fields,
				postUrl:postUrl
			};
		}
	}
}();