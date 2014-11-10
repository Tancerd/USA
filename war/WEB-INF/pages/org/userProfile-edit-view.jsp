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
	<div>
		<p><input type="submit" value="   Zapisz   " />
		<input type="button" onClick="parent.location='userProfile-list.htm'" value="Wróć"/></p>
		
	</div>

	<div class = "grip">
		<div class="tagBox userView">

			[@spring.bind "profile.id" /]
			<input type="hidden" name="${spring.status.expression}" 
							value="${spring.status.value?default("")}" />
			[@spring.bind "profile.user.id" /]
			<input type="hidden" name="${spring.status.expression}" 
							value="${spring.status.value?default("")}" />

			[@spring.bind "profile.name" /]
			<p><label>Imię: </label>
			<input type="text" class="inputText" name="${spring.status.expression}" 
				value="${spring.status.value?default("")}" /></p>

			[@spring.bind "profile.lastname" /]
			<p><label>Nazwisko:</label>
			<input type="text" class="inputText" name="${spring.status.expression}" 
				value="${spring.status.value?default("")}" /></p>

			<p><label>Emial:</label>
			<input type="text" class="inputText" disabled="disabled" value="${profile.user.email}"/></p>

			[@spring.bind "profile.nick" /]
			<p><label>Nick:</label>
			<input type="text" class="inputText" name="${spring.status.expression}" 
				value="${spring.status.value?default("")}" /></p>

		</div>
	</div>

	<div class = "grip">
		<div class="tagBox userView">

			[@spring.bind "profile.privatePageUrl" /]
			<p><label>Strona www: </label>
			<input type="text" class="inputText" name="${spring.status.expression}" 
				value="${spring.status.value?default("")}" /></p>

			[@spring.bind "profile.phoneNumber" /]
			<p><label>Numer telefonu: </label>
			<input type="text" class="inputText" name="${spring.status.expression}" 
				value="${spring.status.value?default("")}" /></p>

			[@spring.bind "profile.description" /]
			<p><label>O użytkowniku: </label>
			<textarea name="${spring.status.expression}" 
				value="${spring.status.value?default("")}" >${spring.status.value?default("")}</textarea></p>

		</div>
	</div>

</form>

</body>

</html>
