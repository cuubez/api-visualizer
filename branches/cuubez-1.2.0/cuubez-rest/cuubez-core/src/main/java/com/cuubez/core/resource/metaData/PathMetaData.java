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


import java.util.List;

public class PathMetaData {

    private List<PathVariableMetaData> pathVariables;
    private String template;
    private String tail;
    private boolean empty;
    private boolean rootPath;

    public List<PathVariableMetaData> getPathVariables() {
        return pathVariables;
    }

    public void setPathVariables(List<PathVariableMetaData> pathVariables) {
        this.pathVariables = pathVariables;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public boolean isRootPath() {
        return rootPath;
    }

    public void setRootPath(boolean rootPath) {
        this.rootPath = rootPath;
    }
}
