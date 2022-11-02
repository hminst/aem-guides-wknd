package com.adobe.aem.guides.wknd.core.models;

import java.util.Optional;
import javax.security.auth.login.CredentialException;

public interface VanjaContact {
    String getTitle();
    String getFirstName();
    String getLastName();
    String getPhoneNumber();
    String getEmail();
    Optional<String> getCountry();

  String getData() throws CredentialException;
}
