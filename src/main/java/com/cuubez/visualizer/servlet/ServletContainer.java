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

import com.cuubez.visualizer.domain.ApiMetaDataInformation;
import com.cuubez.visualizer.resource.InformationRepository;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import freemarker.template.Template;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ServletContainer extends HttpServlet {

    private static Log log = LogFactory.getLog(ServletContainer.class);

    protected void process(HttpServletRequest request, HttpServletResponse response) {

        ApiMetaDataInformation apiMetaDataInformation = InformationRepository.getInstance().getApiMetaData();

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("apiMetaDataInfo", apiMetaDataInformation);


        try {

            Configuration freemarkerConfiguration = new Configuration();
            freemarkerConfiguration.setClassForTemplateLoading(this.getClass(), "/");
            Template freemarkerTemplate = freemarkerConfiguration.getTemplate("cuubez_api.ftl");
            freemarkerTemplate.process(data, response.getWriter());


        } catch (IOException e) {
            log.error(e);
        } catch (TemplateException e) {
            log.error(e);
        }


    }



}
