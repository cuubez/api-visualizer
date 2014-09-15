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

import com.cuubez.visualizer.context.ApiMetaData;
import com.cuubez.visualizer.util.CuubezUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResourceRepository {

    private static Log log = LogFactory.getLog(ResourceRepository.class);

    private List<RootResource> rootResources = null;
    private List<ApiMetaData> apiMetaData;
    private static ResourceRepository instance = null;
	
	public static ResourceRepository getInstance() {

        if(instance == null) {
            log.trace("resource repository created");
            instance = new ResourceRepository();
        }

        return instance;
    }

	private ResourceRepository() {
		super();
		this.rootResources = new ArrayList<RootResource>();

	}

	public void addRootResource(RootResource rootResource) {
        this.rootResources.add(rootResource);
	}


    public List<RootResource> getRootResources() {
        return rootResources;
    }

    public List<ApiMetaData> getApiMetaDataList() {
        return apiMetaData;
    }

    public void setApiMetaData(List<ApiMetaData> apiMetaData) {
        this.apiMetaData = apiMetaData;
    }
}
