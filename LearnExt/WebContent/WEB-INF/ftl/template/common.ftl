<#macro shared title cssList jsList>
	<#global prefix="${request.contextPath}">
	<#global iconPath="${prefix}/image/icon">
	<!DOCTYPE html PUBLIC="-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhml1/DTD/xhtml1-transitional.dtd">
	<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=11, IE=8, Chrome=1">

		<title>${title}</title>
		
		<link rel="stylesheet" type="text/css" href="${prefix}/widget/extjs/resources/css/ext-all.css"/>
		<#list cssList as cssName>
		<link rel="stylesheet" type="text/css" href="${prefix}/css/${cssName}"/>
		</#list>
		
		<script>
			document.write("<script id=\"ext-base.js\" src=\"${prefix}/widget/extjs/adapter/ext/ext-base.js\"></script" + ">");
			document.write("<script id=\"ext-all.js\" src=\"${prefix}/widget/extjs/ext-all.js\"></script" + ">");
			document.write("<script id=\"jquery.min.js\" src=\"${prefix}/widget/jquery.min.js\"></script" + ">");
		</script>
	</head>
	
	<body leftmargin="0" rightmargin="0" bottommargin="0" topmargin="0" marginheight="0" marginwidth="0" scroll="no" onload="renderLoaded()">
		<!--此处可写一个div用于显示等待加载图标和说明-->
		<!--写一个js函数定义，用于移除上面的div元素，该函数作为body元素onload事件的回调函数-->
		<script>
			renderLoaded = function() {
				console.log("page loaded");
				}
		</script>
		<!--可继续写脚本用于设置ext的各种参数，以优化性能、美化界面、提高兼容性等-->
		<!--还有包括一些公共变量-->
		<script>
			var rootPath = '${request.contextPath}';
		</script>
		<!--此处嵌入模板自定义的内容-->
		<#nested/>
		<!--jsList里所有自定义的js可以放在最后加载-->
		<script>
			<#list jsList as jsName>
			document.write("<script id=\"${jsName}\" scr=\"${prefix}/js/${jsName}\"></script" + ">");
			</#list>
		</script>
	</body>
	</html>
	</#macro>
			