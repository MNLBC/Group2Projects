<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<html>
			<body>
				<h2>My Bookstore</h2>
				<table border="1">
					<tr bgcolor="#9acd32">
						<th>Title</th>
						<th>Author</th>
						<th>Price</th>
					</tr>
					<xsl:for-each select="bookstore/book">
						<tr>
							<xsl:choose>
								<xsl:when test="price &gt; 35">
									<td bgcolor="#BED2D9"><xsl:value-of select="title"/></td>
									<td bgcolor="#BED2D9"><xsl:value-of select="author"/></td>
									<td bgcolor="#BED2D9"><xsl:value-of select="price"/></td>
								</xsl:when>
								<xsl:otherwise>
									<td><xsl:value-of select="title"/></td>
									<td><xsl:value-of select="author"/></td>
									<td><xsl:value-of select="price"/></td>
								</xsl:otherwise>
							</xsl:choose>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>

</xsl:stylesheet>