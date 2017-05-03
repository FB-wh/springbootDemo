package org.fb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.fb.model.Person;
import org.fb.services.PersonService;
import org.fb.vo.BaseResponseVo;
import org.fb.vo.person.GetPersonRequestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * DateTime: 2017年4月27日下午9:46:47
 * 
 * @author wh
 * @Copyright (c) 2017, fb All Rights Reserved.
 **/
@RestController
@RequestMapping("/")
public class PersonController {
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Resource(name="personServiceImpl")
	private PersonService personService;
	
	@RequestMapping(value = "/getPerson", method = RequestMethod.POST)
	public BaseResponseVo getPerson(@Valid @RequestBody GetPersonRequestVo person){
		logger.info("in...");
		Person p = personService.getPerson(person.getPsnid());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("psnid", p.getPsnid());
		map.put("name", p.getPsnname());
		
		BaseResponseVo response = new BaseResponseVo();
		response.setAjaxObj(map);
		return response;
	}
}
