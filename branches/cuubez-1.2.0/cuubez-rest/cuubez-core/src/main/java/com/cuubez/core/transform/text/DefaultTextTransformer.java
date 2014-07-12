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
package com.cuubez.core.transform.text;


import com.cuubez.core.exception.CuubezException;
import com.cuubez.core.exception.CuubezExceptionConstance;
import com.cuubez.core.transform.Transformer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultTextTransformer implements Transformer {

    private static Log log = LogFactory.getLog(DefaultTextTransformer.class);

    public String marshal(Object object) throws CuubezException {

        if(object == null) {
            return null;
        }

        if(object.getClass().isPrimitive() || object.getClass().equals(String.class) || object.getClass().equals(Integer.class) || object.getClass().equals(Double.class) ||
                object.getClass().equals(Short.class) || object.getClass().equals(Long.class) || object.getClass().equals(Float.class) ||
                object.getClass().equals(Boolean.class) || object.getClass().equals(Character.class)) {

            return object.toString();
        } else {
            log.error(object.getClass().getCanonicalName()+" not support to Plain Text media type");
            throw new CuubezException(CuubezExceptionConstance.UNSUPPORTED_MEDIA_TYPE);

        }

    }


    public <T> T unMarshal(String rootNode, String content, Class<T> type) throws CuubezException {
        throw new CuubezException(CuubezExceptionConstance.UNSUPPORTED_CONSUMER_TYPE);
    }
}
