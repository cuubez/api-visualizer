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
package com.cuubez.core.handler;


import com.cuubez.core.context.MessageContext;
import com.cuubez.core.exception.CuubezException;
import com.cuubez.core.util.ResponseCodeTransformUtil;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.CaseInsensitiveMap;
import sun.security.provider.certpath.OCSPResponse;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class ResponseNormalizerHandler implements ResponseHandler {


    public void handleResponse(MessageContext messageContext) throws CuubezException {

        populateResponseObjectValues(messageContext);

    }

    private void populateResponseObjectValues(MessageContext messageContext) {

        if (messageContext.getResponseContext().getReturnObject() != null && messageContext.getResponseContext().getReturnObject() instanceof Response) {

            Response response = (Response) messageContext.getResponseContext().getReturnObject();
            int responseCode = response.getStatus();
            messageContext.getResponseContext().setResponseCode(responseCode);

            Object entity = response.getEntity();

            if (entity == null) {
                entity = "";
            }
            messageContext.getResponseContext().setReturnObject(entity);


            if (isVariable(entity)) {
                messageContext.getResponseContext().setNeedToTransform(false);
            }

            populateMetaData(messageContext, response);

        }
    }


    private boolean isVariable(Object object) {

        if (object == null) {
            return false;
        }

        if (object.getClass().equals(String.class) || object.getClass().equals(Integer.class) || object.getClass().equals(Double.class) ||
                object.getClass().equals(Short.class) || object.getClass().equals(Long.class) || object.getClass().equals(Float.class) ||
                object.getClass().equals(Boolean.class) || object.getClass().equals(Character.class)) {
            return true;

        }

        return false;
    }

    private void populateMetaData(MessageContext messageContext, Response response) {

        MultivaluedMap<String, Object> metadata = response.getMetadata();

        if (metadata != null && metadata.size() > 0) {

            populateContentLocation(messageContext, metadata);
            populateCookies(messageContext, metadata);
            populateExpiresDate(messageContext, metadata);
            populateCacheControl(messageContext, metadata);
            populateLanguage(messageContext, metadata);
            populateLastModified(messageContext, metadata);
            populateLocation(messageContext, metadata);
            populateType(messageContext, metadata);
            populateSeeOther(messageContext, metadata, response.getStatus());
            populateTemporaryRedirect(messageContext, metadata, response.getStatus());
            populateNoContent(messageContext, response);
            populateServerError(messageContext, response);
            populateHeaders(messageContext, metadata);


        }


    }


    private void populateContentLocation(MessageContext messageContext, MultivaluedMap<String, Object> metadata) {

        Object object = metadata.getFirst(HttpHeaders.CONTENT_LOCATION);

        if (object != null) {

            URI uri = (URI) object;

            messageContext.getResponseContext().addHeaderValues(HttpHeaders.CONTENT_LOCATION, uri.toString());

        }

        metadata.remove(HttpHeaders.CONTENT_LOCATION);

    }

    private void populateCookies(MessageContext messageContext, MultivaluedMap<String, Object> metadata) {

        Object object = metadata.getFirst(HttpHeaders.SET_COOKIE);

        if (object != null) {

            NewCookie newCookie = (NewCookie) object;
            messageContext.getResponseContext().addHeaderValues(HttpHeaders.SET_COOKIE, newCookie.getName() + "=" + newCookie.getValue() + ",Version=" + newCookie.getVersion());

        }

        metadata.remove(HttpHeaders.SET_COOKIE);

    }

    private void populateExpiresDate(MessageContext messageContext, MultivaluedMap<String, Object> metadata) {

        Object object = metadata.getFirst(HttpHeaders.EXPIRES);

        if (object != null) {

            String expiresDate = (String) object;
            messageContext.getResponseContext().addHeaderValues(HttpHeaders.EXPIRES, expiresDate);

        }

        metadata.remove(HttpHeaders.EXPIRES);

    }

    private void populateCacheControl(MessageContext messageContext, MultivaluedMap<String, Object> metadata) {

        Object object = metadata.getFirst(HttpHeaders.CACHE_CONTROL);

        if (object != null) {

            CacheControl cacheControl = (CacheControl) object;
            messageContext.getResponseContext().addHeaderValues(HttpHeaders.CACHE_CONTROL, cacheControl.toString());

        }

        metadata.remove(HttpHeaders.CACHE_CONTROL);

    }


    private void populateLanguage(MessageContext messageContext, MultivaluedMap<String, Object> metadata) {

        Object object = metadata.getFirst(HttpHeaders.CONTENT_LANGUAGE);

        if (object != null) {

            Locale locale = (Locale) object;

            String language = locale.getLanguage();
            String country = locale.getCountry();

            if (language != null && !language.isEmpty() && country != null && !country.isEmpty()) {

                String contentLanguage = locale.getLanguage() + "-" + locale.getCountry();
                messageContext.getResponseContext().addHeaderValues(HttpHeaders.CONTENT_LANGUAGE, contentLanguage.toLowerCase());
            }

        }

        metadata.remove(HttpHeaders.CONTENT_LANGUAGE);
    }

    private void populateLastModified(MessageContext messageContext, MultivaluedMap<String, Object> metadata) {

        Object object = metadata.getFirst(HttpHeaders.LAST_MODIFIED);

        if (object != null) {

            String lastModified = (String) object;

            if (lastModified != null && !lastModified.isEmpty()) {
                messageContext.getResponseContext().addHeaderValues(HttpHeaders.LAST_MODIFIED, lastModified);
            }

        }

        metadata.remove(HttpHeaders.LAST_MODIFIED);

    }

    private void populateLocation(MessageContext messageContext, MultivaluedMap<String, Object> metadata) {

        Object object = metadata.getFirst(HttpHeaders.LOCATION);

        if (object != null) {

            URI location = (URI) object;
            messageContext.getResponseContext().addHeaderValues(HttpHeaders.LOCATION, location.toString());
        }

        metadata.remove(HttpHeaders.LOCATION);

    }

    private void populateType(MessageContext messageContext, MultivaluedMap<String, Object> metadata) {

        Object object = metadata.getFirst(HttpHeaders.CONTENT_TYPE);

        if (object != null) {

            MediaType mediaType = MediaType.valueOf(String.valueOf(object));
            messageContext.getResponseContext().setMediaType(mediaType.toString());

        }

        metadata.remove(HttpHeaders.CONTENT_TYPE);

    }

    private void populateSeeOther(MessageContext messageContext, MultivaluedMap<String, Object> metadata, int status) {

        if (status == HttpServletResponse.SC_SEE_OTHER) {
            Object object = metadata.getFirst(HttpHeaders.LOCATION);

            if (object != null) {

                URI location = (URI) object;

                messageContext.getResponseContext().addHeaderValues(HttpHeaders.LOCATION, location.toString());

            }
            messageContext.getResponseContext().setResponseCode(HttpServletResponse.SC_SEE_OTHER);
        }

        metadata.remove(HttpHeaders.LOCATION);

    }

    private void populateTemporaryRedirect(MessageContext messageContext, MultivaluedMap<String, Object> metadata, int status) {

        if (status == HttpServletResponse.SC_TEMPORARY_REDIRECT) {
            Object object = metadata.getFirst(HttpHeaders.LOCATION);

            if (object != null) {

                URI location = (URI) object;

                messageContext.getResponseContext().addHeaderValues(HttpHeaders.LOCATION, location.toString());

            }
            messageContext.getResponseContext().setResponseCode(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        }

        metadata.remove(HttpHeaders.LOCATION);

    }

    private void populateNoContent(MessageContext messageContext, Response response) {
        if (HttpServletResponse.SC_NO_CONTENT == response.getStatus()) {
            messageContext.getResponseContext().setResponseCode(HttpServletResponse.SC_NO_CONTENT);
        }
    }

    private void populateServerError(MessageContext messageContext, Response response) {
        if (HttpServletResponse.SC_INTERNAL_SERVER_ERROR == response.getStatus()) {
            messageContext.getResponseContext().setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }


    private void populateHeaders(MessageContext messageContext, MultivaluedMap<String, Object> metadata) {

        for (String key : metadata.keySet()) {

            Object value = metadata.get(key);

            if (value != null) {
                List<Object> values = (List<Object>) value;
                messageContext.getResponseContext().addHeaderValues(key, String.valueOf(values.get(0)));
            }

        }

    }

}
