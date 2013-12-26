<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gong bang</title>
<link type="text/css" href="../css/reset.css" rel="stylesheet" />
<link type="text/css" href="../css/style.css" rel="stylesheet" />
<link type="text/css" href="../css/layout.css" rel="stylesheet" />
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
</head>

<body>
	<div id="wrapper" class="cf">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="aside" />
		<tiles:insertAttribute name="content" />
	</div>




	<!-- aside 스크립트 -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#menu-box li').mouseenter(function() {
				$(this).css('background', '#c70000');

			}), $('#menu-box li').mouseleave(function() {
				$(this).css('background', '');

			})
		});
	</script>

	<!-- content hover 스크립트 -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#gallery li .caption').mouseenter(function() {
				$(this).css('opacity', '1');

			}), $('#gallery li .caption').mouseleave(function() {
				$(this).css('opacity', '0');

			})
		});
	</script>

</body>
</html>