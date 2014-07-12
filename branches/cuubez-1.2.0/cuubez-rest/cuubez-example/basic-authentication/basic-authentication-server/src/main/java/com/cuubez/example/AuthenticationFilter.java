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
package com.cuubez.example;


import com.cuubez.core.Interceptor.RequestInterceptor;
import com.cuubez.core.annotation.security.DenyAll;
import com.cuubez.core.annotation.security.PermitAll;
import com.cuubez.core.annotation.security.RolesAllowed;
import com.cuubez.core.context.InterceptorRequestContext;
import com.cuubez.core.context.InterceptorResponseContext;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthenticationFilter implements RequestInterceptor {

    private final InterceptorResponseContext ACCESS_FORBIDDEN = new InterceptorResponseContext("No access", HttpServletResponse.SC_FORBIDDEN);

    public InterceptorResponseContext process(InterceptorRequestContext interceptorRequestContext) {


        if (interceptorRequestContext.isAnnotationContain(DenyAll.class)) {

            return ACCESS_FORBIDDEN;

        } else if (interceptorRequestContext.isAnnotationContain(PermitAll.class)) {

            return null;

        } else if (interceptorRequestContext.isAnnotationContain(RolesAllowed.class)) {

            //get encoded user name and password
            String encodedUserName = interceptorRequestContext.getHeader("userName");
            String encodedPassword = interceptorRequestContext.getHeader("password");

            //decode user name and password
            String decodedUserName = new String(Base64.decodeBase64(encodedUserName.getBytes()));
            String decodedPassword = new String(Base64.decodeBase64(encodedPassword.getBytes()));

            //get allowed user roles
            String[] allowedRoles = ((RolesAllowed) interceptorRequestContext.getAnnotation(RolesAllowed.class)).value();

            //Access userAccessor to retrieve user details(UserAccessor is not provided by framework, developer need to implement it according their requirement)
            UserAccessor userAccessor = new UserAccessor();
            String role = userAccessor.getUserRole(decodedUserName, decodedPassword);

            if(isAllow(allowedRoles, role)) {
                return null;
            } else {
                return ACCESS_FORBIDDEN;
            }

        }

        return null;

    }

    private boolean isAllow(final String[] allowedRoles, final String userRole) {

        for (String allRole : allowedRoles) {

            if (allRole.equals(userRole)) {
                return true;
            }
        }

        return false;
    }
}
