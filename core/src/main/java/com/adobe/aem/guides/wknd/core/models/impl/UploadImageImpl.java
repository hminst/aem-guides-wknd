package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.UploadImage;
import com.adobe.cq.wcm.core.components.models.Image;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.factory.ModelFactory;

import javax.annotation.PostConstruct;
@Model(
        adaptables = {Resource.class, SlingHttpServletRequest.class},
        adapters = UploadImage.class,
        resourceType = UploadImageImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class UploadImageImpl implements UploadImage {

    public static final String RESOURCE_TYPE = "aem-learning/components/uploadimage";
    @Self
    private SlingHttpServletRequest request;
    @OSGiService
    private ModelFactory modelFactory;
    private Image image;

    @PostConstruct
    private void init() {
        image = modelFactory.getModelFromWrappedRequest(request, request.getResource(), Image.class);
    }
}