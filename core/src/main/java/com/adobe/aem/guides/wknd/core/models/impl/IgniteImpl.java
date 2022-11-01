package com.adobe.aem.guides.wknd.core.models.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.aem.guides.wknd.core.models.Ignite;
import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.DataLayerBuilder;
import com.adobe.cq.wcm.core.components.util.ComponentUtils;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { Ignite.class }, resourceType = {
        IgniteImpl.RESOURCE_TYPE }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class IgniteImpl implements Ignite {

    protected static final String RESOURCE_TYPE = "wknd/components/custom/ignite";

    @ValueMapValue
    private String text;

    @Self
    @Required
    private SlingHttpServletRequest request;

    @Override
    public ComponentData getData() {
        Resource imageListResource = this.request.getResource();
        if (ComponentUtils.isDataLayerEnabled(imageListResource)) {
            return DataLayerBuilder.forComponent()
                    .withId(() -> request.getPathInfo())
                    .withType(() -> RESOURCE_TYPE)
                    .build();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return StringUtils.isBlank(text);
    }
}
