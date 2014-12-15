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
				<p><label>Email: </label> 
				<input type="text" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" />
				<span style="color : red">[@spring.showErrors "<br>" /]</span></p> 
					
				[@spring.bind "user.password" /]
				<p><label>Hasło: </label>
				<input type="password" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" />
				<span style="color : red">[@spring.showErrors "<br>" /]</span></p> 

				[@spring.bind "user.repeatedPassword" /]
				<p><label>Powtórz hasło: </label>
				<input type="password" name="${spring.status.expression}" 
					value="${spring.status.value?default("")}" />
				<span style="color : red">[@spring.showErrors "<br>" /]</span></p>
 
				<input type="submit" value="   Wyślij   " />
			</form>
		</div>
	</div>
</body>
</html>
