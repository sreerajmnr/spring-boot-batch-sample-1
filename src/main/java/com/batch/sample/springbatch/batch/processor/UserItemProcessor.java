package com.batch.sample.springbatch.batch.processor;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.batch.sample.springbatch.model.User;
import com.batch.sample.springbatch.service.TestService;

public class UserItemProcessor implements ItemProcessor<User, User> {
  
	@Autowired
	TestService testService;
	
   @Override
   public User process(final User user) throws Exception {
      final String email = user.getEmailId().toUpperCase();
      final String userName = user.getUserName().toUpperCase();
      final String id = user.getId();
      final User transformedPerson = new User(id, userName, email);
      //System.out.println("UserItemProcessor==== "+ userName);
      
      List<User> users = new ArrayList<User>();
      users.add(user);
      
      //testService.writToFile("D:\\test\\TestOut.csv", users);
      return transformedPerson;
   }
}
