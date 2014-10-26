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
				Imie: <input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" /> <br /> 
				[@spring.bind "profile.lastname" /]
				Nazwisko: <input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" /> <br /> 
				[@spring.bind "profile.nick" /]
				Nick: <input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" /> <br /> 
				<input type="submit" value="   Zapisz   " />
			</form>
		</div>

	</div>
</body>

</html>
