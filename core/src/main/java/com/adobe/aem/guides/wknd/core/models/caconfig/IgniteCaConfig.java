package com.adobe.aem.guides.wknd.core.models.caconfig;

import com.adobe.aem.guides.wknd.core.models.impl.LinditCountryLookupServiceImpl.Configuration;
import org.apache.sling.caconfig.annotation.Property;

@Configuration
public @interface IgniteCaConfig {

  @Property(label = "Some config")
    String configString() default "this is a default";
}
