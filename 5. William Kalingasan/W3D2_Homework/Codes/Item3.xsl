<?xml version="1.0" encoding="UTF-8"?>
<xsl:transform version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml" encoding="UTF-8" indent = "yes"/>
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
						<xsl:for-each select="//upgrade-group">
							<groupName><xsl:value-of select="group-name"/></groupName>
							<groupVersion><xsl:value-of select="version"/></groupVersion>
						</xsl:for-each>
						<connectivity>
							<cascadePort><xsl:value-of select="connectivity/cascade-port"/></cascadePort>
							<uplinkInterfaceName><xsl:value-of select="connectivity/uplink-interface-name"/></uplinkInterfaceName>
							<adjacencyState><xsl:value-of select="connectivity/adjacency-state"/></adjacencyState>
						</connectivity>
					</chassis-satellite>
				</xsl:for-each>
			</chassis-satellites>
		</dmi-specific-rpc-reply>
	</rpc-reply-converter-output>
</xsl:template>
</xsl:transform>