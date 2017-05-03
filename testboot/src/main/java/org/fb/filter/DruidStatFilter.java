package org.fb.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

/**
 * Function: druidweb监控工具. <br/>
 * Date: 2017年3月31日 下午2:40:57 <br/>
 *
 * @author wh
 * @version 1.0
 * @Copyright (c) 2017, fb  All Rights Reserved.
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",  
initParams={  
    @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//忽略资源  
}  
)  
public class DruidStatFilter extends WebStatFilter {  

}  

