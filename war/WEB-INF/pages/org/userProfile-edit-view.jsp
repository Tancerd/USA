[#ftl/]
[#import "/spring.ftl" as spring /]
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>U.S.A. - Profil użytkownika</title>
</head>

<body>

	<h3><center>Profil użytkownika ${profile.name} ${profile.lastname}</center></h3>

	<form method="POST">
		<table>
			<tr>
				[@spring.bind "profile.name" /]
				<td>Imię: </td>
				<td><input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" /></td>
			</tr>
			<tr>
				[@spring.bind "profile.lastname" /]
				<td>Nazwisko:</td>
				<td><input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" /></td>
				</tr>
			<tr>
				[@spring.bind "profile.nick" /]
				<td>Nick:</td>
				<td><input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="   Zapisz   " /></td>
			</tr>
		</table>
	</form>

</body>

</html>
