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
package com.cuubez.core.template;


import com.cuubez.core.resource.metaData.PathMetaData;
import com.cuubez.core.resource.metaData.PathVariableMetaData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UriTemplateBuilder {

    public static String VARIABLE = "([^/]+?)";
    //public static String TAIL = "((?:/.*)?)";
    public static String TAIL = "((/.*)?)";
    public static String VARIABLE_START = "{";
    public static String VARIABLE_END = "}";
    public static String TEMPLATE_START = "(";
    public static String TEMPLATE_END = ")";
    public static String ROOT_PATH ="/";
    public static final Pattern variablePattern = Pattern.compile("\\{[ \\t]*(\\w[\\w\\.-]*)[ \\t]*(?::[ \\t]*((?:(?:[^{}])|(?:\\{[^{}]*\\}))*)[ \\t]*)?\\}");


    public PathMetaData build(final String path, final boolean rootPath) {

        StringBuffer uriTemplate = null;
        PathMetaData pathMetaData = new PathMetaData();
        pathMetaData.setRootPath(rootPath);


        if(path == null || path.isEmpty() || path.equals(ROOT_PATH)) {

            uriTemplate = new StringBuffer();
            uriTemplate.append(TAIL);
            pathMetaData.setEmpty(true);


        } else {

            List<PathVariableMetaData> pathVariableMetaData = extractVariables(path);
            List<String> pathVariableNames = populateVariableNames(pathVariableMetaData);

            uriTemplate = new StringBuffer();
            uriTemplate.append(TEMPLATE_START);
            uriTemplate.append(TEMPLATE_START);
            uriTemplate.append(path);
            uriTemplate.append(TEMPLATE_END);

            for (String pathVariableName : pathVariableNames) {

                String variableMatcher = VARIABLE_START + pathVariableName + VARIABLE_END;
                int startIndex = uriTemplate.indexOf(variableMatcher);
                int lastIndex = startIndex + variableMatcher.length();

                uriTemplate.replace(startIndex, lastIndex, VARIABLE);


            }

            uriTemplate.append(TAIL);
            uriTemplate.append(TEMPLATE_END);

            pathMetaData.setPathVariables(pathVariableMetaData);
        }

        pathMetaData.setTemplate(uriTemplate.toString());

        return pathMetaData;

    }

    private List<PathVariableMetaData> extractVariables(String path) {

        List<PathVariableMetaData> pathVariables = new ArrayList<PathVariableMetaData>();
        Matcher variableMatcher = variablePattern.matcher(path);

        while (variableMatcher.find()) {

            PathVariableMetaData pathVariable = new PathVariableMetaData(variableMatcher.group(1), null);
            pathVariables.add(pathVariable);

        }

        return pathVariables;

    }

    public static List<String> populateVariableNames(List<PathVariableMetaData> pathVariableMetaDatas) {

        if(pathVariableMetaDatas.isEmpty()) {
            Collections.emptyList();
        }

        List<String> pathVariableNames = new ArrayList<String>();
        for (PathVariableMetaData pathVariableMetaData : pathVariableMetaDatas) {
            pathVariableNames.add(pathVariableMetaData.getName());
        }

        return pathVariableNames;
    }


}
