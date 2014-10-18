[#ftl/]
[#import "/spring.ftl" as spring /]
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>U.S.A. - Formularz rejestracyjny</title>
</head>
<body>

	<div id="pageContent">

		<div class="articleTitle">Formularz rejestrowania użytkownika</div>
		<div class="articleContent">
			<form method="POST">
				[@spring.bind "user.email" /]
				Email: <input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" /> <br /> 
				[@spring.bind "user.password" /]
				Hasło: <input type="password" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" /> <br /> 
				[@spring.bind "user.repeatedPassword" /]
				Powtórz hasło: <input type="password" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" /> <br /> 
				<input type="submit" value="   Wyślij   " />
			</form>
		</div>
	</div>
</body>
</html>
