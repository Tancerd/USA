[#ftl/] [#import "/spring.ftl" as spring /]
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<title>U.S.A. - Widok postaci</title>
</head>

<body>

	<script type="text/javascript">

		function addNote() {

			var note = $( "#new-note" ).val();
			var formData = {id:${character.id},note:note};

			$.ajax({
				url : "characterPersonalNote.ltr",
				type : "POST",
				data : formData,
				success : function(data, textStatus, jqXHR) {
					if (data !== "OK") {
						alert("Błędne wywołanie");
					}
					else {
						location.reload();
					}
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("Problem łączności...")
				}
			});

		}

		function deleteNote(id) {

			var formData = {id:id};

			$.ajax({
				url : "characterPersonalNote.ltr?delete",
				type : "POST",
				data : formData,
				success : function(data, textStatus, jqXHR) {
					if (data !== "OK") {
						alert("Błędne wywołanie");
					}
					else {
						location.reload();
					}
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("Problem łączności...")
				}
			});

		}
	</script>

	<h3>
		<center>Postać ${character.name}</center>
	</h3>

	<form method="POST">
		<div>
			<p>
				<input type="submit" value="   Zapisz   " /> <input type="button"
					onClick="parent.location='character-list.htm'" value="Wróć" />
			</p>

		</div>

		<div class="grip">
			<div class="tagBox userView">

				[@spring.bind "character.id" /] <input type="hidden"
					name="${spring.status.expression}"
					value="${spring.status.value?default(" ")}" /> [@spring.bind
				"character.user.id" /] <input type="hidden"
					name="${spring.status.expression}"
					value="${spring.status.value?default(" ")}" /> [@spring.bind
				"character.name" /]

				<p>
					<label>Profil gracza: </label> <a
						href="userProfile-edit.htm?id=${character.user.profile.id}" class="link">  Profil</a>
				</p>

				<p>
					<label>Imię: </label> <input type="text" class="inputText"
						name="${spring.status.expression}"
						value="${spring.status.value?default(" ")}" />
				</p>

				[@spring.bind "character.age" /]
				<p>
					<label>Wiek:</label> <input type="text" class="inputText"
						name="${spring.status.expression}"
						value="${spring.status.value?default(" ")}" />
				</p>

				[@spring.bind "character.story" /]
				<p>
					<label>Historia:</label>
					<textarea name="${spring.status.expression}"
						value="${spring.status.value?default("")}" >${spring.status.value?default("")}</textarea>
				</p>

			</div>
		</div>

		<div class="grip">
			<div class="tagBox userView"></div>

			<div class="tagBox userView">
				[#list character.notes as note]

				<p>${note.dateCreate}${note.author.email}</p>
				${note.note} <br /> <input type="button"
					onclick="deleteNote(${note.id})" value="Usuń" />
				<hr />

				[/#list]

				<p>
					<label>Notatka:</label>
					<textarea id="new-note"></textarea>
				</p>
				<input type="button" onclick="addNote()" value="Dodaj" />
			</div>
		</div>

	</form>

</body>

</html>
