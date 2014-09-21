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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ResourceGenerator {


    public RootResource generateResource(Class<?> clazz) {

        RootResource rootResource = null;

        if (ResourceMetaDataScanner.isResource(clazz)) {

            ResourceMetaDataScanner resourceMetaDataScanner = ResourceMetaDataScanner.getInstance();
            rootResource = resourceMetaDataScanner.scanClass(clazz);

            if (rootResource == null) {
                return null;
            }


            rootResource.setSubResources(generateSubResource(resourceMetaDataScanner, rootResource));

        }

        return rootResource;

    }


    private List<SubResource> generateSubResource(ResourceMetaDataScanner resourceMetaDataScanner, RootResource rootResource) {

        Class<?> clazz = rootResource.getClazz();
        Method[] methods = clazz.getDeclaredMethods();

        List<SubResource> subResources = new ArrayList<SubResource>();

        for (Method method : methods) {

            if (ResourceMetaDataScanner.isSubResource(method)) {
                SubResource subResource = resourceMetaDataScanner.scanMethods(clazz, method);

                if (subResource != null) {

                    populateRootLevelValues(rootResource, subResource);
                    subResources.add(subResource);

                }

            }
        }
        return subResources;
    }

    private void populateRootLevelValues(RootResource rootResource, SubResource subResource) {

        if (subResource.getConsume() == null || subResource.getConsume().length == 0) {
            subResource.setConsume(rootResource.getConsume());
        }

        if (subResource.getProduce() == null || subResource.getProduce().length == 0) {
            subResource.setProduce(rootResource.getProduce());
        }

    }



}
