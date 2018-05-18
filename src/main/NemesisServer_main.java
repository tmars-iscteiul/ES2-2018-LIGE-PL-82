package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;

public class NemesisServer_main {

	public static void main(String[] args) {
		SpringApplication.run(SpringMain.class, args);
		
		try {
			Process out = Runtime.getRuntime().exec("cmd /c .");
			BufferedReader reader = 
                    new BufferedReader(new InputStreamReader(out.getInputStream()));
			
			String line = "";			
			while ((line = reader.readLine())!= null) {
				System.out.println(line);
			}
			System.out.println(reader);
		} catch (IOException e) {
			System.out.println("Cannot run the commands.");
		}
	}
}
