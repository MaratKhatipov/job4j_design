package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnaliseTest {
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void unavailable() throws IOException {
		Analise analise = new Analise();
		File source = folder.newFile("server.log");
		File target = folder.newFile("result.cvs");
		try (PrintWriter out = new PrintWriter(source)) {
			out.println("200 10:56:01");
			out.println("500 10:57:01");
			out.println("400 10:58:01");
			out.println("500 10:59:01");
			out.println("400 11:01:02");
			out.println("200 11:02:02");
		}
		analise.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
		StringBuilder sb = new StringBuilder();
		try (BufferedReader in = new BufferedReader(new FileReader(target))) {
			in.lines().forEach(sb::append);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(
				"10:57:01;11:02:02;",
				is(sb.toString())
		);
	}

	@Test
	public void unavailable2() throws IOException {
		Analise analise = new Analise();
		File source = folder.newFile("server.log");
		File target = folder.newFile("result.cvs");
		try (PrintWriter out = new PrintWriter(source)) {
			out.println("200 10:56:01");
			out.println("500 10:57:01");
			out.println("400 10:58:01");
			out.println("200 10:59:01");
			out.println("500 11:01:02");
			out.println("200 11:02:02");
		}
		analise.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
		StringBuilder sb = new StringBuilder();
		try (BufferedReader in = new BufferedReader(new FileReader(target))) {
			in.lines().forEach(sb::append);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(
				"10:57:01;10:59:01;" + "11:01:02;11:02:02;",
				is(sb.toString())
		);
	}
}