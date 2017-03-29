/**
 * Copyright [2013] [www.cuubez.com]
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cuubez.visualizer.processor;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cuubez.visualizer.resource.InformationRepository;
import com.cuubez.visualizer.resource.ResourceGenerator;
import com.cuubez.visualizer.resource.RootResource;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

public class ServiceRepositoryProcessor
{

   private static Log logger = LogFactory.getLog(ServiceRepositoryProcessor.class);

   public void process()
   {
      logger.trace("service repository initialization started");

      String packageToScan = InformationRepository.getInstance().getConfiguration().getPackageToScan();
      if (Strings.isNullOrEmpty(packageToScan))
      {
         logger.warn("No package to scan");
      }
      else
      {
         scan(packageToScan);
      }
   }

   private void scan(String packageToScan)
   {
      try
      {
         ImmutableSet<ClassInfo> classes = ClassPath.from(ServiceRepositoryProcessor.class.getClassLoader()).getTopLevelClassesRecursive(packageToScan);

         ResourceGenerator resourceGenerator = new ResourceGenerator();
         for (ClassInfo classInfo : classes)
         {
            Class<?> clazz = Class.forName(classInfo.getName());
            RootResource rootResource = resourceGenerator.generateResource(clazz);
            if (rootResource != null)
            {
               InformationRepository.getInstance().addRootResource(rootResource);
            }
         }

      }
      catch (IOException | ClassNotFoundException e)
      {
         logger.error(e);
      }
   }

}
