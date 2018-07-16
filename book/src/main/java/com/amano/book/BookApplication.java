package com.amano.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@RestController
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

    @RequestMapping(value = "health")
    public ResponseEntity<Void> health() {
        System.out.println("BookApplication.... health - OK");
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "health2")
    @ResponseBody
    public String health2(HttpServletResponse response) {
        System.out.println("BookApplication.... health2 - OK");
        return "BookApplication.... health2 - OK";
    }

}
