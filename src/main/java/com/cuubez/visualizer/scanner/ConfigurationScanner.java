package com.cuubez.visualizer.scanner;


import com.cuubez.visualizer.scanner.filter.ClassFileFilter;
import com.cuubez.visualizer.scanner.filter.XmlFileFilter;
import com.cuubez.visualizer.scanner.reader.ClassFileReader;
import com.cuubez.visualizer.scanner.reader.FileReader;
import com.cuubez.visualizer.scanner.reader.JarFileReader;
import com.cuubez.visualizer.scanner.reader.XmlFileReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.net.URL;

public class ConfigurationScanner extends FileScanner {

    public InputStream scan(String applicationPath) throws IOException {

        URL resource = findResources(applicationPath);
        FileReader itr = getFileReader(resource, new XmlFileFilter());


        return itr.next();

    }

    private FileReader getFileReader(URL url, com.cuubez.visualizer.scanner.filter.FileFilter filter) throws IOException {

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
                return new XmlFileReader(f, filter);
            } else {
                return new JarFileReader(url.openStream(), filter);
            }
        }
    }

}
