package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class EchoServerChat {
	private static final Logger LOG = LoggerFactory.getLogger(EchoServerChat.class.getName());

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(9000)) {
			System.out.println("Сервер запущен");
			while (!server.isClosed()) {
				try (Socket socket = server.accept()) {
					try (OutputStream out = socket.getOutputStream();
						 BufferedReader in = new BufferedReader(
								 new InputStreamReader(socket.getInputStream()))) {
						out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
						for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
							System.out.println(str);
							if (str.contains("Exit")) {
								out.write("Работа сервера завершена".getBytes(Charset.forName("WINDOWS-1251")));
								System.out.println("Сервер остановлен");
								server.close();
								break;
							} else if (str.contains("Hello")) {
								out.write("Hello, dear friend.".getBytes());
								System.out.println("Привет");
								break;
							} else if (!str.contains("Hello")) {
								out.write("What!".getBytes());
								break;
							}
						}
						out.flush();
					}
				}
			}
		} catch (IOException e) {
			LOG.error("An error occurred while working with an external source", e);
		}
	}
}
