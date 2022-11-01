package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.ImageList;
import com.adobe.aem.guides.wknd.core.models.MarijaContact;
import com.day.cq.search.QueryBuilder;
import javax.annotation.Generated;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.factory.ModelFactory;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    adapters = {MarijaContact.class},
    resourceType = {MarijaContactImpl.RESOURCE_TYPE}
)
public class MarijaContactImpl implements MarijaContact {
  protected static final String RESOURCE_TYPE = "wknd/components/marija-contact";
  @Self
  @Required
  private SlingHttpServletRequest request;

  @OSGiService
  private ModelFactory modelFactory;

  @OSGiService
  @Required
  private QueryBuilder queryBuilder;
  @ValueMapValue
  @Optional
  private String title;
  @ValueMapValue
  @Required
  private String firstName;
  @ValueMapValue
  @Required
  private String lastName;
  @ValueMapValue
  @Required
  private String phoneNumber;
  @ValueMapValue
  @Optional
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
