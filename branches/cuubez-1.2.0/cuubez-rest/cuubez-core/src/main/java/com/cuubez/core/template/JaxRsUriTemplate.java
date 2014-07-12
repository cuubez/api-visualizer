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

import java.util.List;
import java.util.regex.Matcher;

public class JaxRsUriTemplate extends UriTemplate {

    @Override
    public PathMetaData match(String path) {

        List<PathVariableMetaData> pathVariableMetaDataList = pathMetaData.getPathVariables();
        Matcher matcher = pattern.matcher(path);

        if(matcher.matches()) {

            if(pathMetaData.isRootPath() && pathMetaData.isEmpty()) {

                setTailForEmptyPath(matcher);

            } else if(pathMetaData.isRootPath() && !pathMetaData.isEmpty()) {

                populatePathVariable(matcher, pathVariableMetaDataList);
                setTailForNonEmptyPath(matcher, pathVariableMetaDataList);


            } else if(!pathMetaData.isRootPath() && pathMetaData.isEmpty()) {

                setTailForEmptyPath(matcher);

                if(!pathMetaData.getTail().isEmpty()) {
                    return null;
                }

            } else {

                populatePathVariable(matcher, pathVariableMetaDataList);
                setTailForNonEmptyPath(matcher, pathVariableMetaDataList);


            }



          return pathMetaData;

        }
        return null;
    }

    private void populatePathVariable(Matcher matcher, final List<PathVariableMetaData> pathVariableMetaDataList) {

        if(pathVariableMetaDataList != null) {
            for (int i = 0; i < pathVariableMetaDataList.size(); i++) {
                pathVariableMetaDataList.get(i).setValue(matcher.group(i + 3));
            }
        }

    }

    private void setTailForEmptyPath(final Matcher matcher) {
        String tail = matcher.group(1);
        pathMetaData.setTail(tail);
    }

    private void setTailForNonEmptyPath(final Matcher matcher, final List<PathVariableMetaData> pathVariableMetaDataList) {
        int pathVariableCount = 0;


        if(pathVariableMetaDataList != null) {
            pathVariableCount = pathVariableMetaDataList.size();
        }
        String tail = matcher.group(pathVariableCount + 3);
        pathMetaData.setTail(tail);

    }
}
