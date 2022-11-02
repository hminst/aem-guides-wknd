package com.adobe.aem.guides.wknd.core.models.impl;
import com.adobe.aem.guides.wknd.core.models.PhoneSearch;
import com.adobe.aem.guides.wknd.core.models.VanjaContact;
import java.util.Optional;
import javax.security.auth.login.CredentialException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = {Resource.class},
    adapters = {VanjaContact.class},
    resourceType = {VanjaContactImpl.RESOURCE_TYPE},
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class VanjaContactImpl implements VanjaContact {

  protected static final String RESOURCE_TYPE = "wknd/components/vanjacontact";


  @OSGiService
  PhoneSearch phoneSearch;
  @ValueMapValue
  private  String title;
  @ValueMapValue
  private  String firstName;
  @ValueMapValue
  private  String lastName;
  @ValueMapValue
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
  public Optional<String> getCountry() {
    return phoneSearch.getTheCountry(phoneNumber);
  }


  @Override
  public String getData() throws CredentialException {
    if (getPhoneNumber().isEmpty() && getFirstName().isEmpty() && getLastName().isEmpty()) {
    throw new CredentialException();
    } else {
      return "The title is: " + title+
          "<br/> The First Name is: " +firstName+
          "<br/> The Last Name is: " +lastName+
          "<br/> The Phonenumber is: " +phoneNumber+
          "<br/> The email is: " +email+
          "<br/> The country is: " +getCountry();
    }

  }
}
