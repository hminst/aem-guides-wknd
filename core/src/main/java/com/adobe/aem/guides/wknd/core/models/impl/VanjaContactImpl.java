package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.Byline;
import com.adobe.aem.guides.wknd.core.models.VanjaContact;
import com.day.cq.search.QueryBuilder;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.components.ComponentContext;
import javax.security.auth.login.CredentialException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = {SlingHttpServletRequest.class},
    adapters = {Byline.class},
    resourceType = {BylineImpl.RESOURCE_TYPE},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class VanjaContactImpl implements VanjaContact {

  protected static final String RESOURCE_TYPE = "wknd/components/vanjacontact";

  @ValueMapValue
  private  String title;
  @ValueMapValue
  @Required
  private  String firstName;
  @ValueMapValue
  @Required
  private  String lastName;
  @ValueMapValue
  @Required
  private String phoneNumber;
  @ValueMapValue
  private  String email;

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
    return email;
  }


  @Override
  public String getData() throws CredentialException {
    if (getPhoneNumber().isEmpty() && getFirstName().isEmpty() && getLastName().isEmpty()) {
    throw new CredentialException();
    } else {
      return "The title is:" + title+
          "\n The First Name is" +firstName+
          "\n The Last Name is" +lastName+
          "\n The Phonenumber is" +phoneNumber+
          "\n The email is" +email;
    }
  }
}
