package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.MarijaContact;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    adapters = {MarijaContact.class},
    resourceType = {MarijaContactImpl.RESOURCE_TYPE}
)
public class MarijaContactImpl implements MarijaContact {
  protected static final String RESOURCE_TYPE = "wknd/components/marija-contact";

  @ValueMapValue(name="title", injectionStrategy=InjectionStrategy.OPTIONAL)
  private String title;
  @ValueMapValue(name="firstName", injectionStrategy=InjectionStrategy.REQUIRED)
  private String firstName;
  @ValueMapValue(name="lastName", injectionStrategy=InjectionStrategy.
  REQUIRED)
  private String lastName;
  @ValueMapValue(name="phoneNumber", injectionStrategy=InjectionStrategy.
  REQUIRED)
  private String phoneNumber;
  @ValueMapValue(name="email", injectionStrategy=InjectionStrategy.OPTIONAL)
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
}
