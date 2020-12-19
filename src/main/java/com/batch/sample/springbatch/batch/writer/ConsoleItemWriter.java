package com.batch.sample.springbatch.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.batch.sample.springbatch.model.User;
import com.batch.sample.springbatch.service.TestService;

public class ConsoleItemWriter<T> implements ItemWriter<T> { 
	
	@Autowired
	TestService testService;
	
    @Override
    public void write(List<? extends T> items) throws Exception { 
//        for (T item : items) { 
//            System.out.println("ConsoleItemWriter=== "+ ((User) item).getUserName()); 
//        } 
        testService.writToFile("D:\\test\\TestOut.csv", (List<User>)items);
    } 
}
