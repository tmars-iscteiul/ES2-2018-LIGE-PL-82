package utilities;

import java.net.*;

import java.io.*;

public abstract class ReadFromURL {
	
	
	
    public static boolean downloadFile(String fromUrl, String localFileName) {
    	    File localFile = new File(Path.appsFolder + localFileName);
    	    if (localFile.exists())
    	        localFile.delete();
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
			try {
				out = new BufferedOutputStream(new FileOutputStream(localFileName));
				conn = url.openConnection();
	    	    in = conn.getInputStream();
	    	    byte[] buffer = new byte[1024];
	    	    int numRead;
	    	    while ((numRead = in.read(buffer)) != -1) {
	    	        out.write(buffer, 0, numRead);
	    	    }
	    	    if (in != null)
	    	        in.close();
	    	    if (out != null)
	    	        out.close();
			} catch (IOException e) {
				System.out.println("Cannot download the file.");
				return false;
			}
			
			System.out.println("File " + localFileName + " was downloaded to into path " + Path.appsFolder + " with sucess.");
			return true;
    	    
    	}
    	
    
    public static void main(String[] args) throws IOException {
		ReadFromURL.downloadFile("https://www.github.com/tmars-iscteiul/ES2-2018-LIGE-PL-82/raw/testSpring/caseStudies/test1.jar","test1.jar");
	}
    
}

