/*
 *  Copyright 2019 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.NihadCountryLookupService;
import com.adobe.aem.guides.wknd.core.models.NtContact;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.*;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {NtContact.class},
        resourceType = {NtContactImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class NtContactImpl implements NtContact {
    protected static final String RESOURCE_TYPE = "wknd/components/ntcontact";

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String firstName;

    @ValueMapValue
    private String lastName;

    @ValueMapValue
    private String phoneNumber;

    @ValueMapValue
    private String email;

    @OSGiService(injectionStrategy = InjectionStrategy.REQUIRED)
    private NihadCountryLookupService nihadCountryLookupService;

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
        return nihadCountryLookupService.getCountryName(phoneNumber);
    }

    @Override
    public String getEmail() {
        return email;
    }
}