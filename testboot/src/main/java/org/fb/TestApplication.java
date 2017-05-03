package org.fb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author:fb-wh
 * @date:2017年4月27日下午3:11:46
 * @description:
 */

@SpringBootApplication
//@ImportResource({"spring-dubbo.xml"})
@EnableTransactionManagement 
@ServletComponentScan
public class TestApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);

	}

}
