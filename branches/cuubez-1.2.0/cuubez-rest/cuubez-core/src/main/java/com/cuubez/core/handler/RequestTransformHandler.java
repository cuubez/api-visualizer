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
import com.cuubez.core.exception.CuubezExceptionConstance;
import com.cuubez.core.transform.json.DefaultJSONTransformer;
import com.cuubez.core.transform.xml.DefaultXMLTransformer;
import com.cuubez.core.exception.CuubezException;
import com.cuubez.core.util.XMLTransformerUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;

import javax.ws.rs.core.MediaType;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.io.InputStreamReader;

public class RequestTransformHandler implements RequestHandler {

    private static Log log = LogFactory.getLog(RequestTransformHandler.class);


    public void handleRequest(MessageContext messageContext) throws CuubezException {

        if(MediaType.APPLICATION_XML.equals(getConsumeType(messageContext))) {

            transformFromXML(messageContext);

        } else if(MediaType.APPLICATION_JSON.equals(getConsumeType(messageContext))) {

            transformFromJSON(messageContext);
        }

    }


    private void transformFromXML(MessageContext messageContext) throws CuubezException {

        String content = null;
        Object output;
        Document document = null;

        log.trace("request transformation[XML] started");
        DefaultXMLTransformer transformer = new DefaultXMLTransformer();

        try {

            document = XMLTransformerUtil.createDocument(messageContext.getRequestConfigurationContext().getRequest());

            if(XMLTransformerUtil.isEmpty(document)) {
                content = XMLTransformerUtil.getDocumentAsString(document);
            }

        } catch (ParserConfigurationException e) {
            log.error(e);
            throw new CuubezException(CuubezExceptionConstance.PARSING_EXCEPTION);
        } catch (TransformerException e) {
            log.error(e);
            throw new CuubezException(CuubezExceptionConstance.PARSING_EXCEPTION);
        }

        if (content != null) {
            Class<?> inputObjectType = messageContext.getRequestContext().getSelectedResource().getSelectedMethodMetaData().getInputObjectType();
            String rootNode = XMLTransformerUtil.getRootNodeName(document);
            output = transformer.unMarshal(rootNode, content, inputObjectType);
            setInputObjectToParameterArray(messageContext, output);
        }

    }


    private void transformFromJSON(MessageContext messageContext) throws CuubezException {

        Object output;
        log.trace("request transformation[JSON] started");

        DefaultJSONTransformer transformer = new DefaultJSONTransformer();
        Class<?> inputObjectType = messageContext.getRequestContext().getSelectedResource().getSelectedMethodMetaData().getInputObjectType();

        try {
            output = transformer.unMarshal(new InputStreamReader(messageContext.getRequestConfigurationContext().getRequest().getInputStream()), inputObjectType);
            setInputObjectToParameterArray(messageContext, output);
        } catch (IOException e) {
            log.error(e);
            throw new CuubezException(CuubezExceptionConstance.PARSING_EXCEPTION);
        }

    }

    private void setInputObjectToParameterArray(MessageContext messageContext, Object input) {

        Object[] parameters = messageContext.getRequestContext().getSelectedResource().getSelectedMethodMetaData().getParameters();
        int inputObjectIndex =  messageContext.getRequestContext().getSelectedResource().getSelectedMethodMetaData().getInputObjectIndex();

        if(parameters == null) {
            parameters = new Object[1];
            messageContext.getRequestContext().getSelectedResource().getSelectedMethodMetaData().setParameters(parameters);
        }

        if(parameters.length > inputObjectIndex) {
            parameters[inputObjectIndex] = input;
        }
    }


    private String getConsumeType(MessageContext messageContext) throws CuubezException {

        String[] consumeMediaTypes = messageContext.getRequestContext().getSelectedResource().getSelectedMethodMetaData().getConsume();
        String requestMediaType =messageContext.getRequestContext().getUrlContext().getMediaType();


            if (requestMediaType == null && isNotSpecifyMediaType(consumeMediaTypes)) {

                return MediaType.APPLICATION_XML;

            } else if (requestMediaType == null && !isNotSpecifyMediaType(consumeMediaTypes)) {

                return consumeMediaTypes[0];

            } else if (requestMediaType != null && !isNotSpecifyMediaType(consumeMediaTypes)) {

                for (String consumeMediaType : consumeMediaTypes) {

                    if (requestMediaType.equals(consumeMediaType)) {
                        return requestMediaType;
                    }
                }

            } else {

                log.error("unsupported request media type");
                throw new CuubezException(CuubezExceptionConstance.UNSUPPORTED_MEDIA_TYPE);
            }

            log.error("unsupported request media type");
            throw new CuubezException(CuubezExceptionConstance.UNSUPPORTED_MEDIA_TYPE);
        }


    private boolean isNotSpecifyMediaType(String[] consume) {

        if (consume == null || consume.length == 0 || (consume.length == 1 && consume[0] == "*/*")) {
            return true;
        }

        return false;

    }


}
