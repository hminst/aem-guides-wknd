package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.PhoneLookUp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = {PhoneLookUp.class})
@Designate(ocd = PhoneLookUpImpl.Config.class)
public class PhoneLookUpImpl implements PhoneLookUp {

  private static final Logger log = LoggerFactory.getLogger(PhoneLookUpImpl.class);



  @ObjectClassDefinition(name = "Andrea phone lookup service cfg")
  @interface Config{
    @AttributeDefinition(
        name = "Phone number",
        description = "Numbers"
    )
    String[] phoneNumbers() default{"+41#Switzerland","+49#Germany"};

  }

  private String[] phoneNumbers;
  private Map<String,String> phoneTable;


  @Override
  public String getCountryByPhone(String phoneNumber) {

    return "this is a super country resolved by phone";
  }



  @Activate
  protected void activate(Config config) {

    this.phoneNumbers = config.phoneNumbers();
    this.phoneTable = new HashMap<>();
    Arrays.stream(phoneNumbers).forEach(item -> {
      String[] parts = item.split("#");
      phoneTable.put(parts[0],parts[1]);
    });

    log.info("Activated PhoneLookUpImpl");
  }

  @Deactivate
  protected void deactivate() {
    log.info("PhoneLookUpImpl has been deactivated!");
  }

}
