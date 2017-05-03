package org.fb.services.impl;

import org.fb.mapper.PersonMapper;
import org.fb.model.Person;
import org.fb.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * DateTime: 2017年4月27日下午9:27:35
 * 
 * @author wh
 * @Copyright (c) 2016, fb All Rights Reserved.
 **/
@Component("personServiceImpl")
public class PersonServiceImpl implements PersonService {
	private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

	@Autowired  
    private PersonMapper mapper;

	@Override
	public Person getPerson(String psnid) {
		logger.info("getPerson..." + psnid);
		Person person = mapper.selectById(psnid);
		return person;
	}
	
	
}
