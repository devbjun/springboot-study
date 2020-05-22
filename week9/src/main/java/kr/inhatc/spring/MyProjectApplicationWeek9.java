package kr.inhatc.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication(exclude = MultipartAutoConfiguration.class)
public class MyProjectApplicationWeek9 {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplicationWeek9.class, args);
  }

}
