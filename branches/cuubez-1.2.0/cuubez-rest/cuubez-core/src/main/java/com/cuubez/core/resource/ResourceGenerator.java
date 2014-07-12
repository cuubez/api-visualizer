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


import com.cuubez.core.template.JaxRsUriTemplateProcessor;
import com.cuubez.core.template.UriTemplateProcessor;
import com.cuubez.core.template.UriTemplate;
import com.cuubez.core.resource.metaData.ClassMetaData;
import com.cuubez.core.resource.metaData.MethodMetaData;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

public class ResourceGenerator {


    public RootResource generateResource(Class<?> clazz) {

        RootResource resource = null;

        if (ResourceMetaDataScanner.isResource(clazz)) {

            resource = new RootResource();

            ResourceMetaDataScanner resourceMetaDataScanner = new ResourceMetaDataScanner();
            ClassMetaData classMetaData = resourceMetaDataScanner.scanClass(clazz);

            if (classMetaData == null) {
                return null;
            }

            resource.setClassMetaData(classMetaData);

            UriTemplateProcessor templateProcessor = new JaxRsUriTemplateProcessor();
            UriTemplate uriTemplate = templateProcessor.compile(classMetaData);
            resource.setUriTemplate(uriTemplate);

            resource.setSubResources(generateSubResource(resourceMetaDataScanner, classMetaData));

        }

        return resource;

    }


    private List<SubResource> generateSubResource(ResourceMetaDataScanner resourceMetaDataScanner, ClassMetaData classMetaData) {

        Class<?> clazz = classMetaData.getClazz();
        Method[] methods = clazz.getDeclaredMethods();

        List<SubResource> subResources = new ArrayList<SubResource>();

        for (Method method : methods) {

            if (ResourceMetaDataScanner.isSubResource(method)) {
                MethodMetaData methodMetaData = resourceMetaDataScanner.scanMethods(clazz, method);

                if (methodMetaData != null) {

                    populateRootLevelValues(classMetaData, methodMetaData);
                    methodMetaData.setReturnType(method.getReturnType());

                    SubResource subResource = new SubResource();
                    subResource.setMethodMetaData(methodMetaData);

                    UriTemplateProcessor templateProcessor = new JaxRsUriTemplateProcessor();
                    UriTemplate uriTemplate = templateProcessor.compile(methodMetaData);

                    subResource.setUriTemplate(uriTemplate);
                    subResources.add(subResource);

                }

            }
        }
        return subResources;
    }

    private void populateRootLevelValues(ClassMetaData classMetaData, MethodMetaData methodMetaData) {

        if (methodMetaData.getConsume() == null || methodMetaData.getConsume().length == 0) {
            methodMetaData.setConsume(classMetaData.getConsume());
        }

        if (methodMetaData.getProduce() == null || methodMetaData.getProduce().length == 0) {
            methodMetaData.setProduce(classMetaData.getProduce());
        }

    }

    public InterceptorProvider generateInterceptorProvide(final Class<?> clazz) {

        InterceptorProvider interceptorProvider = null;

        if (ResourceMetaDataScanner.isProvider(clazz) && ResourceMetaDataScanner.isInterceptor(clazz)) {
            interceptorProvider = new InterceptorProvider();
            interceptorProvider.setClazz(clazz);
        }

        return interceptorProvider;
    }

}
