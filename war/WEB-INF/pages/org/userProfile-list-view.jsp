<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>U.S.A. - List użytkowników</title>
</head>

<body>

	<h3><center>Lista profili użytkowników</center></h3>

	<table class = "hoverTable">
		<tr>
			<th>Lp</th>
			<th>Imię</th>
			<th>Nazwisko</th>
			<th>Nick</th>
			<th>Data urodzenia</th>
			<th>Funkcje</th>
		</tr>

		<#list profiles as profile>

			<tr>
			<td>${profile_index + 1}</td>
			<td>${profile.name}</td>
			<td>${profile.lastname}</td>
			<td>${profile.nick}</td>
			<td>${profile.birthDate}</td>
			<td><a href = "userProfile-edit.htm?id=${profile.id}">Edytuj</a></td>
			</tr>
	
		</#list>

	</table>

</body>

</html>
