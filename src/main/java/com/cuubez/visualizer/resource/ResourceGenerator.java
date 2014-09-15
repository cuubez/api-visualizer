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


import com.cuubez.visualizer.context.ClassMetaData;
import com.cuubez.visualizer.context.MethodMetaData;
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
                    SubResource subResource = new SubResource();
                    subResource.setMethodMetaData(methodMetaData);

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



}
