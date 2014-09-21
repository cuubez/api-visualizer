/**
 *	Copyright [2013] [www.cuubez.com]
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *	http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package com.cuubez.visualizer.resource;

import com.cuubez.visualizer.domain.ApiMetaDataInformation;
import com.cuubez.visualizer.domain.ApplicationConfigurationContext;
import com.cuubez.visualizer.domain.configuration.Configuration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class InformationRepository {

    private static Log log = LogFactory.getLog(InformationRepository.class);

    private List<RootResource> rootResources = null;
    private ApiMetaDataInformation apiMetaData;
    private Configuration configuration;
    private ApplicationConfigurationContext applicationConfigurationContext;

    private static InformationRepository instance = null;
	
	public static InformationRepository getInstance() {

        if(instance == null) {
            log.trace("resource repository created");
            instance = new InformationRepository();
        }

        return instance;
    }

	private InformationRepository() {
		super();
		this.rootResources = new ArrayList<RootResource>();

	}

	public void addRootResource(RootResource rootResource) {
        this.rootResources.add(rootResource);
	}


    public List<RootResource> getRootResources() {
        return rootResources;
    }

    public ApiMetaDataInformation getApiMetaData() {
        return apiMetaData;
    }

    public void setApiMetaData(ApiMetaDataInformation apiMetaData) {
        this.apiMetaData = apiMetaData;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public ApplicationConfigurationContext getApplicationConfigurationContext() {
        return applicationConfigurationContext;
    }

    public void setApplicationConfigurationContext(ApplicationConfigurationContext applicationConfigurationContext) {
        this.applicationConfigurationContext = applicationConfigurationContext;
    }
}
