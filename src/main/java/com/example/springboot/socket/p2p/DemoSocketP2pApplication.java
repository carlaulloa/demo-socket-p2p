package com.example.springboot.socket.p2p;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("> enter username and port: ");
		String[] setupValues = bufferedReader.readLine().split(" ");
		ServerThread serverThread = new ServerThread(setupValues[1]);
		serverThread.start();
		new Peer().updateListenToPeers(bufferedReader, setupValues[0], serverThread);
	}

}
