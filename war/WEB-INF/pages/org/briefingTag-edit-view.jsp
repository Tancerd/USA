[#ftl/]
[#import "/spring.ftl" as spring /]
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>U.S.A. - tag</title>
</head>

<body>

	<h3><center>Tag ${tag.description}</center></h3>

<form method="POST">
	<div>
		<p><input type="submit" value="   Zapisz   " />
		<input type="button" onClick="parent.location='briefingTag-list.htm'" value="Wróć"/>
	</div>

	<div class = "grip">
		<div class="tagBox userView">

			[@spring.bind "tag.id" /]
			<input type="hidden" name="${spring.status.expression}" 
							value="${spring.status.value?default("")}" />

			[@spring.bind "tag.identifier" /]
			<p><label>Identyfikator: </label>
			<input type="text" class="inputText" name="${spring.status.expression}" 
				value="${spring.status.value?default("")}" />
				<span style="color : red">[@spring.showErrors "<br>" /]</span></p>

			[@spring.bind "tag.description" /]
			<p><label>Opis: </label>
			<textarea name="${spring.status.expression}" 
				value="${spring.status.value?default("")}" >${spring.status.value?default("")}</textarea>
				<span style="color : red">[@spring.showErrors "<br>" /]</span></p>

			[@spring.bind "tag.text" /]
			<p><label>Tekst: </label>
			<textarea name="${spring.status.expression}" 
				value="${spring.status.value?default("")}" >${spring.status.value?default("")}</textarea>
				<span style="color : red">[@spring.showErrors "<br>" /]</span></p>

		</div>
	</div>

</form>

</body>

</html>
