package com.example.CRUDService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudServiceApplication.class, args);

		        try {
		            // Example code that may cause ArrayIndexOutOfBoundsException
		            String[] data = {}; // Empty array
		            String element = data[0]; // Accessing index 0 of empty array
		            System.out.println("Element: " + element);
		        } catch (ArrayIndexOutOfBoundsException e) {
		            // Handle the exception gracefully
		            System.err.println("Array index out of bounds: " + e.getMessage());
		            e.printStackTrace();
		        }
		    }
    // Other methods and logic of the converter class go here
}
