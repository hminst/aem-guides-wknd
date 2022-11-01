package com.adobe.aem.guides.wknd.core.models;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LinditContactModel {

    @ValueMapValue
    protected String title;
    @ValueMapValue
    protected String firstName;
    @ValueMapValue
    protected String lastName;
    @ValueMapValue
    protected String phoneNumber;
    @ValueMapValue
    protected String emailAddress;

    @OSGiService(injectionStrategy = InjectionStrategy.REQUIRED)
    private LinditCountryLookupService countryLookupService;

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getCountry(){
        return this.countryLookupService.calculateCountry(this.phoneNumber).orElse("");
    }

    public boolean hasContent() {
        return StringUtils.isNoneBlank(firstName, lastName, phoneNumber);
    }

}
