package com.cuubez.visualizer.resource;


import com.cuubez.visualizer.annotation.M;
import com.cuubez.visualizer.context.HeaderVariableMetaData;
import com.cuubez.visualizer.context.PathVariableMetaData;
import com.cuubez.visualizer.context.QueryVariableMetaData;
import com.cuubez.visualizer.resource.domain.RootResource;
import com.cuubez.visualizer.resource.domain.SubResource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

public class ResourceVariableProcessor {

    private static Log log = LogFactory.getLog(ResourceVariableProcessor.class);



    public void process() {

        List<RootResource> rootResourceList = ResourceRepository.getInstance().getRootResources();

        for (RootResource rootResource : rootResourceList) {

            for (SubResource subResource : rootResource.getSubResources()) {


                Method selectedMethod = subResource.getReflectionMethod();
                final Class[] paramTypes = selectedMethod.getParameterTypes();

                final Annotation[][] paramAnnotations = selectedMethod.getParameterAnnotations();


                for (int i = 0; i < paramAnnotations.length; i++) {

                    boolean pathParam = false;
                    boolean queryParam = false;
                    boolean headerParam = false;
                    boolean mandatory = false;
                    String name = null;

                    for (Annotation annotation : paramAnnotations[i]) {

                        if (annotation instanceof PathParam) {
                            name = ((PathParam) annotation).value();
                            pathParam = true;

                        } else if (annotation instanceof QueryParam) {

                            name = ((QueryParam) annotation).value();
                            queryParam = true;

                        } else if (annotation instanceof HeaderParam) {

                            name = ((HeaderParam) annotation).value();
                            headerParam = true;

                        } else if(annotation instanceof M) {

                            mandatory = true;
                        }
                    }

                    if(!pathParam && !headerParam && !queryParam) {
                       subResource.setRequestBody(paramTypes[i]);
                    }

                    constructPathVariableContext(name, pathParam, mandatory, paramTypes[i], subResource);
                    constructQueryVariableContext(name, queryParam, mandatory, paramTypes[i], subResource);
                    constructHeaderVariableContext(name, headerParam, mandatory, paramTypes[i], subResource);

                }

            }
        }




    }

    private void constructPathVariableContext(String name, boolean pathParam, boolean mandatory, Class type, SubResource subResource ) {

        if(pathParam) {

            PathVariableMetaData pathVariableMetaData = new PathVariableMetaData(name, true, type.getSimpleName(), null);
            subResource.addPathVariableMetaData(pathVariableMetaData);
        }


    }


    private void constructQueryVariableContext(String name, boolean queryParam, boolean mandatory, Class type, SubResource subResource ) {

        if(queryParam) {

            QueryVariableMetaData queryVariableMetaData = new QueryVariableMetaData(name, mandatory, type.getSimpleName(), null);
            subResource.addQueryVariableMetaData(queryVariableMetaData);
        }


    }

    private void constructHeaderVariableContext(String name, boolean headerParam, boolean mandatory, Class type, SubResource subResource ) {

        if(headerParam) {

            HeaderVariableMetaData headerVariableMetaData = new HeaderVariableMetaData(name, mandatory, type.getSimpleName(), null);
            subResource.addHeaderVariableMetaData(headerVariableMetaData);
        }


    }


}
