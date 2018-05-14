package utils;

import java.net.*;
import java.util.jar.Manifest;
import java.io.*;

public class ReadFromURL {
    public void getJarFromURL (String URL) {

    	URL url;
		try {
			url = new URL(URL);
			
			JarURLConnection jarConnection;
			try {
				jarConnection = (JarURLConnection)url.openConnection();
				
				Manifest manifest = jarConnection.getManifest();
				System.out.println(manifest);
				
			} catch (IOException e) {
				System.out.println("JAR File doesn't exist in that URL.");
			}
			
		} catch (MalformedURLException e) {
			System.out.println("Cannot parse that URL.");
		}
		
    }
    
    public static void main(String[] args) {
		new ReadFromURL().getJarFromURL("https://www.github.com/tmars-iscteiul/ES2-2018-LIGE-PL-82/raw/testSpring/caseStudies/test1.jar");
	}
    
}

