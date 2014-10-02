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
package com.cuubez.visualizer.processor;


import com.cuubez.visualizer.domain.configuration.*;
import com.cuubez.visualizer.resource.InformationRepository;
import com.cuubez.visualizer.scanner.ConfigurationScanner;
import com.cuubez.visualizer.util.CuubezUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class ConfigurationProcessor {

    private static Log log = LogFactory.getLog(ConfigurationProcessor.class);

    public void process() {

        InputStream configurationStream = null;
        String applicationPath = InformationRepository.getInstance().getApplicationConfigurationContext().getApplicationPath();
        try {
            configurationStream = new ConfigurationScanner().scan(applicationPath);
        } catch (IOException e) {
            log.debug("No configuration found", e);
        }

        if (configurationStream == null) {
           log.debug("No configuration found");
        }

        Configuration configuration = null;
        try {
            configuration = transformFromXML(configurationStream);
        }catch (Exception e) {
            log.error("Error occurred while processing configuration file", e);
        }
        InformationRepository.getInstance().setConfiguration(configuration);

    }

    private Configuration transformFromXML(InputStream inputStream) {

        String content = null;
        Configuration output = null;
        Document document = null;

        try {

            document = CuubezUtil.createDocument(inputStream);

            if(isEmpty(document)) {
                content = getDocumentAsString(document);
            }

        } catch (ParserConfigurationException e) {
            log.error("Error occurred while processing configuration file", e);
        } catch (TransformerException e) {
            log.error("Error occurred while processing configuration file", e);
        }

        if (content != null) {
            String rootNode = getRootNodeName(document);
            output = (Configuration)unMarshal(rootNode, content, Configuration.class);
        }

        return output;

    }

    private  <T> T unMarshal(String rootNode, String content, Class<T> targetClass) {
        XStream xStream = new XStream(new DomDriver());
        xStream.processAnnotations(Configuration.class);
        xStream.alias(rootNode, targetClass);
        xStream.alias("group", Group.class);
        xStream.alias("http-code", HttpCode.class);
        xStream.alias("resource", Resource.class);
        xStream.alias("variable", Variable.class);
        return targetClass.cast(xStream.fromXML(content));
    }

    private static boolean isEmpty(final Document document) {

        if(document == null) {
            return false;
        }

        if(document.getDocumentElement() == null) {
            return false;
        }

        return true;
    }

    private static String getDocumentAsString(Document doc) throws TransformerFactoryConfigurationError, TransformerException {

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(doc);
        transformer.transform(source, result);

        return result.getWriter().toString();
    }


    private static  String getRootNodeName(final Document document) {

        Node node = document.getDocumentElement();
        return node.getNodeName();

    }

}
