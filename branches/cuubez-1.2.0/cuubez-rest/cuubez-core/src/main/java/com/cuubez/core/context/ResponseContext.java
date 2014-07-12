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
package com.cuubez.core.context;


import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ResponseContext {

   private String content;
   private Object returnObject;
   private String mediaType;
   private int responseCode = HttpServletResponse.SC_OK; //Default set to success code
   private String responseMessage;
   private boolean needToTransform = true;
   private Map<String, String> headerValues;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Object getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public boolean isNeedToTransform() {
        return needToTransform;
    }

    public void setNeedToTransform(boolean needToTransform) {
        this.needToTransform = needToTransform;
    }

    public Map<String, String> getHeaderValues() {
        return headerValues;
    }

    public void addHeaderValues(final String headerName, final String headerValue) {
        if(this.headerValues == null) {
            this.headerValues = new HashMap<String, String>();
        }

        this.headerValues.put(headerName, headerValue);
    }
}
