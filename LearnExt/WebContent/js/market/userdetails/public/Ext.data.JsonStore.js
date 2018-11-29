//ext.data.store
...

//Ext.Data.JsonStore
/*主要参数如下：
	url:获取json数据的地址
	fields:以数组形式描述json数据中有哪些字段，对于String类型的字段名直接写即可，对于其他类型需要以{name:'',type:''}形式指明
	storeId:该jsonStore的id，可以随便取
	root:包含要解析的数据的字段名
	totalProperty:包含数据条数的字段名
*/
//假设获得的json为：{dataField:[{id:1,notes:'one',category:'number'},{...},...], total:100}
//以下为个别参数的示例
fields:[{name:'id', type:'int'}, 'notes', 'category'],
root:dataField,
totalProperty:'total'

//设置好JsonStore参数后，需要装载数据，可以通过设置autoLoad自动加载? 也可以使用load()方法加载
jsonStore.load();
//load方法有几个可选参数，其中包括callback参数，用于设置回调函数，回调时会提供3个参数
//r代表record(可以当做获取到的数据),options代表jsonStore的参数，success表示load过程是否成功
jsonStore.load({
	callback: function(r, options, success){
		...;
	}
})