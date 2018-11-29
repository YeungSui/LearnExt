/*获取showuserdetails的crudpanel
* 需要先加载crudPanel.js, crudForm.js
*/
ThisPageCrudPanel = function() {
	var selectId = null;
	getFormWin = function(winType, selectId) {
		console.log('form configuring');
		//表单配置
		var formCfg = {
			formMode:winType
		};
		switch(winType) {
			case 'create':
				formCfg['postUrl'] = rootPath+'/test/adduserdetails';
				formCfg['fields'] = [{label:'user name', dataIndex: 'uname', maxLength:20, type:'text'},
					{label:'user description', dataIndex:'udescription', type:'text'}];
				formCfg['title'] = 'Create User';
				break;
			case 'view':
				formCfg['fields'] = [{label:'user id', dataIndex:'uid', type:'number'},
					{label:'user name', dataIndex: 'uname', type:'text'}, 
					{label:'user description', dataIndex:'udescription', type:'text'}];
				formCfg['title'] = 'User Details';
				break;
			case 'modify':
				formCfg['fields'] = [{label:'user id', dataIndex:'uid', type:'number',readOnly:true},
					{label:'user name', dataIndex: 'uname', type:'text'},
					{label:'user description', dataIndex:'udescription', type:'text'}];
				formCfg['postUrl'] = '/test/updateuserdetails';
				formCfg['title'] = 'Modify User Details';
				break;

			case 'delete':
				formCfg = null;
				break;
		}
		if (formCfg) {
			console.log('creating window');
			var crudForm = new com.info.market.CrudForm(formCfg);
			new Ext.Window({
				title: winType,
				height:400,
				items:crudForm
			}).show();
			if (winType != 'create' && (typeof selectId != 'undefine') && selectId != null) {
				crudForm.getForm().load({
					url:rootPath+'/test/getuserdetails',
					waitMsg:'Loading...',
					params:{'uid':selectId},
					failure:function(form, action){
						alert('failed to load data');
					}
				});
			} else {
				//提示选择用户
			}
		} else {
			//弹出删除确认框，点击确认发送请求删除并自动关闭确认窗，删除操作后弹窗提示结果
		}
	};
	return {
		//获取crudpanel
		getCrudPanel:function(cfg) {
			var btnCfgs = [];
			btnCfgs[0] = {
				btnText:'new',
				handler:function(){
					console.log('new');
					getFormWin('create');
				}
			};
			btnCfgs[1] = {
				btnText:'view',
				handler:function(){
					getFormWin('view',selectId);
				}
			};
			btnCfgs[2] = {
				btnText:'modify',
				handler:function(){
					getFormWin('modify',selectId);
				}
			};
			
			cfg['panelCfgs'] = [{panelTitle:'normal',panelBtnCfgs:btnCfgs}];
			return new com.info.market.CrudPanel(cfg);
		},
		selectHandler:function(id) {
			selectId = id;
		},
		deSelectHandler:function() {
			selectId = null;
		}
	}
}();