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
package com.cuubez.visualizer.resource;


import com.cuubez.visualizer.context.ApplicationConfigurationContext;
import com.cuubez.visualizer.resource.domain.RootResource;
import com.cuubez.visualizer.scanner.ClassScanner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.List;

public class ServiceRepositoryProcessor {

    private static Log log = LogFactory.getLog(ServiceRepositoryProcessor.class);

    public void process() {

        log.trace("service repository initialization started");
        List<Class<?>> classes = null;

        String applicationPath = ApplicationConfigurationContext.getInstance().getApplicationPath();
        ClassScanner scanner = new ClassScanner();

        try {
            classes = scanner.discover(applicationPath);
        } catch (IOException e) {
            log.error(e);
        }

        if (classes != null) {

            for (Class<?> clazz : classes) {
                ResourceGenerator resourceGenerator = new ResourceGenerator();
                RootResource rootResource = resourceGenerator.generateResource(clazz);

                if(rootResource != null) {
                    ResourceRepository.getInstance().addRootResource(rootResource);
                }

            }
        }

    }


}
