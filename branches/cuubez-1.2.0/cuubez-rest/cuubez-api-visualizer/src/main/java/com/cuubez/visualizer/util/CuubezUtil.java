package com.cuubez.visualizer.util;


import com.cuubez.visualizer.context.HttpCodeMetaData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.ArrayList;
import java.util.List;

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

        if(!rootPath.startsWith(PATH_SEPARATOR)) {
            rootPath = PATH_SEPARATOR + rootPath;
        }

        if (!rootPath.endsWith(PATH_SEPARATOR)) {
            rootPath = rootPath + PATH_SEPARATOR;
        }

        return rootPath;
    }

    private static String normalizeSubPath(String subPath) {

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
            log.error(e);
        } catch (JsonProcessingException e) {
            log.error(e);
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



}
