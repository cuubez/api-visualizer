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
package com.cuubez.visualizer.scanner;


import com.cuubez.visualizer.scanner.filter.XmlFileFilter;
import com.cuubez.visualizer.scanner.reader.FileReader;
import com.cuubez.visualizer.scanner.reader.JarFileReader;
import com.cuubez.visualizer.scanner.reader.XmlFileReader;
import java.io.*;
import java.net.URL;

public class ConfigurationScanner extends FileScanner {

    public InputStream scan(String applicationPath) throws IOException {

        URL resource = findResources(applicationPath);
        FileReader itr = getFileReader(resource, new XmlFileFilter());


        return itr.next();

    }

    private FileReader getFileReader(URL url, com.cuubez.visualizer.scanner.filter.FileFilter filter) throws IOException {

        String urlString = url.toString();
        if (urlString.endsWith("!/")) {
            urlString = urlString.substring(4);
            urlString = urlString.substring(0, urlString.length() - 2);
            url = new URL(urlString);
        }

        if (!urlString.endsWith("/")) {
            return new JarFileReader(url.openStream(), filter);
        } else {

            if (!url.getProtocol().equals("file")) {
                throw new IOException("Unable to understand protocol: " + url.getProtocol());
            }

            File f = new File(url.getPath());
            if (f.isDirectory()) {
                return new XmlFileReader(f, filter);
            } else {
                return new JarFileReader(url.openStream(), filter);
            }
        }
    }

}
