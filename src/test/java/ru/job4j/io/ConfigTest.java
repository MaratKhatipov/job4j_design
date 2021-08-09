package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {
	@Test
	public void whenPairWithoutComment() {
		String path = "./data/pair_without_comment.properties";
		Config config = new Config(path);
		config.load();
		assertThat(config.value("hibernate.dialect"),
				is("org.hibernate.dialect.PostgreSQLDialect"));
		assertThat(config.value("surname"), is(Matchers.nullValue()));
	}

	@Test
	public void whenPairWithCommentAndEmptyString() {
		String path = "./data/pair_with_comment_and_empty_string.properties";
		Config config = new Config(path);
		config.load();
		assertThat(config.value("hibernate.dialect"),
				is("org.hibernate.dialect.PostgreSQLDialect"));
		assertThat(config.value("hibernate.connection.password"),
				is("password"));
	}

	@Test (expected = IllegalArgumentException.class)
	public void whenEmptyValue() {
		String path = "./data/pair_empty_value.properties";
		Config config = new Config(path);
		config.load();
	}
}