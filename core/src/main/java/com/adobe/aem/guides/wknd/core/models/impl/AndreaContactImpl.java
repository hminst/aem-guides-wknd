package com.adobe.aem.guides.wknd.core.models.impl;


import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;

import com.adobe.aem.guides.wknd.core.models.AndreaContact;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,
    adapters = {AndreaContact.class},
    resourceType = {AndreaContactImpl.RESOURCE_TYPE})
public class AndreaContactImpl implements AndreaContact {

  protected static final String RESOURCE_TYPE = "wknd/components/andrea-beleska-contact";

  @ValueMapValue(name=PROPERTY_RESOURCE_TYPE, injectionStrategy=InjectionStrategy.REQUIRED)
  protected String  firstName;

  @ValueMapValue(name="lastNameDetail")
  private String lastName;

  @ValueMapValue(name=PROPERTY_RESOURCE_TYPE, injectionStrategy=InjectionStrategy.OPTIONAL)
  private String emailAddress;

  @ValueMapValue(name=PROPERTY_RESOURCE_TYPE, injectionStrategy=InjectionStrategy.REQUIRED)
  private String  phoneNumber;


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
    return emailAddress;
  }
}

