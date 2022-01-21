<?xml version="1.0" encoding="windows-1252" ?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match='/'>
		<html>
			<xsl:apply-templates />
		</html>
	</xsl:template>
	<xsl:template match='Alumnos'>
		<head>
			<title>LISTADO DE ALUMNOS</title>
		</head>
		<body>
			<h1>LISTA DE ALUMNOS</h1>
			<table border='1'>
				<tr>
					<th>Nombre</th>
					<th>Apellido1</th>
					<th>Apellido2</th>
					<th>Edad</th>
					<th>nMatricula</th>
				</tr>
				<xsl:apply-templates select='Alumno' />
			</table>
		</body>
	</xsl:template>

	<xsl:template match='Alumno'>
		<tr>
			<xsl:apply-templates />
		</tr>
	</xsl:template>
	<xsl:template match='nombre|apellido1|apellido2|edad|nMatricula'>
		<td>
			<xsl:apply-templates />
		</td>
	</xsl:template>
</xsl:stylesheet>

