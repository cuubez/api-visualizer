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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ClassFileReader implements FileReader {

    private List<File> files;
    private int index = 0;

    public ClassFileReader(File file, FileFilter filter) {
        files = new ArrayList<File>();
        try {
            init(files, file, filter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void init(List<File> list, File dir, FileFilter filter) throws Exception {
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                init(list, files[i], filter);
            } else {
                if (filter == null || filter.accepts(files[i].getAbsolutePath())) {
                    list.add(files[i]);
                }
            }
        }
    }

    @Override
    public final InputStream next() {
        if (index >= files.size()) {
            return null;
        }
        File fp = (File) files.get(index++);
        try {
            return new FileInputStream(fp);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        // DO Nothing
    }

}
