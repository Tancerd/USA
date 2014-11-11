<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>U.S.A. - Aktualności organizatorów</title>
</head>

<body>

	<script type="text/javascript">

		function change() {

			var selectedOption = $('#select :selected').text();

			window.location.href = 'index.htm?type=' + selectedOption;

		}
	</script>

	<div id="navigation">
		<input type="button" onClick="parent.location='news-edit.htm'" value="Nowy" />
		Filtrowanie: <select name = "select" id = "select" onchange="change()">
			<#list types as type>
				<option value="${type}" 
				<#if type == selectedType>selected="selected"</#if> 
				>${type}</option>
			</#list>
		</select>
	</div>

	<div id="news">

		<#list newsList as news>

			<div class="newsType">Typ: ${news.type}</div>
			<div class="newsDate">${news.dateCreate}</div>
			<div class="newsTitle">${news.title}</div>
			<div class="newsContent">${news.content}</div>
			<div class="newsAuthor">${news.author}</div>
			<div class="newsEditHref"><a href="news-edit.htm?id=${news.id}">Edytuj</a></div>
			<hr/>

		</#list>

	</div>

</body>

</html>
