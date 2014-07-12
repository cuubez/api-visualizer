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


public class FileFilter {

    private transient String[] ignoredPackages = {"javax", "java", "sun", "com.sun", "javassist", "org.apache"};

    public final boolean accepts(String filename) {

        if (filename.endsWith(".class")) {
            if (filename.startsWith("/")) {
                filename = filename.substring(1);
            }
            if (!ignoreScan(filename.replace('/', '.'))) {
                return true;
            }
        }
        return false;
    }


    private boolean ignoreScan(String intf) {

        for (String ignored : ignoredPackages) {
            if (intf.startsWith(ignored + ".")) {
                return true;
            }
        }

        return false;
    }


}
