<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method='html' version='1.0' encoding='UTF-8' indent='yes'/>

<xsl:template match="/">
  <html>
  <body>
  <h2>My Book Collection</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th align="left">Title</th>
        <th align="left">Author</th>
		<th align="left">Year</th>
		<th align="left">Price</th>
      </tr>
      <xsl:for-each select="bookstore/book">
      <tr>
        <td><xsl:value-of select="title"/></td>
        <td><xsl:value-of select="author"/></td>
		<td><xsl:value-of select="year"/></td>
		<td><xsl:value-of select="price"/></td>
      </tr>
      </xsl:for-each>
    </table>
	
	<h2>Select all the text from price nodes</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
		<th align="left">Price</th>
      </tr>
      <xsl:for-each select="bookstore/book">
      <tr>
		<td><xsl:value-of select="price"/></td>
      </tr>
      </xsl:for-each>
    </table>
	
	<h2>Select all the price nodes and their price is higher than 35</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
		<th align="left">Price</th>
      </tr>
      <xsl:for-each select="bookstore/book">
	  <xsl:if test="price &gt; 35">
      <tr>
		<td><xsl:value-of select="price"/></td>
      </tr>
	  </xsl:if>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>