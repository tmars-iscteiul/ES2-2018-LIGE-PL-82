package data.utils;

import java.net.*;
import java.io.*;

public abstract class ReadFromURL {
    public static boolean downloadFile(String fromUrl, String localPath, String localFileName) {
    	    File localFile = new File(localPath + localFileName);
    	    if (localFile.exists()) {
    	    	System.out.println("File already existed.");
    	        localFile.delete();
    	    }
    	    
    	    try {
				localFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Cannot create a local file.");
				return false;
			}
    	    
    	    URL url;
    	    
			try {
				url = new URL(fromUrl);
			} catch (MalformedURLException e) {
				System.out.println("Invalid URL.");
				return false;
			}
			
    	    OutputStream out;
    	    InputStream in;
    	    URLConnection conn;
    	    
    	    System.out.print("Start downloading...");
    	    
			try {
				out = new BufferedOutputStream(new FileOutputStream(localFileName));
				
				conn = url.openConnection();
	    	    in = conn.getInputStream();
	    	    
	    	    byte[] buffer = new byte[1024];

	    	    int numRead;
	    	    
	    	    while ((numRead = in.read(buffer)) != -1) {
	    	        out.write(buffer, 0, numRead);
	    	    }
	    	    
	    	    System.out.println("Complete");
	    	    
	    	    if (in != null) {
	    	        in.close();
	    	    }
	    	    if (out != null) {
	    	        out.close();
	    	    }
			} catch (IOException e) {
				System.out.println("Cannot download the file.");
				return false;
			}
			
			System.out.println("File " + localFileName + " was downloaded to into path " + localPath + " with sucess.");
			return true;
    	    
    	}
    	
    
    public static void main(String[] args) throws IOException {
		ReadFromURL.downloadFile("https://www.github.com/tmars-iscteiul/ES2-2018-LIGE-PL-82/raw/testSpring/caseStudies/test1.jar","./caseStudies/","test1.jar");
	}
    
}

