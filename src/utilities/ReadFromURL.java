package utilities;

import java.net.*;

import java.io.*;

/**
 * Class that read JAR and downloads it, by given URL
 * @author skner
 *
 */
public abstract class ReadFromURL {
	
	public static void downloadFile(String fileURL, String fileName) {
		
        URL url;
		try {
			url = new URL(fileURL);
			
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
	        int responseCode = httpConn.getResponseCode();
	        
	     // always check HTTP response code first
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            
	            // opens input stream from the HTTP connection
	            InputStream inputStream = httpConn.getInputStream();
	            String saveFilePath = Paths.APPS_FOLDER + fileName;
	             
	            // opens an output stream to save into file
	            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
	 
	            int bytesRead = -1;
	            byte[] buffer = new byte[4096];
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                outputStream.write(buffer, 0, bytesRead);
	            }
	 
	            outputStream.close();
	            inputStream.close();
	 
	        } else {
	            System.err.println("No file to download. Server replied HTTP code: " + responseCode);
	        }
	        httpConn.disconnect();
	        
		} catch (MalformedURLException e) {
			System.out.println("Invalid URL.");
		} catch (IOException e) {
			System.out.println("Invalid URL.");
		}
 
    }
    	
    
    public static void main(String[] args) throws IOException {
    	ReadFromURL.downloadFile("https://github.com/tmars-iscteiul/ES2-2018-LIGE-PL-82/blob/master/caseStudies/antiSpamProblem.jar?raw=true", "antiSpamProblem.jar");
    }
    
}

