[#ftl/]
[#import "/spring.ftl" as spring /]
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>U.S.A. - Login</title>
</head>
<body>

	<div id="pageContent">

		<div class="articleTitle">Strona logowania</div>

		<div class="articleContent">

				<form action="[@spring.url '/login'/]" method="post">
					<label for="username">Login: </label><input type="text"
						id="username" name="username"><br /> 

					<label for="password">Hasło: </label><input type="password" 
						id="password" name="password"><br /> 

					<input type="submit" value="Zaloguj!">
				</form>

				<a href="user-formular.htm">Rejestracja</a>

		</div>
	</div>
</body>
</html>
