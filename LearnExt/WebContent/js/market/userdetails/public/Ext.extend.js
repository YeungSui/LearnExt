// 1.组件继承中，子组件的属性值传递
// 以子组件UserDetailsGrid及自定义属性mdata为例
UserDetailsGrid = Ext.extend(Ext.grid.GridPanel,{
	mdata:null,
	constructor: function(cfg) {
		...
	},
	...
});
// 创建子组件时：
new UserDetailsGrid({
	mdata:data
});

//子组件中需要mdata时可以用this.mdata获取
UserDetailsGrid = Ext.extend(Ext.grid.GridPanel,{
	mdata:null,
	constructor: function(cfg) {
		...
	},
	usemdata: function() {
		var a = this.mdata;
	},
	...
});
//但是constructor是例外，构造函数初始化组件时并未将mdata的值赋给this.mdata
//在constructor中需要使用cfg.mdata获取，其他配置的值类似，均可从构造函数参数cfg中获取
market.userdetails.UserDetailsGrid = Ext.extend(Ext.grid.GridPanel, {
	constructor: function(cfg) {
		cfg.mdata;
	}
});
//在constructor最后通过Ext.apply({},cfg)构建配置
config = Ext.apply({store: jsonStore,colModel: colModel}, cfg);
//然后调用父组件的构造函数进行初始化
market.userdetails.UserDetailsGrid.superclass.constructor.call(this, config);
		