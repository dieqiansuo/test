package com.example.demo;

import com.example.demo.bean.BookBean;
import com.example.demo.controller.RedisController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static sun.misc.Version.println;

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
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		stringCollection
				.stream()
				.filter((s) -> s.startsWith("a"))
				.forEach(System.out::println);
		Boolean anyString = stringCollection
				.stream()
				.anyMatch((s) -> s.startsWith("a"));
		System.out.println("anyString:"+anyString);
		Boolean allString = stringCollection
				.stream()
				.allMatch((s) -> s.startsWith("a"));
		System.out.println("allString:"+allString);
		Long stringCount = stringCollection
				.stream()
				.filter((s) -> s.startsWith("b"))
				.count();
		System.out.println("stringCount:"+stringCount);
		return "Hello Spring Boot! The BookName is "+bookBean.getName()+";and Book Author is "+bookBean.getAuthor()+";and Book PinYin is "+bookBean.getPinyin();
	}

	@RequestMapping("/hello/{myName}")
	public String index(@PathVariable String myName) {
		return "Hello " + myName + "!!!";
	}
}
