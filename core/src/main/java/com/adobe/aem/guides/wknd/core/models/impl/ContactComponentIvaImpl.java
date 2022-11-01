//package com.adobe.aem.guides.wknd.core.models.impl;
//
//import com.adobe.aem.guides.wknd.core.models.ContactComponentIva;
//import lombok.Getter;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.sling.api.resource.Resource;
//import org.apache.sling.models.annotations.DefaultInjectionStrategy;
//import org.apache.sling.models.annotations.Model;
//import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
//
//@Model(adaptables = Resource.class,
//        adapters = ContactComponentIvaImpl.class,
//        resourceType = {ContactComponentIva.RESOURCE_TYPE},
//        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
//public class ContactComponentIvaImpl implements ContactComponentIva {
//
//    public static final String RESOURCE_TYPE = "wknd/components/contactcomponentiva";
//
//    @ValueMapValue(name = "firstName")
//    @Getter
//    public String getFirstName;
//
//    @ValueMapValue(name = "lastName")
//    @Getter
//    public String getLastName;
//
//    @Override
//    public String getFullName() {
//        return String.join(StringUtils.SPACE, getFirstName, getLastName);
//    }
//}
