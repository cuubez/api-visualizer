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
