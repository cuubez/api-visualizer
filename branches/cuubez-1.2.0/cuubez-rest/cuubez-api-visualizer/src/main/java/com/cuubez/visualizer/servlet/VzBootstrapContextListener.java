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
package com.cuubez.visualizer.servlet;

import com.cuubez.visualizer.context.ApplicationConfigurationContext;
import com.cuubez.visualizer.resource.ApiMetaDataProcessor;
import com.cuubez.visualizer.resource.ResourceVariableProcessor;
import com.cuubez.visualizer.resource.ServiceRepositoryProcessor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class VzBootstrapContextListener implements ServletContextListener {

    private static Log log = LogFactory.getLog(VzBootstrapContextListener.class);

    public void contextDestroyed(ServletContextEvent arg0) {

    }

    public void contextInitialized(ServletContextEvent contextEvent) {

        log.trace("Context initialization started");

        initiateApplicationConfigurationContext(contextEvent);
        new ServiceRepositoryProcessor().process();
        new ResourceVariableProcessor().process();
        new ApiMetaDataProcessor().process();

    }


    private String getApplicationName(String realPath) {

        String PATH_SEPARATOR = System.getProperty("path.separator");
        String path = realPath;

        if (path == null) {
            return null;
        }

        if (realPath.endsWith(PATH_SEPARATOR)) {
            path = path.substring(0, path.length() - 1);
        }

        int index = path.lastIndexOf(PATH_SEPARATOR);
        return path.substring(index + 1, path.length());
    }

    private void initiateApplicationConfigurationContext(ServletContextEvent contextEvent) {

        String applicationPath = contextEvent.getServletContext().getRealPath("/");
        String applicationName = getApplicationName(contextEvent.getServletContext().getContextPath());
        ApplicationConfigurationContext applicationConfigurationContext = ApplicationConfigurationContext.getInstance();
        applicationConfigurationContext.setApplicationName(applicationName);
        applicationConfigurationContext.setApplicationPath(applicationPath);

    }

}
