package com.jop.stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.time.Instant;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author julianopontes
 *
 */
public class FindCharTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private PrintStream original = null;
	private Instant start;

	@Before
	public void setUpStream() {
		original = System.out;
		System.setOut(null);
		System.setOut(new PrintStream(outContent, true));

		start = Instant.now();
	}

	@After
	public void setUpOriginal() {
		Instant stop = Instant.now();

		long milliseconds = Duration.between(start, stop).toMillis();

		original.print(outContent.toString());
		System.setOut(original);
		System.out.println(String.format("Test duration: %d seconds, %d milliseconds", milliseconds / 100, milliseconds));
	}

	@Test
	public void testFindCharAtMidlePosition() {
		assertEquals('b', FirstNotRepeatedChar.firstChar(new CharStream("aAbBABac".toCharArray())));
	}

	@Test
	public void testFindCharAtLastPosition() {
		assertEquals('c', FirstNotRepeatedChar.firstChar(new CharStream("aAbBABabc".toCharArray())));
	}

	@Test
	public void testFindCharAtLastPositionLongStream() {
		String string = "qqwertyuiopasdfghjkkklzxxxxxxxxxxxcvvbbbnqwertyuiopa1478562458624562145621458624586245865s"
		    + "dfghjklzzzxcvbbbbnqqqqwsdfgvbnzxcvghuiqwertyuiopasdf24854785ghjklzxcvbbbbbbnwsdfcvqazxrfgvtyhnujoijh"
		    + "gciuytfdiugfdsjhgfdhgfds!!@@##$$%%^^&&**(())__++''::;;??//>><<,,..~~``dcvsdfcsdxcbvtyhbvyuikjjuioiuy"
		    + "gfgresxewqazxddcvghym";

		assertEquals('m', FirstNotRepeatedChar.firstChar(new CharStream(string.toCharArray())));
	}

	@Test
	public void testNotFoundChar() {
		assertEquals(0, FirstNotRepeatedChar.firstChar(new CharStream("aaaa".toCharArray())));
		assertTrue(outContent.toString().contains("First character without repetition not found! :("));
	}
}