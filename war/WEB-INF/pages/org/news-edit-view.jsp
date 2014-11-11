[#ftl/]
[#import "/spring.ftl" as spring /]
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>U.S.A. - news</title>
</head>

<body>

	<h3><center>News ${news.title}</center></h3>

<form method="POST">
	<div>
		<p><input type="submit" value="   Zapisz   " />
		<input type="button" onClick="parent.location='news-list.htm'" value="Wróć"/></p>
		
	</div>

	<div class = "grip">
		<div class="tagBox userView">

			[@spring.bind "news.id" /]
			<input type="hidden" name="${spring.status.expression}" 
							value="${spring.status.value?default("")}" />

			[@spring.bind "news.title" /]
			<p><label>Tytuł: </label>
			<textarea name="${spring.status.expression}" 
				value="${spring.status.value?default("")}" >${spring.status.value?default("")}</textarea></p>

			[@spring.bind "news.content" /]
			<p><label>Treść: </label>
			<textarea name="${spring.status.expression}" 
				value="${spring.status.value?default("")}" >${spring.status.value?default("")}</textarea></p>

			

		</div>
	</div>

</form>

</body>

</html>
