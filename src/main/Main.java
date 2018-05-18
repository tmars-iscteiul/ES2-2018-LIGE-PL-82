package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"main, spring"})
public class Main {

	/*
	 * How to run:
	 * 
	 * Simply execute this class as a JavaApplication
	 * The SPRING service will listen on localhost:8080
	 * 
	 * To send a JSON simply send a POST with content-type application/json, having the raw json text on the message body
	 * The app listens for JSONs on localhost:8080/send_problem
	 * 
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		
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
