<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>U.S.A. - Aktualności</title>
</head>

<body>
	<div id="pageContent">

		<#list newsList as news>

			<div class="articleDate">${news.dateCreate}</div>
			<div class="articleTitle">${news.title}</div>
			<div class="articleContent">${news.content}</div>
			<div class="articleAuthor">${news.author}</div>
			<div class="newsLabel"></div>

		</#list>

	</div>
</body>

</html>
