<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<title>U.S.A. - List tagów</title>
</head>

<body>

	<script type="text/javascript">

	function deleteTag(id) {

		var r = confirm("Czy jesteś pewien że chcesz usunąć tag?");

		if (r == true) {

			var formData = {id:id};

			$.ajax({
				url : "briefingTag-edit.htm?delete",
				type : "POST",
				data : formData,
				success : function(data, textStatus, jqXHR) {
					location.reload();
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("Problem łączności...")
				}
			});
		}
	}

	</script>

	<h3><center>Lista tagów</center></h3>

	<input type="button" onClick="parent.location='briefingTag-edit.htm'" value="Nowy" />

	<table class = "hoverTable">
		<tr>
			<th>Lp</th>
			<th>Identyfikator</th>
			<th>Opis</th>
			<th>Funkcje</th>
		</tr>

		<#list tags as tag>

			<tr>
			<td>${tag_index + 1}</td>
			<td>${tag.identifier}</td>
			<td>${tag.description}</td>
			<td><a href = "briefingTag-edit.htm?id=${tag.id}">Edytuj</a>
				<a href = "#" onclick="deleteTag(${tag.id})">Usuń</a></td>
			</tr>

		</#list>

	</table>

</body>

</html>
