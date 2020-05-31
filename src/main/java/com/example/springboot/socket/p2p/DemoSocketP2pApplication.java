package com.example.springboot.socket.p2p;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSocketP2pApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoSocketP2pApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Peer peer = new Peer();
		peer.start();
	}

}
