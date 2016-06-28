<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method='html' version='1.0' encoding='UTF-8' indent='yes'/>

<xsl:template match="/">
	<rpc-reply-converter-output>
	<dmi-specific-rpc-reply>
	<chassis-satellites>
	
	
	<xsl:for-each select="//satellite">
		<chassis-satellite>
			<satelliteName><xsl:value-of select="satellite-alias"/></satelliteName>
			<slotId><xsl:value-of select="slot-id"/></slotId>
			<productModel><xsl:value-of select="product-model"/></productModel>
			<version><xsl:value-of select="version"/></version>
			<managementAddress><xsl:value-of select="management-address"/></managementAddress>
			<groupName><xsl:value-of select="//group-name"/></groupName>
			<groupVersion><xsl:value-of select="//version"/></groupVersion>
	<xsl:for-each select="//connectivity">
		<connectivity>
			<cascadePort><xsl:value-of select="cascade-port"/></cascadePort>
			<uplinkIntefaceName><xsl:value-of select="uplink-interface-name"/></uplinkIntefaceName>
			<adjacencyState><xsl:value-of select="adjacency-state"/></adjacencyState>
		</connectivity>
	</xsl:for-each>
		</chassis-satellite>
	</xsl:for-each>
	</chassis-satellites>
	</dmi-specific-rpc-reply>
	</rpc-reply-converter-output>
</xsl:template>

</xsl:stylesheet>