package com.stackroute;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class TrackServiceApplication {

	public static void main(String[] args)
	{

		SpringApplication.run(TrackServiceApplication.class, args);
	}
}
