package org.fb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.fb.model.Person;

/**
 * Function: 支付用户mapper. <br/>
 * Date: 2017年3月31日 下午2:10:33 <br/>
 *
 * @author wh
 * @version 1.0
 * @Copyright (c) 2017, fb All Rights Reserved.
 */
@Mapper
public interface PersonMapper {

	/**
	 * 根据id查找用户
	 * @param id
	 * @return
	 */
	Person selectById(String id);
}
