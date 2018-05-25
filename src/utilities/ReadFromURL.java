package utilities;

import java.net.*;

import java.io.*;

public abstract class ReadFromURL {
	
	public static void downloadFileTwo(String fileURL, String fileName) throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
 
        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            
            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = Path.appsFolder + fileName;
             
            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
 
            int bytesRead = -1;
            byte[] buffer = new byte[4096];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            outputStream.close();
            inputStream.close();
 
            System.out.println("File downloaded");
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
    }
	
	
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
    	ReadFromURL.downloadFileTwo("https://github.com/tmars-iscteiul/ES2-2018-LIGE-PL-82/blob/master/caseStudies/antiSpamProblem.jar?raw=true", "teste.jar");
    }
    
}

