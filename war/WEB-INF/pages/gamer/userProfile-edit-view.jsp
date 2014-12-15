[#ftl/]
[#import "/spring.ftl" as spring /]

<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>U.S.A. - Edycja profilu gracza</title>
</head>

<body>
	<div id="pageContent">

		<div class="articleTitle">Edycja profilu gracza</div>

		<div class="articleContent">
			<form method="POST">

				[@spring.bind "profile.name" /]
				<p><label>Imie<span style="color : red">*</span>: </label><input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" />
					<span style="color : red">[@spring.showErrors "<br>" /]</span></p>

				[@spring.bind "profile.lastname" /]
				<p><label>Nazwisko<span style="color : red">*</span>: </label><input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" />
					<span style="color : red">[@spring.showErrors "<br>" /]</span></p>

				[@spring.bind "profile.nick" /]
				<p><label>Nick<span style="color : red">*</span>: </label><input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" />
					<span style="color : red">[@spring.showErrors "<br>" /]</span></p>

				[@spring.bind "profile.birthDate" /]
				<p><label>Data urodzenia<span style="color : red">*</span>: </label><input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" placeholder="dd-MM-rrrr"/>
					<span style="color : red">[@spring.showErrors "<br>" /]</span></p>

				[@spring.bind "profile.phoneNumber" /]
				<p><label>Numer telefonu: </label><input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" />
					<span style="color : red">[@spring.showErrors "<br>" /]</span></p>

				[@spring.bind "profile.privatePageUrl" /]
				<p><label>Strona www: </label><input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" />
					<span style="color : red">[@spring.showErrors "<br>" /]</span></p>

				<input type="submit" value="   Zapisz   " />
			</form>
		</div>

	</div>
</body>

</html>
