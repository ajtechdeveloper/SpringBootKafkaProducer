package com.aj.springbootkafkaproducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootKafkaProducerApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootKafkaProducerApplication.class);

    public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootKafkaProducerApplication.class,args);
	}
}
