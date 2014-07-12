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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class JarFileReader implements FileReader {

    private static Log log = LogFactory.getLog(JarFileReader.class);

    private JarInputStream jarInputStream;
    private JarEntry next;
    private FileFilter filter;
    private boolean start = true;
    private boolean closed = false;

    public JarFileReader(File file, FileFilter filter) throws IOException {
        this(new FileInputStream(file), filter);
    }

    public JarFileReader(InputStream is, FileFilter filter) throws IOException {
        this.filter = filter;
        jarInputStream = new JarInputStream(is);
    }

    private void setNext() {
        start = true;
        try {

            if (next != null) {
                jarInputStream.closeEntry();
            }
            next = null;

            do {
                next = jarInputStream.getNextJarEntry();
            } while (next != null && (next.isDirectory() || (filter == null || !filter.accepts(next.getName()))));

            if (next == null) {
                close();
            }

        } catch (IOException e) {
            log.error(e);
        }

    }

    @Override
    public InputStream next() {
        if (closed || (next == null && !start)) {
            return null;
        }
        setNext();
        if (next == null) {
            return null;
        }
        return jarInputStream;
    }

    @Override
    public void close() {
        try {

            closed = true;
            jarInputStream.close();

        } catch (IOException e) {
            log.error(e);
        }
    }


}
