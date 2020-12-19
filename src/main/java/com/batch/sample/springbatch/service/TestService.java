package com.batch.sample.springbatch.service;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch.sample.springbatch.model.User;

@Service
public class TestService {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	public void triggerJob() {
		System.out.println("Job triggered...");
		JobParameters params = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();
		try {
			jobLauncher.run(job, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void writToFile(String fileName, List<User> users) {
		//System.out.println("File writer ===== " + users);
		File file = new File(fileName);//"D:\\TestFile.csv"
		try {
			FileWriter myWriter = new FileWriter(file, true);
			for(User user : users) {
				String data = user.getId() + "," + user.getUserName() + "," + user.getEmailId() + "\n";
				myWriter.write(data);
			}
			myWriter.close();
			//System.out.println("File created Successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
