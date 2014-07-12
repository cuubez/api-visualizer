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
package com.cuubez.core.resource.metaData;


import com.cuubez.core.resource.metaData.HeaderVariableMetaData;
import com.cuubez.core.resource.metaData.MethodMetaData;
import com.cuubez.core.resource.metaData.PathVariableMetaData;
import com.cuubez.core.resource.metaData.QueryVariableMetaData;

import java.util.ArrayList;
import java.util.List;

public class SelectedResourceMetaData {

    private MethodMetaData selectedMethodMetaData = null;
    private List<PathVariableMetaData> pathVariableMetaDataList = null;


    public List<PathVariableMetaData> getPathVariableMetaDataList() {
        return pathVariableMetaDataList;
    }

    public MethodMetaData getSelectedMethodMetaData() {
        return selectedMethodMetaData;
    }

    public void setSelectedMethodMetaData(MethodMetaData selectedMethodMetaData) {
        this.selectedMethodMetaData = selectedMethodMetaData;
    }

    public void addPathVariableMetaData(List<PathVariableMetaData> pathVariableMetaDataList) {

        if(pathVariableMetaDataList != null) {
            if (this.pathVariableMetaDataList == null) {
                this.pathVariableMetaDataList = new ArrayList<PathVariableMetaData>();
            }

            this.pathVariableMetaDataList.addAll(pathVariableMetaDataList);
        }

    }

}
