<%@page import="pe.gob.mininter.entities.SiminImagen"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Fotos del Interior</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.lightbox-0.5.js"></script>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/jquery.lightbox-0.5.css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/style-projects-jquery.css" />

<script type="text/javascript">
	$(function() {
		$('#gallery a').lightBox();
	});
</script>

<style type="text/css">
.irgaleria {
	background-image: url("images/icon_galeria.jpg");
	height: 22px;
	display: block;
	width: 104px;
	margin-left: 480px;
	margin-top: 10px;
}
</style>

</head>

<body>
	
	<div>
		<a href="galeriaFotos.htm" class="irgaleria"></a>
	</div>
	
	<div id="gallery">
		<ul>
			<% List<SiminImagen> lista = (List<SiminImagen>)request.getAttribute("limagenesDigemin");
				for(SiminImagen img : lista){
			%>
			<li>
				<a href="pdf.htm?id=<%=img.getCoImgCodigo()%>" title="texto 1">
					<img alt="<%=img.getNaImgNombre() %>" src="pdf.htm?id=<%=img.getCoImgCodigo()%>" width="120" height="100" alt=""/>
				</a>		
			</li>
			<%
				}
			%>
		</ul>
	</div>

</body>
</html>