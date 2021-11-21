package ru.job4j.serialization.json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class JsonConvert {

	public static void main(String[] args) throws JAXBException, IOException {

		final JsonExample jExample = new JsonExample(
				false, 30, "MY_names",
				new NestedObject("black", 100), 1000, 500
		);

		/* Получаем контекст для доступа к АПИ */
		JAXBContext context = JAXBContext.newInstance(JsonExample.class);

		/* Создаем сериализатор */
		Marshaller marshaller = context.createMarshaller();

		/* Указываем, что нам нужно форматирование */
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		String xml = "";

		try (StringWriter writer = new StringWriter()) {
			/* Сериализуем */
			marshaller.marshal(jExample, writer);
			xml = writer.getBuffer().toString();
			System.out.println(xml);
		}

		/* Для десериализации нам нужно создать десериализатор */
		Unmarshaller unmarshaller = context.createUnmarshaller();

		try (StringReader reader = new StringReader(xml)) {
			/* десериализуем */
			JsonExample result = (JsonExample) unmarshaller.unmarshal(reader);
			System.out.println(result);
		}
	}
}
