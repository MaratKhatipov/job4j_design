package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerChat {
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(9000)) {
			System.out.println("Сервер запущен");
			while (!server.isClosed()) {
				Socket socket = server.accept();
				try (OutputStream out = socket.getOutputStream();
					 BufferedReader in = new BufferedReader(
							 new InputStreamReader(socket.getInputStream()))) {
					out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
					out.write("Hello, dear friend.".getBytes());
					for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
						System.out.println(str);
						if (str.contains("Exit")) {
							out.write("Работа сервера завершена".getBytes());
							System.out.println("Сервер остановлен");
							server.close();
							socket.close();
						} else if (str.contains("msg=Hello")) {
							out.write("Hello, dear friend.".getBytes());
							System.out.println("Привет");
						} else if (str.split("=").length == 2) {
							out.write("What".getBytes());
							System.out.println("What");
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
