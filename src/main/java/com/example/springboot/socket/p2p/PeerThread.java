package com.example.springboot.socket.p2p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.json.Json;
import javax.json.JsonObject;

public class PeerThread extends Thread {
	
	private BufferedReader bufferedReader;
	
	public PeerThread(Socket socket) throws IOException {
		bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	@Override
	public void run() {
		boolean flag = true;
		while(flag) {
			try {
				JsonObject json = Json.createReader(bufferedReader).readObject();
				System.out.println(json);
				if(json.containsKey("username")) {
					System.out.println("[" + json.getString("username") + "]: " + json.getString("message"));
				}
			} catch(Exception e) {
				e.printStackTrace();
				flag = false;
				interrupt();
			}
		}
	}
}
