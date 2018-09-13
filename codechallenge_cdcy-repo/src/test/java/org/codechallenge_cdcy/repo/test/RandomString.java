package org.codechallenge_cdcy.repo.test;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class RandomString {
	public static final int DEFAULT_LENGTH = 30;
	public static final String UPPER_LETTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String LOWER_LETTER = UPPER_LETTER.toLowerCase(Locale.ROOT);
	public static final String DIGITS_LETTER = "0123456789";
	public static final String SYMBOLS = "-+!@^*(),.:;_={}";
	public static final String alphanum = UPPER_LETTER + LOWER_LETTER + DIGITS_LETTER + SYMBOLS;

	private final Random random;
	private final char[] symbols;
	private final char[] buf;

//	public static void main(String[] args) {
//		System.out.println("Key: " + new RandomString(30).nextString());
//	}

	public RandomString(int length, Random random, String symbols) {
		if (length < 1)
			throw new IllegalArgumentException("Invalid string length!");
		if (symbols.length() < 2)
			throw new IllegalArgumentException();

		this.random = Objects.requireNonNull(random);
		this.symbols = symbols.toCharArray();
		this.buf = new char[length];
	}

	/**
	 * Create an alphanumeric string generator.
	 */
	public RandomString(int length, Random random) {
		this(length, random, alphanum);
	}

	/**
	 * Create an alphanumeric strings from a secure generator.
	 */
	public RandomString(int length) {
		this(length, new SecureRandom());
	}

	/**
	 * Create session identifiers.
	 */
	public RandomString() {
		this(DEFAULT_LENGTH);
	}

	/**
	 * Generate a random string.
	 */
	public String nextString() {
		for (int idx = 0; idx < buf.length; ++idx)
			buf[idx] = symbols[random.nextInt(symbols.length)];
		return new String(buf);
	}
}