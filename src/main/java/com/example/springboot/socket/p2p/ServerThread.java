package com.example.springboot.socket.p2p;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;

public class ServerThread extends Thread {
	
	private ServerSocket serverSocket;
	private Set<ServerThreadThread> serverThreadThreads = new HashSet<>();
	
	public ServerThread(String port) throws NumberFormatException, IOException {
		serverSocket = new ServerSocket(Integer.valueOf(port));
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				ServerThreadThread serverThreadThread = new ServerThreadThread(serverSocket.accept(), this);
				serverThreadThreads.add(serverThreadThread);
				serverThreadThread.start();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Aqui se podria poder colocar a quien enviar el mensaje 
	 * un parametro adicional un identificador por serverthread
	 * 
	 */
	public void sendMessage(String message) {
		try {
			serverThreadThreads.forEach(s -> s.getPrintWriter().println(message));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Set<ServerThreadThread> getServerThreadThreads() {
		return serverThreadThreads;
	}	
	
}
