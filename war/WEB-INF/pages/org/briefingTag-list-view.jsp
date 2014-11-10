<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>U.S.A. - List tagów</title>
</head>

<body>

	<h3><center>Lista tagów</center></h3>

	<input type="button" onClick="parent.location='briefingTag-edit.htm'" value="Nowy" />

	<table class = "hoverTable">
		<tr>
			<th>Lp</th>
			<th>Identyfikator</th>
			<th>Opis</th>
			<th>Funkcje</th>
		</tr>

		<#list tags as tag>

			<tr>
			<td>${tag_index + 1}</td>
			<td>${tag.identifier}</td>
			<td>${tag.description}</td>
			<td><a href = "briefingTag-edit.htm?id=${tag.id}">Edytuj</a></td>
			</tr>

		</#list>

	</table>

</body>

</html>
