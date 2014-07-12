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

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.cuubez.core.exception.CuubezException;
import com.cuubez.core.exception.CuubezExceptionConstance;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XMLTransformerUtil {

    private static Log log = LogFactory.getLog(XMLTransformerUtil.class);

    public static Document createDocument(HttpServletRequest httpServletRequest) throws ParserConfigurationException, CuubezException/*, IOException*/ {

        javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        javax.xml.parsers.DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = null;

        try {

            if(httpServletRequest.getContentLength() > 0) {

                document = db.parse(httpServletRequest.getInputStream());
            }

        } catch (SAXException e) {
            log.error(e);
            throw new CuubezException(CuubezExceptionConstance.PARSING_EXCEPTION);
        } catch (IOException e) {
            log.error(e);
            throw new CuubezException(CuubezExceptionConstance.PARSING_EXCEPTION);
        }

        return document;
    }


    public static String getDocumentAsString(Document doc) throws TransformerFactoryConfigurationError, TransformerException {

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(doc);
        transformer.transform(source, result);

        return result.getWriter().toString();
    }


    public static  String getRootNodeName(final Document document) {

        Node node = document.getDocumentElement();
        return node.getNodeName();

    }


    public static boolean isEmpty(final Document document) {

        if(document == null) {
            return false;
        }

        if(document.getDocumentElement() == null) {
            return false;
        }

        return true;
    }


}
