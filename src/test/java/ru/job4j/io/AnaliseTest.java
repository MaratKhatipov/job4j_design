package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnaliseTest {

	@Test
	public void unavailable() {
		Analise analise = new Analise();
		String source = "./data/server.log";
		String target = "./data/result.cvs";
		analise.unavailable(source, target);
		StringBuilder sb = new StringBuilder();
		try (BufferedReader in = new BufferedReader(new FileReader(target))) {
			in.lines().forEach(sb::append);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat("10:57:01;11:02:02;", is(sb.toString()));
	}

	@Test
	public void unavailable2() {
		Analise analise = new Analise();
		String source = "./data/server2.log";
		String target = "./data/result2.cvs";
		analise.unavailable(source, target);
		StringBuilder sb = new StringBuilder();
		try (BufferedReader in = new BufferedReader(new FileReader(target))) {
			in.lines().forEach(sb::append);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat("10:57:01;10:59:01;" + "11:01:02;11:02:02;", is(sb.toString()));
	}
}