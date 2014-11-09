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
				Imię: <input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" /> <br /> 
				[@spring.bind "character.age" /]
				Wiek: <input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" /> <br /> 
				[@spring.bind "character.story" /]
				Historia: <br />
					<textarea name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" ></textarea> <br /> 
				<input type="submit" value="   Wyślij   " />
			</form>
		</div>

	</div>
</body>

</html>
