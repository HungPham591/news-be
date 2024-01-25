package com.news.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.server.WebServer;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EntityScan( basePackages = {"com.news.news"} )
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
