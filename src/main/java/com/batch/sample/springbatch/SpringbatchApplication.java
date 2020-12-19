package com.batch.sample.springbatch;

import java.io.File;
import java.io.FileWriter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude =  {DataSourceAutoConfiguration.class })
public class SpringbatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbatchApplication.class, args);
		//createTestFile();
	}

	private static void createTestFile() {
		File file = new File("D:\\TestFile.csv");
		try {
			FileWriter myWriter = new FileWriter(file);
			for(int i = 0; i < 100000; i++) {
				String data = i + ",username" + i + ",email" + i + "@company.com";
				myWriter.write(data);
				myWriter.write("\n");
			}
			myWriter.close();
			System.out.println("File created Successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
