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
package com.cuubez.core.scanner.file;

import javassist.bytecode.ClassFile;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ClassScanner {

    private static Log log = LogFactory.getLog(ClassScanner.class);

    public List<Class<?>> discover(String applicationPath) throws IOException {

            List<Class<?>> classes = new ArrayList<Class<?>>();

            URL resource = findResources(applicationPath);
            FileReader itr = getFileReader(resource, new FileFilter());

            InputStream is = null;
            while ((is = itr.next()) != null) {
                // make a data input stream
                DataInputStream dstream = new DataInputStream(
                        new BufferedInputStream(is));

                try {
                    // get java-assist class file
                    ClassFile classFile = new ClassFile(dstream);
                    classes.add(Class.forName(classFile.getName()));

                } catch (ClassNotFoundException e) {
                    log.error(e);
                } finally {
                    dstream.close();
                    is.close();
                }
            }

            return classes;
        }


    private final URL findResources(String applicationPath) throws MalformedURLException {

        File fp = new File(applicationPath);

        if (!fp.exists()) {
            throw new RuntimeException("File path does not exist: " + fp);
        }

        return fp.toURI().toURL();
    }

    private final URL[] findResources() {
        List<URL> list = new ArrayList<URL>();
        String classpath = System.getProperty("java.class.path");
        StringTokenizer tokenizer = new StringTokenizer(classpath, File.pathSeparator);

        while (tokenizer.hasMoreTokens()) {
            String path = tokenizer.nextToken();
            try {

                path = java.net.URLDecoder.decode(path, "UTF-8");

            } catch (UnsupportedEncodingException e) {

            }

            File fp = new File(path);

            if (!fp.exists())
                throw new RuntimeException("File in java.class.path does not exist: " + fp);
            try {

                list.add(fp.toURL());

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        return list.toArray(new URL[list.size()]);
    }

    private FileReader getFileReader(URL url, FileFilter filter) throws IOException {
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
                return new ClassFileReader(f, filter);
            } else {
                return new JarFileReader(url.openStream(), filter);
            }
        }
    }

}
