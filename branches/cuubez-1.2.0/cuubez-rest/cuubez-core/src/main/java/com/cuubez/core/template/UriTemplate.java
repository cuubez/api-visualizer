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
import java.util.regex.Pattern;

public abstract class UriTemplate {

    protected Pattern pattern = null;
    protected PathMetaData pathMetaData;


    public abstract PathMetaData match(String path);


    public void setTemplate(String template) {
        this.pattern = Pattern.compile(template);
    }

    public PathMetaData getPathMetaData() {
        return pathMetaData;
    }

    public void setPathMetaData(PathMetaData pathMetaData) {
        this.pathMetaData = pathMetaData;
    }

}
