package com.adobe.aem.guides.wknd.core.caconfig;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;

@Configuration(label = "Ignite CA Config")
public @interface IgniteCaConfig {

    @Property(label = "Whatever config")
    String configString() default "this is the default :P";
    
}
