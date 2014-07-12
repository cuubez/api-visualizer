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
package com.cuubez.core.initiator;


import com.cuubez.core.context.ApplicationConfigurationContext;
import com.cuubez.core.resource.InterceptorProvider;
import com.cuubez.core.resource.ResourceGenerator;
import com.cuubez.core.resource.ResourceRepository;
import com.cuubez.core.resource.RootResource;
import com.cuubez.core.scanner.file.ClassScanner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.List;

public class ServiceRepositoryInitiator {

    private static Log log = LogFactory.getLog(ServiceRepositoryInitiator.class);

    public void initiate() {

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

                InterceptorProvider interceptorProvider = resourceGenerator.generateInterceptorProvide(clazz);

                if(interceptorProvider != null) {
                    ResourceRepository.getInstance().addInterceptorProvider(interceptorProvider);
                }
            }
        }

    }


}
