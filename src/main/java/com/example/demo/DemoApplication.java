package com.example.demo;

import com.example.demo.bean.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableConfigurationProperties(BookBean.class)
public class DemoApplication {
	@Autowired
	private BookBean bookBean;


	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(DemoApplication.class);
		//springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
	}

	@RequestMapping("/book")
	public String book(){
		return "Hello Spring Boot! The BookName is "+bookBean.getName()+";and Book Author is "+bookBean.getAuthor()+";and Book PinYin is "+bookBean.getPinyin();
	}

	@RequestMapping("/hello/{myName}")
	public String index(@PathVariable String myName) {
		return "Hello " + myName + "!!!";
	}
}
