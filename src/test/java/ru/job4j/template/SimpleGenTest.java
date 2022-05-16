package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.IllegalFormatFlagsException;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleGenTest {
    private final Generator testGenerator = new SimpleGen();

    @Ignore
    @Test
    public void whenAllCorrect() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Marat");
        args.put("subject", "you");
        String result = testGenerator.produce(template, args);
        assertThat("I am a Marat, Who are you?", is(result));
    }

    @Ignore
    @Test(expected = IllegalFormatFlagsException.class)
    public void whenFirsKeyMissing() {
        Map<String, String> args = new HashMap<>();
        String template = "I am a ${name}, Who are ${subject}? ";
        args.put("subject", "you");
        String result = testGenerator.produce(template, args);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenHasNotKeyInMap() {
        Map<String, String> args = new HashMap<>();
        String template = "I am ${profession}, Who are ${subject}?";
        args.put("name", "Marat");
        args.put("subject", "you");
        String result = testGenerator.produce(template, args);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenMapHasExtraKeys() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Marat");
        args.put("subject", "you");
        args.put("profession", "Java Developer");
        String result = testGenerator.produce(template, args);
    }
}