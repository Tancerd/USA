[#ftl/]
[#import "/spring.ftl" as spring /]

<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>U.S.A. - Formularz zgłoszeniowy postaci</title>
</head>

<body>
	<div id="pageContent">

		<div class="articleTitle">Formularz zgłoszeniowy postaci</div>

		<div class="articleContent">
			<form method="POST">

				[@spring.bind "character.name" /]
				<p><label>Imię: </label><input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" />
					<span style="color : red">[@spring.showErrors "<br>" /]</span></p>

				[@spring.bind "character.age" /]
				<p><label>Wiek: </label><input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" />
					<span style="color : red">[@spring.showErrors "<br>" /]</span></p>

				[@spring.bind "character.story" /]
				<p><label>Historia: </label><br />
					<textarea name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" rows="20" cols="40">${spring.status.value?default("")}</textarea>
					<span style="color : red">[@spring.showErrors "<br>" /]</span></p> 

				<input type="submit" value="   Wyślij   " />
			</form>
		</div>

	</div>
</body>

</html>
