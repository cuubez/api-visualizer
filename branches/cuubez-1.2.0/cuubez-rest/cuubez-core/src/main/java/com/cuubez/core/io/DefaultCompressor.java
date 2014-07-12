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
package com.cuubez.core.io;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.cuubez.core.context.ResponseContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultCompressor implements Compressor {

    private static Log log = LogFactory.getLog(DefaultCompressor.class);


    public void compressAndWrite(HttpServletResponse response, ResponseContext responseContext) {

        PrintWriter out = null;

        try {

            out = response.getWriter();

        } catch (IOException e) {
            log.error(e);
        }

        out.write(responseContext.getContent());
        out.flush();
        out.close();

    }

}
