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
