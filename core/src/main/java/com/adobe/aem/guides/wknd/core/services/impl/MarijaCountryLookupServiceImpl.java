package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.services.MarijaCountryLookupService;
import java.util.HashMap;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    service = { MarijaCountryLookupService.class }
)
@Designate(ocd = MarijaCountryLookupServiceImpl.Config.class)
public class MarijaCountryLookupServiceImpl implements MarijaCountryLookupService{

  private static final Logger log = LoggerFactory.getLogger(MarijaCountryLookupServiceImpl.class);

  @ObjectClassDefinition(
      name = "Country Lookup Service",
      description = "OSGi Service providing information about phone number"
  )
  @interface Config {

    @AttributeDefinition(
        name = "Phone numbers"
    )
    String[] numbers() default { "+41", "+49", "+389" };

    @AttributeDefinition(
        name = "Random Activity Seed",
        description = "Seed used to randomize activity selection"
    )
    String[] countries() default {"Switzerland","Germany","North Macedonia"};


  }


  private String[] numbers;
  private String[] countries;


  @Override
  public String getCountryCodeLookup(String phoneNumber) {
    HashMap<String, String> countryNumber=new HashMap<>();
    countryNumber.put("+41","Switzerland");
    countryNumber.put("+49","Germany");
    countryNumber.put("+389","North Macedonia");

    return countryNumber.entrySet().stream().filter( e -> e.getKey().substring(0,4).equals( phoneNumber.substring(0,4))).findFirst().get().getKey();
  }

  @Activate
  protected void activate(Config config) {

    this.numbers = config.numbers();

   this.countries= config.countries();

    log.info("Activated Country Lookup Impl with countries [ {} ]", String.join(", ", this.countries));
  }

  @Deactivate
  protected void deactivate() {
    log.info("Country Lookup has been deactivated!");
  }

}