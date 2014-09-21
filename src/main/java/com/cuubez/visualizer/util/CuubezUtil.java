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
package com.cuubez.visualizer.util;


import com.cuubez.visualizer.domain.HttpCodeMetaData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CuubezUtil {

    private static Log log = LogFactory.getLog(CuubezUtil.class);


    private static String PATH_SEPARATOR = "/";

    public static String constructApiPath(String rootPath, String subPath) {

        rootPath = normalizeRootPath(rootPath);
        subPath = normalizeSubPath(subPath);

        if(isNullOrEmpty(rootPath) && isNullOrEmpty(subPath)) {

            return null;

        } else if (!isNullOrEmpty(rootPath) && isNullOrEmpty(subPath)) {

            return rootPath;

        } else if (isNullOrEmpty(rootPath) && !isNullOrEmpty(subPath)) {

            return subPath;

        } else {

            return rootPath + subPath;

        }

    }

    private static String normalizeRootPath(String rootPath) {

        if (isNullOrEmpty(rootPath)) {
            return null;
        }

        if(!rootPath.startsWith(PATH_SEPARATOR)) {
            rootPath = PATH_SEPARATOR + rootPath;
        }

        if (!rootPath.endsWith(PATH_SEPARATOR)) {
            rootPath = rootPath + PATH_SEPARATOR;
        }

        return rootPath;
    }

    private static String normalizeSubPath(String subPath) {

        if (isNullOrEmpty(subPath)) {
            return null;
        }

        if(subPath.startsWith(PATH_SEPARATOR) && subPath.length() == 1) {
            return null;

        } else if (subPath.startsWith(PATH_SEPARATOR)) {
            return subPath.substring(1);
        }

        return subPath;
    }


    public static boolean isNullOrEmpty(final String value) {

        if(value == null || value.isEmpty()) {
            return true;
        }

        return false;
    }

    public static String getName(String rootResourceName, String subResourceName) {

        if(!isNullOrEmpty(subResourceName)) {
            return subResourceName;
        }

        return rootResourceName;
    }

    public static String getDetail(String rootResourceDetail, String subResourceDetail) {

        if(!isNullOrEmpty(subResourceDetail)) {
            return subResourceDetail;
        }

        return rootResourceDetail;
    }


    public static String generateJsonSchema(Class<?> clazz) {


        ObjectMapper mapper = new ObjectMapper();
        SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
        try {
            mapper.acceptJsonFormatVisitor(clazz, visitor);

            JsonSchema schema = visitor.finalSchema();
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema);

        } catch (JsonMappingException e) {
            log.error("Error occurred while generating JSON schema for the class ["+clazz+"]",e);
        } catch (JsonProcessingException e) {
            log.error("Error occurred while generating JSON schema for the class ["+clazz+"]",e);
        }

        return null;
    }

    public static List<HttpCodeMetaData> generateHttpCodeMetaData(String value) {

        if(isNullOrEmpty(value)) {
            return null;
        }

        List<HttpCodeMetaData> httpCodeMetaDataList = new ArrayList<HttpCodeMetaData>();

        String[] httpCodes = value.split(",");

        for (String httpCode : httpCodes) {

            String[] httpCodeDetail = httpCode.split(">");

            if(httpCodeDetail.length == 2) {
                HttpCodeMetaData httpCodeMetaData = new HttpCodeMetaData(httpCodeDetail[0], httpCodeDetail[1]);
                httpCodeMetaDataList.add(httpCodeMetaData);
            }

        }

        return httpCodeMetaDataList;
    }

    public static List<HttpCodeMetaData> getHttpCodes(List<HttpCodeMetaData> rootHttpCodes, List<HttpCodeMetaData> subResourceHttpCodes) {

        if((subResourceHttpCodes != null && subResourceHttpCodes.size() > 0) && (rootHttpCodes != null && rootHttpCodes.size() >0)) {

            List<HttpCodeMetaData> httReasonCodeList = new ArrayList<HttpCodeMetaData>();
            httReasonCodeList.addAll(rootHttpCodes);
            httReasonCodeList.addAll(subResourceHttpCodes);

            return httReasonCodeList;
        }

        if(subResourceHttpCodes != null && subResourceHttpCodes.size() > 0) {
            return subResourceHttpCodes;
        }

        if((subResourceHttpCodes == null || subResourceHttpCodes.size() == 0) && (rootHttpCodes != null && rootHttpCodes.size() >0)) {
            return rootHttpCodes;
        }

        return null;

    }


    public static String generateRandomString() {

        double MEAN = 100.0f;
        double VARIANCE = 5.0f;

        return String.valueOf(MEAN + new Random().nextGaussian() * VARIANCE);
    }

    public static Document createDocument(InputStream inputStream) throws ParserConfigurationException{

        javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        javax.xml.parsers.DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = null;

        try {

            document = db.parse(inputStream);

        } catch (SAXException e) {
            log.error("Wrong configuration file format",e);
        } catch (IOException e) {
            log.error("Wrong configuration file format",e);
        }

        return document;
    }



}
