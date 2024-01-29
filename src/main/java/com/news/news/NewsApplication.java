package com.news.news;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.news.news.entity")
public class NewsApplication implements CommandLineRunner {

	@Value("${server.port}")
	private int serverPort;

	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			System.out.println("Start success !!!");

			System.out.println("Server Port: " + serverPort);
			System.out.println("Local IP Address: " + hostAddress);
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
	}
}
