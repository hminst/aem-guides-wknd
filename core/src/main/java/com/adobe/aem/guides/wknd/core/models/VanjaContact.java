package com.adobe.aem.guides.wknd.core.models;

import javax.security.auth.login.CredentialException;

public interface VanjaContact {
    String getTitle();
    String getFirstName();
    String getLastName();
    String getPhoneNumber();
    String getEmail();

  String getData() throws CredentialException;
}
