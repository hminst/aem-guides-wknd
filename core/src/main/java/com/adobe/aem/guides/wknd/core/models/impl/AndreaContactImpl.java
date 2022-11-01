package com.adobe.aem.guides.wknd.core.models.impl;



import com.adobe.aem.guides.wknd.core.models.AndreaContact;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,
    adapters = AndreaContact.class,
    resourceType = AndreaContactImpl.RESOURCE_TYPE,
  defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AndreaContactImpl implements AndreaContact {

  protected static final String RESOURCE_TYPE = "wknd/components/andrea-beleska-contact";

  @ValueMapValue
  private String title;
  @ValueMapValue
  private String firstName;
  @ValueMapValue
  private String lastName;

  @ValueMapValue
  private String emailAddress;

  @ValueMapValue
  private String phoneNumber;


  @Override
  public String getTitle() {
    return title;
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
    return emailAddress;
  }
}

