<@c.autoload cssList=["commonForm.css"] jsList=[]>
<div class="formOutline" style="height:500px">
<div class="formTitle">${details.userName}</div>
<div class="formTable">
	<#assign keys=details?keys>
	<#assign count=0>
	<#assign total=0>
	<div class="formBox Normal">
		<#list keys as key>
		<#assign total=total+1>
		<#if details[key]?? && !details[key]?is_method>
			<#assign count = count+1>
		<div class="formLabel">${key?replace("user","")}</div>
		<div class="formField" id="f_u${key?replace("user","")}">${details[key]}</div>
			<#if count%2==0 || total==keys?size>
	</div>
			</#if>
			<#if count%2==0 && total!=keys?size>
	<div class="formBox Normal">
			</#if>
		</#if>
		</#list>
</div>
</@c.autoload>
