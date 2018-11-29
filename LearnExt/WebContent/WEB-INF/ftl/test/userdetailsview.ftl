<@c.autoload cssList=["commonForm.css"] jsList=[]>
<div class="formOutline" style="height:500px">
<div class="formTitle">${details.userName}</div>
<div class="formTable">
	<div class="formBox Normal">
		<div class="formLabel">ID</div><div class="formField" id="f_uid">${details.userId}</div>
		<div class="formLabel">Name</div><div class="formField" id="f_uname">${details.userName}</div>
	</div>
	<div class="formBox Normal">
		<div class="formLabel">Description</div><div class="formField" id="f_udecription">${details.userDescription}</div>
		<div class="formLabel">Nation</div><div class="formField" id="f_unationality">${details.userNationality}</div>
	</div>
</div>
</@c.autoload>
