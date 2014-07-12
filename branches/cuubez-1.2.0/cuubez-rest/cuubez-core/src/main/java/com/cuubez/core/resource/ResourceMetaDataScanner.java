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

import com.cuubez.core.Interceptor.RequestInterceptor;
import com.cuubez.core.resource.metaData.ClassMetaData;
import com.cuubez.core.resource.metaData.MethodMetaData;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import javax.ws.rs.*;
import javax.ws.rs.ext.Provider;

public class ResourceMetaDataScanner {

    public ClassMetaData scanClass(Class<?> clazz) {

        ClassMetaData classMetaData = new ClassMetaData();

        scanPath(clazz, classMetaData);
        scanConsume(clazz, classMetaData);
        scanProduce(clazz, classMetaData);
        classMetaData.setClazz(clazz);
        return classMetaData;

    }


    public MethodMetaData scanMethods(Class<?> clazz, Method method) {

        int modifier = method.getModifiers();

        if (Modifier.isStatic(modifier) || !Modifier.isPublic(modifier)) {
            return null;
        }

        MethodMetaData methodMetaData = new MethodMetaData();
        methodMetaData.setReflectionMethod(method);

        if (!scanHttpMethod(methodMetaData, method)) {
            return null;
        }
        scanPath(methodMetaData, method);
        scanConsume(methodMetaData, method);
        scanProduce(methodMetaData, method);
        methodMetaData.setClazz(clazz);
        return methodMetaData;
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

    public static boolean isInterceptor(Class<?> clazz) {

        if (RequestInterceptor.class.isAssignableFrom(clazz)) {
            return true;
        }

        return false;

    }

    private boolean scanPath(MethodMetaData methodMetaData, Method method) {

        Path path = method.getAnnotation(Path.class);

        if (path != null) {
            methodMetaData.setPath(normalizePath(path.value()));
            return true;
        }

        return false;
    }

    private boolean scanPath(Class<?> clazz, ClassMetaData classMetaData) {

        Path path = clazz.getAnnotation(Path.class);

        if (path != null) {
            classMetaData.setPath(normalizePath(path.value()));
            return true;
        }

        if (!clazz.equals(Object.class)) {

            Class<?> superClass = clazz.getSuperclass();
            Path superClassPath = superClass.getAnnotation(Path.class);

            if (superClassPath != null) {
                classMetaData.setPath(normalizePath(superClassPath.value()));
                return true;
            }

            Class<?>[] interfaces = clazz.getInterfaces();

            for (Class<?> intface : interfaces) {

                Path interfacePath = intface.getAnnotation(Path.class);

                if (interfacePath != null) {

                    classMetaData.setPath(normalizePath(interfacePath.value()));
                    return true;

                }
            }

        }

        return false;
    }

    private boolean scanProduce(MethodMetaData methodMetaData, Method method) {

        Produces produce = method.getAnnotation(Produces.class);

        if (produce != null) {
            methodMetaData.setProduce(produce.value());

            return true;
        }

        return false;
    }

    private boolean scanHttpMethod(MethodMetaData methodMetaData, Method method) {

        GET get = method.getAnnotation(GET.class);

        if (get != null) {
            methodMetaData.setHttpMethod(HttpMethod.GET);
            return true;
        }

        POST post = method.getAnnotation(POST.class);

        if (post != null) {
            methodMetaData.setHttpMethod(HttpMethod.POST);
            return true;
        }

        PUT put = method.getAnnotation(PUT.class);

        if (put != null) {
            methodMetaData.setHttpMethod(HttpMethod.PUT);
            return true;
        }

        DELETE delete = method.getAnnotation(DELETE.class);

        if (delete != null) {
            methodMetaData.setHttpMethod(HttpMethod.DELETE);
            return true;
        }

        return false;
    }


    private boolean scanProduce(Class<?> clazz, ClassMetaData classMetaData) {

        Produces produce = clazz.getAnnotation(Produces.class);

        if (produce != null) {
            classMetaData.setProduce(produce.value());

            return true;
        }

        return false;
    }


    private boolean scanConsume(MethodMetaData methodMetaData, Method method) {

        Consumes consume = method.getAnnotation(Consumes.class);

        if (consume != null) {
            methodMetaData.setConsume(consume.value());
            return true;
        }

        return false;
    }

    private boolean scanConsume(Class<?> clazz, ClassMetaData classMetaData) {

        Consumes consume = clazz.getAnnotation(Consumes.class);

        if (consume != null) {
            classMetaData.setConsume(consume.value());

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
