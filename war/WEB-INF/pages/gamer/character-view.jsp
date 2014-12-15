<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>U.S.A. - Karta postaci</title>
</head>

<body>
	<div id="pageContent">

		<div class="articleTitle">Karta Postaci</div>

		<div class="articleContent">

			<p class="articleContentUnit"><label>Status odprawki: </label><h3><b>${character.briefing.briefingStatus}</b></h3></p>
			<p class="articleContentUnit"><label>Mistrz gry: </label>
				<h3><b><#if character.briefing.gameMaster??>${character.briefing.gameMaster.email}</#if></b></h3>
			</p>
			<p class="articleContentUnit"><label>Imię: </label><b>${character.name}</b></p>
			<p class="articleContentUnit"><label>Wiek: </label><b>${character.age}</b></p>
			<p class="articleContentUnit"><label>Historia: </label></p><p>${character.story}</p>

			<p><hr/></p>

			<#if character.briefing.briefingStatus == "READY">

				<div class="articleTitle">Odprawka</div>

				<p class="articleContentUnit"><label>Wie: </label></p><p>${character.briefing.know}</p>
				<p class="articleContentUnit"><label>Chce: </label></p><p>${character.briefing.want}</p>
				<p class="articleContentUnit"><label>Ma: </label></p><p>${character.briefing.have}</p>
				<p class="articleContentUnit"><label>Plotki: </label></p><p>${character.briefing.gossip}</p>

			</#if>

		</div>


	</div>
</body>

</html>
