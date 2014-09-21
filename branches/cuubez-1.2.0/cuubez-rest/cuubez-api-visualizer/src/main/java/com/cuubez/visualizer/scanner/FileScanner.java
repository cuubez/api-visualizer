package com.cuubez.visualizer.scanner;


import com.cuubez.visualizer.scanner.reader.ClassFileReader;
import com.cuubez.visualizer.scanner.reader.FileReader;
import com.cuubez.visualizer.scanner.reader.JarFileReader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FileScanner {

    protected final URL findResources(String applicationPath) throws MalformedURLException {

        File fp = new File(applicationPath);

        if (!fp.exists()) {
            throw new RuntimeException("File path does not exist: " + fp);
        }

        return fp.toURI().toURL();
    }


}
