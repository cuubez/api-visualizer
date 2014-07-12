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
import com.cuubez.core.transform.Transformer;
import com.cuubez.core.transform.json.DefaultJSONTransformer;
import com.cuubez.core.transform.text.DefaultTextTransformer;
import com.cuubez.core.transform.xml.DefaultXMLTransformer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.core.MediaType;

public class ResponseTransformHandler implements ResponseHandler {


    private static Log log = LogFactory.getLog(ResponseTransformHandler.class);

    public void handleResponse(MessageContext messageContext) throws CuubezException {


        if(!messageContext.getResponseContext().isNeedToTransform()) {

            String responseContent = "";
            if(messageContext.getResponseContext().getReturnObject() != null) {
                responseContent = messageContext.getResponseContext().getReturnObject().toString();
            }

           messageContext.getResponseContext().setContent(responseContent);

        } else if (MediaType.APPLICATION_XML.equals(messageContext.getResponseContext().getMediaType()) && messageContext.getResponseContext().isNeedToTransform()) {

            log.trace("response transformation[XML] started");
            Transformer transformer = new DefaultXMLTransformer();
            String output = transformer.marshal(messageContext.getResponseContext().getReturnObject());
            messageContext.getResponseContext().setContent(output);

        } else if (MediaType.APPLICATION_JSON.equals(messageContext.getResponseContext().getMediaType()) && messageContext.getResponseContext().isNeedToTransform()) {

            log.trace("response transformation[JSON] started");
            Transformer transformer = new DefaultJSONTransformer();
            String output = transformer.marshal(messageContext.getResponseContext().getReturnObject());
            messageContext.getResponseContext().setContent(output);

        } else if (MediaType.TEXT_PLAIN.equals(messageContext.getResponseContext().getMediaType()) && messageContext.getResponseContext().isNeedToTransform()) {

            log.trace("response transformation[Text] started");
            Transformer transformer = new DefaultTextTransformer();
            String output = transformer.marshal(messageContext.getResponseContext().getReturnObject());
            messageContext.getResponseContext().setContent(output);

        }

    }
}
