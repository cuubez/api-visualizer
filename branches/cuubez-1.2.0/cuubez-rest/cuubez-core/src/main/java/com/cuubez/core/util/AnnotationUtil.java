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

package com.cuubez.core.util;


import com.cuubez.core.annotation.security.DenyAll;
import com.cuubez.core.annotation.security.PermitAll;
import com.cuubez.core.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AnnotationUtil {

    public static List<Annotation> getMethodLevelAnnotations(final Class<?> clazz, final Method method) {

        List<Annotation> annotations = new ArrayList<Annotation>();

        annotations.add(getHttpMethodAnnotation(method));
        annotations.add(getMethodPathAnnotation(clazz, method));

        Annotation produceAnnotation = getMethodProduceAnnotation(clazz, method);
        if(produceAnnotation != null) {
            annotations.add(produceAnnotation);
        }

        Annotation consumeAnnotation = getMethodConsumeAnnotation(clazz, method);
        if(consumeAnnotation != null) {
            annotations.add(consumeAnnotation);
        }

        Annotation accessLevelAnnotation = getMethodAccessLevelAnnotation(clazz, method);

        if(accessLevelAnnotation != null) {
            annotations.add(accessLevelAnnotation);
        }


        return annotations;

    }

    public static Annotation getHttpMethodAnnotation(final Method method) {

        if(method.getAnnotation(GET.class) != null) {
           return method.getAnnotation(GET.class);
        }else if(method.getAnnotation(POST.class) != null) {
            return method.getAnnotation(POST.class);
        }else if(method.getAnnotation(PUT.class) != null) {
            return method.getAnnotation(PUT.class);
        }else {
            return method.getAnnotation(DELETE.class);
        }

    }

    public static Annotation getMethodPathAnnotation(final Class<?> clazz, final Method method) {

        if(method.getAnnotation(Path.class) != null) {
            return method.getAnnotation(Path.class);
        } else {
            return clazz.getAnnotation(Path.class);
        }
    }

    public static Annotation getMethodConsumeAnnotation(final Class<?> clazz, final Method method){

        if(method.getAnnotation(Consumes.class) != null) {
            return method.getAnnotation(Consumes.class);
        } else {
            return clazz.getAnnotation(Consumes.class);
        }
    }

    public static Annotation getMethodProduceAnnotation(final Class<?> clazz, final Method method){

        if(method.getAnnotation(Produces.class) != null) {
            return method.getAnnotation(Produces.class);
        } else {
            return clazz.getAnnotation(Produces.class);
        }
    }

    public static Annotation getMethodAccessLevelAnnotation(final Class<?> clazz, final Method method){

        if(method.getAnnotation(DenyAll.class) != null) {
            return method.getAnnotation(DenyAll.class);
        }else if(method.getAnnotation(PermitAll.class) != null) {
            return method.getAnnotation(PermitAll.class);
        }else if(method.getAnnotation(RolesAllowed.class) != null) {
            return method.getAnnotation(RolesAllowed.class);
        }else if(clazz.getAnnotation(DenyAll.class) != null) {
            return clazz.getAnnotation(DenyAll.class);
        }else if(clazz.getAnnotation(PermitAll.class) != null) {
            return clazz.getAnnotation(PermitAll.class);
        }else if(clazz.getAnnotation(RolesAllowed.class) != null) {
            return clazz.getAnnotation(RolesAllowed.class);
        }else {

            return null;
        }

    }
}
