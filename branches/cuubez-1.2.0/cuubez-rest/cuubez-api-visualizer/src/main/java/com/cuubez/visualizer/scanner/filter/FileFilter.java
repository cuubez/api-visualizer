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
package com.cuubez.visualizer.scanner.filter;


import java.io.File;

public abstract class FileFilter {

    public abstract boolean filter(String fileName);


    protected boolean isAcceptExtension(String filename, String[] extensions) {

        if (containExtension(filename, extensions)) {
            if (filename.startsWith(File.separator)) {
                filename = filename.substring(1);
            }
            if (!isIgnore(filename)) {
                return true;
            }
        }
        return false;

    }

    protected boolean isAcceptFileName(String fileName, String expectedFileName) {

        String[] splittedName = fileName.split(File.separator);

        String actualName = splittedName[splittedName.length - 1];
        String[] splittedActualName = actualName.split("\\.");

        if(expectedFileName.endsWith(splittedActualName[0])) {
            return true;
        }

        return false;

    }

    protected boolean isIgnore(String fileName) {
        return false;
    }


    private boolean containExtension(String filename, String[] extensions) {

        for (String extension : extensions) {

            if(filename.endsWith("."+extension)) {
                return true;
            }
        }

        return false;
    }




}
