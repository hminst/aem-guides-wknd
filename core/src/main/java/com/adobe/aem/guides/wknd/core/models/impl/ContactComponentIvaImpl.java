package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.ContactComponentIva;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,
        adapters = ContactComponentIva.class,
        resourceType = {ContactComponentIvaImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class ContactComponentIvaImpl implements ContactComponentIva {

    public static final String RESOURCE_TYPE = "wknd/components/contactcomponentiva";

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String firstName;

    @ValueMapValue
    private String lastName;

    public String getTitle() {
        return title;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
