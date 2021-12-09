package com.bilgeadam.boost.momdb.clientside.communication;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.bilgeadam.boost.momdb.clientside.dao.MovieDbFactory;
import com.bilgeadam.boost.momdb.clientside.dto.ActorDto;
import com.bilgeadam.boost.momdb.resources.Resources;

public class MovieServer {
	
	public void start() {
		ActorDto actorDto;
		MovieDbFactory dbFactory = new MovieDbFactory();
		
		try {
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(Resources.getUtils("serverPort")));
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("Client Connected.");
				InputStream inputStream = socket.getInputStream();
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
				actorDto = (ActorDto) objectInputStream.readObject();
				actorDto = dbFactory.getDao(1).read(actorDto);
				ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
				outputStream.writeObject(actorDto);
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("MovieServer start() method failed." + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MovieServer movieServer = new MovieServer();
		movieServer.start();
	}
}
