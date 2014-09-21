package com.cuubez.visualizer.scanner.reader;


import com.cuubez.visualizer.scanner.filter.FileFilter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlFileReader implements FileReader {

    private List<File> files;
    private int index = 0;

    public XmlFileReader(File file, FileFilter filter) {
        files = new ArrayList<File>();
        try {
            init(files, file, filter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public InputStream next() {

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

    private static void init(List<File> list, File dir, FileFilter filter) throws Exception {
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                init(list, files[i], filter);
            } else {
                if (filter == null || filter.filter(files[i].getAbsolutePath())) {
                    list.add(files[i]);
                }
            }
        }
    }
}
