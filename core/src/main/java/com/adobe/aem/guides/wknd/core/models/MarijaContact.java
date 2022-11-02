package com.adobe.aem.guides.wknd.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;


public interface MarijaContact {
  String getTitle();
  String getFirstName();
  String getLastName();
  String getPhoneNumber();
  String getEmail();
  String getCountry();

}
