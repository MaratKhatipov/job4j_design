package ru.job4j.io;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

	private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

	public static void main(String[] args) {
		byte byteNum = 0;
		short shortNum = 1;
		int intNum = 2;
		long longNum = 3L;
		char character = 'A';
		boolean booleanType = false;
		double doubleNum = 4.1;
		float floatNum = 5.2f;

		LOG.debug("Values of 8 primitive types - \n"
				+ "byteNum : {} \nshortNum : {} \nintNum : {} \nlongNum : {} "
				+ "\ncharacter : {} \nbooleanType : {} \ndoubleNum : {} \nfloatNum : {}",
				byteNum, shortNum, intNum, longNum,
				character, booleanType, doubleNum, floatNum);
	}
}