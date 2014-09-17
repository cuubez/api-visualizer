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

import com.cuubez.visualizer.annotation.Detail;
import com.cuubez.visualizer.annotation.Name;
import com.cuubez.visualizer.annotation.ResponseType;
import com.cuubez.visualizer.resource.domain.RootResource;
import com.cuubez.visualizer.resource.domain.SubResource;
import com.cuubez.visualizer.util.CuubezUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.*;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ResourceMetaDataScanner {

    private static Log log = LogFactory.getLog(ResourceMetaDataScanner.class);
    private static ResourceMetaDataScanner instance = null;

    public static ResourceMetaDataScanner getInstance() {

        if(instance == null) {
            log.trace("resource repository created");
            instance = new ResourceMetaDataScanner();
        }

        return instance;
    }

    private ResourceMetaDataScanner() {
        super();
    }

    public RootResource scanClass(Class<?> clazz) {

        RootResource rootResource = new RootResource();

        scanPath(clazz, rootResource);
        scanConsume(clazz, rootResource);
        scanProduce(clazz, rootResource);
        scanHttpCodes(clazz, rootResource);
        rootResource.setClazz(clazz);
        return rootResource;

    }


    public SubResource scanMethods(Class<?> clazz, Method method) {

        int modifier = method.getModifiers();

        if (Modifier.isStatic(modifier) || !Modifier.isPublic(modifier)) {
            return null;
        }

        SubResource subResource = new SubResource();
        subResource.setReflectionMethod(method);

        if (!scanHttpMethod(subResource, method)) {
            return null;
        }

        scanPath(subResource, method);
        scanConsume(subResource, method);
        scanProduce(subResource, method);
        scanDetail(subResource, method);
        scanName(subResource, method);
        scanHttpCodes(subResource, method);
        scanResponseType(subResource, method);
        subResource.setClazz(clazz);

        return subResource;
    }


    public static boolean isResource(Class<?> clazz) {

        if (Modifier.isInterface(clazz.getModifiers()) || Modifier.isAbstract(clazz.getModifiers())) {
            return false;
        }

        if (clazz.getAnnotation(Path.class) != null) {
            return true;
        }

        Class<?> declaringClass = clazz;

        while (!declaringClass.equals(Object.class)) {
            // try a superclass
            Class<?> superclass = declaringClass.getSuperclass();
            if (superclass.getAnnotation(Path.class) != null) {
                return true;
            }

            // try interfaces
            Class<?>[] interfaces = declaringClass.getInterfaces();
            for (Class<?> interfaceClass : interfaces) {
                if (interfaceClass.getAnnotation(Path.class) != null) {
                    return true;
                }
            }
            declaringClass = declaringClass.getSuperclass();
        }
        return false;
    }

    public static boolean isSubResource(Method method) {


        if (method.getAnnotation(GET.class) != null ||
                method.getAnnotation(POST.class) != null || method.getAnnotation(PUT.class) != null || method.getAnnotation(DELETE.class) != null) {

            return true;
        }

        return false;

    }

    public static boolean isProvider(Class<?> clazz) {

        if (clazz.getAnnotation(Provider.class) != null) {
            return true;
        }

        return false;
    }

    private boolean scanPath(SubResource subResource, Method method) {

        Path path = method.getAnnotation(Path.class);

        if (path != null) {
            subResource.setPath(normalizePath(path.value()));
            return true;
        }

        return false;
    }

    private boolean scanPath(Class<?> clazz, RootResource rootResource) {

        Path path = clazz.getAnnotation(Path.class);

        if (path != null) {
            rootResource.setPath(normalizePath(path.value()));
            return true;
        }

        if (!clazz.equals(Object.class)) {

            Class<?> superClass = clazz.getSuperclass();
            Path superClassPath = superClass.getAnnotation(Path.class);

            if (superClassPath != null) {
                rootResource.setPath(normalizePath(superClassPath.value()));
                return true;
            }

            Class<?>[] interfaces = clazz.getInterfaces();

            for (Class<?> intface : interfaces) {

                Path interfacePath = intface.getAnnotation(Path.class);

                if (interfacePath != null) {

                    rootResource.setPath(normalizePath(interfacePath.value()));
                    return true;

                }
            }

        }

        return false;
    }

    private boolean scanProduce(SubResource subResource, Method method) {

        Produces produce = method.getAnnotation(Produces.class);

        if (produce != null) {
            subResource.setProduce(produce.value());

            return true;
        }

        return false;
    }


    private boolean scanDetail(SubResource subResource, Method method) {

        Detail detail = method.getAnnotation(Detail.class);

        if (detail != null) {

            subResource.setDetail(detail.value());
            return true;
        }

        return false;
    }

    private boolean scanName(SubResource subResource, Method method) {

        Name name = method.getAnnotation(Name.class);

        if (name != null) {

            subResource.setName(name.value());
            return true;
        }

        return false;
    }

    private boolean scanHttpMethod(SubResource subResource, Method method) {

        GET get = method.getAnnotation(GET.class);

        if (get != null) {
            subResource.setHttpMethod(HttpMethod.GET);
            return true;
        }

        POST post = method.getAnnotation(POST.class);

        if (post != null) {
            subResource.setHttpMethod(HttpMethod.POST);
            return true;
        }

        PUT put = method.getAnnotation(PUT.class);

        if (put != null) {
            subResource.setHttpMethod(HttpMethod.PUT);
            return true;
        }

        DELETE delete = method.getAnnotation(DELETE.class);

        if (delete != null) {
            subResource.setHttpMethod(HttpMethod.DELETE);
            return true;
        }

        return false;
    }


    private boolean scanProduce(Class<?> clazz, RootResource rootResource) {

        Produces produce = clazz.getAnnotation(Produces.class);

        if (produce != null) {
            rootResource.setProduce(produce.value());

            return true;
        }

        return false;
    }

    private boolean scanName(Class<?> clazz, RootResource rootResource) {

        Name name = clazz.getAnnotation(Name.class);

        if (name != null) {
            rootResource.setName(name.value());
            return true;
        }

        return false;
    }

    private boolean scanDetail(Class<?> clazz, RootResource rootResource) {

        Detail detail = clazz.getAnnotation(Detail.class);

        if (detail != null) {
            rootResource.setDetail(detail.value());

            return true;
        }

        return false;
    }


    private boolean scanConsume(SubResource subResource, Method method) {

        Consumes consume = method.getAnnotation(Consumes.class);

        if (consume != null) {
            subResource.setConsume(consume.value());
            return true;
        }

        return false;
    }

    private boolean scanConsume(Class<?> clazz, RootResource rootResource) {

        Consumes consume = clazz.getAnnotation(Consumes.class);

        if (consume != null) {
            rootResource.setConsume(consume.value());

            return true;
        }

        return false;
    }

    private boolean scanHttpCodes(Class<?> clazz, RootResource rootResource) {

        com.cuubez.visualizer.annotation.HttpCode httpCode = clazz.getAnnotation(com.cuubez.visualizer.annotation.HttpCode.class);

        if (httpCode != null) {
            rootResource.setHttpCodeMetaDataList(CuubezUtil.generateHttpCodeMetaData(httpCode.value()));
            return true;
        }

        return false;
    }

    private boolean scanHttpCodes(SubResource subResource, Method method) {

        com.cuubez.visualizer.annotation.HttpCode httpCode = method.getAnnotation(com.cuubez.visualizer.annotation.HttpCode.class);

        if (httpCode != null) {
            subResource.setHttpCodeMetaDataList(CuubezUtil.generateHttpCodeMetaData(httpCode.value()));
            return true;
        }

        return false;
    }

    private boolean scanResponseType(SubResource subResource, Method method) {

        ResponseType responseType = method.getAnnotation(ResponseType.class);

        if (responseType != null) {
            subResource.setReturnType(responseType.value());
            return true;
        }

        return false;
    }


    private String normalizePath(String path) {

        if (!path.startsWith("/")) {
            path = "/".concat(path);
        }

        return path;

    }

}
