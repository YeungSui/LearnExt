//获取提示框
getCrudFormPopUpWindows = function() {
	return {
		getResultWin:function(result,msg) {
			return new Ext.Window({
				title:result,
				height: 100,
				width: 200,
				html:'<p>'+result+'</p><p>'+msg+'</p>'
			});
		}
	}
}();
//提交结果相应的字符串
CATE_RESULT = function() {
	return {
		SUCCESS:'success',
		FAILURE:'failure'
	}
}();
//获取表单按钮
getCrudFormButtons= function() {
	return {
		getCreateFormSaveButton: function(url,params) {
			return new Ext.Button({
				text:'save',
				handler:function(){
					var form = this.up('form').getForm();
					if (form.isValid()){
						form.submit({
							url:url,
							params:param,
							success:function(form,action){
								var result = CATE_RESULT.SUCCESS;
								var sw = getCrudFormPopUpWindows.getResultWin(result,action.result.msg);
								var parent = this.up('form').findParentByType("window");
								//添加提示窗关闭监听，提示窗关闭后，关闭包含表单的窗口
								sw.addListener('close',function(){
									this.close();
								},parent);
								sw.show();
							},
							failure:function(form, action){
								var result = CATE_RESULT.FAILURE;
								getCrudFormPopUpWindows.getResultWin(result,action.result.msg).show();
							}
						});
					}
				}
			});
		},
		getUpdateFormSaveButton:function(url,params){
			return new Ext.Button({
				text:'save',
				handler:function(){
					var form = this.up('form').getForm();
					if (form.isValid()){
						form.submit({
							url:url,
							params:params,
							success:function(form,action){
								var result = CATE_RESULT.SUCCESS;
								getCrudFormPopUpWindows.getResultWin(result,action.result.msg).show();
							},
							failure:function(form, action){
								var result = CATE_RESULT.FAILURE;
								getCrudFormPopUpWindows.getResultWin(result,action.result.msg).show();
							}
						});
					}
				}
			});
		},
		getConfirmButton:function() {
			return new Ext.Button({
				text:'ok',
				handler:function(){
					//关闭包含表单的窗口
					this.up('form').findParentByType('window').close();
				}
			});
		},
		getCreateFormSAddButton:function() {
			return new Ext.Button({
				text:'add',
				handler:function(){
					//清空表单所有值
					//todo:如何保留初始值
					this.up("form").getForm().reset();
				}
			})
		}
	}
}();

Ext.namespace('com.info.market');
//构造formpanel
/*配置参数
* 必须：form提交地址postUrl, form域(formFields)的label,dataIndex
* 可选：max/minLength/Value,allowBlank，form的加载地址loadUrl(可用该属性区分增加和删改操作)
*/
com.info.market.CrudForm = Ext.extend(Ext.form.FormPanel,{
	constructor: function(cfg) {
		console.log('log');
		console.log(cfg);
		var formMode = cfg.formMode;
		var formReadOnly =  formMode =='view';
		var formFields = [];
		var fields = (typeof cfg.fields == 'undefined') ? []:cfg.fields;
		//根据配置参数type创建对应的表单域
		for (var i = 0; i < fields.length; i++) {
			var readOnly = (typeof fields[i].readOnly == 'undefined') ? formReadOnly: fields[i].readOnly;
			var fieldCfg = {
				width:80,
				allowBlank:false,
				blankText:fields[i].label+' cannot be empty',
				readOnly:readOnly,
				fieldLabel:fields[i].label,
				name:fields[i].dataIndex
			}
			switch (fields[i].type) {
				//textfield
				case 'text':
					var maxLength = (typeof fields[i].max == 'undefined') ? 255:fields[i].max;
					fieldCfg['maxLength'] = maxLength;
					fieldCfg['maxLengthText'] = 'input limits '+maxLength+' characters';
					var minLength = (typeof fields[i].min == 'undefined') ? 0:fields[i].min;
					fieldCfg['minLength'] = minLength;
					fieldCfg['minLengthText'] = 'input at least '+minLength+' characters';
					formFields[i] = new Ext.form.TextField(fieldCfg);
					break;
				case 'date':
					break;
				//numberfield
				case 'number':
					fieldCfg['maxValue'] = (typeof fields[i].min == 'undefined') ? 0:fields[i].min;
					fieldCfg['minValue'] = (typeof fields[i].max == 'undefined') ? 4250000000:fields[i].max;
					formFields[i] = new Ext.form.NumberField(fieldCfg);
					break;
			}
		}
		var end = formFields.length;
		console.log('form fields length:');
		console.log(formFields.length);
		var params = (typeof cfg.params == 'undefined') ? cfg.params:{};
		switch(formMode) {
			case 'create':
				formFields[end++] = getCrudFormButtons.getCreateFormSAddButton();
				formFields[end] = getCrudFormButtons.getCreateFormSaveButton(cfg.postUrl,params);
				formFields[end++] = getCrudFormButtons.getConfirmButton();
			case 'view':
				formFields[end++] = getCrudFormButtons.getConfirmButton();
			case 'modify':
				formFields[end++] = getCrudFormButtons.getUpdateFormSaveButton(cfg.postUrl,params);
				formFields[end++] = getCrudFormButtons.getConfirmButton();
		}
		var configuration = Ext.apply({items:formFields}, cfg);
		com.info.market.CrudForm.superclass.constructor.call(this, configuration);
	}
	
});
Ext.reg('crudform',com.info.market.CrudForm);