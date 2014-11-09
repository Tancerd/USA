<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>U.S.A. - List postaci</title>
</head>

<body>

	<h3><center>Lista postaci</center></h3>

	<table class = "hoverTable">
		<tr>
			<th>Lp</th>
			<th>Imię</th>
			<th>Funkcje</th>
		</tr>

		<#list characters as character>

			<tr>
			<td>${character_index + 1}</td>
			<td>${character.name}</td>
			<td>Edytuj</td>
			</tr>
	
		</#list>

	</table>

</body>

</html>
