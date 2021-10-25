package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) {
		boolean serverState = false;
		try (ServerSocket server = new ServerSocket(9000)) {
			System.out.println("Сервер запущен");
			while (server.isClosed() == serverState) {
				Socket socket = server.accept();
				try (OutputStream out = socket.getOutputStream();
					 BufferedReader in = new BufferedReader(
							 new InputStreamReader(socket.getInputStream()))) {
					out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
					for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
						System.out.println(str);
						if (str.contains("Bye")) {
							out.write("Работа сервера завершена".getBytes());
							System.out.println("Сервер остановлен");
							serverState = true;

						}
					}
					out.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
