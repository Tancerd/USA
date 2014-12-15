[#ftl/] [#import "/spring.ftl" as spring /]
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
			<th>Status</th>
			<th>Frakcja</th>
			<th>Mistrz gry</th>
			<th>Funkcje</th>
		</tr>

		[#list characters as character]

			<tr>
			<td>${character_index + 1}</td>
			<td>${character.name}</td>
			<td>${character.briefing.briefingStatus}</td>
			<td>${character.briefing.fraction}</td>
			<td>[#if character.briefing.gameMaster??]${character.briefing.gameMaster.email}[/#if]</td>
			<td><a href = "character-edit.htm?id=${character.id}">Edytuj</a></td>
			</tr>

		[/#list]

	</table>

</body>

</html>
