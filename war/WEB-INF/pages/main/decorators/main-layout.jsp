<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>
<head>

<title><dec:title
		default="U.S.A. - Uniwersalny System Akredytacji" /></title>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />

<link rel="stylesheet" type="text/css"
	href="main/decorators/style/style.css" />
<style type="text/css">
	body {
		background-color: #000000;
	}
</style>
<dec:head />
</head>
<body>
	<div id="page">
		<div id="header">
			<div class="title">U S A</div>
			<div class="subText">Uniwersalny System Akredytacji</div>
		</div>
		<div id="bar">
			<div class="menuLink">
				<a href="index.htm">Strona główna</a>
			</div>
			<div class="menuLink">
				<a href="gamer/userProfile.htm">Profil gracza</a>
			</div>
			<div class="menuLink">
				<a href="about.htm">O projekcie</a>
			</div>
			<div class="menuLink">
				<a href="contact.htm">Kontakt</a>
			</div>
		</div>

		<dec:body />

	</div>
	<div id="footer">By Michał Kowalik 2014</div>

</body>
</html>