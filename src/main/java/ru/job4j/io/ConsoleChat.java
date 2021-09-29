package ru.job4j.io;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * В этом задании необходимо создать программу 'Консольный чат'. Некоторое описание:
 *
 * - пользователь вводит слово-фразу,
 * программа берет случайную фразу из текстового файла и выводит в ответ.
 * - программа замолкает если пользователь вводит слово «стоп»,
 * при этом он может продолжать отправлять сообщения в чат.
 * - если пользователь вводит слово «продолжить», программа снова начинает отвечать.
 * - при вводе слова «закончить» программа прекращает работу.
 * - запись диалога, включая слова-команды
 * стоп/продолжить/закончить должны быть записаны в текстовый лог.
 */

public class ConsoleChat {

	private final String path;
	private final String botAnswers;
	private static final String OUT = "закончить";
	private static final String STOP = "стоп";
	private static final String CONTINUE = "продолжить";

	public ConsoleChat(String path, String botAnswers) {
		this.path = path;
		this.botAnswers = botAnswers;
	}
	public void run() {
		System.out.println("начните общение с БОТОМ" + "\n");
		List<String> log = new ArrayList<>();
		List<String> answers = readPhrases();
		Random random = new Random();
		int index;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String ask = reader.readLine();
			boolean isContinue = true;
			while (!ask.equals(OUT)) {
				index = random.nextInt(answers.size());
				if (ask.equals(STOP)) {
					isContinue = false;
				}
				if (ask.equals(CONTINUE)) {
					log.add("user: " + ask.toUpperCase());
					isContinue = true;
					ask = reader.readLine();
					continue;
				}
				if (isContinue) {
					String answer = answers.get(index);
					log.add("user: " + ask);
					log.add("ConsoleChat: " + answer);
					System.out.println(answer);
				} else {
					log.add("user: " + ask.toUpperCase());
				}
				ask = reader.readLine();
			}
			log.add("user: " + ask.toUpperCase());
			saveLog(log);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<String> readPhrases() {
		List<String> answers = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
			while (reader.ready()) {
				answers.add(reader.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return answers;
	}

	private void saveLog(List<String> log) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
			for (String l : log) {
				writer.println(l);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
	ConsoleChat cc = new ConsoleChat(
			"./data/chat_log.log",
			"./data/consoleChatPhrase.txt"
	);
		cc.run();
	}
}
