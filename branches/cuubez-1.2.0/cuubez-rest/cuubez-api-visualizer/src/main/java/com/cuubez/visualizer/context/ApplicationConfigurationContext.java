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
package com.cuubez.visualizer.context;

public class ApplicationConfigurationContext {

    private static ApplicationConfigurationContext applicationConfigurationContext = null;
    private String applicationName = null;
    private String applicationPath = null;

    private ApplicationConfigurationContext() {
    }

    public static ApplicationConfigurationContext getInstance() {

        if (applicationConfigurationContext == null) {

            applicationConfigurationContext = new ApplicationConfigurationContext();

        }

        return applicationConfigurationContext;

    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationPath() {
        return applicationPath;
    }

    public void setApplicationPath(String applicationPath) {
        this.applicationPath = applicationPath;
    }

}
