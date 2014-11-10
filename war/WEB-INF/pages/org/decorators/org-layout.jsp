<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ page contentType="text/html;charset=utf8"%>
<html>

<head>

	<title><dec:title
		default="U.S.A. - Uniwersalny System Akredytacji" /></title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />

    <link href="decorators/style/bootstrap.min.css" rel="stylesheet">

    <link href="decorators/style/simple-sidebar.css" rel="stylesheet">

    <link href="decorators/style/table.css" rel="stylesheet">

    <link href="decorators/style/edit-pages.css" rel="stylesheet">

</head>

<body>

    <div id="wrapper">

        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="news-list.htm">
                        U.S.A.
                    </a>
                </li>
                <li>
                    <a href="news-list.htm">Aktualności</a>
                </li>
                <li>
                    <a href="userProfile-list.htm">Lista użytkowników</a>
                </li>
                <li>
                    <a href="character-list.htm">Lista postaci</a>
                </li>
                <li>
                    <a href="briefingTag-list.htm">List tagów</a>
                </li>
                <li>
                    <a href="../logout.htm">Wyloguj</a>
                </li>
            </ul>
        </div>

        <div id="page-content-wrapper">
            <dec:body />
			<div id = "toogle">
            	<p><center><a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Zwijanie/Rozwijanie</a></center></p>
            </div>
        </div>

    </div>

    <script src="decorators/js/jquery.js"></script>

    <script src="decorators/js/bootstrap.min.js"></script>

    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>

</body>

</html>
