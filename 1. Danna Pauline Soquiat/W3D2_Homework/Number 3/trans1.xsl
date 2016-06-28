<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xs="http://www.w3.org/2001/XMLSchema"
                exclude-result-prefixes="xs xsi xsl">
    <xsl:output method="xml" encoding="UTF-8" indent="yes"/>
    
    <xsl:template match="/rpc-reply-converter-input">
        <rpc-reply-converter-output>
            <dmi-specific-rpc-reply>
				
				<chassis-satellites>
					<chassis-satellite>
						<xsl:for-each select="device-specific-rpc-reply-list/device-specific-rpc-reply">
					
						<xsl:choose>
							<xsl:when test="position() = 1"> 
								
								<xsl:for-each select="satellite-information/satellite">	
									
										<xsl:if test="satellite-alias">                       
											<satelliteName>
												<xsl:value-of select="normalize-space(satellite-alias)"/>
											</satelliteName>                                        
										</xsl:if>										
										<xsl:if test="slot-id">                       
											<slotId>
												<xsl:value-of select="normalize-space(slot-id)"/>
											</slotId>                                        
										</xsl:if>
										<xsl:if test="product-model">                       
											<productModel>
												<xsl:value-of select="normalize-space(product-model)"/>
											</productModel>                                        
										</xsl:if>
										<xsl:if test="version">                       
											<version>
												<xsl:value-of select="normalize-space(version)"/>
											</version>                                        
										</xsl:if>
										<xsl:if test="management-address">                       
											<managementAddress>
												<xsl:value-of select="normalize-space(management-address)"/>
											</managementAddress>                                        
										</xsl:if>

										
										
								
								</xsl:for-each>
								
							</xsl:when>
							<xsl:when test="position() = 2"> 
							<xsl:for-each select="upgrade-group-information/upgrade-group">
							<groupName>
							<xsl:value-of select="normalize-space(group-name)"/>
							</groupName>
							<groupVersion>
							<xsl:value-of select="normalize-space(version)"/>
							</groupVersion>
							
							
							
							
							
							  </xsl:for-each >
							  
							</xsl:when>
						</xsl:choose>	
					</xsl:for-each>
					<xsl:for-each select="device-specific-rpc-reply-list/device-specific-rpc-reply">
					
					<xsl:choose>
							<xsl:when test="position() = 1">
							<xsl:for-each select="satellite-information/satellite">
							<xsl:for-each select="connectivity">
								<connectivity>
								<cascadePort>
								<xsl:value-of select="normalize-space(cascade-port)"/>
								</cascadePort>
								<uplinkInterfaceName>
								<xsl:value-of select="normalize-space(uplink-interface-name)"/>
								</uplinkInterfaceName>
								<adjacencyState>
								<xsl:value-of select="normalize-space(adjacency-state)"/>
								</adjacencyState>
								</connectivity>
							  </xsl:for-each>
							</xsl:for-each>
							</xsl:when>
					</xsl:choose>
					</xsl:for-each>
					</chassis-satellite>
				</chassis-satellites>
            </dmi-specific-rpc-reply>
        </rpc-reply-converter-output>
    </xsl:template>
</xsl:stylesheet>


        
