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
package com.cuubez.core.resource;

import com.cuubez.core.template.UriTemplate;
import com.cuubez.core.resource.metaData.MethodMetaData;

public class SubResource {

    private UriTemplate uriTemplate = null;
    private MethodMetaData methodMetaData = null;

    public MethodMetaData getMethodMetaData() {
        return methodMetaData;
    }

    public void setMethodMetaData(MethodMetaData methodMetaData) {
        this.methodMetaData = methodMetaData;
    }

    public UriTemplate getUriTemplate() {
        return uriTemplate;
    }

    public void setUriTemplate(UriTemplate uriTemplate) {
        this.uriTemplate = uriTemplate;
    }
}
