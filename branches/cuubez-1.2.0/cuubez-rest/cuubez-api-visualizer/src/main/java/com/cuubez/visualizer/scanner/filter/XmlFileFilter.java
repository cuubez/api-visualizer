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


public class XmlFileFilter extends FileFilter {

    private static final String EXTENSION = "xml";
    private static final String FILE_NAME = "cuubez-visualize";


    @Override
    public boolean filter(String fileName) {

        String[] extensions = {EXTENSION};
        if(isAcceptExtension(fileName, extensions)) {

            if (isAcceptFileName(fileName, FILE_NAME)) {
                return true;
            }

        }
        return false;
    }

    @Override
    protected boolean isIgnore(String fileName) {
        return false;
    }
}
