package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.MarijaContact;
import com.adobe.aem.guides.wknd.core.services.MarijaCountryLookupService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    adapters = {MarijaContact.class},
    resourceType = {MarijaContactImpl.RESOURCE_TYPE},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class MarijaContactImpl implements MarijaContact {
  protected static final String RESOURCE_TYPE = "wknd/components/marija-contact";
  @OSGiService(injectionStrategy = InjectionStrategy.REQUIRED)
  private MarijaCountryLookupService lookupService;
  @ValueMapValue
  private String title;
  @ValueMapValue
  private String firstName;
  @ValueMapValue
  private String lastName;
  @ValueMapValue
  private String phoneNumber;
  @ValueMapValue
  private String email;


  @Override
  public String getTitle() {
    return title.toUpperCase();
  }

  @Override
  public String getFirstName() {
    return firstName;
  }

  @Override
  public String getLastName() {
    return lastName;
  }

  @Override
  public String getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public String getCountry() {
    return lookupService.getCountryCodeLookup(phoneNumber);
  }
}
